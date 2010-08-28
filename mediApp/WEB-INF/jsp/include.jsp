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
    <title>mediApp</title>    
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" type="image/x-icon" />
    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/autocomplete.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>    
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/password.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">

</head>
<body>
	<div id="main">
		<%Person p = (Person)request.getSession().getAttribute("person"); %>
			<%if (p.getPersonTypeString() != null && !p.getPersonTypeString().equals("AppMent")) {%> 
	
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
		<div id="header" style="background: url(/images/shake-hand.jpg) no-repeat;overflow: hidden;">
			<div id="name">
				<h3> AppMent
				</h3>
				<h4> Easy way to get organized!
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
							<div id="menu">
							
						</div>				
				</div>
			</div>		
		</div>
<script type="text/javascript">
//hide('Menu1');
//hide('Menu2');

</script>