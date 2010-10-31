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
	<link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
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
								<table border="0" cellpadding="0" cellspacing="0" width="80" height="30" >      
									<tr>     
										<td  style="background: url(/images/homebutton_1.jpg) no-repeat;overflow: hidden;background-position: middle center;background-size: 100%;width:100%;height:30;"  align="center" class="sansa">  
								  			<a href="/welcomePage.htm" onClick="" style="text-decoration:none"> 
								  				<font size="+1" color="#3E3535" ><b> Home</b></font> 
								  			</a>
								  		</td>
									</tr>
								</table>										
							
				</div>
			</div>		
		</div>
<script type="text/javascript">
//hide('Menu1');
//hide('Menu2');

</script>