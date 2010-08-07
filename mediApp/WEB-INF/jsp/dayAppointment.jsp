<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="dayAppointment" id="dayAppointment" method="post" >
									<input type="hidden" name="AppointmentID"  id="AppointmentID" value=""/>
									<input type="hidden" name="PersonID"  id="PersonID" value="${personID}"/>
									<input type="hidden" name="AppointmentDate"  id="AppointmentDate" value="${appointmentDate}"/>
									<c:set var="PersonType" />
									<c:set var="PersonID" />
									<%	 pageContext.setAttribute("PersonType",p.getPersonTypeString());
									pageContext.setAttribute("PersonID",p.getIdPerson());
									%>							
									<table width=900  border="1" class="layout"  >	
										<tr>
											<td>
											
												<table width=100 align="left"  border="1" class="layout" >	
											     <menu:verticalMenuItemTag></menu:verticalMenuItemTag>													<tr>
													</table>
										<div id="dayAppointments"  style="display:block" align="center">
											<table  border=""  class="appointment" border="0" cellpadding="2" cellspacing="1" width="680" align="right">
												<tr bgcolor="lightblue">
															Appointment for  <fmt:formatDate type="date" value="${appointmentDate}"/>
												<tr>
												<c:set var="PersonType" />												
												<%	 pageContext.setAttribute("PersonType",p.getPersonTypeString());								
												%>
												<c:forEach items="${appointment}" var="appointments">
													<c:if test="${'Patient' == PersonType}">													
														<tr>													
															<c:if test='${not empty appointments.headline}'>
																<td width="10%" bgcolor="#FFCCCC" bordercolor="black">
																	<c:out value="${appointments.timeOfAppointment}"/>																	
																</td>
															</c:if>
																<c:if test='${empty appointments.headline }'>
																	<td width="10%" bgcolor="#E0E0F8" bordercolor="black">
																		<a href="javascript:fn_createAppointment(<c:out value="${personID}"/>,<c:out value="${appointments.doctorID}"/>,'<c:out value="${appointments.timeOfAppointment}"/>','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointmentDate}"/>')" >
																			<c:out value="${appointments.timeOfAppointment}"/>
																		</a>
																	</td>
																</c:if>															
																<c:if test='${not empty appointments.headline}'>
																	<td width="90%" bgcolor="#FFCCCC" bordercolor="black">
																		<c:if test='${appointments.headline != "OOO"}'>
																			<c:if test='${appointments.headline != "OOO"}'>
																			<a href="javascript:fn_openAppointment(${personID},'${appointments.timeOfAppointment}','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointmentDate}"/>',${appointments.appointmentID})" >
																				<c:out value="${appointments.headline}"/>
																			</a>
																			</c:if>
																		</c:if>
																	</td>
																	<c:if test='${appointments.headline != "OOO"}'>
																		<td align="left" width="33%" bgcolor="#3399FF">
																		<a href="javascript:fn_rescheduleAppointment(${personID},'${appointments.timeOfAppointment}','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointmentDate}"/>',${appointments.appointmentID})" title="Click to rescheule this appointment">
																				<font color="#FF9933"><b>R</b></font>
																			</a>
																			</td>
																	</c:if>

																</c:if>														
																<c:if test='${empty appointments.headline}'>
																	<td width="90%" bgcolor="#E0E0F8" bordercolor="black">															
																	</td>
																</c:if>
														</tr>
													</c:if>													
													<c:if test="${'Doctor' == PersonType}">
														<tr>		
															<c:if test='${not empty appointments.headline}'>
																<td width="10%" bgcolor="#FFCCCC" bordercolor="black">
																	<c:out value="${appointments.timeOfAppointment}"/>
																</td>
															</c:if>
															<c:if test='${empty appointments.headline}'>
																<td width="10%" bgcolor="#E0E0F8" bordercolor="black">
																	<c:out value="${appointments.timeOfAppointment}"/>
																</td>
															</c:if>
															
															<c:if test='${not empty appointments.headline}'>
																<td width="90%" bgcolor="#FFCCCC" bordercolor="black">
																	<c:if test='${appointments.headline != "OOO"}'>
																	<a href="javascript:fn_openAppointment(${personID},'${appointments.timeOfAppointment}','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointmentDate}"/>',${appointments.appointmentID})" >
																		<c:out value="${appointments.headline}"/>
																	</a>																	
																	</c:if>
																</td>
																<c:if test='${appointments.headline != "OOO"}'>
																	<c:if test='${appointments.confirmedIndicator == "N"}'>
																		<td align="left" width="33%" bgcolor="#3399FF">
																			<a href="#" onclick="fn_UpdateAppointment(${appointments.appointmentID});" style="text-decoration:none"  title="Confirm this appointment">
																				<font color="#FF9933" ><b>C</b></font>
																			</a>
																		</td>
																	</c:if>
																	<td align="left" width="33%" bgcolor="#3399FF">
																		<a href="#" onclick="alert(work in progress)" style="text-decoration:none"  >
																			<font color="#FF9933"><b>R</b></font>
																			</a>
																	</td>
																</c:if>
															</c:if>
															<c:if test='${empty appointments.headline}'>
																<td width="90%" bgcolor="#E0E0F8" bordercolor="black">	
																</td>
															</c:if>														
																													
														</tr>
														
													</c:if>
													</c:forEach>
													
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