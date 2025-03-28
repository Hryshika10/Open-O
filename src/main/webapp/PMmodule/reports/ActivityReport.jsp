
<%--


    Copyright (c) 2005-2012. Centre for Research on Inner City Health, St. Michael's Hospital, Toronto. All Rights Reserved.
    This software is published under the GPL GNU General Public License.
    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation; either version 2
    of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.

    This software was written for
    Centre for Research on Inner City Health, St. Michael's Hospital,
    Toronto, Ontario, Canada

--%>

<%@ include file="/taglibs.jsp"%>

<h4>Summary</h4>

<table class="table table-bordered table-striped table-condensed table-hover">
	<thead>
	<tr>
		<th>Program</th>
		<th>Total Admissions</th>
		<th>Total Referrals</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="stat" items="${summary}">
		<tr>
			<td><c:out value="${stat.key}" /></td>
			<c:forEach var="value" items="${stat.value }">
				<td><c:out value="${value}" /></td>
			</c:forEach>
		</tr>
	</c:forEach>
	</tbody>
</table>
