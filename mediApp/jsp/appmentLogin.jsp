<%@ include file="/jsp/welcomeInclude.jsp" %>
		<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div class="stp" style="margin-bottom:1.5em;">
						<div class="or" style="margin:1em; padding:0;" >								
					<div id="contentSingleEntry" style="">
						<div id="entries" align="left" >
<script>
var cacheonimg = new Image ();
var cacheoffimg = new Image ();
cacheonimg.src = '<%=request.getContextPath()%>/images/MCbutton_1.png';
cacheoffimg.src = '<%=request.getContextPath()%>/images/MCbutton_0.png';

var cacheonimgl = new Image ();
var cacheoffimgl = new Image ();
cacheonimgl.src = '<%=request.getContextPath()%>/images/MLbutton_1.png';
cacheoffimgl.src = '<%=request.getContextPath()%>/images/MLbutton_0.png';

var cacheonimgs = new Image ();
var cacheoffimgs = new Image ();
cacheonimgs.src = '<%=request.getContextPath()%>/images/submitbutton_1.png';
cacheoffimgs.src = '<%=request.getContextPath()%>/images/submitbutton_0.png';

</script>
						
							<div class="entryAlone" >
							<table>
							<tr>
								<td width="65%">
								<table  border="0"    align="left" class="wheader">  
										  <tr>
										  		<td> Manage Appointment
												</td>										  
										  </tr>
										
								</table>													
								
								</td>
							</tr>
							</table>
							</div> 
						</div>
						<div id="column" >
							<form name="appMentlogin" id="appMentlogin" method="post"> 
							<div class="stp" style="margin-bottom:1.em;">
	  							<div class="or" style="margin:1em; padding:0;">	  							 
	  								<span style="font-size:2.0em;font-color:black;font:Verdana">  Login</span>
	  								<br> <br> 
									<table class="sample" width="100%" >  
																
										<tr >
											<td  align="right" >Name: </td>
											<td align="left">
												<spring:bind path="person.username">
													<input type="text" name="username"  id="username"  value="<c:out value="${status.value}"/>" size="30" tabindex="1" />		
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
											<td  align="right" >Password: </td>
											<td  align="left">
												<spring:bind	path="person.password">
													<input type="password" name="password" id="password" tabindex="2" size="30" />
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
									<table border="0" cellpadding="0" cellspacing="0" width="100%" height="30" >    
										<tr>  
											<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;"  align="center"> 										  		
									  			<a href="javascript:void(0);" onClick="fn_login();" style="text-decoration:none">
									  				<font size="+1" color="#FFFFFF" >Login </font> 
									  			</a>
									  		</td>
										</tr>
									</table>										
	  								 
	  							</div>							
							</div>
							<div class="stp" style="margin-bottom:1.5em;" >
	  							<div class="or" style="margin:1em; padding:0;" > 
										<table class="sample"  >
											<tr >   
												<td>
													<script type="IN/Login" >

													</script>
												</td>											
												<td  > 										  		
													<a href="javascript:void(0);" id="googlelogin" >
													<img class="googlelogin" src="/images/signin-google.png">
													</a>
												</td>
												<td>
													<div id="fb-root"></div>
													<fb:login-button autologoutlink="true" perms="email,user_birthday,status_update,publish_stream"></fb:login-button>
												</td>
											</tr>

										</table>
	  							</div>							
							</div>
							
							<div class="stp" style="margin-bottom:1.5em;" >
	  							<div class="or" style="margin:1em; padding:0;" > 
	  								<span style="font-size:1.3em;font-color:black;font:Verdana" >Don't have account yet?</span><br />   
	  								<a href="<%=request.getContextPath()%>/appmentSignUp.htm" onMouseover="document.buttonimg1.src=eval('cacheonimg.src')" onMouseout="document.buttonimg1.src=eval('cacheoffimg.src')">
	  									<img src="<%=request.getContextPath()%>/images/MCbutton_0.png" name="buttonimg1" width="170" height="68" alt="AppMent-Create a new Account">   
	  								</a>
	  							</div>							
							</div>
						</form>
						</div>
					</div>
					</div>
					</div>
				</div>
			</div> 
		</div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/openid-jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/openid-jquery-en.js"></script>
	<script type="text/javascript">	 
	//  var $j = jQuery.noConflict();
		
	$(document).ready(function() {
	    openid.init('openid_identifier');
	    openid.setDemoMode(true); //Stops form submission for client javascript-only test purposes
	});
	
	</script>
		
<%@ include file="/jsp/footer.jsp" %>
