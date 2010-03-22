<%@ include file="/WEB-INF/jsp/include.jsp" %>


		
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="takeAppointment" id="takeAppointment" method="post" >
									<table width=700  border="1" class="layout"  >	
										<tr>
											<td>	
												<table width=100 align="left"  border="1" class="layout" >	
													<tr>
														<td>
															<input type="button" onClick="javascript:fn_nextURL('/personalProfile.htm');" alignment="center" value="Personal Details" class="gsubmit"    />
														</td>
													</tr>
													<tr>
														<td>
															<input type="button"  alignment="center" value="Past History" class="gsubmit"  />
														</td>
													<tr>
														<td>
															<input type="button"  alignment="center" value="Upload Documents" class="gsubmit"  />																																												
														</td>
													</tr>
													<tr>
														<td >
														<input type="hidden" name="calSelectedDate" value="">
														<input type="hidden" name="selectedDate" value="">
														<input type="hidden" name="selectedMonth" value="">
														<input type="hidden" name="selectedYear" value="">																								
<select name="tbSelMonth" id="tbSelMonth" onchange='fUpdateCal(takeAppointment.tbSelYear.value, takeAppointment.tbSelMonth.value)'>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6">June</option>
<option value="7">July</option>
<option value="8">August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>
  
<select name="tbSelYear" id="tbSelYear" onchange='fUpdateCal(takeAppointment.tbSelYear.value, takeAppointment.tbSelMonth.value)'>
<option value="2008">2008</option>
<option value="2009">2009</option>
<option value="2010">2010</option>
<option value="2011">2011</option>
</select>
</td>
</tr>
<tr>
<td>
<script language="JavaScript" for=window event=onload>
<!-- Begin
var dCurDate = new Date();
takeAppointment.tbSelMonth.options[dCurDate.getMonth()].selected = true;
for (i = 0; i < takeAppointment.tbSelYear.length; i++)
if (takeAppointment.tbSelYear.options[i].value == dCurDate.getFullYear())
	takeAppointment.tbSelYear.options[i].selected = true;
//  End -->
</script>

<script language="JavaScript">
var dCurDate = new Date();
fDrawCal(dCurDate.getFullYear(), dCurDate.getMonth()+1, 30, 30, "12px", "bold", 1);
</script>
														</td>
													</tr>
													</table>
												<div id="dayAppointments"  style="display:block" align="center">
												<table  border=""  class="appointment" width=450>
<tr><td align="center"><table border="0" cellpadding="3" cellspacing="0" width="100%"><tbody><tr><td align="center" bgcolor="#eeeeee" valign="middle" width="14%"><font size="1" color="#ff0000" face="verdana,arial,helvetica"><b>Sunday</b></font></td><td align="center" bgcolor="#eeeeee" valign="middle" width="14%"><font size="1" color="#ff0000" face="verdana,arial,helvetica"><b>Monday</b></font></td><td align="center" bgcolor="#eeeeee" valign="middle" width="14%"><font size="1" color="#ff0000" face="verdana,arial,helvetica"><b>Tuesday</b></font></td><td align="center" bgcolor="#eeeeee" valign="middle" width="14%"><font size="1" color="#ff0000" face="verdana,arial,helvetica"><b>Wednesday</b></font></td><td align="center" bgcolor="#eeeeee" valign="middle" width="14%"><font size="1" color="#ff0000" face="verdana,arial,helvetica"><b>Thursday</b></font></td><td align="center" bgcolor="#eeeeee" valign="middle" width="14%"><font size="1" color="#ff0000" face="verdana,arial,helvetica"><b>Friday</b></font></td><td align="center" bgcolor="#eeeeee" valign="middle" width="14%"><font size="1" color="#ff0000" face="verdana,arial,helvetica"><b>Saturday</b></font></td></tr></tbody></table></td></tr>
<tr>
	<td align="center">
		<table border="0" cellpadding="2" cellspacing="1" width="100%">
			<tbody><tr>	<td height="70" width="14%">&nbsp;</td>
					<td height="70" width="14%">&nbsp;</td>
					<td height="70" width="14%">&nbsp;</td>
					<td height="70" width="14%">&nbsp;</td>
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;1',300,350,0,1);">
						<font color="#000000">1</font></a></font></td>
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;2',300,350,0,1);">
						<font color="#000000">2</font></a></font></td>
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;3',300,350,0,1);">
						<font color="#000000">3</font></a></font></td></tr>
			<tr>	<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;1',300,350,0,1);">
						<font color="#000000">4</font></a></font></td>
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;2',300,350,0,1);">
						<font color="#000000">5</font></a></font></td>
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;3',300,350,0,1);">
						<font color="#000000">6</font></a></font></td>
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;1',300,350,0,1);">
						<font color="#000000">7</font></a></font></td>						
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;1',300,350,0,1);">
						<font color="#000000">8</font></a></font></td>
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;1',300,350,0,1);">
						<font color="#000000">9</font></a></font></td>
					<td align="right" bgcolor="#eeeeee" height="70" valign="top" width="14%">
						<font size="1" face="verdana,arial,helvetica">
						<a href="javascript://" onclick="javascript:open_window('day_scheduler.html?April&amp;1',300,350,0,1);">
						<font color="#000000">10</font></a></font></td></tr>						
</tbody>

</table>


												
												</table>
												</div></td>
												</tr>
												</table>
												
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