<%@ include file="/WEB-INF/jsp/include.jsp" %>

		
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="personalProfile" id="personalProfile" method="post" >
								<spring:hasBindErrors name="command">
									<c:if test="${not empty errors.globalErrors}">
										<div align="center" id="redmsg">
											<ul>
												<c:forEach items="${errors.globalErrors}" var="error">
												<li> <c:out value="${error}"/> </li>
												</c:forEach>
											</ul>
										</div>
									</c:if>
								</spring:hasBindErrors>
								
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
													
													<tr></tr>
														<tr>
															<td align="center" bgcolor="lightblue">Search</td>
														</tr>
														<tr>
															<td>Doctor Name: </td>
														</tr>
														<tr>
															<td >
																<input type="text"  name="docFirstName"    value=""  />
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
															<input type="text"  name="searchlocality"    value=""  />														
														</td>
													</tr>
													<tr>
														<td align="center" colspan="2">
															<input type="submit"  align="middle" value="Search" class="bsubmit"  width="75"/>
														</td>
													</tr>
														
														
												</table>

												<div id="Personal Details"  style="display:block" align="center">
												<table  border=""  class="login" width=450>
													<tr bgcolor="lightblue">
														<td>Personal Details</td>
													</tr>
												
													<tr>
														<td >First Name: </td>
														<td >
															<spring:bind path="person.firstName">																															
																<input type="text"  name="firstName" value="${person.firstName }"/>
															</spring:bind>
														</td>
													</tr>
													<tr>
														<td >Middle Initials: </td>
														<td >
															<spring:bind path="person.middleInitial">
																<input type="text" name="middleInitial"    value="${person.middleInitial}"/>
															</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Last Name: </td>
														<td >
															<spring:bind path="person.lastName">
																<input type="text" name="lastName"    value="${person.lastName}"/>
															</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Date of Birth: </td>
														<td >
																<input type="text" name="dateOOfBirth"/>
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'personalProfile',
																			// input name
																			'controlname': 'dateOOfBirth'
																			});
																	</script>
														</td>
													</tr>
													<tr>
														<td >Gender: </td>
														<td >
														<spring:bind path="person.gender">
															<input type="radio" name="gender" value="M"/> Male		
															<input type="radio" name="gender" value="F"/> Female
														</spring:bind>		
														</td>
													</tr>
													<tr>
														<td>Address 1:</td>
														<td>
																<input type="text" name="address1" value="${person.address.address1}"/>
														</td>
													</tr>
													<tr>
														<td>Address 2:</td>
														<td>
																<input type="text" name="address2" value="${person.address.address2}"/>
														</td>
													</tr>
													<tr>
														<td>Locality:</td>
														<td>
																<input type="text" name="locality" value="${person.address.locality}"/>
														</td>
													</tr>
													<tr>
														<td>City:</td>
														<td>
																<input type="text" name="city" value="${person.address.city}"/>
														</td>
													</tr>
													<tr>
														<td>State:</td>
														<td>
																<input type="text" name="state" value="${person.address.state}"/>
														</td>
													</tr>
													<tr>
														<td>Country:</td>
														<td>
																<input type="text" name="country" value="${person.address.country}"/>
														</td>
													</tr>
													<tr>
														<td >Phone Number(Landline): </td>
														<td >
														<spring:bind path="person.landlinePhoneNumber">
															<input type="text" name="landlinePhoneNumber"    value="${person.landlinePhoneNumber}"/>
														</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Cell Number: </td>
														<td >
														<spring:bind path="person.cellPhoneNumber">
															<input type="text" name="cellPhoneNumber" value="${person.cellPhoneNumber}"/>
														</spring:bind>		
														</td>
													</tr>
													<tr>
														<td align="center" colspan="2">
															<input id="saveProfile" type="submit"  alignment="center" value="Save" class="bsubmit"  width="75"/>
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