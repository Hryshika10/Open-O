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
package org.oscarehr.common.dao.forms;

import org.oscarehr.common.dao.AbstractDaoImpl;
import oscar.form.model.FormBCAR2020Data;

import javax.persistence.Query;
import java.util.List;

public class FormBCAR2020DataDao extends AbstractDaoImpl<FormBCAR2020Data> {
    public FormBCAR2020DataDao() { super(FormBCAR2020Data.class); }

    public List<FormBCAR2020Data> findFields(Integer formId) {
        String sql = "select f from FormBCAR2020Data f " +
                "where f.formId = :formId";
        Query query = entityManager.createQuery(sql);
        query = query.setParameter("formId", formId);
        return query.getResultList();
    }

    public List<FormBCAR2020Data> findFieldsForPage(Integer formId, Integer pageNo) {
        String sql = "select f from FormBCAR2020Data f " +
                "where f.formId = :formId and (f.pageNo = :pageNo OR f.pageNo = 0)";
        Query query = entityManager.createQuery(sql);
        query = query.setParameter("formId", formId);
        query = query.setParameter("pageNo", pageNo);
        return query.getResultList();
    }
    
    public FormBCAR2020Data findFieldForPage(Integer formId, Integer pageNo, String fieldName) {
        String sql = "SELECT f FROM FormBCAR2020Data f " +
                "WHERE f.formId = :formId AND (f.pageNo = :pageNo OR f.pageNo = 0) AND f.field = :fieldName";
        Query query = entityManager.createQuery(sql);
        query = query.setParameter("formId", formId);
        query = query.setParameter("pageNo", pageNo);
        query = query.setParameter("fieldName", fieldName);

        FormBCAR2020Data record = null;

        List<FormBCAR2020Data> results = query.getResultList();
        if (!results.isEmpty()) {
            record = results.get(0);
        }

        return record;
    }
}
