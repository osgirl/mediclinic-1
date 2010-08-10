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
									<input type="hidden" name="AppointmentDate"  id="AppointmentDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${AppointmentDate}"/>">
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
											<td align="left" width="10%" bgcolor="#eeeeee">
												<a href="#" onclick="fn_GetMonthAppointmentDayView(1);" style="text-decoration:none">
													<font color="#ff0000"><b>&lt;&lt;</b></font>
												</a>
											
											</td>
										
											<td align="center" bgcolor="#eeeeee" valign="middle" >
												<font size="3" color="#ff0000" face="verdana,arial,helvetica">
													<input type="hidden" name="AppointmentMonth" value="<fmt:formatDate pattern="MM" value="${AppointmentDate}"/>">
													<input type="hidden" name="AppointmentYear" value="<fmt:formatDate pattern="yyyy" value="${AppointmentDate}"/>">
													<b><fmt:formatDate pattern="MMMMMMMMM" value="${AppointmentDate}"/></b>
													
												</font>
											</td>
											<td align="right" width="33%" bgcolor="#eeeeee">
												<a href="#" onclick="fn_GetMonthAppointmentDayView(2);" style="text-decoration:none" >
													<font color="#ff0000"><b>&gt;&gt;</b></font>
												</a>
											
											</td>
											</tr>
															<tr>
																<td align="left" width="10%" bgcolor="#eeeeee">
																	<a href="#" onclick="fn_GetDayAppointmentDayView(1);" style="text-decoration:none" >
																		<font color="#ff0000"><b>&lt;</b></font>
																	</a>
																
																</td>
																<td align="center" bgcolor="#eeeeee" valign="middle" width="33%" >
																	<font size="3" color="#ff0000" face="verdana,arial,helvetica">
																		<input type="hidden" name="AppointmentMonth" value="<fmt:formatDate pattern="MM" value="${AppointmentDate}"/>">
																		<input type="hidden" name="AppointmentYear" value="<fmt:formatDate pattern="yyyy" value="${AppointmentDate}"/>">
																		<input type="hidden" name="AppointmentDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${AppointmentDate}"/>">																																							
																		<b><fmt:formatDate pattern="d" value="${AppointmentDate}"/></b>
																		
																	</font>
																</td>
																<td align="right" width="33%" bgcolor="#eeeeee" >
																	<a href="#" onclick="fn_GetDayAppointmentDayView(2);" style="text-decoration:none">
																		<font color="#ff0000"><b>&gt;</b></font>
																	</a>
																
																</td>

															</tr>
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