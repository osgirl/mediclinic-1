<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@page import="com.mediapp.domain.common.Person"%><html>
<head>
    <title>mediApp</title>    
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" type="image/x-icon" />
    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/autocomplete.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>    
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">

</head>
<body>
	<div id="main">
		<div id="header">
			<div id="name">
				<h3> MediApp
				</h3>
				<h4> Easy way to get medical attention!
				</h4>
			</div>
			<div id="controls">
					<form id="searchform" action="<%=request.getContextPath()%>" method="post">
						<p>
						<label id="searchlabel" for="searchfield">Search:</label>
						<input id="searchfield" type="text" value="" name="query"/>
						<input id="searchimage" type="image" title="Click here to search this website" alt="Search" value="submit" src="<%=request.getContextPath()%>/images/asual-search.jpg"/>
						</p>
					</form>
			</div>
		</div>
<div >
								<table cellspacing=0 cellpadding=2 border="1" bordercolor="339999">
									<tr>
										<td onmouseover="javascript:show('Menu1')" onmouseout="javascript:hide('Menu1')" valign=top class="menu1">Home
											<div id=Menu1 class="submenu1" >
													<a href="/welcomePage.htm">Home</a><br>
													<a href="/logon.htm">Login</a>
											</div>
										</td>
										<td onmouseover="javascript:show('Menu2')" onmouseout="javascript:hide('Menu2')" valign=top class="menu2">Login
											<div id=Menu2 class="submenu2">
												<a href="/logon.htm">Logon as Patient</a><br>
												<a href="/logon.htm">Logon as Doctor</a>
											</div>
										</td>
									</tr>
								</table>
							
								<div align="right">																
								<%Person p = (Person)request.getSession().getAttribute("person");
									if (p != null){
										out.print("Welcome " + p.getUsername());
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
hide('Menu1');
hide('Menu2');

</script>