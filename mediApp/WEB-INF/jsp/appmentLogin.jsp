<%@ include file="/WEB-INF/jsp/include.jsp" %>
		<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries" align="left">
<script>
var cacheonimg = new Image ();
var cacheoffimg = new Image ();
cacheonimg.src = '/images/MCbutton_1.png';
cacheoffimg.src = '/images/MCbutton_0.png';

var cacheonimgl = new Image ();
var cacheoffimgl = new Image ();
cacheonimgl.src = '/images/MLbutton_1.png';
cacheoffimgl.src = '/images/MLbutton_0.png';

var cacheonimgs = new Image ();
var cacheoffimgs = new Image ();
cacheonimgs.src = '/images/submitbutton_1.png';
cacheoffimgs.src = '/images/submitbutton_0.png';

</script>
						
							<div class="entryAlone" >
								<table  border="0"   width=700 align="left">  
										<tr>
											<td align="center"  class="sansa"><big><big>Welcome to Appointment Managing Application!</big></big></td>
										</tr>
										 <tr>
										 <tr>
										 </tr>
										 <tr>
										 </tr>
  											<td valign=top style="text-align:left" class="sansa" >
											  <i>Easy way to get organized!</i>
											  <td valign=top>&nbsp;
											  </tr>
										
								</table>													
							</div> 
						</div>
						<div id="column" align="right" style="width: 34em;" >
							<form name="appMentlogin" id="appMentlogin" method="post"> 
							<div class="stp" style="margin-bottom:1.5em;width: 34em;" >
								<div class="or" style="margin:1em; padding:0;" align="center"> 		
									<span  style="font-size:1.5em;font-color:black;font:Verdana">Login to account</span><br /><br />       
									<table class="sample" width="100%" >  						
										<tr >
											<td width="33%" align="right" >Username: </td>
											<td width="66%" align="left">
												<spring:bind path="person.username">
													<input type="text" name="username"  id="username"  value="<c:out value="${status.value}"/>" tabindex="1"/>		
													<script>document.getElementById('username').focus()</script>

												</spring:bind>
											</td>

										</tr> 
										<tr></tr>
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
													<input type="password" name="password" id="password" tabindex="2"/>
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
									</table>
									</br>
									<table border="0" cellpadding="0" cellspacing="0" width="300" height="30" >    
										<tr>  
											<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;width:100%;height:100%;"  align="center"> 										  		
									  			<a href="javascript:void(0);" onClick="fn_login();" style="text-decoration:none">
									  				<font size="+1" color="#FFFFFF" >Login </font> 
									  			</a>
									  		</td>
										</tr>
									</table>										
								</div>
							</div>  
							<div class="stp" style="margin-bottom:1.5em;width: 25em" >
	  							<div class="or" style="margin:1em; padding:0;" > 
	  								<span style="font-size:1.3em;font-color:black;font:Verdana" >Don't have account yet?</span><br />   
	  								<a href="/appmentSignUp.htm" onMouseover="document.buttonimg.src=eval('cacheonimg.src')" onMouseout="document.buttonimg.src=eval('cacheoffimg.src')">
	  									<img src="/images/MCbutton_0.png" name="buttonimg" width="200" height="68" alt="AppMent-Create a new Account">   
	  								</a>
	  							</div>							
							</div>
																					
						</form>
						
						</div>
					</div>
				</div>
			</div> 
		</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
