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
    <title>AppMent</title>    
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/shakehand.ico" type="image/x-icon" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />
    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/openid.css" />    
    <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/customalert.js"></script>

</head>
<body onLoad="initVar(); moveBanner()">
	<div id="main" >
		<div id="header">
			<div id="name" > 
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
				        <%Person p = (Person)request.getSession().getAttribute("person");
				        	if (p != null) {%>
						        <a href="logOut.htm" >Logout</a>
						        
				        <%} %>
					</form>
			</div>
		</div>
<div >
							
								<div align="right">																
								<%
									if (p != null){
										out.print("Welcome " + p.getUsername());
									}
								%>
								
								</div>
</div>
		<div id="contentHeadLeft">
			<div id="contentHeadRight">				
				<div id="contentHeadCenter">
					<table border="0" cellpadding="0" cellspacing="0" width="200" height="30" >      
									<tr >     
								  		<td>
								  			<a href="javascript:void(0);" onclick="fn_easyBugs();" style="font:100% 'ARIAL BLACK'; text-decoration:none;color:black;background: url(/images/down_1.png)">
								  			ReportIt!<img src="/images/warning.jpg" ></img>
								  			</a>
								  		
								  		</td>
									
									</tr>
								</table>										
									 <div id="easyBugDiv" style="display: none;">
									 	<b>Click on ReportIt! to go back to application</b>
										 <iframe id="if" src="" width="1000" height="800" frameborder="0">
										<p>No iframe support</p>
										</iframe>
									</div>
				</div>
			</div>		
		</div>
<script type="text/javascript">
//hide('Menu1');
//hide('Menu2');

</script>
<div id="helpbox"></div>