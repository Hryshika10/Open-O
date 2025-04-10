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

import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;
import org.apache.logging.log4j.Logger;
import org.oscarehr.common.model.UserDSMessagePrefs;
import org.oscarehr.util.MiscUtils;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class UserDSMessagePrefsDaoImpl extends AbstractDaoImpl<UserDSMessagePrefs> implements UserDSMessagePrefsDao {
    private static Logger logger = MiscUtils.getLogger();

    public UserDSMessagePrefsDaoImpl() {
        super(UserDSMessagePrefs.class);
    }

    @Override
    public void saveProp(UserDSMessagePrefs prop) {
        this.persist(prop);
    }

    @Override
    public void updateProp(UserDSMessagePrefs prop) {
        this.merge(prop);
    }

    @Override
    public UserDSMessagePrefs getMessagePrefsOnType(String prov, String name) {
        Query query = entityManager.createQuery("SELECT p FROM UserDSMessagePrefs p WHERE p.providerNo=? and p.resourceType=? and p.archived=true");
		query.setParameter(0, prov);
		query.setParameter(1, name);

		List<UserDSMessagePrefs> list = query.getResultList();
		if (list != null && list.size() > 0) {
			UserDSMessagePrefs prop = list.get(0);
			return prop;
		} else return null;
    }

    @Override
    public Hashtable<String, Long> getHashofMessages(String providerNo, String name) {
        Query query = entityManager.createQuery("SELECT p FROM UserDSMessagePrefs p WHERE p.providerNo=? and p.resourceType=? and p.archived=true");
		query.setParameter(0, providerNo);
		query.setParameter(1, name);

		Hashtable<String, Long> retHash = new Hashtable<String, Long>();

		List<UserDSMessagePrefs> list = query.getResultList();
		logger.debug("dsmessage list size "+list.size()+" for providerNo "+providerNo+" and resource Type "+name);
		if (list != null && list.size() > 0) {
			for (UserDSMessagePrefs pref : list) {
				retHash.put(pref.getResourceType() + pref.getResourceId(), pref.getResourceUpdatedDate().getTime());
			}
		}
		return retHash;
    }

    @Override
    public List<UserDSMessagePrefs> findMessages(String providerNo, String resourceType, String resourceId, boolean archived) {
        Query query = createQuery("p", "p.providerNo = :providerNo AND p.resourceType = :resourceType and p.resourceId = :resourceId and p.archived = :archived");
		query.setParameter("providerNo", providerNo);
		query.setParameter("resourceType", resourceType);
		query.setParameter("resourceId", resourceId);
		query.setParameter("archived", new Boolean(archived));
		return query.getResultList();
    }

    @Override
    public UserDSMessagePrefs getDsMessage(String providerNo, String resourceType, String resourceId, boolean archived) {
        Query query = entityManager.createQuery("SELECT p FROM UserDSMessagePrefs p WHERE p.providerNo=? and p.resourceType=? and p.resourceId=? and p.archived = ? order by p.id DESC");
		query.setParameter(0, providerNo);
		query.setParameter(1, resourceType);
		query.setParameter(2, resourceId);
		query.setParameter(3, archived);

		List<UserDSMessagePrefs> list = query.getResultList();

		UserDSMessagePrefs pref = new UserDSMessagePrefs();
		if (list != null && list.size() > 0) {
			pref = list.get(0);
		}
		return pref;
    }

    @Override
    public List<UserDSMessagePrefs> findAllByResourceId(String resourceId) {
        Query query = createQuery("p", "p.resourceId = :resourceId");
		query.setParameter("resourceId", resourceId);
		return query.getResultList();
    }
}
