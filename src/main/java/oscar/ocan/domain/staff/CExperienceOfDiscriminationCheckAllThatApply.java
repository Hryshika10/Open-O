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
 *         &lt;element ref="{}CDisability"/>
 *         &lt;element ref="{}CEthnicity"/>
 *         &lt;element ref="{}CGender"/>
 *         &lt;element ref="{}CImmigration"/>
 *         &lt;element ref="{}CMental_Illness"/>
 *         &lt;element ref="{}CRace"/>
 *         &lt;element ref="{}CReligion"/>
 *         &lt;element ref="{}CSexual_orientation"/>
 *         &lt;element ref="{}CUnknown"/>
 *         &lt;element ref="{}CClient_declined_to_answer"/>
 *         &lt;element ref="{}COther_"/>
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
    "cDisability",
    "cEthnicity",
    "cGender",
    "cImmigration",
    "cMentalIllness",
    "cRace",
    "cReligion",
    "cSexualOrientation",
    "cUnknown",
    "cClientDeclinedToAnswer",
    "cOther"
})
@XmlRootElement(name = "CExperience_of_Discrimination__check_all_that_apply_")
public class CExperienceOfDiscriminationCheckAllThatApply {

    @XmlElement(name = "CDisability", required = true)
    protected String cDisability;
    @XmlElement(name = "CEthnicity", required = true)
    protected String cEthnicity;
    @XmlElement(name = "CGender", required = true)
    protected String cGender;
    @XmlElement(name = "CImmigration", required = true)
    protected String cImmigration;
    @XmlElement(name = "CMental_Illness", required = true)
    protected String cMentalIllness;
    @XmlElement(name = "CRace", required = true)
    protected String cRace;
    @XmlElement(name = "CReligion", required = true)
    protected String cReligion;
    @XmlElement(name = "CSexual_orientation", required = true)
    protected String cSexualOrientation;
    @XmlElement(name = "CUnknown", required = true)
    protected String cUnknown;
    @XmlElement(name = "CClient_declined_to_answer", required = true)
    protected String cClientDeclinedToAnswer;
    @XmlElement(name = "COther_", required = true)
    protected String cOther;

    /**
     * Gets the value of the cDisability property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDisability() {
        return cDisability;
    }

    /**
     * Sets the value of the cDisability property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDisability(String value) {
        this.cDisability = value;
    }

    /**
     * Gets the value of the cEthnicity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEthnicity() {
        return cEthnicity;
    }

    /**
     * Sets the value of the cEthnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEthnicity(String value) {
        this.cEthnicity = value;
    }

    /**
     * Gets the value of the cGender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCGender() {
        return cGender;
    }

    /**
     * Sets the value of the cGender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCGender(String value) {
        this.cGender = value;
    }

    /**
     * Gets the value of the cImmigration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCImmigration() {
        return cImmigration;
    }

    /**
     * Sets the value of the cImmigration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCImmigration(String value) {
        this.cImmigration = value;
    }

    /**
     * Gets the value of the cMentalIllness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMentalIllness() {
        return cMentalIllness;
    }

    /**
     * Sets the value of the cMentalIllness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMentalIllness(String value) {
        this.cMentalIllness = value;
    }

    /**
     * Gets the value of the cRace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRace() {
        return cRace;
    }

    /**
     * Sets the value of the cRace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRace(String value) {
        this.cRace = value;
    }

    /**
     * Gets the value of the cReligion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCReligion() {
        return cReligion;
    }

    /**
     * Sets the value of the cReligion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCReligion(String value) {
        this.cReligion = value;
    }

    /**
     * Gets the value of the cSexualOrientation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSexualOrientation() {
        return cSexualOrientation;
    }

    /**
     * Sets the value of the cSexualOrientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSexualOrientation(String value) {
        this.cSexualOrientation = value;
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

    /**
     * Gets the value of the cOther property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOther() {
        return cOther;
    }

    /**
     * Sets the value of the cOther property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOther(String value) {
        this.cOther = value;
    }

}
