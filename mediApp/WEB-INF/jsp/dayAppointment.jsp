<%@ include file="/WEB-INF/jsp/include.jsp" %>
<script>
function ajaxCall(){
	new Ajax.Request('/appointmentPopUp.htm',
			{
			 method:'get',
			 onSuccess: function(transport){
			   var response = transport.responseText || "no response text";
			   alert("Success! \n\n" + response);
			  // document.getElementId('test1').style="display:block";
//			   alert(document.getElementById('test1'));
			   document.getElementById('test1').InnerHTML="hey";
			   alert(document.getElementById('test1').InnerHTML);
			   },
			 onFailure: function(){ alert('Something went wrong...') }
			});

}

</script>		

		
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="dayAppointment" id="dayAppointment" method="post" >
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
													</tr>
													<tr>
														<td>															
															<input type="button"  onClick="javascript:fn_nextURL('/takeAppointment.htm');" alignment="center" value="Take Appointment" class="gsubmit"  />
														</td>
													</tr>
													<tr>
														<td>
															<input type="button"  alignment="center" value="Reschedule" class="gsubmit"  />																																												
														</td>
													</tr>
													<tr>
														<td >
														<input type="hidden" name="calSelectedDate" value="">
														<input type="hidden" name="selectedDate" value="">
														<input type="hidden" name="selectedMonth" value="">
														<input type="hidden" name="selectedYear" value="">																								
<select name="tbSelMonth" id="tbSelMonth" onchange='fUpdateCal(dayAppointment.tbSelYear.value, dayAppointment.tbSelMonth.value)'>
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
  
<select name="tbSelYear" id="tbSelYear" onchange='fUpdateCal(dayAppointment.tbSelYear.value, dayAppointment.tbSelMonth.value)'>
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
dayAppointment.tbSelMonth.options[dCurDate.getMonth()].selected = true;
for (i = 0; i < dayAppointment.tbSelYear.length; i++)
if (dayAppointment.tbSelYear.options[i].value == dCurDate.getFullYear())
	dayAppointment.tbSelYear.options[i].selected = true;
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
													<tr>
															<td width="50" bgcolor="lightblue">9:00 AM </td>
															<td width="250" bgcolor="lightblue" ><a onclick="javascript:ajaxCall();">hi</a></td>
													</tr>
													<tr id="test1"></tr>
												</table>												
												</div>
												
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