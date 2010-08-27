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
							<div class="entryAlone">
								<form name="welcomePage" id="welcomePage" method="post" >
								<div id="TypeForm"  >								
								<table width="800">
								<table   width=500 height="50" align="center" >
									<img src="/images/welcomePage.gif"  />  
								</table>
								
								</table>
								   
								</div>								
							</form>
	
							</div>
						</div>
						<div id="column">
							<div class="stp" style="margin-bottom:1.5em;">
	  							<div class="or" style="margin:1em; padding:0;"> 
	  								<span style="font-size:2.0em;font-color:black;font:Verdana">  AppMent</span><br /> 
	  								<a href="" onMouseover="document.buttonimg.src=eval('cacheonimgl.src')" onMouseout="document.buttonimg.src=eval('cacheoffimgl.src')">
	  									<img src="/images/MLbutton_0.png" name="buttonimg" width="170" height="68" alt="AppMent-Login to your Account">
	  								</a>
	  								 
	  								<a href="" onMouseover="document.buttonimg.src=eval('cacheonimg.src')" onMouseout="document.buttonimg.src=eval('cacheoffimg.src')">
	  									<img src="/images/MCbutton_0.png" name="buttonimg" width="170" height="68" alt="AppMent-Create a new Account">
	  								</a>
	  							</div>							
							</div>
							<div class="stp" style="margin-bottom:1.5em;">
	  							<div class="or" style="margin:1em; padding:0;">    
	  								<span style="font-size:2.0em;font-color:black;font:Verdana">  MediApp</span><br /> 
	  								<a href="/logon.htm" onMouseover="document.buttonimg.src=eval('cacheonimgl.src')" onMouseout="document.buttonimg.src=eval('cacheoffimgl.src')">
	  									<img src="/images/MLbutton_0.png" name="buttonimg" width="170" height="68" alt="MediApp-Login to your Account">
	  								</a>
	  								 
	  								<a href="/logon.htm" onMouseover="document.buttonimg.src=eval('cacheonimg.src')" onMouseout="document.buttonimg.src=eval('cacheoffimg.src')">
	  									<img src="/images/MCbutton_0.png" name="buttonimg" width="170" height="68" alt="MediApp-Create a new Account">
	  								</a>
	  							</div>							
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		
<%@ include file="/WEB-INF/jsp/footer.jsp" %>