/**
 * Copyright (c) 2024. Magenta Health. All Rights Reserved.
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
 *
 * Modifications made by Magenta Health in 2024.
 */
package org.oscarehr.PMmodule.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.util.LabelValueBean;
import org.oscarehr.common.dao.AdmissionDao;
import org.oscarehr.PMmodule.dao.DefaultRoleAccessDAO;
import org.oscarehr.PMmodule.dao.ProgramAccessDAO;
import org.oscarehr.PMmodule.dao.ProgramClientStatusDAO;
import org.oscarehr.PMmodule.dao.ProgramDao;
import org.oscarehr.PMmodule.dao.ProgramFunctionalUserDAO;
import org.oscarehr.PMmodule.dao.ProgramProviderDAO;
import org.oscarehr.PMmodule.dao.ProgramSignatureDao;
import org.oscarehr.PMmodule.dao.ProgramTeamDAO;
import org.oscarehr.PMmodule.dao.VacancyTemplateDao;
import org.oscarehr.PMmodule.model.AccessType;
import org.oscarehr.common.model.Admission;
import org.oscarehr.PMmodule.model.DefaultRoleAccess;
import org.oscarehr.PMmodule.model.FunctionalUserType;
import org.oscarehr.PMmodule.model.Program;
import org.oscarehr.PMmodule.model.ProgramAccess;
import org.oscarehr.PMmodule.model.ProgramClientStatus;
import org.oscarehr.PMmodule.model.ProgramFunctionalUser;
import org.oscarehr.PMmodule.model.ProgramProvider;
import org.oscarehr.PMmodule.model.ProgramSignature;
import org.oscarehr.PMmodule.model.ProgramTeam;
import org.oscarehr.PMmodule.model.VacancyTemplate;
import org.oscarehr.util.LoggedInInfo;
import oscar.OscarProperties;

public interface ProgramManager {

    boolean getEnabled();

    void setEnabled(boolean enabled);

    ProgramSignatureDao getProgramSignatureDao();

    void setProgramSignatureDao(ProgramSignatureDao programSignatureDao);

    void setProgramDao(ProgramDao dao);

    void setProgramProviderDAO(ProgramProviderDAO dao);

    void setProgramFunctionalUserDAO(ProgramFunctionalUserDAO dao);

    void setProgramTeamDAO(ProgramTeamDAO dao);

    void setProgramAccessDAO(ProgramAccessDAO dao);

    void setAdmissionDao(AdmissionDao dao);

    void setDefaultRoleAccessDAO(DefaultRoleAccessDAO dao);

    void setProgramClientStatusDAO(ProgramClientStatusDAO dao);

    Program getProgram(String programId);

    Program getProgram(Integer programId);

    Program getProgram(Long programId);
    
    List<Program> getActiveProgramByFacility(String providerNo, Integer facilityId);

    String getProgramName(String programId);

    Integer getProgramIdByProgramName(String programName);

    List<Program> getAllPrograms();

    List<Program> getAllPrograms(String programStatus, String type, int facilityId);

    List<Program> getCommunityPrograms(Integer facilityId);

    List<Program> getPrograms(Integer facilityId);

    List<Program> getPrograms();

    Program[] getBedPrograms();

    Program[] getBedPrograms(Integer facilityId);

    List<Program> getServicePrograms();

    Program[] getExternalPrograms();

    boolean isBedProgram(String programId);

    boolean isServiceProgram(String programId);

    boolean isCommunityProgram(String programId);

    void saveProgram(Program program);

    void removeProgram(String programId);

    List<ProgramProvider> getProgramProviders(String programId);

    List<ProgramProvider> getProgramProvidersByProvider(String providerNo);

    ProgramProvider getProgramProvider(String id);

    ProgramProvider getProgramProvider(String providerNo, String programId);

    void saveProgramProvider(ProgramProvider pp);

    void deleteProgramProvider(String id);

    void deleteProgramProviderByProgramId(Long programId);

    List<FunctionalUserType> getFunctionalUserTypes();

    FunctionalUserType getFunctionalUserType(String id);

    void saveFunctionalUserType(FunctionalUserType fut);

    void deleteFunctionalUserType(String id);

    List<FunctionalUserType> getFunctionalUsers(String programId);

    ProgramFunctionalUser getFunctionalUser(String id);

    void saveFunctionalUser(ProgramFunctionalUser pfu);

    void deleteFunctionalUser(String id);

    Long getFunctionalUserByUserType(Long programId, Long userTypeId);

    List<ProgramTeam> getProgramTeams(String programId);

    ProgramTeam getProgramTeam(String id);

    void saveProgramTeam(ProgramTeam team);

    void deleteProgramTeam(String id);

    boolean teamNameExists(Integer programId, String teamName);

    List<ProgramAccess> getProgramAccesses(String programId);

    ProgramAccess getProgramAccess(String id);

    void saveProgramAccess(ProgramAccess pa);

    void deleteProgramAccess(String id);

    List<AccessType> getAccessTypes();

    AccessType getAccessType(Long id);

    List<ProgramProvider> getAllProvidersInTeam(Integer programId, Integer teamId);

    List<Admission> getAllClientsInTeam(Integer programId, Integer teamId);

    List<Program> search(Program criteria);

    List<Program> searchByFacility(Program criteria, Integer facilityId);

    Program getHoldingTankProgram();

    ProgramAccess getProgramAccess(String programId, String accessTypeId);

    List<Program> getProgramDomain(String providerNo);

    List<Program> getActiveProgramDomain(String providerNo);

    List<Program> getProgramDomainInCurrentFacilityForCurrentProvider(LoggedInInfo loggedInInfo, boolean activeOnly);

    Program[] getCommunityPrograms();

    List<LabelValueBean> getProgramBeans(String providerNo);

    List<DefaultRoleAccess> getDefaultRoleAccesses();

    DefaultRoleAccess getDefaultRoleAccess(String id);

    void saveDefaultRoleAccess(DefaultRoleAccess dra);

    void deleteDefaultRoleAccess(String id);

    DefaultRoleAccess findDefaultRoleAccess(long roleId, long accessTypeId);

    List<ProgramClientStatus> getProgramClientStatuses(Integer programId);

    void saveProgramClientStatus(ProgramClientStatus status);

    void deleteProgramClientStatus(String id);

    boolean clientStatusNameExists(Integer programId, String statusName);

    List<Admission> getAllClientsInStatus(Integer programId, Integer statusId);

    ProgramClientStatus getProgramClientStatus(String statusId);

    ProgramSignature getProgramFirstSignature(Integer programId);

    List<ProgramSignature> getProgramSignatures(Integer programId);

    void saveProgramSignature(ProgramSignature programSignature);
    
    VacancyTemplate getVacancyTemplate(Integer templateId);

    void setVacancyTemplateDao(VacancyTemplateDao vacancyTemplateDao);

    boolean hasAccessBasedOnCurrentFacility(LoggedInInfo loggedInInfo, Integer programId);

    List<Program> getAllProgramsByRole(String providerNo,int roleId);
}
