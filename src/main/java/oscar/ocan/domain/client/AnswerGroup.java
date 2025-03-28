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
 *         &lt;element ref="{}CNo_Need"/>
 *         &lt;element ref="{}CMet_Need"/>
 *         &lt;element ref="{}CUnmet_Need"/>
 *         &lt;element ref="{}CI_don_t_want_to_answer"/>
 *         &lt;element ref="{}CComments__"/>
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
    "cNoNeed",
    "cMetNeed",
    "cUnmetNeed",
    "ciDonTWantToAnswer",
    "cComments"
})
@XmlRootElement(name = "AnswerGroup")
public class AnswerGroup {

    @XmlElement(name = "CNo_Need", required = true)
    protected String cNoNeed;
    @XmlElement(name = "CMet_Need", required = true)
    protected String cMetNeed;
    @XmlElement(name = "CUnmet_Need", required = true)
    protected String cUnmetNeed;
    @XmlElement(name = "CI_don_t_want_to_answer", required = true)
    protected String ciDonTWantToAnswer;
    @XmlElement(name = "CComments__", required = true)
    protected String cComments;

    /**
     * Gets the value of the cNoNeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNoNeed() {
        return cNoNeed;
    }

    /**
     * Sets the value of the cNoNeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNoNeed(String value) {
        this.cNoNeed = value;
    }

    /**
     * Gets the value of the cMetNeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMetNeed() {
        return cMetNeed;
    }

    /**
     * Sets the value of the cMetNeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMetNeed(String value) {
        this.cMetNeed = value;
    }

    /**
     * Gets the value of the cUnmetNeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUnmetNeed() {
        return cUnmetNeed;
    }

    /**
     * Sets the value of the cUnmetNeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUnmetNeed(String value) {
        this.cUnmetNeed = value;
    }

    /**
     * Gets the value of the ciDonTWantToAnswer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIDonTWantToAnswer() {
        return ciDonTWantToAnswer;
    }

    /**
     * Sets the value of the ciDonTWantToAnswer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIDonTWantToAnswer(String value) {
        this.ciDonTWantToAnswer = value;
    }

    /**
     * Gets the value of the cComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCComments() {
        return cComments;
    }

    /**
     * Sets the value of the cComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCComments(String value) {
        this.cComments = value;
    }

}
