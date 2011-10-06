<script type="text/javascript">
	jQuery.jGrowl("Report bugs found using the ReportIt! <a href='http://www.easy-bugs.com/projects/appment/issues/new.widget'>ReportIt!</a>",
		   {header: 'Report Bugs' ,life: 10000 }
		);		
	jQuery.jGrowl('<table><tr>You can book appointment, postpone it or cancel it by sending SMS.Following are the commands:</tr></br><tr>1. To schedule an appointment with a fellow appmate at certain date and time SCD [yourusername] [mm/dd/yyyy] [hh:mm:ss] [duration hh:mm:ss] [appmateusername] </tr></br><tr>2. To postpone any appointment that you have already scheduleRESCD [yourusername] [old mm/dd/yyyy] [old hh:mm:ss] [new mm/dd/yyyy] [new hh:mm:ss] [duration hh:mm:ss] </tr></br><tr>3. To cancel any appointment that you have already scheduleCANCEL [yourusername] [mm/dd/yyyy] [hh:mm:ss] </tr></table>',

				   {header: 'SMS Support!' ,life: 10000 }
				  );

		jQuery.noConflict(true);


</script>

<div id="contentFootLeft">
		
			<div id="contentFootRight">
				<div id="contentFootCenter"/>
			</div>
		</div>
		<div id="footer">
			<p id="copyright"></p>
			<p id="info">
				Beta 1.0
			</p>
		</div>
	</div>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>
    
<!-- Attach events to Link -->
<div id="helpbox"></div>

</body>

</html>
