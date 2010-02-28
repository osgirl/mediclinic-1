<%@ include file="/WEB-INF/jsp/include.jsp" %>

		<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">

		<form method="post">
		<table width=500>	
		<tr>
		<td>	
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
								<input type="text" 
								       name="username" 
								       value=""/>		
							</td>
							
						</tr>
						<tr>
							<td width="33%" align="right" >Password: </td>
							<td width="66%" align="left">
								<input type="password" name="password" />
							</td>
							<td colspan="2" align="center">
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
		<table  border="" class="login"  width=250>
			<tr>
				<td align="center" bgcolor="lightblue">Register Now</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="100%" >						
						
						<tr>
							<td align="center" colspan="5">
								<input type="button" alignment="center" onClick="fn_showPatientRgFrm()" value="Patient Registration" style="background-color: #bcc6ae; border-top: 2px solid #5f6c4d; border-right: 2px solid #000000; border-bottom: 2px solid #000000; border-left: 2px solid #5f6c4d; width: 200px; height: 24px; font:bold 15px Trebuchet MS,Tahoma;"/>
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<input type="button" alignment="center" value="Doctor Registration" onclick="fn_showDoctorRgFrm()" style="background-color: #bcc6ae; border-top: 2px solid #5f6c4d; border-right: 2px solid #000000; border-bottom: 2px solid #000000; border-left: 2px solid #5f6c4d; width: 200px; height: 24px; font:bold 15px Trebuchet MS,Tahoma;"/>
							</td>							
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
		</td>
		</tr>
		</table>
		<div id="PatientRegistrationForm" style="display:none">
		<table  border="" id="RegistrationForm"  class="login" width=250>
			<tr>
				<td align="center" bgcolor="lightblue">Patient Registration Form</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="100%" >						
						
						<tr>
							<td width="30%" align="right">Email: </td>
							<td width="70%" align="left">
								<input type="text" 
								       name="emailID" 
								       value=""/>		
							</td>
							
						</tr>
						<tr>
							<td width="30%" align="right">Password: </td>
							<td width="70%" align="left">
								<input type="password" 
								       name="password" 
								       value=""/>		
							</td>
							
						</tr>
						<tr>
							<td width="30%" align="right">Confirm Password: </td>
							<td width="70%" align="left">
								<input type="password" 
								       name="cPassword" 
								       value=""/>		
							</td>
							
						</tr>
						<tr>
							<td align="center" colspan="2">
								<input type="submit" alignment="center" value="Register" style="background-color: #bcc6ae; border-top: 2px solid #5f6c4d; border-right: 2px solid #000000; border-bottom: 2px solid #000000; border-left: 2px solid #5f6c4d; width: 80px; height: 24px; font:bold 15px Trebuchet MS,Tahoma;"/>
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
		</div>
			<div id="DoctorRegistrationForm"  style="display:none">
		<table  border="" id="RegistrationForm"  class="login" width=250>
			<tr>
				<td align="center" bgcolor="lightblue">Doctor Registration Form</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="100%" >						
						
						<tr>
							<td width="30%" align="right">Email: </td>
							<td width="70%" align="left">
								<input type="text" 
								       name="emailID" 
								       value=""/>		
							</td>
							
						</tr>
						<tr>
							<td width="30%" align="right">Password: </td>
							<td width="70%" align="left">
								<input type="password" 
								       name="password" 
								       value=""/>		
							</td>
							
						</tr>
						<tr>
							<td width="30%" align="right">Confirm Password: </td>
							<td width="70%" align="left">
								<input type="password" 
								       name="cPassword" 
								       value=""/>		
							</td>
							
						</tr>
						<tr>
							<td width="30%" align="right">Registration Number: </td>
							<td width="70%" align="left">
								<input type="text" 
								       name="registrationNumber" 
								       value=""/>		
							</td>
							
						</tr>

						<tr>
							<td align="center" colspan="2">
								<input type="submit" alignment="center" value="Register" style="background-color: #bcc6ae; border-top: 2px solid #5f6c4d; border-right: 2px solid #000000; border-bottom: 2px solid #000000; border-left: 2px solid #5f6c4d; width: 80px; height: 24px; font:bold 15px Trebuchet MS,Tahoma;"/>
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
		</div>
		
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