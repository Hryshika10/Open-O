/**
 *
 * Copyright (c) 2005-2012. Centre for Research on Inner City Health, St. Michael's Hospital, Toronto. All Rights Reserved.
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
 * This software was written for
 * Centre for Research on Inner City Health, St. Michael's Hospital,
 * Toronto, Ontario, Canada
 */

package org.oscarehr.PMmodule.model;

import java.io.Serializable;

/**
 * This is the object class that relates to the access_type table.
 * Any customizations belong here.
 */
public class AccessType implements Serializable {

    private int hashCode = Integer.MIN_VALUE;// primary key
    private Long _id;// fields
    private String _name;
    private String _type;

    // constructors
    public AccessType () {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public AccessType (Long _id) {
        this.setId(_id);
        initialize();
    }


    /*[CONSTRUCTOR MARKER END]*/
    protected void initialize () {
    	//autogenerated code
    }

    /**
     * Return the unique identifier of this class
     * 
     *  generator-class="native"
     *  column="access_id"
     */
    public Long getId () {
        return _id;
    }

    /**
     * Set the unique identifier of this class
     * @param _id the new ID
     */
    public void setId (Long _id) {
        this._id = _id;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: name
     */
    public String getName () {
        return _name;
    }

    /**
     * Set the value related to the column: name
     * @param _name the name value
     */
    public void setName (String _name) {
        this._name = _name;
    }

    /**
     * Return the value associated with the column: type
     */
    public String getType () {
        return _type;
    }

    /**
     * Set the value related to the column: type
     * @param _type the type value
     */
    public void setType (String _type) {
        this._type = _type;
    }

    public boolean equals (Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof AccessType)) return false;
        else {
            AccessType mObj = (AccessType) obj;
            if (null == this.getId() || null == mObj.getId()) return false;
            else return (this.getId().equals(mObj.getId()));
        }
    }

    public int hashCode () {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }

    public String toString () {
        return super.toString();
    }
}
