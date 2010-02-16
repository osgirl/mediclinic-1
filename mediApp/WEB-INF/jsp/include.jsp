<%@ page session="false"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib prefix="spring" uri="/spring" %>
<html>
<head>
    <title>Sample</title>
    <link href="<%=request.getContextPath()%>/css/puremenu.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/menu.js"></script>
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
					<form id="searchform" action="http://www.developers-blog.org/blog/default/" method="post">
						<p>
						<label id="searchlabel" for="searchfield">Search:</label>
						<input id="searchfield" type="text" value="" name="query"/>
						<input id="searchimage" type="image" title="Click here to search this blog" alt="Search" value="submit" src="http://www.developers-blog.org/resources/default/asual-search.jpg"/>
						</p>
					</form>
			</div>
		</div>
		<div id="contentHeadLeft">
			<div id="menu">
				<ul class="pureCssMenu pureCssMenum">
					<li class="pureCssMenui"><a href="GOHE.html" class="parent"><span>Home</span></a></li>
					<li class="pureCssMenui"><a href="./Find_A_Doctor.html"><span>Locate</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul class="pureCssMenum">
								<li class="pureCssMenui"><a href="#"><span>Search by Speciality</span></a></li>
								<li class="pureCssMenui"><a href="#"><span>Search by name</span></a></li>							
								<li class="pureCssMenui"><a href="#"><span>Search by location</span></a></li>
						</ul>
					</li>
					<li class="pureCssMenui"><a href="./Find_A_Doctor.html"><span>Login</span><![if gt IE 6]></a><![endif]><!--[if lte IE 6]><table><tr><td><![endif]-->
						<ul class="pureCssMenum">
								<li class="pureCssMenui"><a href="#"><span>Doctor</span></a></li>
								<li class="pureCssMenui"><a href="#"><span>Patient</span></a></li>							
						</ul>
					</li>

				</ul>
		</div>
			
			<div id="contentHeadRight">
				<div id="contentHeadCenter"></div>
			</div>		
		</div>
