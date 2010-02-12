<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<title>MediApp</title>
</head>
<body>
<h1>Hello Doctor :)</h1>

<br>
<form method="post" action="/welcomeDoc.htm" >
<table width="25%" border="1">
	<tr>
		<td align="center" bgcolor="lightblue">Name :</td>
	</tr>
	<tr>
		<td align="center" bgcolor="lightblue">Age :</td>
	</tr>
</table>
</form>
<a href="<core:url value="logon.htm"/>">Log out</a>
<br>
</body>
</html>
