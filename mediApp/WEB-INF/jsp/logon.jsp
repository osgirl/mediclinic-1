<%@ include file="/WEB-INF/jsp/include.jsp" %>
		<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<table  border="0"   width=800>
										<tr>
											<td align="center" bgcolor="lightblue">Welcome to MediApp!</td>
										</tr>
										 <tr>
										 <tr>
										 </tr>
										 <tr>
										 </tr>
  											<td valign=top style="text-align:left">
											  <b>Easy way to get medical attention</b>
											  <td valign=top>&nbsp;
											  </tr>
										
								</table>													
							</div>
						</div>
						<div id="column">
		<form name="logon" id="logon" method="post">
		<input type="hidden" id="hPersonType" name="hPersonType"></input>
		<input type="hidden" id="hRegisterMe" name="hRegisterMe"></input>		
		<table width=250 border="0"  >	
		<tr>
		<td>	
		<font color="red"><c:out value="${SuccessMessage}" /></font>
		<div id="Login" style="display:block" align="center">
		<table  border=""  class="login" width=250>
			<tr>
				<td align="center" bgcolor="lightblue">Log on</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="100%" >						
						
						<tr>
							<td width="33%" align="right">Username: </td>
							<td width="66%" align="left">
								<spring:bind path="person.username">
									<input type="text" name="username"  id="username"  value="<c:out value="${status.value}"/>"/>		
								</spring:bind>
							</td>
							
						</tr>
						<tr>
							<td colspan="2" align="center">
								<spring:bind	path="person.username">
										<font color="red"><c:out value="${status.errorMessage}" /></font>
								</spring:bind>
							</td>
						</tr>
						
						<tr>
							<td width="33%" align="right" >Password: </td>
							<td width="66%" align="left">
								<spring:bind	path="person.password">
									<input type="password" name="password" id="password"/>
								</spring:bind>
							</td>
							<td colspan="2" align="center">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<spring:bind	path="person.password">
									<font color="red"><c:out value="${status.errorMessage}" /></font>
								</spring:bind>
							</td>
						</tr>						
						<tr>
						<td>
								<input type="button" onClick="javascript:fn_showType();" alignment="center" value="Sign Up" name="SignUpButton" id="SignUpButton" class="bsubmit"  width="50"/>
						</td>
							<td  align="center">
								<input type="hidden" id="PersonType" name="PersonType"></input>
								<input type="button" onClick="javascript:fn_submitLogin();" alignment="center" value="Logon" name="LoginButton" id="LoginButton" class="bsubmit"  width="75"/>
						
							
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
		</div>
		</td>
		
		</tr>
				<tr>
		<td>
		<div id="TypeForm" style="display:none" >
		<table  border="" id="TypeForm"  class="login" width=250 >
			<tr>
				<td>
					<table border="0" width="100%" >						

						<tr>
							<td align="center" colspan="5">
								<input type="button" class="bsubmit" name="Patient" id="Patient" alignment="center" onClick="javascript:fn_showPatientRgFrm();" value="Patient" />
							</td>
							<td align="center" colspan="2">
								<input type="button" class="bsubmit" name="Doctor" id="Doctor" alignment="center" value="Doctor" onClick="javascript:fn_showDoctorRgFrm();" />
							</td>							
						</tr>
					</table>

				</td>
			</tr>

		</table>
		</div>
		</td>
		</tr>
		
		
		<tr>
		<td>
		<div id="RegistrationForm" style="display:none" >
		<table  border="" id="RegistrationForm"  class="login" width=250 >
			<tr>
				<td align="center" bgcolor="lightblue">Registration Form</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="100%" >						
						
						<tr>
							<td width="30%" align="right">Email: </td>
							<td width="70%" align="left">
							<spring:bind path="person.emailID">
								<input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>"/>		
							</spring:bind>
							</td>
							
						</tr>
						<tr>
							<td width="30%" align="right">Cell Number: </td>
							<td width="70%" align="left">
							<spring:bind path="person.cellPhoneNumber">
								<input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" onKeyUp="if(this.value.match(/\D/))this.value=this.value.replace(/\D/g,'')" onblur="if(this.value.match(/\D/))this.value=this.value.replace(/\D/g,'')"/>		
							</spring:bind>
							</td>
							
						</tr>
						<tr>
							<td align="center" colspan="2">
								<input type="button" alignment="center" class="bsubmit" onClick="javascript:fn_showMessage();" value="Register" />
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
		</div>
		</td>
		</tr>
		
		</table>
		<script>
			if ('<c:out value="${SuccessMessage}" />' !=""){
				document.getElementById("emailID").value="";
				document.getElementById("cellPhoneNumber").value="";
				
				}
		</script>
		
	</form>
						
						</div>
					</div>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
