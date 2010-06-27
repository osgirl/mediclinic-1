<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="searchDoctor" id="searchDoctor" method="post" >
									<table width=700  border="1" class="layout"  >	
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
													<table  border=""  class="login" width=670 cellpadding="200">
														<tr bgcolor="lightblue" >
															Add Holidays
														</tr>
														<tr>
															<td>
															</td>						
															<td>Holiday Date:
															</td>
															<td>From Time:
															</td>
															<td>
															</td>
															<td>To Time:
															</td>
														</tr>
														
														<tr>
														<td >
															<spring:bind path="holidayCalendar.holidays.holidayDate">
																<input type="text" name="${status.expression}" id="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${status.value}"/>" />																
															</spring:bind>
														</td>
														<td >
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'searchDoctor',
																			// input name
																			'controlname': 'dateOfAppointment'
																			});
																	</script>
																
														</td>
														<td >
															<spring:bind path="holidayCalendar.holidays.fromTime">
																<input type="text" name="${status.expression}" id="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${status.value}"/>" />																
															</spring:bind>
														</td>
														<td >
															<spring:bind path="holidayCalendar.holidays.toTime">
																<input type="text" name="${status.expression}" id="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${status.value}"/>" />																
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