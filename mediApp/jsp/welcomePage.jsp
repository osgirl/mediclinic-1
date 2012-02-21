<%@ include file="/jsp/welcomeInclude.jsp" %>
<script>
//IE7 = (navigator.appVersion.indexOf("MSIE 7.")==-1) ? false : true;
//IE8 = (navigator.appVersion.indexOf("MSIE 8.")==-1) ? false : true;

//if(!(IE7  || IE8)){
//	alert("This application is tested on Internet Explorer 7 and higher. It may not work properly on this browser.");
//}

var cacheonimg = new Image ();
var cacheoffimg = new Image ();
cacheonimg.src = '<%=request.getContextPath()%>/images/MCbutton_1.png';
cacheoffimg.src = '<%=request.getContextPath()%>/images/MCbutton_0.png';

var cacheonimgl = new Image ();
var cacheoffimgl = new Image ();
cacheonimgl.src = '<%=request.getContextPath()%>/images/MLbutton_1.png';
cacheoffimgl.src = '<%=request.getContextPath()%>/images/MLbutton_0.png';

</script>
<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div class="stp" style="margin-bottom:1.5em;">
					<div class="or" style="margin:1em; padding:0;" >
					<div id="contentSingleEntry" >
						<div id="entries">
								<form name="welcomePage" id="welcomePage" method="post" >
								<table width="400">
									<h1>Welcome to appointment managing application - Appment</h1></br>
									<h4 style="font-family:Arial;color:#000;font-size:14px;">This application will help doctors, hospitals to allow their patients take appointment online. 
									</br>Doctors can be searched on the website, once enrolled (like in social networking sites) </br>email, sms notifications are sent to doctor when an appointment is scheduled. 
									</br>Diagnosis is stored and is available for review later as part of various reports. </br>
									More features like uploading of old reports, doctors holiday updates 
									</br>(leading to cancellation notification to patients), follow up meetings is also available. 
									</br>It has an Android application too to keep updated on appontments!</h4></br>
									
								</table>
								<table>
									<tr>
										<td>
											<table  border=""  class="layout" >
												<tr>
													<td><h3 style="font-family:Arial;color:#000;font-size:18px;">Find out how to get Started!</h3>
													<span style="font-family:Arial;color:#000;font-size:12px;">
													The application is pretty simple to get started with.</br>Complete step-by-step help can be found here:</br>
													<a href="javascript:void(0);" onClick="javascript:fn_openHelp();" >
													Appment Help
													</a>
													</span>

													</td>

												</tr>
											</table>
										</td>
										<td>									
											<table  border=""  class="layout" >
												<tr>
													<td><h3 style="font-family:Arial;color:#000;font-size:18px;">About Android Application!</h3>
													<span style="font-family:Arial;color:#000;font-size:12px;">
													Yes, we also have android version of the application!.</br>Find out more here:</br>
													<a href="http://www.facebook.com/media/set/?set=a.301833309875268.71114.118415181550416&type=1" >
													Android App
													</a>
													</span>

													</td>

												</tr>
											</table>
										</td>
									</tr>
								</table>
							</form>
	
						</div>
						<div id="column">
								<%
									if (p == null){
								%>
						
							<div class="stp" style="margin-bottom:1.5em;">
	  							<div class="or" style="margin:1em; padding:0;">	  							 
	  								<span style="font-size:2.0em;font-color:black;font:Verdana">  AppMent</span><br /> 
	  								<a href="<%=request.getContextPath()%>/appmentLogin.htm" onMouseover="document.buttonimg.src=eval('cacheonimgl.src')" onMouseout="document.buttonimg.src=eval('cacheoffimgl.src')">
	  									<img src="<%=request.getContextPath()%>/images/MLbutton_0.png" name="buttonimg" width="170" height="68" alt="AppMent-Login to your Account">
	  								</a>
	  								 
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
							<%}  %>
															<%
									if (p != null){
								%>
							<div class="stp" style="margin-bottom:1.5em;" >
	  							<div class="or" style="margin:1em; padding:0;" > 

								<table border="0" cellpadding="0" cellspacing="0" width="100" height="30" >      
					                <tr>     
										<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;width:100%;height:40;"  align="center">  
							  				<a href="javascript:void(0);" onClick="history.back();" style="text-decoration:none"> 
							  					<font size="+1" color="#FFFFFF" >Go Back</font>  
							  				</a>
						  				</td>
									</tr>
								</table>
								</div>
							</div>
								<%} %>										
							
							
						</div>
					</div>
					</div>	
								</div>
				</div>
			</div>
		</div>
		
<%@ include file="/jsp/footer.jsp" %>