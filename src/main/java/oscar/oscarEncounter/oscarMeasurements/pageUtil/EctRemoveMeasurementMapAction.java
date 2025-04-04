/**
 * Copyright (c) 2001-2002. Department of Family Medicine, McMaster University. All Rights Reserved.
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
 * This software was written for the
 * Department of Family Medicine
 * McMaster University
 * Hamilton
 * Ontario, Canada
 */


/*
 * EctEditMeasurementMapAction.java
 *
 * Created on September 29, 2007, 2:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package oscar.oscarEncounter.oscarMeasurements.pageUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.oscarehr.managers.SecurityInfoManager;
import org.oscarehr.util.LoggedInInfo;
import org.oscarehr.util.SpringUtils;

import oscar.oscarEncounter.oscarMeasurements.data.MeasurementMapConfig;

/**
 *
 * @author wrighd
 */
public class EctRemoveMeasurementMapAction extends Action{
    
    Logger logger = org.oscarehr.util.MiscUtils.getLogger();
    private SecurityInfoManager securityInfoManager = SpringUtils.getBean(SecurityInfoManager.class);
    
    /** Creates a new instance of EctEditMeasurementMapAction */
    public EctRemoveMeasurementMapAction() {
    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    	if( securityInfoManager.hasPrivilege(LoggedInInfo.getLoggedInInfoFromSession(request), "_admin", "w", null) || securityInfoManager.hasPrivilege(LoggedInInfo.getLoggedInInfoFromSession(request), "_admin.measurements", "w", null) )  {
    	
        String id = request.getParameter("id");
        String identifier = request.getParameter("identifier");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String loinc_code = request.getParameter("loinc_code");
        String outcome = "continue";
        
        if (id != null){
            
                MeasurementMapConfig mmc = new MeasurementMapConfig();
                
                // these values will be set if the measurement is to be remapped instead of deleted
                // therefore it is first mapped then deleted
                if ( identifier != null && name != null && type != null && loinc_code != null){
                    if (!mmc.checkLoincMapping(loinc_code, type)){
                        mmc.mapMeasurement(identifier, loinc_code, name, type);
                        mmc.removeMapping(id, request.getParameter("provider_no"));
                        outcome = "success";
                    }else{
                        outcome = "failedcheck";
                    }                    
                }else{
                    mmc.removeMapping(id, request.getParameter("provider_no"));
                    outcome = "success";
                }
            
        }
        
        return mapping.findForward(outcome);
        
    	}else{
			throw new SecurityException("Access Denied!"); //missing required security object (_admin)
    	}  
       
    }
    
}
