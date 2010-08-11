<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="str"
	uri="http://jakarta.apache.org/taglibs/string-1.1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page import="com.mediapp.domain.common.Person"%>
<html>
<head>
<title>mediApp</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/favicon.ico"
	type="image/x-icon" />
<link href="<%=request.getContextPath()%>/css/mycss.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/autocomplete.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/mediapp.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/prototype.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/calendar.css">
</head>
<body>
<form name="uploadFile" id="uploadFile" method="post"
	action="uploadFile.htm" enctype="multipart/form-data">
<div id="createApt" style="display: block" align="center">
<table border="" class="login" width=680 cellpadding="200">
	<tr bgcolor="lightblue">
		Upload File
	</tr>
	<tr>
		<td>Select File:</td>
		<td>
			<spring:bind path="fileUpload.file">
				<input type="file" name="${status.expression}" style="WIDTH: 500px" />
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>Document Type:</td>
		<td>
			<spring:bind path="fileUpload.fileName">
				<select id="${status.expression}" name="${status.expression}" style="WIDTH: 250px">
					<c:forEach items="${DocumentType}" var="data">
						<option value='${data.codeDecode}' >${data.codeDecode}</option>
					</c:forEach>
				</select>
			</spring:bind>

		</td>
	</tr>
	<tr>
		<td>Comments:</td>
		<td>
			<spring:bind path="fileUpload.comments">
				<textarea name="${status.expression}" value="" rows="4" cols="50">
        		</textarea>
        	</spring:bind>
        </td>
	</tr>
	<tr>
		<td align="center" colspan="2"><input type="button"
			onClick="javascript:fn_uploadSelectedFile();" alignment="center"
			value="Upload" class="bsubmit" width="75" /></td>
	</tr>



</table>
</div>
</form>

</body>
</html>

