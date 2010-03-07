<%@ include file="/WEB-INF/jsp/include.jsp" %>

		
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="profile" id="personalProfile" method="post" >
									<table width=700  border="1" class="layout"  >	
										<tr>
											<td>	
												<table width=200 align="left"  border="1" class="layout" >	
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
															<input type="button"  alignment="center" value="Make an Appointment" class="gsubmit"  />
														</td>
													</tr>
													<tr>
														<td>
															<input type="button"  alignment="center" value="Reschedule" class="gsubmit"  />																																												
														</td>
													</tr>
												</table>
												<table  border="0" >												
													
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
																<input type="text" name="dateOOfBirth"    value="26-Feb-2009" readonly="readonly"/>
														</td>
													</tr>
													<tr>
														<td >Gender: </td>
														<td >
															<input type="radio" name="username"    value=""/> Male		
															<input type="radio" name="username"    value=""/> Female		
														</td>
													</tr>
													<tr>
														<td >Address1 : </td>
														<td >
															<input type="text" name="username"    value=""/>		
														</td>
													</tr>
													<tr>
														<td >Address 2: </td>
														<td >
															<input type="text" name="username"    value=""/>		
														</td>
													</tr>
													<tr>
														<td >Locality: </td>
														<td >
															<select>
																<option>-Select-</option>
															</select>
														</td>
													</tr>
													<tr>
														<td >City: </td>
														<td >
															<select>
																<option>-Select-</option>
															</select>
														</td>
													</tr>
													<tr>
														<td >State: </td>
														<td >
															<select>
																<option>-Select-</option>
															</select>

														</td>
													</tr>
													<tr>
														<td >Country: </td>
														<td >
															<select>
																<option>-Select-</option>
															</select>
														</td>
													</tr>
													<tr>
														<td >Phone Number(Landline): </td>
														<td >
															<input type="text" name="username"    value=""/>		
														</td>
													</tr>
													<tr>
														<td >Cell Number: </td>
														<td >
															<input type="text" name="username"    value=""/>		
														</td>
													</tr>
													<tr>
														<td align="center" colspan="2">
															<input type="submit"  alignment="center" value="Save" class="bsubmit"  width="75"/>
														</td>
													</tr>
												</table>
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