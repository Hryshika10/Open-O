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
import org.oscarehr.common.model.AbstractCodeSystemModel;

public interface AbstractCodeSystemDao<T extends AbstractCodeSystemModel<?>> extends AbstractDao<T> {

    //public static enum codingSystem {icd9,icd10,ichppccode,msp,SnomedCore}

   // public static String getDaoName(codingSystem codeSystem);

    public List<T> searchCode(String term);

    public T findByCode(String code);

    public AbstractCodeSystemModel<?> findByCodingSystem(String codingSystem);

    public static enum codingSystem {icd9,icd10,ichppccode,msp,SnomedCore}

    public static String getDaoName(codingSystem codeSystem) {
        String object;
        switch(codeSystem) {
            case SnomedCore: object = "snomedCoreDao";
                break;
            case icd10: object = "icd10Dao";
                break;
            case icd9: object = "icd9Dao";
                break;
            case ichppccode: object = "ichppccodeDao";
                break;
            case msp: object = "diagnosticCodeDao";
                break;
            default: throw new IllegalArgumentException("Unsupported code system: " + codeSystem + ". Please use one of icd9, ichppccode, snomedcore");
        }
        return object;
    }
}
