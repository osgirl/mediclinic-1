<%@ include file="/WEB-INF/jsp/include.jsp" %>

		<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">

		<form method="post">
		<table width="25%" border="" align="center" class="login">
			<tr>
				<td align="center" bgcolor="lightblue">Log on</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="100%">
						<tr>
							<td width="33%" align="right">Username: </td>
							<td width="66%" align="left">
								<spring:bind path="person.username">
								<input type="text" 
								       name="username" 
								       value="<core:out value="${status.value}"/>"/>		
								</spring:bind>
							</td>
							
						</tr>
						<tr>
							<td colspan="2" align="center">
								<spring:hasBindErrors name="person">
								<font color="red"><core:out value="${status.errorMessage}"/></font>
								</spring:hasBindErrors>
							</td>
						</tr>
						<tr>
							<td width="33%" align="right" >Password: </td>
							<td width="66%" align="left">
								<spring:bind path="person.password">
								<input type="password" name="password" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<spring:hasBindErrors name="person">
								<font color="red"><core:out value="${status.errorMessage}"/></font>
								</spring:hasBindErrors>
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<input type="submit" alignment="center" value="Logon" style="background-color: #bcc6ae; border-top: 2px solid #5f6c4d; border-right: 2px solid #000000; border-bottom: 2px solid #000000; border-left: 2px solid #5f6c4d; width: 80px; height: 24px; font:bold 15px Trebuchet MS,Tahoma;"/>
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
		
	</form>
						
							</div>
						</div>
						<div id="column">
						</div>
					</div>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>