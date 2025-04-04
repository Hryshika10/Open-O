/**
 * Copyright (c) 2006-. OSCARservice, OpenSoft System. All Rights Reserved.
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
 */

package org.oscarehr.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Billingreferral generated by hbm2java
 */
@Deprecated
@Entity
@Table(name="billingreferral")
public class Billingreferral  extends AbstractModel<Integer> implements java.io.Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="billingreferral_no")
     private Integer billingreferralNo;
	@Column(name="referral_no")
     private String referralNo;
	@Column(name="last_name")
     private String lastName;
	@Column(name="first_name")
     private String firstName;
     private String specialty;
     private String address1;
     private String address2;
     private String city;
     private String province;
     private String country;
     private String postal;
     private String phone;
     private String fax;

    public Billingreferral() {
    }


    public Billingreferral(String referralNo) {
        this.referralNo = referralNo;
    }

    public Billingreferral(String referralNo, String lastName, String firstName, String specialty, String address1, String address2, String city, String province, String country, String postal, String phone, String fax) {
       this.referralNo = referralNo;
       this.lastName = lastName;
       this.firstName = firstName;
       this.specialty = specialty;
       this.address1 = address1;
       this.address2 = address2;
       this.city = city;
       this.province = province;
       this.country = country;
       this.postal = postal;
       this.phone = phone;
       this.fax = fax;
    }

    public Integer getId() {
    	return getBillingreferralNo();
    }

    public Integer getBillingreferralNo() {
        return this.billingreferralNo;
    }

    public void setBillingreferralNo(Integer billingreferralNo) {
        this.billingreferralNo = billingreferralNo;
    }
    public String getReferralNo() {
        return this.referralNo;
    }

    public void setReferralNo(String referralNo) {
        this.referralNo = referralNo;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getPostal() {
        return this.postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Billingreferral other = (Billingreferral) obj;
        if (this.billingreferralNo != other.billingreferralNo && (this.billingreferralNo == null || !this.billingreferralNo.equals(other.billingreferralNo))) {
            return false;
        }
        if ((this.referralNo == null) ? (other.referralNo != null) : !this.referralNo.equals(other.referralNo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.billingreferralNo != null ? this.billingreferralNo.hashCode() : 0);
        hash = 67 * hash + (this.referralNo != null ? this.referralNo.hashCode() : 0);
        return hash;
    }


    public String getFormattedName() {
    	return getLastName() + "," + getFirstName();
    }

}
