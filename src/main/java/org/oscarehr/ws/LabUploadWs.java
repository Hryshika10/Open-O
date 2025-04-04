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

package org.oscarehr.ws;

import org.apache.commons.io.FileUtils;
import org.apache.cxf.annotations.GZIP;
import org.apache.logging.log4j.Logger;
import org.oscarehr.common.model.enumerator.LabType;
import org.oscarehr.util.LoggedInInfo;
import org.oscarehr.util.MiscUtils;
import org.springframework.stereotype.Component;
import oscar.OscarProperties;
import oscar.log.LogAction;
import oscar.oscarLab.FileUploadCheck;
import oscar.oscarLab.ca.all.upload.HandlerClassFactory;
import oscar.oscarLab.ca.all.upload.handlers.MessageHandler;
import oscar.oscarLab.ca.all.util.Utilities;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;


@WebService
@Component
@GZIP(threshold=AbstractWs.GZIP_THRESHOLD)
public class LabUploadWs extends AbstractWs {

    private static final Logger logger=MiscUtils.getLogger();

    public String uploadCLS(
            @WebParam(name="file_name") String fileName,
            @WebParam(name="contents") String contents,
            @WebParam(name="oscar_provider_no") String oscarProviderNo 
            )
    {
        String returnMessage, audit;
        
        try {
            audit = importLab(fileName, contents, LabType.CLS, oscarProviderNo);

        } catch(Exception e)
        {
            logger.error(e.getMessage());
            returnMessage = "{\"success\":0,\"message\":\"" +
                e.getMessage() + "\", \"audit\":\"\"}";
            return returnMessage;
        }

        returnMessage = "{\"success\":1,\"message\":\"\", \"audit\":\""+audit+"\"}";
        return returnMessage;
    }

    public String uploadCML(
            @WebParam(name="file_name") String fileName,
            @WebParam(name="contents") String contents,
            @WebParam(name="oscar_provider_no") String oscarProviderNo 
            )
    {
        String returnMessage, audit;
        
        try {
            audit = importLab(fileName, contents, LabType.CML,oscarProviderNo);

        } catch(Exception e)
        {
            logger.error(e.getMessage());
            returnMessage = "{\"success\":0,\"message\":\"" +
                e.getMessage() + "\", \"audit\":\"\"}";
            return returnMessage;
        }

        returnMessage = "{\"success\":1,\"message\":\"\", \"audit\":\""+audit+"\"}";
        return returnMessage;
    }

    public String uploadLifelabs(
            @WebParam(name="file_name") String fileName,
            @WebParam(name="contents") String contents,
            @WebParam(name="oscar_provider_no") String oscarProviderNo 
            )
    {
        String returnMessage, audit;
        
        try {
        	audit = importLab(fileName, contents, LabType.MDS, oscarProviderNo);
        } catch(Exception e)
        {
            logger.error(e.getMessage());
            returnMessage = "{\"success\":0,\"message\":\"" +
                e.getMessage() + "\", \"audit\":\"\"}";
            return returnMessage;
        }

        returnMessage = "{\"success\":1,\"message\":\"\", \"audit\":\""+audit+"\"}";
        return returnMessage;
    }

    public String uploadExcelleris(
            @WebParam(name="file_name") String fileName,
            @WebParam(name="contents") String contents,
            @WebParam(name="oscar_provider_no") String oscarProviderNo 
    )
    {
        String returnMessage, audit;

	    LabType labType = LabType.EXCELLERIS;
		/*
		 * Quick and dirty work around to enable the different lab handler
		 * for Exelleris lab versions used in Ontario.
		 * This wont be a forever solution.
		 */
		if(OscarProperties.getInstance().isOntarioBillingRegion()) {
			labType = LabType.ExcellerisON;
		}
        
        try {
        	audit = importLab(fileName, contents, labType, oscarProviderNo);
        } catch(Exception e)
        {
            logger.error(e.getMessage());
            returnMessage = "{\"success\":0,\"message\":\"" +
                e.getMessage() + "\", \"audit\":\"\"}";
            return returnMessage;
        }
        returnMessage = "{\"success\":1,\"message\":\"\", \"audit\":\""+audit+"\"}";
        return returnMessage;
    }
    
    public String uploadIHA(
            @WebParam(name="file_name") String fileName,
            @WebParam(name="contents") String contents,
            @WebParam(name="oscar_provider_no") String oscarProviderNo 
            )
    {
        String returnMessage, audit;
        
        try {
        	audit = importLab(fileName, contents, LabType.IHAPOI, oscarProviderNo);
        } catch(Exception e)
        {
            logger.error(e.getMessage());
            returnMessage = "{\"success\":0,\"message\":\"" +
                e.getMessage() + "\", \"audit\":\"\"}";
            return returnMessage;
        }

        returnMessage = "{\"success\":1,\"message\":\"\", \"audit\":\""+audit+"\"}";
        return returnMessage;
    }
    
    public String uploadGammaDynacare(
            @WebParam(name="file_name") String fileName,
            @WebParam(name="contents") String contents,
            @WebParam(name="oscar_provider_no") String oscarProviderNo 
            )
    {
        String returnMessage, audit;
        
        try {
            audit = importLab(fileName, contents, LabType.GDML, oscarProviderNo);
        } catch(Exception e)
        {
            logger.error(e.getMessage());
            returnMessage = "{\"success\":0,\"message\":\"" +
                e.getMessage() + "\", \"audit\":\"\"}";
            return returnMessage;
        }

        returnMessage = "{\"success\":1,\"message\":\"\", \"audit\":\""+audit+"\"}";
        return returnMessage;
    }

