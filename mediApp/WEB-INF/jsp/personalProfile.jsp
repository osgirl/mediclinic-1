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
								<c:set var="PersonType" />
								<c:set var="PersonID" />
								<%	 pageContext.setAttribute("PersonType",p.getPersonTypeString());
								pageContext.setAttribute("PersonID",p.getIdPerson());
								%>							
									<table width=900  border="1" class="layout"  >	
										<tr>
											<td>	
												<table width=100 align="left"  border="1" class="layout" >
													<c:if test="${'Patient' == PersonType}">												 	
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
																<input type="button"  onClick="javascript:fn_nextURL('/searchDoctor.htm');" alignment="center" value="Search Doctor" class="gsubmit"  />
															</td>
														</tr>
														<tr>
															<td>
																<input type="button"  onClick="javascript:fn_nextURL('/searchDoctor.htm');" alignment="center" value="Upload Documents" class="gsubmit"  />																																												
															</td>
														</tr>
													</c:if>
													
													<c:if test="${'Doctor' == PersonType}">												 	
														<tr>
															<td>															
																<input type="button"  onClick="javascript:fn_nextURL('/dayAppointment.htm?PersonID=${PersonID}');" alignment="center" value="My Appointments" class="gsubmit"  />
															</td>
														</tr>
														<tr>
															<td>
																<input type="button"  onClick="javascript:fn_nextURL('/searchDoctor.htm');" alignment="center" value="My Search" class="gsubmit"  />																																												
															</td>
														</tr>
													</c:if>													
																										
												</table>

												<div id="Personal Details"  style="display:block" align="center">
												<table  border=""  class="login" width=670 cellpadding="200">
													<tr bgcolor="lightblue" >
														Personal Details
													</tr>
												
													<tr>
														<td >First Name: <font color="red">*</font></td>
														<td >
															<spring:bind path="person.firstName">																															
																<input type="text"  name="firstName" value="${person.firstName }"/>
																<font color="red"><c:out value="${status.errorMessage}" /></font>
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
														<td >Last Name: <font color="red">*</font></td>
														<td >
															<spring:bind path="person.lastName">
																<input type="text" name="lastName"    value="${person.lastName}"/>
															</spring:bind>		
														</td>
													</tr>
													<tr>
														<td >Date of Birth: <font color="red">*</font></td>
														<td >
																<input type="text" name="dateOOfBirth" value='<fmt:formatDate pattern="MM/dd/yyyy" value="${person.dateOfBirth}" />'/>
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
														<td >Gender: <font color="red">*</font></td>
														<td >
															<spring:bind path="person.gender">
															<input type="hidden" name="personGender" value="${person.gender }"/>
																<input type="radio" name="gender" value="M" /> Male		
																<input type="radio" name="gender" value="F"/> Female
															</spring:bind>	
														</td>
														<spring:bind path="person.idPerson">
															<input type="hidden" name="${status.expression}" value="${person.idPerson}"/>
														</spring:bind>
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
														<td >Cell Number: <font color="red">*</font></td>
														<td >
														<spring:bind path="person.cellPhoneNumber">
															<input type="text" name="cellPhoneNumber" value="${person.cellPhoneNumber}"/>
														</spring:bind>		
														</td>
													</tr>
													<c:if test="${'Doctor' == person.personTypeString}">
													<tr>
														<td>Specialization:<font color="red">*</font></td>
														<td>
															<input type="hidden" id="hSpeciality" name="hSpeciality" />
															<input type="text" name="speciality" id="speciality" />		
															<script type="text/javascript">
																new Autocomplete('speciality', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALITY');
															</script>
														</td>
													</tr>
													<tr>
														<td>Availability:<font color="red">*</font></td>
														<td>
														<table border="0" width="">
															<tr>
															<td><input type="checkbox" name="sundayWorking" value="Y">Sunday</input></td>
															<td><input type="checkbox" name="mondayWorking" value="Y">Monday</input></td>
															<td><input type="checkbox" name="tuesdayWorking" value="Y">Tuesday</input></td>
															</tr>
															<br>
															<tr>
															<td><input type="checkbox" name="wednesdayWorking" value="Y">Wednesday</input></td>
															<td><input type="checkbox" name="thursdayWorking" value="Y">Thursday</input></td>
															<td><input type="checkbox" name="fridayWorking" value="Y">Friday</input></td>
															</tr>
															</br>
															<tr>
															<td><input type="checkbox" name="saturdayWorking" value="Y">Saturday</input></td>
															</tr>
														</table>
														</td>
													</tr>
													<tr>
														<td width="150px">Working Hours:<font color="red">*</font></td>
														<td width="250px" align="left">Start Time: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<select name="startTime">
																<option value="9:00 AM">9:00 AM</option>
																<option value="10:00 AM">10:00 AM</option>
																<option value="11:00 AM">11:00 AM</option>
																<option value="12:00 AM">12:00 AM</option>
																<option value="4:00 PM">4:00 PM</option>
																<option value="5:00 PM">5:00 PM</option>
																<option value="6:00 PM">6:00 PM</option>
																<option value="9:00 PM">9:00 PM</option>
															</select>
														</td>
														<td align="left" width="250px">End Time: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<select name="endTime">
																<option value="10:00 AM">10:00 AM</option>
																<option value="11:00 AM">11:00 AM</option>
																<option value="12:00 AM">12:00 AM</option>
																<option value="4:00 PM">4:00 PM</option>
																<option value="5:00 PM">5:00 PM</option>
																<option value="6:00 PM">6:00 PM</option>
																<option value="9:00 PM">4:00 PM</option>
															</select>														
														</td>
													</tr>
													</c:if>
													<tr>
														<td align="center" colspan="2">
															<input id="saveProfile" name ="saveProfile" type="submit"  alignment="center" value="Save" class="bsubmit"  width="75"/>
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