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
package org.oscarehr.common.model;

import java.io.Serializable;

import javax.persistence.Column;

public class BedDemographicPK implements Serializable {

	@Column(name="demographic_no")
    private Integer demographicNo;
	
	@Column(name="bed_id")
	private Integer bedId;

	public BedDemographicPK() {
		//required by JPA
	}
   
    public BedDemographicPK(Integer demographicNo, Integer bedId) {
	   	this.demographicNo = demographicNo;
	   	this.bedId = bedId;   
    }

	public Integer getDemographicNo() {
		return demographicNo;
	}

	public void setDemographicNo(Integer demographicNo) {
		this.demographicNo = demographicNo;
	}
	
	public Integer getBedId() {
		return bedId;
	}
	
	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	@Override
	public String toString() {
		return ("demographicNo=" + demographicNo + ", bedId=" + bedId);
	}

	@Override
	public int hashCode() {
		return (toString().hashCode());
	}

	@Override
	public boolean equals(Object o) {
		try {
			BedDemographicPK o1 = (BedDemographicPK) o;
			return ((demographicNo == o1.getDemographicNo()) && (bedId == o1.getBedId()));
		} catch (RuntimeException e) {
			return (false);
		}
	}
	
	
   
}