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
															Personal Details
														</tr>
														<tr>
															<td >Weight: <font color="red">*</font></td>
															<td >
																<spring:bind path="patientDetails.weight">																															
																	<input type="text"  name="weight"  value="<c:out value="${status.value}"/>"/>
																	<font color="red"><c:out value="${status.errorMessage}" /></font>
																</spring:bind>
																
															</td>
														</tr>
														<tr>
															<td >Height: <font color="red">*</font></td>
															<td >
																<spring:bind path="patientDetails.height">																															
																	<input type="text"  name="height"  value="<c:out value="${status.value}"/>"/>
																	<font color="red"><c:out value="${status.errorMessage}" /></font>
																</spring:bind>
																
															</td>
														</tr>
														<tr>
															<td >Blood Group: <font color="red">*</font></td>
															<td >
																<spring:bind path="patientDetails.bloodGroup">
																	<select id="bloodGroup" name="bloodGroup" style="WIDTH: 150px">
																		<c:forEach items="${logonCriteria}" var="data">
																			<option value='${data.codeDecode}' >${data.codeDecode}</option>
																		</c:forEach>
																	</select>
																</spring:bind>
															</td>
														</tr>
													</table>
												</div>
												<div id="History"  style="display:block" align="center">
													<table  border=""  class="login" width=670 cellpadding="200">
														<tr bgcolor="lightblue" >
															Allergies
														</tr>
														<tr>
															<td >
																<spring:bind path="patientDetails.allergies">																															
																	<input type="text"  name="allergies"  value="<c:out value="${status.value}"/>"/>
																	<font color="red"><c:out value="${status.errorMessage}" /></font>
																</spring:bind>
																
															</td>
														</tr>
													</table>
												</div>
												<div id="History"  style="display:block" align="center">
													<table  border=""  class="login" width=670 cellpadding="200">
														<tr bgcolor="lightblue" >
															Upload Past History Files
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