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
<%@ taglib uri="/WEB-INF/security.tld" prefix="security"%>
<%
    String roleName$ = (String)session.getAttribute("userrole") + "," + (String) session.getAttribute("user");
    boolean authed=true;
%>
<security:oscarSec roleName="<%=roleName$%>" objectName="_rx" rights="r" reverse="<%=true%>">
	<%authed=false; %>
	<%response.sendRedirect("../securityError.jsp?type=_rx");%>
</security:oscarSec>
<%
	if(!authed) {
		return;
	}
%>

<%@ page
	import="java.util.*,oscar.oscarRx.data.*,oscar.oscarRx.pageUtil.*,java.io.*,org.apache.xmlrpc.*"%>
<%
RxSessionBean bean = (RxSessionBean) session.getAttribute("RxSessionBean");
if ( bean == null ){
    return;
}
    Vector codes = bean.getAtcCodes();
    Vector interactions = getInteractions(codes);
    Object[] interactionsArray = interactions.toArray();
    if ( interactionsArray != null && interactionsArray.length > 0){
        for (int i=0; i < interactionsArray.length; i++){
            Hashtable ht = (Hashtable) interactionsArray[i]; 
            %>


<%@page import="org.oscarehr.util.MiscUtils"%><div
	style="background-color:<%=sigColor(""+ht.get("significance"))%>;margin-right:3px;margin-left:3px;margin-top:2px;padding-left:3px;padding-top:3px;padding-bottom:3px;">
<%=ht.get("name")%> <%=effect(""+ht.get("effect"))%> <%=ht.get("drug2")%>
&nbsp;(<%=evidence(""+ht.get("evidence"))%>)<br />
<%=ht.get("body")%></div>

<%}
    }else if(interactions == null){ %>
<div>MyDrug to MyDrug Interaction Service not available</div>
<%  }   %>
<%!

    String effect(String s){
		  Hashtable h = new Hashtable();
        h.put("a","augments (no clinical effect)");
        h.put("A","augments");
        h.put("i","inhibts  (no clinical effect)");
        h.put("I","inhibits");
        h.put("n","has no effect on");
        h.put("N","has no effect on");
        h.put(" ","unknown effect on");
        
        String retval = (String) h.get(s);
        if (retval == null) {retval = "unknown effect on";}
        return retval;
   }
    
	String significance(String s){
       Hashtable h = new Hashtable();
       h.put("1","minor");
       h.put("2","moderate");
       h.put("3","major");
       h.put(" ","unknown");
       
       String retval = (String) h.get(s);
        if (retval == null) {retval = "unknown";}
        return retval;
   }
   
   String evidence(String s){
       Hashtable h = new Hashtable();
       h.put("P","Poor");
       h.put("F","Fair");
       h.put("G","Good");
       h.put(" ","Unknown");
       
       String retval = (String) h.get(s);
        if (retval == null) {retval = "Unknown";}
        return retval;
   }


   String sigColor(String s){
       Hashtable h = new Hashtable();
       h.put("1","yellow");
       h.put("2","orange");
       h.put("3","red");
       h.put(" ","greenyellow");
       
       String retval = (String) h.get(s);
        if (retval == null) {retval = "greenyellow";}
        return retval;
   }
    
   String severityOfReaction(String s){
       Hashtable h = new Hashtable();
       h.put("1","Mild");
       h.put("2","Moderate");
       h.put("3","Severe");
       
       String retval = (String) h.get(s);
       if (retval == null) {retval = "Unknown";}
       return retval;
   }
    
   String severityOfReactionColor(String s){
       Hashtable h = new Hashtable();
       h.put("1","yellow");
       h.put("2","orange");
       h.put("3","red");
       
       String retval = (String) h.get(s);
       if (retval == null) {retval = "red";}
       return retval;
   }
                        
   String onSetOfReaction(String s){
       Hashtable h = new Hashtable();
       h.put("1","Immediate");
       h.put("2","Gradual");
       h.put("3","Slow");
       
       String retval = (String) h.get(s);
       if (retval == null) {retval = "Unknown";}
       return retval;
   }
   
   private Object callWebserviceLite(String procedureName,Vector params) throws Exception{
        Object object = null;
        String server_url = "http://know2act.org/backend/api";
        try{
            if (!System.getProperty("http.proxyHost","").isEmpty()) {
                //The Lite client won't recgonize JAVA_OPTS as it uses a customized http
                XmlRpcClient server = new XmlRpcClient(server_url);
                object = (Object) server.execute(procedureName, params);
            } else {
                XmlRpcClientLite server = new XmlRpcClientLite(server_url);
                object = (Object) server.execute(procedureName, params);
            }
        }catch (XmlRpcException exception) {
            MiscUtils.getLogger().error("JavaClient: XML-RPC Fault #" + exception.code, exception);
            
            throw new Exception("JavaClient: XML-RPC Fault #" +
                    Integer.toString(exception.code) + ": " +
                    exception.toString());
            
        } catch (Exception exception) {
        	MiscUtils.getLogger().error("JavaClient: ", exception);
            throw new Exception("JavaClient: " + exception.toString());
        }
        return object;
    }
    
    
     public Vector getInteractions(Vector drugs)throws Exception{
        removeNullFromVector(drugs);
        Vector params = new Vector();
        params.addElement("interactions_byATC");
        params.addElement(drugs);
        //Vector vec = (Vector) callWebserviceLite("get",params);
        Vector vec = new Vector();
        Object obj =  callWebserviceLite("Fetch",params);
        if (obj instanceof Vector){
            vec = (Vector) obj;
        }else if(obj instanceof Hashtable){
            Object holbrook = ((Hashtable) obj).get("Holbrook Drug Interactions");
            if (holbrook instanceof Vector){
                vec = (Vector) holbrook;
            }
            Enumeration e = ((Hashtable) obj).keys();
            while (e.hasMoreElements()){
                String s = (String) e.nextElement();
            }
        }
        
        return vec;
    }
     
     
    public static void removeNullFromVector(Vector v){
        while(v != null && v.contains(null)){
            v.remove(null);
        }
    }
    
    
%>
