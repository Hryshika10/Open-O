<%--

    Copyright (c) 2001-2002. Department of Family Medicine, McMaster University. All Rights Reserved.
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

    This software was written for the
    Department of Family Medicine
    McMaster University
    Hamilton
    Ontario, Canada

--%>

<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.oscarehr.util.LoggedInInfo"%>
<%@page import="org.oscarehr.util.SpringUtils"%>
<%@page import="org.oscarehr.renal.ReportHelper" %>
<%@page import="org.oscarehr.renal.ReportDataContainer" %>
<%@page import="org.oscarehr.common.model.ORNCkdScreeningReportLog" %>
<%@page import="org.oscarehr.common.dao.ORNCkdScreeningReportLogDao" %>
<%@page import="org.oscarehr.PMmodule.dao.ProviderDao" %>
<%@page import="org.oscarehr.common.model.Provider" %>

<%@ include file="/taglibs.jsp"%>

<%@ taglib uri="/WEB-INF/security.tld" prefix="security"%>
<%
      String roleName$ = (String)session.getAttribute("userrole") + "," + (String) session.getAttribute("user");
      boolean authed=true;
%>
<security:oscarSec roleName="<%=roleName$%>" objectName="_report" rights="w" reverse="<%=true%>">
	<%authed=false; %>
	<%response.sendRedirect("../securityError.jsp?type=_report");%>
</security:oscarSec>
<%
if(!authed) {
	return;
}
%>


<%
ORNCkdScreeningReportLogDao logDao = SpringUtils.getBean(ORNCkdScreeningReportLogDao.class);
ProviderDao providerDao = SpringUtils.getBean(ProviderDao.class);
    		
List<ORNCkdScreeningReportLog> reports = logDao.getAllReports();
    		
%>

<html>
<head>
	<title>CKD Screening Reports</title>
	<link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.9.1.min.js"></script>

<script>
$(document).ready(function() {
	$("#runReport").bind("click",function(){
		$.get("<%=request.getContextPath()%>/renal/Renal.do?method=submitCkdScreeningReport");
		
	});
});
</script>
</head>

<body>
	<h3>CKD Screening Report</h3>
		
	<div class="container-fluid well">		
		<br/>
		<p>Welcome to the ORN CKD Screening Report page. This page will show you all reports previously run, and allow you to submit new reports.</p>
		<p>After submitting a report, revisit the page periodically to see when it is ready to be viewed.</p>
		<p>Note: reports are system intensive, and take a long time to run, especially in larger clinics. Generate the report during low traffic times.</p>
		<br/>
		
		<table class="table table-striped table-condensed">
			<thead>
			<tr>
				<th>Date</th>
				<th>Generated By</th>
				<th>Actions</th>
			</tr>
			</thead>

			<tbody>
			<%for(ORNCkdScreeningReportLog report:reports) { 
				Provider p = providerDao.getProvider(report.getProviderNo());
			%>
				<tr>
					<td><%=report.getLastUpdateDate() %></td>
					<td><%=(p!=null)?p.getFormattedName():"N/A" %></td>
					<td><input class="btn" type="button" onClick="window.open('<%=request.getContextPath()%>/renal/ckdScreeningReportView.jsp?id=<%=report.getId()%>')" value="View"/></td>
					
				</tr>
			<% } %>
			</tbody>
		</table>
		<br/>
		<input class="btn btn-primary" type="button" id="runReport" value="Run new report (Resource intensive)"/>
		</div>



</body>
</html>
