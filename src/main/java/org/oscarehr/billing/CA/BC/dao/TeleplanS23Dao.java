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


package org.oscarehr.billing.CA.BC.dao;

import java.util.List;

import javax.persistence.Query;

import org.oscarehr.billing.CA.BC.model.TeleplanS23;
import org.oscarehr.common.dao.AbstractDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class TeleplanS23Dao extends AbstractDaoImpl<TeleplanS23>{

	public TeleplanS23Dao() {
		super(TeleplanS23.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<TeleplanS23> search_taS23 (Integer s21Id, String type, String aji) {
		Query q = entityManager.createQuery("select t from TeleplanS23 t where t.s21Id=? and t.s23Type<>? and t.aji like ? order by t.id");
		q.setParameter(0, s21Id);
		q.setParameter(1, type);
		q.setParameter(2, aji);
		return q.getResultList();
	}
}
