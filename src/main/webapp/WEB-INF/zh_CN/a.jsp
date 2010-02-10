<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/commons.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>a starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>&nbsp;&nbsp; 中文国际化
    @This is my JSP page. test4${1+1 }<br><c:out value="asdasd"></c:out>
  </body>
  <form action="">
   <mytags:fck id="asdasd" basePath="/commons/" toolbarSet="Default" customConfigurationsPath="/commons/fckconfig_2.js" width="600px" height="500px" defaultLanguage="zh-cn" autoDetectLanguage="false" uuid="dasdasd">
      asdasd 吞吞吐吐
      </mytags:fck>
      </form>
</html>
