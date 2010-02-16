<head>
    <title>MediClinic</title>
    <link type="text/css" href="../css/menu.css" rel="stylesheet" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/menu.js"></script>
    <LINK REL="stylesheet" HREF="../css/mycss.css">
</head>

<body>
	<table border = 2 width = "100%" height = "100%" valign = "top">
		<tr>
			<td>
				<table>
					<tr>
						<td>
							Contact Information
							<table width = "100%" height = "100%" class="tableBorder">
								<tr>
									<td>First Name:*</td><td>
										<spring:bind path="command.custFirstName"><input type = "text" name =custFirstName" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
									<td>Middle Name:</td><td>
										<spring:bind path="command.custMidName">	<input type = "text" name =custMidName" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
									<td>Last Name:*</td><td>
										<spring:bind path="command.custLastName">	<input type = "text" name =custLastName" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
									
								</tr>
								<tr>
									<td>Sex:*</td><td><select>
													<option>-Select-</option>
													<option>M</option>
													<option>F</option>
											  </select></td>
									<td>Primary Contact Number:*</td><td>
										<spring:bind path="command.priContactNo">	<input type = "text" name =priContactNo" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
									<td>Secondary Contact Number:</td><td>
										<spring:bind path="command.secContactNo">	<input type = "text" name =secContactNo" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
								</tr>
								<tr>
									<td>Email:*</td><td colspan = 5>
										<spring:bind path="command.email">	<input type = "text" name =email" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							Mailing Address Information
							<table width = "100%" height = "100%" class="tableBorder">
								<tr>
									<td>Address Line1:*</td><td>
										<spring:bind path="command.addressLine1">	<input type = "text" name =addressLine1" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
									<td>Address Line2:</td><td>
										<spring:bind path="command.addressLine2">	<input type = "text" name =addressLine2" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
									<td>City:*</td><td>
										<spring:bind path="command.city">	<input type = "text" name =city" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
								</tr>
								<tr>
									<td>State:*</td><td>
										<spring:bind path="command.state">	<input type = "text" name =state" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
									<td>Country:</td><td>
										<spring:bind path="command.country">	<input type = "text" name =country" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
									<td>ZipCode:*</td><td>
										<spring:bind path="command.zipCode">	<input type = "text" name =zipCode" value = "<cout:out value="${status.value}"/>">
										</spring:bind></td>
								</tr>
							</table>
						</td>
					</tr>
					
					<tr>
						<td>
							<input type = "button" name = "Save" value = "Save">
							<input type = "button" name = "Cancel" value = "Cancel">
						</td>
					<tr>
				</table>
			</td>
		</tr>		
	</table>

</body>