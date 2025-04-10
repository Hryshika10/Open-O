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
// Generated on: 2009.05.24 at 10:52:14 PM EDT 
//


package oscar.ocan.domain.staff;

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
 *         &lt;element ref="{}CEmployment"/>
 *         &lt;element ref="{}CEmployment_insurance"/>
 *         &lt;element ref="{}CPension"/>
 *         &lt;element ref="{}CODSP"/>
 *         &lt;element ref="{}CSocial_Assistance"/>
 *         &lt;element ref="{}CDisability_Assistance"/>
 *         &lt;element ref="{}CFamily"/>
 *         &lt;element ref="{}CNo_source_of_income"/>
 *         &lt;element ref="{}COther"/>
 *         &lt;element ref="{}CUnknown"/>
 *         &lt;element ref="{}CClient_declined_to_answer"/>
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
    "cEmployment",
    "cEmploymentInsurance",
    "cPension",
    "codsp",
    "cSocialAssistance",
    "cDisabilityAssistance",
    "cFamily",
    "cNoSourceOfIncome",
    "cOther",
    "cUnknown",
    "cClientDeclinedToAnswer"
})
@XmlRootElement(name = "CWhat_is_your_primary_source_of_income___select_one_")
public class CWhatIsYourPrimarySourceOfIncomeSelectOne {

    @XmlElement(name = "CEmployment", required = true)
    protected String cEmployment;
    @XmlElement(name = "CEmployment_insurance", required = true)
    protected String cEmploymentInsurance;
    @XmlElement(name = "CPension", required = true)
    protected String cPension;
    @XmlElement(name = "CODSP", required = true)
    protected String codsp;
    @XmlElement(name = "CSocial_Assistance", required = true)
    protected String cSocialAssistance;
    @XmlElement(name = "CDisability_Assistance", required = true)
    protected String cDisabilityAssistance;
    @XmlElement(name = "CFamily", required = true)
    protected String cFamily;
    @XmlElement(name = "CNo_source_of_income", required = true)
    protected String cNoSourceOfIncome;
    @XmlElement(name = "COther", required = true)
    protected COther cOther;
    @XmlElement(name = "CUnknown", required = true)
    protected String cUnknown;
    @XmlElement(name = "CClient_declined_to_answer", required = true)
    protected String cClientDeclinedToAnswer;

    /**
     * Gets the value of the cEmployment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEmployment() {
        return cEmployment;
    }

    /**
     * Sets the value of the cEmployment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEmployment(String value) {
        this.cEmployment = value;
    }

    /**
     * Gets the value of the cEmploymentInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEmploymentInsurance() {
        return cEmploymentInsurance;
    }

    /**
     * Sets the value of the cEmploymentInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEmploymentInsurance(String value) {
        this.cEmploymentInsurance = value;
    }

    /**
     * Gets the value of the cPension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPension() {
        return cPension;
    }

    /**
     * Sets the value of the cPension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPension(String value) {
        this.cPension = value;
    }

    /**
     * Gets the value of the codsp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODSP() {
        return codsp;
    }

    /**
     * Sets the value of the codsp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODSP(String value) {
        this.codsp = value;
    }

    /**
     * Gets the value of the cSocialAssistance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSocialAssistance() {
        return cSocialAssistance;
    }

    /**
     * Sets the value of the cSocialAssistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSocialAssistance(String value) {
        this.cSocialAssistance = value;
    }

    /**
     * Gets the value of the cDisabilityAssistance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDisabilityAssistance() {
        return cDisabilityAssistance;
    }

    /**
     * Sets the value of the cDisabilityAssistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDisabilityAssistance(String value) {
        this.cDisabilityAssistance = value;
    }

    /**
     * Gets the value of the cFamily property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFamily() {
        return cFamily;
    }

    /**
     * Sets the value of the cFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFamily(String value) {
        this.cFamily = value;
    }

    /**
     * Gets the value of the cNoSourceOfIncome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNoSourceOfIncome() {
        return cNoSourceOfIncome;
    }

    /**
     * Sets the value of the cNoSourceOfIncome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNoSourceOfIncome(String value) {
        this.cNoSourceOfIncome = value;
    }

    /**
     * Gets the value of the cOther property.
     * 
     * @return
     *     possible object is
     *     {@link COther }
     *     
     */
    public COther getCOther() {
        return cOther;
    }

    /**
     * Sets the value of the cOther property.
     * 
     * @param value
     *     allowed object is
     *     {@link COther }
     *     
     */
    public void setCOther(COther value) {
        this.cOther = value;
    }

    /**
     * Gets the value of the cUnknown property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUnknown() {
        return cUnknown;
    }

    /**
     * Sets the value of the cUnknown property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUnknown(String value) {
        this.cUnknown = value;
    }

    /**
     * Gets the value of the cClientDeclinedToAnswer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCClientDeclinedToAnswer() {
        return cClientDeclinedToAnswer;
    }

    /**
     * Sets the value of the cClientDeclinedToAnswer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCClientDeclinedToAnswer(String value) {
        this.cClientDeclinedToAnswer = value;
    }

}
