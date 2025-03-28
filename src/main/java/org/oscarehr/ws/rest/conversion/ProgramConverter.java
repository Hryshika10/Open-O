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
package org.oscarehr.ws.rest.conversion;

import org.oscarehr.PMmodule.model.Program;
import org.oscarehr.util.LoggedInInfo;
import org.oscarehr.ws.rest.to.model.ProgramTo1;


public class ProgramConverter extends AbstractConverter<Program, ProgramTo1> {
		
//		private static Logger logger = org.oscarehr.util.MiscUtils.getLogger();

		@Override
		public Program getAsDomainObject(LoggedInInfo loggedInInfo,ProgramTo1 t) throws ConversionException {
			Program a = new Program();
			a.setId(t.getId());
			a.setName(t.getName());
			return a;
		}
		
		@Override
		public ProgramTo1 getAsTransferObject(LoggedInInfo loggedInInfo,Program a) throws ConversionException {
			ProgramTo1 t = new ProgramTo1();
			t.setId(a.getId());
			t.setId(a.getId());
			t.setName(a.getName());
			return t;
		}

}

