<%@ page session="true"%>
<%@ taglib uri="verticalMenuItemTag" prefix="menu" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="com.mediapp.domain.common.Person"%><html>
<head>
<% response.setHeader("Expires","Mon, 26 Jul 2020 05:00:00 GMT"); %>
    <title>AppMent</title>
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/shakehand1.ico" type="image/x-icon" />    
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />
	<link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
    <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/customalert.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar_us.js"></script>	
        
	
	
</head>
<body >
	<div id="main">
		<%Person p = (Person)request.getSession().getAttribute("person"); %>
			<%if (p != null && p.getPersonTypeString() != null && p.getPersonTypeString().equals("Doctor")) {%> 
	
		<div id="header" style="background: url(/images/medical.jpg) no-repeat;">
			<div id="name">
				<h3> MediApp
				</h3>
				<h4> Easy way to get medical attention!
				</h4>
	
			</div>
			<div id="controls">
					<form id="searchform" action="<%=request.getContextPath()%>" method="post">
				        <%
				        	if (p != null) {%>
						        <a href="logOut.htm" >Logout</a>
				        <%} %>
					</form>
			</div>
		</div>
		<%}else{ %>
		<div id="header" >
			<div id="name">
				<h3> AppMent
				</h3>
				<h4> <font color="grey">Easy way to get organized!</font>
				</h4>
	
			</div>
			<div id="controls">
					<form id="searchform" action="<%=request.getContextPath()%>" method="post">					
					<a href="http://www.facebook.com/apps/application.php?id=152456314791817&v=info" TARGET="_blank">
					<img src="/images/Facebook-Buttons-11-2.png" title="Find us on Facebook"  
					alt="Find us on Facebook" width="21px" border="0"/></a><br/>
					
				        <%
				        	if (p != null) {%>
						        <a href="logOut.htm" >Logout</a>
				        <%} %>
					</form>
			</div>
		</div>
		
		<%} %>	
<div >
							
								<div align="right">		
													 									
								<%
									if (p != null && p.getFirstName()==null){
										out.print("Welcome " + p.getUsername() );
									}else if(p != null && p.getFirstName()!=null){
										out.print("Welcome " + p.getFirstName() );
									}
								%>
								
								</div>
</div>
		<div id="contentHeadLeft">
			<div id="contentHeadRight">
				
				<div id="contentHeadCenter">
								<table border="0" cellpadding="0" cellspacing="0" width="200" height="30" >      
									<tr >     
										<td  >  
								  			<a href="/welcomePage.htm" onClick="" style="text-decoration:none">
								  			<img src="/images/Home11.png" ></img>
								  			</a>
								  		</td>
								  		<td align="center">
								  		<img src="/images/phone11.png"  onMouseover="showbox(event,'You can book appointment, postpone it or cancel it by sending SMS.</br>Following are the commands</br>1. To schedule an appointment with a fellow appmate at certain date and time</br>SCD &amp;lt;yourusername&amp;gt; &amp;lt;mm/dd/yyyy&amp;gt; &amp;lt;hh:mm:ss&amp;gt; &amp;lt;duration hh:mm:ss&amp;gt; &amp;lt;appmateusername&amp;gt; </br>2. To postpone any appointment that you have already schedule</br>RESCD &amp;lt;yourusername&amp;gt; &amp;lt;old mm/dd/yyyy&amp;gt; &amp;lt;old hh:mm:ss&amp;gt; &amp;lt;new mm/dd/yyyy&amp;gt; &amp;lt;new hh:mm:ss&amp;gt; &amp;lt;duration hh:mm:ss&amp;gt; </br>3. To cancel any appointment that you have already schedule</br>CANCEL &amp;lt;yourusername&amp;gt; &amp;lt;mm/dd/yyyy&amp;gt; &amp;lt;hh:mm:ss&amp;gt;</br>');" onMouseout="hidebox();"/>
								  		</td>
									
									</tr>
								</table>										
							
				</div>
			</div>		
		</div>
