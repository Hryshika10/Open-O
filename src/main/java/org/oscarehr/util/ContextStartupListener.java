/**
 *
 * Copyright (c) 2005-2012. Centre for Research on Inner City Health, St. Michael's Hospital, Toronto. All Rights Reserved.
 * This software is published under the GPL GNU General Public License.
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * This software was written for
 * Centre for Research on Inner City Health, St. Michael's Hospital,
 * Toronto, Ontario, Canada
 */

package org.oscarehr.util;

import org.apache.logging.log4j.Logger;
import org.apache.xml.security.utils.resolver.ResourceResolver;
import org.oscarehr.PMmodule.caisi_integrator.CaisiIntegratorUpdateTask;
import org.oscarehr.PMmodule.dao.ProgramDao;
import org.oscarehr.PMmodule.dao.ProgramProviderDAO;
import org.oscarehr.PMmodule.model.Program;
import org.oscarehr.PMmodule.model.ProgramProvider;
import org.oscarehr.PMmodule.utility.ProgramAccessCache;
import org.oscarehr.PMmodule.utility.RoleCache;
import org.oscarehr.common.jobs.OscarJobUtils;
import org.oscarehr.hospitalReportManager.HRMFixMissingReportHelper;
import org.oscarehr.integration.mcedt.mailbox.CidPrefixResourceResolver;
import org.oscarehr.threads.WaitListEmailThread;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import com.quatro.dao.security.SecroleDao;
import oscar.OscarProperties;

public class ContextStartupListener implements javax.servlet.ServletContextListener {
	private static final Logger logger = org.oscarehr.util.MiscUtils.getLogger();
	private static final OscarProperties oscarProperties = OscarProperties.getInstance();
	@Override
	public void contextInitialized(javax.servlet.ServletContextEvent sce) {

		// ensure cxf uses log4j2
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4j2Logger");

		/*
		 * Map log4j version 1 to version 2
		 */
		System.setProperty("log4j1.compatibility", "true");

		try {
			String contextPath=sce.getServletContext().getContextPath();

			logger.info("Starting OSCAR context. context=" + contextPath);
			
			org.oscarehr.util.MiscUtils.addLoggingOverrideConfiguration(contextPath);

			LocaleUtils.BASE_NAME="oscarResources";

			MiscUtils.setShutdownSignaled(false);
			MiscUtils.registerShutdownHook();

			createOscarProgramIfNecessary();

			if(oscarProperties.getBooleanProperty("INTEGRATOR_ENABLED", "true")){
				CaisiIntegratorUpdateTask.startTask();
			}

			OscarJobUtils.initializeJobExecutionFramework();
			
			WaitListEmailThread.startTaskIfEnabled();

			if (oscarProperties.isPropertyActive("encrypted_xml.remove_cid_prefix")) {
				ResourceResolver.register(CidPrefixResourceResolver.class, true);
			}

			//Run some optimizations
			loadCaches();

			logger.info("OSCAR server processes started. context=" + contextPath);
			
			//bug 4195 - only runs once so long as it finishes..if you want it to not run, add entry
			//try your property table called "HRMFixMissingReportHelper.Run" with value = 1
			HRMFixMissingReportHelper hrmFixer = new HRMFixMissingReportHelper();
			try {
				hrmFixer.fixIt();
			}catch(Exception e) {
				logger.error("Error running HRM fixer",e);
			}
		} catch (Exception e) {
			logger.error("Unexpected error.", e);
			throw (new RuntimeException(e));
		}
	}
	
	public void loadCaches() {
		ProgramDao programDao = (ProgramDao)SpringUtils.getBean(ProgramDao.class);
		for(Program program:programDao.getActivePrograms()) {
			ProgramAccessCache.setAccessMap(program.getId().longValue());
		}
		RoleCache.reload();
	}
	

	private void createOscarProgramIfNecessary() {
		ProgramDao programDao = (ProgramDao)SpringUtils.getBean(ProgramDao.class);
		SecroleDao secRoleDao = (SecroleDao)SpringUtils.getBean(SecroleDao.class);
		ProgramProviderDAO programProviderDao = (ProgramProviderDAO)SpringUtils.getBean(ProgramProviderDAO.class);
		
		Program p = programDao.getProgramByName("OSCAR");
		if(p !=null) 
			return;
		p = new Program();
		p.setFacilityId(1);
		p.setName("OSCAR");
		p.setMaxAllowed(99999);
		p.setType("Bed");
		p.setProgramStatus("active");
		programDao.saveProgram(p);
		
		ProgramProvider pp = new ProgramProvider();
		pp.setProviderNo("999998");
		pp.setProgramId(p.getId().longValue());
		pp.setRoleId(secRoleDao.getRoleByName("doctor").getId());
		programProviderDao.saveProgramProvider(pp);
		
	}
	@Override
    public void contextDestroyed(javax.servlet.ServletContextEvent sce) {
		logger.info("Server processes stopping. context=" + sce.getServletContext().getContextPath());

		WaitListEmailThread.stopTask();
		CaisiIntegratorUpdateTask.stopTask();

		try {
			 StdSchedulerFactory.getDefaultScheduler().shutdown();
		 } catch(SchedulerException e) {
			 logger.error("Error",e);
		 }
		try {
			MiscUtils.checkShutdownSignaled();
			MiscUtils.deregisterShutdownHook();
			MiscUtils.setShutdownSignaled(true);
		} catch (ShutdownException e) {
			// do nothing it's okay.
		}
	}
}