    public String uploadCDL(
            @WebParam(name="file_name") String fileName,
            @WebParam(name="contents") String contents,
            @WebParam(name="oscar_provider_no") String oscarProviderNo 
            )
    {
        String returnMessage, audit;
        
        try {
            audit = importLab(fileName, contents, LabType.CDL, oscarProviderNo);
        } catch(Exception e)
        {
            logger.error(e.getMessage());
            returnMessage = "{\"success\":0,\"message\":\"" +
                e.getMessage() + "\", \"audit\":\"\"}";
            return returnMessage;
        }

        returnMessage = "{\"success\":1,\"message\":\"\", \"audit\":\""+audit+"\"}";
        return returnMessage;
    }
    
    public String uploadPDF(@WebParam(name="file_name") String fileName,
    						   @WebParam(name="contents") byte[] contents,
    						   @WebParam(name="oscar_provider_no") String oscarProviderNo ){
    		logger.error("uploadPDF called file name "+fileName+" provider "+oscarProviderNo+" contnets "+contents);
    	    String returnMessageHandler = "{\"success\":0,\"message\":\"\"}";

    		try(ByteArrayInputStream is = new ByteArrayInputStream(contents)) {
			    String filePath = Utilities.savePdfFile(is, fileName);
			    HttpServletRequest request = getHttpServletRequest();
			    LoggedInInfo loggedInInfo = LoggedInInfo.getLoggedInInfoFromRequest(request);

			    MessageHandler msgHandler = HandlerClassFactory.getHandler("PDFDOC");
			    returnMessageHandler =  msgHandler.parse(loggedInInfo, oscarProviderNo, filePath, 0, request.getRemoteAddr());
		    } catch (Exception e) {
				logger.error("", e);
	        }
	        return returnMessageHandler;
    }
    
    public String uploadDocumentReference(@WebParam(name="file_name") String fileName,
			   @WebParam(name="contents") byte[] contents,
			   @WebParam(name="oscar_provider_no") String oscarProviderNo ){
	        String returnMessageHandler = "{\"success\":0,\"message\":\"\"}";
            try(ByteArrayInputStream is = new ByteArrayInputStream(contents)) {
			    String filePath = Utilities.saveFile(is, fileName);
			    HttpServletRequest request = getHttpServletRequest();
			    LoggedInInfo loggedInInfo = LoggedInInfo.getLoggedInInfoFromRequest(request);

			    MessageHandler msgHandler = HandlerClassFactory.getHandler("FHIR_COMMUNICATION_REQUEST");
			    returnMessageHandler = msgHandler.parse(loggedInInfo, oscarProviderNo, filePath, 0, request.getRemoteAddr());
		    } catch (Exception e) {
				logger.error("", e);
		    }
			return returnMessageHandler;
    }

    private String importLab(String fileName, String labContent, LabType labType, String oscarProviderNo)
		throws Exception
    {
		HttpServletRequest request = getHttpServletRequest();

        OscarProperties props = OscarProperties.getInstance();
        String labFolderPath = props.getProperty("DOCUMENT_DIR") + "labs";
        String retVal = "";

    	LoggedInInfo loggedInInfo = 
			LoggedInInfo.getLoggedInInfoFromRequest(request);
		String ipAddr = request.getRemoteAddr();


        File labFolder = new File(labFolderPath);

        if(!labFolder.exists())
        {
            if(!labFolder.mkdir())
            {
                throw new IOException("Failed to create lab upload folder! " + labFolderPath);
            }
        }

        // Use same naming convention as manually uploaded labs, but place in the labs folder
        fileName = "LabUpload."+fileName.replaceAll(".enc", "")+"."+(new Date()).getTime();
        String labFilePath = labFolderPath + "/" + fileName;

        // Save a copy of the lab locally. This is done to mimic the manual lab
        // upload process.
        FileUtils.writeStringToFile(new File(labFilePath), labContent);
        
        // Upload lab info and hash to DB to check for duplicates
        FileInputStream is = new FileInputStream(labFilePath);
        int checkFileUploadedSuccessfully = FileUploadCheck.addFile(fileName,is,oscarProviderNo);            
        is.close();
        if (checkFileUploadedSuccessfully != FileUploadCheck.UNSUCCESSFUL_SAVE){
            logger.info("filePath" + labFilePath);
            logger.info("Type :" + labType.name());
            MessageHandler msgHandler = HandlerClassFactory.getHandler(labType.getName());
            logger.info("MESSAGE HANDLER "+msgHandler.getClass().getName());
            
            // Parse and handle the lab
            if((retVal = msgHandler.parse(
				loggedInInfo,
				getClass().getSimpleName(), 
				labFilePath,
				checkFileUploadedSuccessfully,
				ipAddr
			)) == null) {
            	throw new ParseException("Failed to parse lab: " + fileName + " of type: " + labType.name(), 0);
            }
                        
        }else{
        	throw new SQLException("Failed insert lab into DB (Likely duplicate lab): " + fileName + " of type: " + labType.name());
        }
        
        // This will always contain one line, so let's just remove the newline characters
        retVal = retVal.replace("\n", "").replace("\r", "");

		LogAction.addLogSynchronous(loggedInInfo, "LabUploadWs.importLab", "fileUploadCheckId=" + String.valueOf(checkFileUploadedSuccessfully));
        
        return retVal;
    }
}
