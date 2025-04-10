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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page import="org.oscarehr.util.ProgressStatus"%><html>
	<head>
		<title>Progress Dialog</title>
	</head>

	<body style="font-size:12px">
		<%
			ProgressStatus progressStatus=null;
		
			// wait for process to start
			for (int i=0; i<20; i++)
			{
				progressStatus=(ProgressStatus)session.getAttribute("progressStatus");
				if (progressStatus!=null) break;
				Thread.sleep(1000);
			}
			
			if (progressStatus==null || progressStatus.completed)
			{
				session.removeAttribute("progressStatus");
				%>
					<script type="text/javascript">
						window.close();
					</script>					
				<%
			}
			else
			{
				%>
					<script type="text/javascript">
						self.focus();
						setTimeout('window.location.reload()', 2000);
					</script>
					
					<span style="font-weight:bold">Total </span><%=progressStatus.total%><br /><br />					
					<span style="font-weight:bold">Processed </span><%=progressStatus.processed%><br /><br />						
					<span style="font-weight:bold">Percent Complete </span><%=progressStatus.percentComplete%>%<br /><br />						
					<span style="font-weight:bold">Current Item </span><%=progressStatus.currentItem%>					
				<%
			}
		%>
	</body>
</html>
