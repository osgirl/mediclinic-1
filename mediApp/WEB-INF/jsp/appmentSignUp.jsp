<%@ include file="/WEB-INF/jsp/include.jsp" %>
		<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" >
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
								<form name="appmentSignUp" id="appmentSignUp" method="post"> 
								<div class="stp" style="margin-bottom:1.5em;">
									<div class="or" style="margin:1em; padding:0;" >								
									<c:if test="${not empty SuccessMessage}">
										
										<font color="red"><c:out value="${SuccessMessage}" /></font><br/>
										<script>
											window.setTimeout('fn1()', 3000);
											function fn1(){
												window.location.href = "/appmentLogin.htm";
												}
										
										</script>
										
										
									 </c:if>
									 <c:if test="${empty SuccessMessage}">
								 
										<span  style="font-size:1.5em;font-color:black;font:Verdana">Please provide following information for creating account</span><br /><br />       
										<table class="sample"  width="500">
											<tr >   
												<td width="40%" align="right" >First Name: </td>
												<td width="40%" align="left"> 
													<spring:bind path="person.firstName"> 
														<input type="text" name="${status.expression}"  id="${status.expression}"  value="<c:out value="${status.value}"/>" tabindex="1"  onKeyUp="if(this.value.match(/[^a-zA-Z]/))this.value=this.value.replace(/[^a-zA-Z]/g,'')" onblur="if(this.value.match(/[^a-zA-Z]/))this.value=this.value.replace(/[^a-zA-Z]/g,'')"/>																
															<script>document.getElementById('firstName').focus()</script>
													</spring:bind>
												</td>
												<td>
												</td>
	
											</tr> 
											<tr>
												<td colspan="2" align="center">
													<spring:bind	path="person.firstName">
															<font color="red"><c:out value="${status.errorMessage}" /></font>
													</spring:bind>
												</td>
											</tr>
											
											<tr >   
												<td width="40%" align="right" >Middle Initials: </td>
												<td width="40%" align="left"> 
													<spring:bind path="person.middleInitial"> 
														<input type="text" name="${status.expression}"  id="${status.expression}"  value="<c:out value="${status.value}"/>" tabindex="1"  onKeyUp="if(this.value.match(/[^a-zA-Z]/))this.value=this.value.replace(/[^a-zA-Z]/g,'')" onblur="if(this.value.match(/[^a-zA-Z]/))this.value=this.value.replace(/[^a-zA-Z]/g,'')"/>																
	
													</spring:bind>
												</td>
												<td>
												</td>
	
											</tr> 
											<tr >   
												<td width="40%" align="right" >Last Name: </td>
												<td width="40%" align="left"> 
													<spring:bind path="person.lastName"> 
														<input type="text" name="${status.expression}"  id="${status.expression}"  value="<c:out value="${status.value}"/>" tabindex="1"  onKeyUp="if(this.value.match(/[^a-zA-Z]/))this.value=this.value.replace(/[^a-zA-Z]/g,'')" onblur="if(this.value.match(/[^a-zA-Z]/))this.value=this.value.replace(/[^a-zA-Z]/g,'')"/>																
	
													</spring:bind>
												</td>
												<td>
												</td>
	
											</tr> 
											<tr>
												<td colspan="2" align="center">
													<spring:bind	path="person.lastName">
															<font color="red"><c:out value="${status.errorMessage}" /></font>
													</spring:bind>
												</td>
											</tr>
											
											<tr>
											<td>
											</td>
											<td >											 
											</td>
											<td>
											</td>
											</tr>
											<tr>
											
											<tr >   
												<td width="40%" align="right" >Choose a Username: </td>
												<td width="40%" align="left"> 
													<spring:bind path="person.username"> 
														<input type="text" name="${status.expression}"  id="${status.expression}"  value="<c:out value="${status.value}"/>" tabindex="1"  onKeyUp="if(this.value.match(/\W/))this.value=this.value.replace(/\W/g,'')" onblur="if(this.value.match(/\W/))this.value=this.value.replace(/\W/g,'')"/>		
													</spring:bind>
												</td>
												<td>
												</td>
	
											</tr> 
											<tr>
											<td> 
											</td>
											<td> <font size="1" color="black" >you can choose any combination of alphabets and numbers.</font> 
											</td>
											<td>
											</td>
											</tr>
											<tr>
											</tr> 
											<tr>
												<td colspan="2" align="center">
													<spring:bind	path="person.username">
															<font color="red"><c:out value="${status.errorMessage}" /></font>
													</spring:bind>
												</td>
											</tr>
	
											<tr>
												<td width="40%" align="right" >Choose a Password: </td>
												<td width="40%" align="left">
													<spring:bind	path="person.password">
														<input type="password" name="${status.expression}" id="${status.expression}" tabindex="2" onKeyUp="checkPassword(this.value)"/>														
													</spring:bind>
												</td>
												<td align="left">&nbsp;   
													<div style="border: 1px solid gray; width: 100px;" >
														<div id="progressBar" style="font-size: 1px; height: 20px;width: 0px; border: 1px solid white;">
														</div>
													</div>												
												</td>
											</tr>
											<tr>
											<td>
											</td>
											<td >											 
											</td>
											<td>
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
												<td width="40%" align="right" >Re-enter Password: </td>
												<td width="40%" align="left">
													<input type="password" name="repassword" id="repassword" tabindex="3"/>
												</td>
												<td >   
													<div style="display:none;background-color:#cadef4;" >
														<img  src="/images/notok.jpg" valign="bottom" >
													</div>
												</td>
											</tr>
											<tr>
											<td> 
											</td>
											<td>
												 <div style="display:none;background-color:#cadef4;" >
													<font size="2" color="red" >Passwords not same.</font>
												</div> 
											</td>
											<td>
											</td>
											</tr>
											<tr>
											</tr> 
											
											<tr>
												<td width="40%" align="right" >Your email-address: </td>
												<td width="40%" align="left">
													<spring:bind	path="person.emailID"> 
														<input type="text" name="${status.expression}" id="${status.expression}"  value="<c:out value="${status.value}"/>" tabindex="4" width="300"/>
													</spring:bind>
												</td>
												<td colspan="2" align="center"> 
												</td>
											</tr>
											<tr>
											</tr>
											<tr>
											</tr>
											<tr>
												<td colspan="2" align="center">
													<spring:bind	path="person.emailID">
															<font color="red"><c:out value="${status.errorMessage}" /></font>
													</spring:bind>
												</td>
											</tr>
											
											<tr>
												<td width="40%" align="right" >Your cell phone number: </td>
												<td width="40%" align="left">
													<spring:bind	path="person.cellPhoneNumber">
														<input type="text" name="${status.expression}" id="${status.expression}" tabindex="5" value="<c:out value="${status.value}"/>" onKeyUp="if(this.value.match(/\D/))this.value=this.value.replace(/\D/g,'')" onblur="if(this.value.match(/\D/))this.value=this.value.replace(/\D/g,'')"/>
													</spring:bind>
												</td>
												<td colspan="2" align="center">
												</td>
											</tr>
											<tr>
												<td colspan="2" align="center">
													<spring:bind	path="person.cellPhoneNumber">
															<font color="red"><c:out value="${status.errorMessage}" /></font>
													</spring:bind>
												</td>
											</tr>
											    
											<table border="0" cellpadding="0" cellspacing="0" width="100" height="30" >      
											<tr>     
												<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;"  align="center">  
										  			<a href="javascript:void(0);" onClick="fn_signUp();" style="text-decoration:none"> 
										  				<font size="+1" color="#FFFFFF" >Register</font> 
										  			</a>
										  		</td>
											</tr>
										</table>										
																											
										</table>
										</br>
										</c:if>
									</div>
								</div>  
							</form>
							
							</div> 
						</div>
						<div id="column" align="right">
						</div>
					</div>
				</div>
			</div> 
		</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
