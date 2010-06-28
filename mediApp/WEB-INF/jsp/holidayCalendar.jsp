<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="holidayCalendar" id="holidayCalendar" method="post" >
									<table width=900  border="1" class="layout"  >	
										<tr>
											<td>	
												<table width=100 align="left"  border="1" class="layout" >	
													<tr>
														<td>
															<input type="button"  alignment="center" value="Past History" class="gsubmit"  />
														</td>
													</tr>
													<tr>
														<td>															
															<input type="button"  onClick="javascript:fn_nextURL('/takeAppointment.htm');" alignment="center" value="My Appointments" class="gsubmit"  />
														</td>
													</tr>
													<tr>
														<td>
															<input type="button"  alignment="center" value="Upload Documents" class="gsubmit"  />																																												
														</td>
													</tr>
												</table>

												<div id="History"  style="display:block" align="center">
													<table  border=""  class="login" width=800 cellpadding="200">
														<tr bgcolor="lightblue" >
															Add Holidays
														</tr>
														<tr >
															<td width="20%">Holiday Date:
															</td>
															<td width="10%" align="left">
															</td >
															<td width="15%" align="left">Full Day:
															</td>
															<td width="15%" align="left">From Time:
															</td>
															<td width="15%" align="left">To Time:
															</td>
															<td width="25%" >
															</td>
														</tr>
														
														<tr>
														<td >
															<spring:bind path="holidayCalendar.holidays[0].holidayDate">
																<input type="text" name="${status.expression}" id="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${status.value}"/>" />																
															</spring:bind>
														</td>
														<td >
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'holidayCalendar',
																			// input name
																			'controlname': 'holidays[0].holidayDate'
																			});
																	</script>
																
														</td>
														<td >
															<spring:bind path="holidayCalendar.holidays[0].fromTime">
																<select id="${status.expression}" name="${status.expression}" style="WIDTH: 100px">
																		<option value='blank' selected="selected" >-Select-</option>
																		<option value='Y'  >Full Day</option>
																</select>
															</spring:bind>
														</td>
														<td >
															<spring:bind path="holidayCalendar.holidays[0].fromTime">
																<select id="${status.expression}" name="${status.expression}" style="WIDTH: 100px">
																		<option value='blank' selected="selected" >-Select-</option>
																		<option value='Y'  >10:00 AM</option>
																</select>
															</spring:bind>
														</td>
														<td >
															<spring:bind path="holidayCalendar.holidays[0].fromTime">
																<select id="${status.expression}" name="${status.expression}" style="WIDTH: 100px">
																		<option value='blank' selected="selected" >-Select-</option>
																		<option value='Y'  >Full Day</option>
																</select>
															</spring:bind>
														</td>
														
														</tr>
													</table>
												</div>
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