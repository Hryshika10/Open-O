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
package org.oscarehr.sharingcenter.dao;

import java.util.List;

import javax.persistence.Query;

import org.oscarehr.common.dao.AbstractDaoImpl;
import org.oscarehr.sharingcenter.model.SiteMapping;
import org.springframework.stereotype.Repository;

@Repository
public class SiteMappingDao extends AbstractDaoImpl<SiteMapping> {

    public SiteMappingDao() {
        super(SiteMapping.class);
    }

    /**
     * Finds all site mappings in our Data model
     * 
     * @return
     * list of all SiteMapping objects
     */
    public List<SiteMapping> findSiteMappings() {
        String sql = "FROM SiteMapping";
        Query query = entityManager.createQuery(sql);

        @SuppressWarnings("unchecked")
        List<SiteMapping> retVal = query.getResultList();
        return retVal;
    }

    public SiteMapping findSiteMapping(int affinityDomain) {
        String sql = "FROM SiteMapping e where e.affinityDomain = ?";
        Query query = entityManager.createQuery(sql);
        query.setParameter(0, affinityDomain);

        query.setMaxResults(1);
        SiteMapping retVal = getSingleResultOrNull(query);
        return retVal;
    }

    public SiteMapping findSiteMapping(int affinityDomain, String source) {
        String sql = "FROM SiteMapping e where e.affinityDomain = ? and e.source = ?";

        Query query = entityManager.createQuery(sql);
        query.setParameter(0, affinityDomain);
        query.setParameter(1, source);

        query.setMaxResults(1);
        SiteMapping retVal = getSingleResultOrNull(query);
        return retVal;
    }

}
