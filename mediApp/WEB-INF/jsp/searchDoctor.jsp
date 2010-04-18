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

												<div id="Search"  style="display:block" align="center">
													<table  border=""  class="login" width=450>
														<tr bgcolor="lightblue">
															Search Doctor
														<tr>
															<td >Doctor First Name:</td>
															
															<td>
																<spring:bind path="doctorSearch.searchCriteria.doctorFirstName">
																	<input type="text" name="${status.expression}"  value="<c:out value="${status.value}"/>"/>
																</spring:bind>																
															</td>
														</tr>
														<tr>
															<td >Doctor Last Name:</td>
															<td>
																<spring:bind path="doctorSearch.searchCriteria.doctorLastName">	
																	<input type="text" name="${status.expression}" value="<c:out value="${status.value}"/>" />
																</spring:bind>	
															</td>
														</tr>
														<tr>
															<td >Doctor Middle Initial:</td>
															<td>
																<spring:bind path="doctorSearch.searchCriteria.doctorMiddleInitial">
																	<input type="text" name="${status.expression}" value="<c:out value="${status.value}"/>" />
																</spring:bind>	
															</td>
														</tr>
														<tr>
															<td>Speciality:</td>
																<td>
																	<spring:bind path="doctorSearch.searchCriteria.speciality">		
																		<input type="text" name="speciality" id="speciality" value="<c:out value="${status.value}"/>"/>
																	</spring:bind>		
																<script type="text/javascript">
																	new Autocomplete('speciality', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
																</script>
															</td>
														</tr>
						

													<tr>
														<td width="40%">Date: </td>
														<td width="40%">
															<spring:bind path="doctorSearch.searchCriteria.dateOfAppointment">
																<input type="text" name="dateOfAppointment" id="dateOfAppointment"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${status.value}"/>" />
																
															</spring:bind>
														</td>
														<td width="20%">
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'searchDoctor',
																			// input name
																			'controlname': 'dateOfAppointment'
																			});
																	</script>
																
														</td>
													</tr>
													<tr>
														<td >Locality: </td>
														<td >
															<spring:bind path="doctorSearch.searchCriteria.locality">	
																<input type="text" name="locality" id="locality" value="<c:out value="${status.value}"/>"/>
															</spring:bind>		
															<script type="text/javascript">
																new Autocomplete('locality', { serviceUrl:'/appointmentPopUp.htm' },'PERSON_TY');
															</script>
	
														</td>
													</tr>
													<tr>
														<td align="center" colspan="2">															
															<input type="button"  onClick="javascript:fn_searchDoctor();" alignment="center" value="Search" class="bsubmit"  width="75"/>
														</td>
													</tr>
														
													</table>
												</div>
												<spring:bind path="doctorSearch.searchResult">
													<c:if test='${not empty status.value}'>
   														<table width=700  border="1" class="layout"  >
   															<tr>
   																<td>
																	<c:forEach var="searchResult" items="${status.value}">
																		<tr>
																			<td>
																				Name: 	<c:out value="${searchResult.doctorFirstName}"/> 
																						<c:out value="${searchResult.doctorMiddleName}"/> 
																						<c:out value="${searchResult.doctorLastName}"/>
																			</td>	
																			<td><a href="javascript:fn_dayAppointment(<c:out value="${searchResult.idPerson}"/>)" > Take Appointment</a>
																			</td>
																		</tr>
																		<tr>																		<tr>
																			<td>
																				Address: 	<c:out value="${searchResult.address1}"/> 
																			</td>
																			<td>
																				Work Hours: <c:out value="${searchResult.workStartTime}"/> - <c:out value="${searchResult.workEndTime}"/> 
																			</td>
																				
																		</tr>															
																		<tr>																		<tr>
																			<td>
																							<c:out value="${searchResult.address2}"/> 
																			</td>	
																		</tr>															
																		<tr>																		<tr>
																			<td>
																							<c:out value="${searchResult.locality}"/> 
																			</td>	
																		</tr>															
																		<tr>																		<tr>
																			<td>
																							<c:out value="${searchResult.state}"/> 
																			</td>	
																		</tr>															
																	</c:forEach>
																</td>
															</tr>
														</table>
													</c:if>
												</spring:bind>
												
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