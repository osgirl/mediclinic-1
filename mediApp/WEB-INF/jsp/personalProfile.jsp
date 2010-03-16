<%@ include file="/WEB-INF/jsp/include.jsp" %>

		
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="personalProfile" id="personalProfile" method="post" >
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
													<tr></tr>
														<tr>
															<td align="center" bgcolor="lightblue">Search</td>
														</tr>
														<tr>
															<td>Doctor Name: </td>
														</tr>
														<tr>
															<td >
																<input type="text"  name="firstName"    value=""  />
															</td>
														</tr>
														<tr>
															<td>Speciality:</td>
														</tr>
														<tr>
															<td >
															<select >
																<option>-Select-</option>
															</select>

															</td>
														</tr>

													<tr>
														<td >Date: </td>
													</tr>
													<tr>
														<td >																
																<input type="text" name="aDate"  />
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'personalProfile',
																			// input name
																			'controlname': 'aDate'
																			});
																	</script>
																
														</td>
													</tr>
													<tr>
														<td >Locality: </td>
													</tr>
													<tr>
														<td >
															<input type="text"  name="firstName"    value=""  />														
														</td>
													</tr>
													<tr>
														<td align="center" colspan="2">
															<input type="submit"  alignment="center" value="Search" class="bsubmit"  width="75"/>
														</td>
													</tr>
														
														
												</table>

												<div id="Personal Details"  style="display:block" align="center">
												<table  border=""  class="login" width=450>
													<tr bgcolor="lightblue">
														Personal Details
													</tr>
												
													<tr>
														<td >First Name: </td>
														<td >
															<spring:bind path="person.firstName">																															
																<input type="text"  name="firstName"    value="<c:out value="${person.firstName}" />"  />
															</spring:bind>
														</td>
													</tr>
													<tr>
														<td >Middle Initials: </td>
														<td >
															<spring:bind path="person.middleInitial">
																<input type="text" name="middleInitial"    value="<c:out value="${person.middleInitial}" />"/>
															</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Last Name: </td>
														<td >
															<spring:bind path="person.lastName">
																<input type="text" name="lastName"    value="<c:out value="${person.lastName}" />"/>
															</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Date of Birth: </td>
														<td >
														<spring:bind path="person.dateOfBirth">																
																<input type="text" name="dateOOfBirth" />
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'personalProfile',
																			// input name
																			'controlname': 'dateOOfBirth'
																			});
																	</script>
														</spring:bind>
														</td>
													</tr>
													<tr>
														<td >Gender: </td>
														<td >
														<spring:bind path="person.gender">
															<input type="radio" name="gender"/> Male		
															<input type="radio" name="gender"/> Female
														</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Address1 : </td>
														<td >
														<spring:bind path="person.address1">
															<input type="text" name="address1"/>	
														</spring:bind>	
														</td>
													</tr>
													<tr>
														<td >Address 2: </td>
														<td >
														<spring:bind path="person.address2">
															<input type="text" name="address2"/>
														</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Locality: </td>
														<td >
														<spring:bind path="person.locality">
															<select name="locality">
																<option>-Select-</option>
																<option>Electronic City</option>
																<option>M G Road</option>
																<option>BTM Layout</option>
															</select>
														</spring:bind>
														</td>
													</tr>
													<tr>
														<td >City: </td>
														<td >
														<spring:bind path="person.city">
															<select name="city">
																<option>-Select-</option>
																<option>Bengalooru</option>
															</select>
														</spring:bind>
														</td>
													</tr>
													<tr>
														<td >State: </td>
														<td >
															<spring:bind path="person.state">
															<select name="state">
																<option>-Select-</option>
																<option>Karanataka</option>
															</select>
														</spring:bind>
														</td>
													</tr>
													<tr>
														<td >Country: </td>
														<td>
														<spring:bind path="person.country">
															<select name="country">
																<option>-Select-</option>
																<option>Karanataka</option>
															</select>
														</spring:bind>
													</td>
													</tr>
													<tr>
														<td >Phone Number(Landline): </td>
														<td >
														<spring:bind path="person.landlinePhoneNumber">
															<input type="text" name="landlinePhoneNumber"    value=""/>
														</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Cell Number: </td>
														<td >
														<spring:bind path="person.cellPhoneNumber">
															<input type="text" name="cellPhoneNumber"    value=""/>
														</spring:bind>		
														</td>
													</tr>
													<tr>
														<td align="center" colspan="2">
															<input type="submit"  alignment="center" value="Save" class="bsubmit"  width="75"/>
														</td>
													</tr>
												</table>
												</div>
											</td>
																						
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