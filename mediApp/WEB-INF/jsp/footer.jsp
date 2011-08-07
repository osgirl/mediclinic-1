<script type="text/javascript">
$.jGrowl('You can book appointment, postpone it or cancel it by sending SMS.Following are the commands:', 
   {header: 'SMS Support!' ,life: 10000}
  );
$.jGrowl('1. To schedule an appointment with a fellow appmate at certain date and time SCD [yourusername] [mm/dd/yyyy] [hh:mm:ss] [duration hh:mm:ss] [appmateusername] ', 
	   {life: 10000}
 );
$.jGrowl('2. To postpone any appointment that you have already scheduleRESCD [yourusername] [old mm/dd/yyyy] [old hh:mm:ss] [new mm/dd/yyyy] [new hh:mm:ss] [duration hh:mm:ss]', 
		   {life: 10000}
	 );
$.jGrowl('3. To cancel any appointment that you have already scheduleCANCEL [yourusername] [mm/dd/yyyy] [hh:mm:ss]', 
		   {life: 10000}
	 );
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
