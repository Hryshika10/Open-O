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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.05.21 at 12:50:19 PM EDT 
//


package oscar.ocan.domain.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}CStart_Date__"/>
 *         &lt;element ref="{}CEnd_Date__"/>
 *         &lt;element ref="{}CWhen_you_have_completed_this_assessment__your_worker_will_have_a_conversation_with_you_about_yo"/>
 *         &lt;element ref="{}CPlease_please_a_check_mark_in_each_row__24_in_total__using_the_following_key__"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cStartDate",
    "cEndDate",
    "cWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo",
    "cPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey"
})
@XmlRootElement(name = "CInstructions")
public class CInstructions {

    @XmlElement(name = "CStart_Date__", required = true)
    protected String cStartDate;
    @XmlElement(name = "CEnd_Date__", required = true)
    protected String cEndDate;
    @XmlElement(name = "CWhen_you_have_completed_this_assessment__your_worker_will_have_a_conversation_with_you_about_yo", required = true)
    protected CWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo cWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo;
    @XmlElement(name = "CPlease_please_a_check_mark_in_each_row__24_in_total__using_the_following_key__", required = true)
    protected CPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey cPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey;

    /**
     * Gets the value of the cStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCStartDate() {
        return cStartDate;
    }

    /**
     * Sets the value of the cStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCStartDate(String value) {
        this.cStartDate = value;
    }

    /**
     * Gets the value of the cEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEndDate() {
        return cEndDate;
    }

    /**
     * Sets the value of the cEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEndDate(String value) {
        this.cEndDate = value;
    }

    /**
     * Gets the value of the cWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo property.
     * 
     * @return
     *     possible object is
     *     {@link CWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo }
     *     
     */
    public CWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo getCWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo() {
        return cWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo;
    }

    /**
     * Sets the value of the cWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo }
     *     
     */
    public void setCWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo(CWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo value) {
        this.cWhenYouHaveCompletedThisAssessmentYourWorkerWillHaveAConversationWithYouAboutYo = value;
    }

    /**
     * Gets the value of the cPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey property.
     * 
     * @return
     *     possible object is
     *     {@link CPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey }
     *     
     */
    public CPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey getCPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey() {
        return cPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey;
    }

    /**
     * Sets the value of the cPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link CPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey }
     *     
     */
    public void setCPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey(CPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey value) {
        this.cPleasePleaseACheckMarkInEachRow24InTotalUsingTheFollowingKey = value;
    }

}
