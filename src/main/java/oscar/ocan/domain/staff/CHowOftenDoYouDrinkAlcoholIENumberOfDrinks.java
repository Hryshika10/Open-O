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
 *         &lt;element ref="{}CDrinks_monthly_"/>
 *         &lt;element ref="{}CDrinks_weekly_"/>
 *         &lt;element ref="{}CDrinks_2_3_times_weekly_"/>
 *         &lt;element ref="{}CDrinks_daily_"/>
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
    "cDrinksMonthly",
    "cDrinksWeekly",
    "cDrinks23TimesWeekly",
    "cDrinksDaily"
})
@XmlRootElement(name = "CHow_often_do_you_drink_alcohol___i_e__number_of_drinks__")
public class CHowOftenDoYouDrinkAlcoholIENumberOfDrinks {

    @XmlElement(name = "CDrinks_monthly_", required = true)
    protected BigInteger cDrinksMonthly;
    @XmlElement(name = "CDrinks_weekly_", required = true)
    protected BigInteger cDrinksWeekly;
    @XmlElement(name = "CDrinks_2_3_times_weekly_", required = true)
    protected BigInteger cDrinks23TimesWeekly;
    @XmlElement(name = "CDrinks_daily_", required = true)
    protected BigInteger cDrinksDaily;

    /**
     * Gets the value of the cDrinksMonthly property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCDrinksMonthly() {
        return cDrinksMonthly;
    }

    /**
     * Sets the value of the cDrinksMonthly property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCDrinksMonthly(BigInteger value) {
        this.cDrinksMonthly = value;
    }

    /**
     * Gets the value of the cDrinksWeekly property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCDrinksWeekly() {
        return cDrinksWeekly;
    }

    /**
     * Sets the value of the cDrinksWeekly property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCDrinksWeekly(BigInteger value) {
        this.cDrinksWeekly = value;
    }

    /**
     * Gets the value of the cDrinks23TimesWeekly property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCDrinks23TimesWeekly() {
        return cDrinks23TimesWeekly;
    }

    /**
     * Sets the value of the cDrinks23TimesWeekly property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCDrinks23TimesWeekly(BigInteger value) {
        this.cDrinks23TimesWeekly = value;
    }

    /**
     * Gets the value of the cDrinksDaily property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCDrinksDaily() {
        return cDrinksDaily;
    }

    /**
     * Sets the value of the cDrinksDaily property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCDrinksDaily(BigInteger value) {
        this.cDrinksDaily = value;
    }

}
