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

import java.math.BigInteger;

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
 *         &lt;element ref="{}C1__Does_the_person_have_any_problems_using_public_transport___If_rated_0_or_9__go_to_the_next_d"/>
 *         &lt;element ref="{}C2__How_much_help_with_travelling_does_the_person_receive_from_friends_or_relatives_"/>
 *         &lt;element ref="{}C3a__How_much_help_with_travelling_does_the_person_receive_from_local_services_"/>
 *         &lt;element ref="{}C3b__How_much_help_with_travelling_does_the_person_need_from_local_services_"/>
 *         &lt;element ref="{}CComments_"/>
 *         &lt;element ref="{}CActions_"/>
 *         &lt;element ref="{}CBy_whom_"/>
 *         &lt;element ref="{}CReview_date_"/>
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
    "c1DoesThePersonHaveAnyProblemsUsingPublicTransportIfRated0Or9GoToTheNextD",
    "c2HowMuchHelpWithTravellingDoesThePersonReceiveFromFriendsOrRelatives",
    "c3AHowMuchHelpWithTravellingDoesThePersonReceiveFromLocalServices",
    "c3BHowMuchHelpWithTravellingDoesThePersonNeedFromLocalServices",
    "cComments",
    "cActions",
    "cByWhom",
    "cReviewDate"
})
@XmlRootElement(name = "C22__Transport__Do_you_have_access_to_transportation__Do_you_have_access_to_other_affordable_tra")
public class C22TransportDoYouHaveAccessToTransportationDoYouHaveAccessToOtherAffordableTra {

    @XmlElement(name = "C1__Does_the_person_have_any_problems_using_public_transport___If_rated_0_or_9__go_to_the_next_d", required = true)
    protected BigInteger c1DoesThePersonHaveAnyProblemsUsingPublicTransportIfRated0Or9GoToTheNextD;
    @XmlElement(name = "C2__How_much_help_with_travelling_does_the_person_receive_from_friends_or_relatives_", required = true)
    protected BigInteger c2HowMuchHelpWithTravellingDoesThePersonReceiveFromFriendsOrRelatives;
    @XmlElement(name = "C3a__How_much_help_with_travelling_does_the_person_receive_from_local_services_", required = true)
    protected BigInteger c3AHowMuchHelpWithTravellingDoesThePersonReceiveFromLocalServices;
    @XmlElement(name = "C3b__How_much_help_with_travelling_does_the_person_need_from_local_services_", required = true)
    protected BigInteger c3BHowMuchHelpWithTravellingDoesThePersonNeedFromLocalServices;
    @XmlElement(name = "CComments_", required = true)
    protected CComments cComments;
    @XmlElement(name = "CActions_", required = true)
    protected String cActions;
    @XmlElement(name = "CBy_whom_", required = true)
    protected String cByWhom;
    @XmlElement(name = "CReview_date_", required = true)
    protected String cReviewDate;

    /**
     * Gets the value of the c1DoesThePersonHaveAnyProblemsUsingPublicTransportIfRated0Or9GoToTheNextD property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getC1DoesThePersonHaveAnyProblemsUsingPublicTransportIfRated0Or9GoToTheNextD() {
        return c1DoesThePersonHaveAnyProblemsUsingPublicTransportIfRated0Or9GoToTheNextD;
    }

    /**
     * Sets the value of the c1DoesThePersonHaveAnyProblemsUsingPublicTransportIfRated0Or9GoToTheNextD property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setC1DoesThePersonHaveAnyProblemsUsingPublicTransportIfRated0Or9GoToTheNextD(BigInteger value) {
        this.c1DoesThePersonHaveAnyProblemsUsingPublicTransportIfRated0Or9GoToTheNextD = value;
    }

    /**
     * Gets the value of the c2HowMuchHelpWithTravellingDoesThePersonReceiveFromFriendsOrRelatives property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getC2HowMuchHelpWithTravellingDoesThePersonReceiveFromFriendsOrRelatives() {
        return c2HowMuchHelpWithTravellingDoesThePersonReceiveFromFriendsOrRelatives;
    }

    /**
     * Sets the value of the c2HowMuchHelpWithTravellingDoesThePersonReceiveFromFriendsOrRelatives property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setC2HowMuchHelpWithTravellingDoesThePersonReceiveFromFriendsOrRelatives(BigInteger value) {
        this.c2HowMuchHelpWithTravellingDoesThePersonReceiveFromFriendsOrRelatives = value;
    }

    /**
     * Gets the value of the c3AHowMuchHelpWithTravellingDoesThePersonReceiveFromLocalServices property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getC3AHowMuchHelpWithTravellingDoesThePersonReceiveFromLocalServices() {
        return c3AHowMuchHelpWithTravellingDoesThePersonReceiveFromLocalServices;
    }

    /**
     * Sets the value of the c3AHowMuchHelpWithTravellingDoesThePersonReceiveFromLocalServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setC3AHowMuchHelpWithTravellingDoesThePersonReceiveFromLocalServices(BigInteger value) {
        this.c3AHowMuchHelpWithTravellingDoesThePersonReceiveFromLocalServices = value;
    }

    /**
     * Gets the value of the c3BHowMuchHelpWithTravellingDoesThePersonNeedFromLocalServices property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getC3BHowMuchHelpWithTravellingDoesThePersonNeedFromLocalServices() {
        return c3BHowMuchHelpWithTravellingDoesThePersonNeedFromLocalServices;
    }

    /**
     * Sets the value of the c3BHowMuchHelpWithTravellingDoesThePersonNeedFromLocalServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setC3BHowMuchHelpWithTravellingDoesThePersonNeedFromLocalServices(BigInteger value) {
        this.c3BHowMuchHelpWithTravellingDoesThePersonNeedFromLocalServices = value;
    }

    /**
     * Gets the value of the cComments property.
     * 
     * @return
     *     possible object is
     *     {@link CComments }
     *     
     */
    public CComments getCComments() {
        return cComments;
    }

    /**
     * Sets the value of the cComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link CComments }
     *     
     */
    public void setCComments(CComments value) {
        this.cComments = value;
    }

    /**
     * Gets the value of the cActions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCActions() {
        return cActions;
    }

    /**
     * Sets the value of the cActions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCActions(String value) {
        this.cActions = value;
    }

    /**
     * Gets the value of the cByWhom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCByWhom() {
        return cByWhom;
    }

    /**
     * Sets the value of the cByWhom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCByWhom(String value) {
        this.cByWhom = value;
    }

    /**
     * Gets the value of the cReviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCReviewDate() {
        return cReviewDate;
    }

    /**
     * Sets the value of the cReviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCReviewDate(String value) {
        this.cReviewDate = value;
    }

}
