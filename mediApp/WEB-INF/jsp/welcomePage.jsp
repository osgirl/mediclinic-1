<%@ include file="/WEB-INF/jsp/welcomeInclude.jsp" %>
<script>
var cacheonimg = new Image ();
var cacheoffimg = new Image ();
cacheonimg.src = '/images/MCbutton_1.png';
cacheoffimg.src = '/images/MCbutton_0.png';

var cacheonimgl = new Image ();
var cacheoffimgl = new Image ();
cacheonimgl.src = '/images/MLbutton_1.png';
cacheoffimgl.src = '/images/MLbutton_0.png';

</script>
<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone" class="or">
								<form name="welcomePage" id="welcomePage" method="post" >
								<div class="stp" style="margin-bottom:1.5em;">
								<div class="or" style="margin:1em; padding:0;" >
								<table   width=900 height="200" align="center" >
									<tr >
              										<td class="sansa"><big><big><b>Welcome to AppMent!</b></big></big></td>	
             						</tr>
									<tr >
										<td>
											<div align="center">
												<div name="addbox" id="addbox">
												<a name="link1" id="link1" href="/appmentSignUp.htm"><img border="0" name="banner1" id="banner1" src="/images/oie_shake_hands_concepts_3.jpg"></a>
												<a name="link2" id="link2" href="/appmentSignUp.htm"><img border="0" name="banner2" id="banner2" src="/images/oie_medical.jpg"></a>
											</div>
										</div>
										 
										</td>
									</tr>
									
									<tr >
										<td class="sansa">
													AppMent is appointment management software. <br/>
													Once you sign up with AppMent, you can find other AppMates. Other AppMates can find you too.<br/>
													Take appointments not just from this website, you can also take it through SMS.<br/>
													Other features of rescheduling, follow up and lot more features<br/>
										</td>
									</tr>  
								</table>
								</div>	
								</div>
															
							</form>
	
							</div>
						</div>
						<div id="column">
						
							<div class="stp" style="margin-bottom:1.5em;">
	  							<div class="or" style="margin:1em; padding:0;">	  							 
	  								<span style="font-size:2.0em;font-color:black;font:Verdana">  AppMent</span><br /> 
	  								<a href="/appmentLogin.htm" onMouseover="document.buttonimg.src=eval('cacheonimgl.src')" onMouseout="document.buttonimg.src=eval('cacheoffimgl.src')">
	  									<img src="/images/MLbutton_0.png" name="buttonimg" width="170" height="68" alt="AppMent-Login to your Account">
	  								</a>
	  								 
	  							</div>							
							</div>
							<div class="stp" style="margin-bottom:1.5em;" >
	  							<div class="or" style="margin:1em; padding:0;" > 
	  								<span style="font-size:1.3em;font-color:black;font:Verdana" >Don't have account yet?</span><br />   
	  								<a href="/appmentSignUp.htm" onMouseover="document.buttonimg1.src=eval('cacheonimg.src')" onMouseout="document.buttonimg1.src=eval('cacheoffimg.src')">
	  									<img src="/images/MCbutton_0.png" name="buttonimg1" width="170" height="68" alt="AppMent-Create a new Account">   
	  								</a>
	  							</div>							
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		
<%@ include file="/WEB-INF/jsp/footer.jsp" %>