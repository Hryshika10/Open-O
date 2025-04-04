/**
 * Copyright (c) 2024. Magenta Health. All Rights Reserved.
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
 *
 * Modifications made by Magenta Health in 2024.
 */
package org.oscarehr.common.dao;

import java.util.List;
import javax.persistence.Query;
import org.oscarehr.common.model.BatchBilling;
import org.springframework.stereotype.Repository;

@Repository
public class BatchBillingDaoImpl extends AbstractDaoImpl<BatchBilling> implements BatchBillingDAO {
    
    public BatchBillingDaoImpl() {
    	super(BatchBilling.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<BatchBilling> find(Integer demographicNo, String service_code) {
    	Query query = entityManager.createQuery("select b from BatchBilling b where b.demographicNo = :demo and b.serviceCode = :service_code");
    	query.setParameter("demo", demographicNo);
    	query.setParameter("service_code", service_code);
    	
    	return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<BatchBilling> findByProvider(String providerNo) {
    	Query query = entityManager.createQuery("select b from BatchBilling b where b.billingProviderNo = :provider");
    	query.setParameter("provider", providerNo);    	    	
    	return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<BatchBilling> findByProvider(String providerNo, String service_code) {
    	Query query = entityManager.createQuery("select b from BatchBilling b where b.billingProviderNo = :provider and b.serviceCode = :service_code");
    	query.setParameter("provider", providerNo);
    	query.setParameter("service_code", service_code);
    	return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<BatchBilling> findByServiceCode(String service_code) {
    	Query query = entityManager.createQuery("select b from BatchBilling b where b.serviceCode = :service_code");
    	query.setParameter("service_code", service_code);    	
    	return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<BatchBilling> findAll() {
    	Query query = entityManager.createQuery("select b from BatchBilling b");    	    	    	
    	return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<String> findDistinctServiceCodes() {
    	Query query = entityManager.createQuery("select distinct b.serviceCode from BatchBilling b");
    	return query.getResultList();
    }
}
