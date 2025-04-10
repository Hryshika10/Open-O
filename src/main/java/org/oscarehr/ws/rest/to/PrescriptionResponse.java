/**
 * Copyright (c) 2013-2015. Department of Computer Science, University of Victoria. All Rights Reserved.
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
 * Department of Computer Science
 * LeadLab
 * University of Victoria
 * Victoria, Canada
 */
package org.oscarehr.ws.rest.to;

import org.oscarehr.ws.rest.to.model.DrugTo1;
import org.oscarehr.ws.rest.to.model.PrescriptionTo1;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class PrescriptionResponse extends GenericRESTResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DrugTo1> drugs;

    private PrescriptionTo1 prescription;

    public List<DrugTo1> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<DrugTo1> drugs) {
        this.drugs = drugs;
    }

    public void addDrug(DrugTo1 d){
        this.drugs.add(d);
    }

    public PrescriptionTo1 getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionTo1 prescription) {
        this.prescription = prescription;
    }
}
