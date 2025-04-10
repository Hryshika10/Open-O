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
package org.oscarehr.PMmodule.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.oscarehr.common.model.AbstractModel;

/**
 * @author AnooshTech
 *
 */
@Entity
@Table(name="vacancy_client_match")
public class VacancyClientMatch extends AbstractModel<Integer> implements Comparable<VacancyClientMatch>{
	
	public static String ACCEPTED = "accepted";
	public static String FORWARDED = "forwarded";
	public static String PENDING = "pending";
	public static String REJECTED = "rejected";
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="match_id")
	private Integer id;
	private int vacancy_id;
	private int client_id;
	@Column(name="contact_attempts")
	private int contactAttempts;
	@Column(name="last_contact_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_contact_date;
	private String status;
	@Column(name="rejection_reason")
	private String rejectionReason;
	private int form_id;
	@Column(name="match_percent")
	private double matchPercentage;
	@Column(name="proportion")
	private String proportion = "";

	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getVacancy_id() {
		return vacancy_id;
	}

	public void setVacancy_id(int vacancy_id) {
		this.vacancy_id = vacancy_id;
	}

	public int getForm_id() {
		return form_id;
	}

	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}

	public int getContactAttempts() {
		return contactAttempts;
	}

	public void setContactAttempts(int contactAttempts) {
		this.contactAttempts = contactAttempts;
	}

	public Date getLast_contact_date() {
		return last_contact_date;
	}

	public void setLast_contact_date(Date last_contact_date) {
		this.last_contact_date = last_contact_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public double getMatchPercentage() {
		return matchPercentage;
	}

	public void setMatchPercentage(double matchPercentage) {
		this.matchPercentage = matchPercentage;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + client_id;
		result = prime * result + form_id;
		result = prime * result + vacancy_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof VacancyClientMatch)) {
			return false;
		}
		VacancyClientMatch other = (VacancyClientMatch) obj;
		if (client_id != other.client_id) {
			return false;
		}
		if (form_id != other.form_id) {
			return false;
		}
		if (vacancy_id != other.vacancy_id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "VacancyClientMatch [client_id=" + client_id + ", vacancy_id=" + vacancy_id + ", form_id=" + form_id + ", contactAttempts=" + contactAttempts + ", last_contact_date=" + last_contact_date + ", status=" + status + ", rejectionReason=" + rejectionReason + ", matchPercentage=" + matchPercentage + "]";
	}
	
	@Override
	public int compareTo(VacancyClientMatch o) {
		return (int)(o.matchPercentage-this.matchPercentage);
	}

}
