<%@ include file="/WEB-INF/jsp/welcomeInclude.jsp" %>
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
							<table>
							<tr>
								<td width="65%">
								<table  border="0"   width=700 align="left">  
										  <tr>
										  		<td>
													<form action="j_spring_openid_security_check" method="post" id="openid_form">
														<input type="hidden" name="action" value="verify" />
													 
														<fieldset>
													    		<legend>Sign-in with if you already have any of these ID</legend>
													    		
													    		<div id="openid_choice">
														    		<p>Please click your account provider:</p>
														    		<div id="openid_btns"></div>
																</div>
																
																<div id="openid_input_area">
																	<input id="openid_identifier" name="openid_identifier" type="text" value="http://" />
																	<input id="openid_submit" type="submit" value="Sign-In"/>
																</div>
																<noscript>
																<p>OpenID is service that allows you to log-on to many different websites using a single indentity.
																Find out <a href="http://openid.net/what/">more about OpenID</a> and <a href="http://openid.net/get/">how to get an OpenID enabled account</a>.</p>
																</noscript>
														</fieldset>
													</form>
												</td>										  
										  </tr>
										
								</table>													
								
								</td>
								<td width="35%">
							<form name="appMentlogin" id="appMentlogin" method="post"> 
							<div class="stp" style="margin-bottom:1.5em;width: 20em;" >
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
							<div class="stp" style="margin-bottom:1.5em;width: 20em" >
	  							<div class="or" style="margin:1em; padding:0;" > 
	  								<span style="font-size:1.3em;font-color:black;font:Verdana" >Don't have account yet?</span><br />   
	  								<a href="/appmentSignUp.htm" onMouseover="document.buttonimg.src=eval('cacheonimg.src')" onMouseout="document.buttonimg.src=eval('cacheoffimg.src')">
	  									<img src="/images/MCbutton_0.png" name="buttonimg" width="200" height="68" alt="AppMent-Create a new Account">   
	  								</a>
	  							</div>							
							</div>
																					
						</form>
								
								</td>
							</tr>
							</table>
							</div> 
						</div>
						<div id="column" align="right" style="width: 34em;" >
						
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
		
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
