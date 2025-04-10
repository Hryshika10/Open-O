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


package oscar.decision;

import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.oscarehr.util.MiscUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DesAnnualReviewPlannerChecklist {

    public String doStuff(String uri, String savedltcrisks) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ContentHandler contentHandler = new DesAnnualReviewPlannerChecklistHandler(savedltcrisks);
            saxParser.parse(uri, (DefaultHandler) contentHandler);

            return ((DesAnnualReviewPlannerChecklistHandler) contentHandler).getResults();
        } catch (IOException e) {
            MiscUtils.getLogger().debug("Error reading URI: " + e.getMessage());
        } catch (SAXException e) {
            MiscUtils.getLogger().debug("Error in parsing: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            MiscUtils.getLogger().debug("Error configuring parser: " + e.getMessage());
        }

        return "Error: unable to find/parse the risks xml file, CHECK if the format is correct";
    }

    public String doStuff(String uri, Properties savedltcrisks) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ContentHandler contentHandler = new DesAnnualReviewPlannerChecklistHandler(savedltcrisks);
            saxParser.parse(uri, (DefaultHandler) contentHandler);

            return ((DesAnnualReviewPlannerChecklistHandler) contentHandler).getResults();
        } catch (IOException e) {
            MiscUtils.getLogger().debug("Error reading URI: " + e.getMessage());
        } catch (SAXException e) {
            MiscUtils.getLogger().debug("Error in parsing: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            MiscUtils.getLogger().debug("Error configuring parser: " + e.getMessage());
        }

        return "Error: unable to find/parse the risks xml file, CHECK if the format is correct";
    }
}
