<%@ page session="false"%>
<%@page import="com.mediapp.domain.common.Person"%>
<%Person p = (Person)request.getSession().getAttribute("person");%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="com.mediapp.domain.common.Person"%>
<html>
	<head>
	    <title>mediApp</title>    
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" type="image/x-icon" />
	    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>    
	</head>
	<body>
	<script type="text/javascript">
	</script>
		<form name="rescheduleAppointment" id="rescheduleAppointment" method="post" >
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
				
			<div id="createApt"  style="display:block" align="center">
				<table  border=""  class="login" width=900>
					<tr bgcolor="lightblue" align="center">
						<font style="text-align: center;font-size: 120%;font-weight: bold;">Reschedule Appointment</font>
					</tr>
					<table  border=""  class="login" width=900>
						<tr>
							<td>Headline : &nbsp;&nbsp; 
								<spring:bind path="appointment.headline">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.headline}"/>"  style="width: 700px" disabled="disabled"/>					
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td >Date : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<spring:bind path="appointment.dateOfAppointment">
									<input type="text" name="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>" disabled="disabled" />
								</spring:bind>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								Time : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<spring:bind path="appointment.timeOfAppointment">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.timeOfAppointment}"/>" disabled="disabled" style="width: 200px"/>
								</spring:bind>
								&nbsp;&nbsp;&nbsp;Duration :
								<spring:bind path="appointment.appointmentDuration">
									<select id="${status.expression}" name="${status.expression}" style="WIDTH: 150px">
										<c:forEach items="${appointmentDuration}" var="data">
											<option value='${data.codeDecode}' ${appointment.appointmentDuration==data.codeDecode ?"selected=\"selected\"":"" }>${data.codeDecode}</option>
										</c:forEach>
									</select>
								</spring:bind>
								
							</td>
						</tr>
						
						<tr>
							<td width="10%">Comments : 							
								<spring:bind path="appointment.comments">
									<textarea name="${status.expression}"    rows="2" cols="100"  align="left" disabled="disabled">
									${fn:trim(appointment.comments)}
									</textarea>													
								</spring:bind>
							</td>
						</tr>
						
					</table>
									<input type="hidden" name="AppointmentID"  id="AppointmentID" value="${AppointmentID}"/>
									<input type="hidden" name="PersonID"  id="PersonID" value="${PersonID}"/>
									<input type="hidden" name="AppointmentDate"  id="AppointmentDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${AppointmentDate}"/>">
									<c:set var="PersonType" />
									<c:set var="PersonID" />
									<%	 pageContext.setAttribute("PersonType",p.getPersonTypeString());
									pageContext.setAttribute("PersonID",p.getIdPerson());
									%>							
									<table width=900  border="1" class="layout"  >	
										<tr>
											<td>
											
										<div id="dayAppointments"  style="display:block" align="center">
											<table  border=""  class="appointment" border="0" cellpadding="2" cellspacing="1" width="880" align="center">
												<tr bgcolor="lightblue">
													<td align="left" width="33%" bgcolor="#eeeeee">
														<a href="#" onclick="fn_GetMonthAppointment(1);" style="text-decoration:none">
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
														<a href="#" onclick="fn_GetMonthAppointment(2);" style="text-decoration:none" >
															<font color="#ff0000"><b>&gt;&gt;</b></font>
														</a>
													
													</td>
													</tr>
																	<tr>
																		<td align="left" width="33%" bgcolor="#eeeeee">
																			<a href="#" onclick="fn_GetDayAppointment(1);" style="text-decoration:none" >
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
																			<a href="#" onclick="fn_GetDayAppointment(2);" style="text-decoration:none">
																				<font color="#ff0000"><b>&gt;</b></font>
																			</a>
																		
																		</td>

																	</tr>
															
												<tr>
												<c:set var="PersonType" />												
												<%	 pageContext.setAttribute("PersonType",p.getPersonTypeString());								
												%>
												<c:forEach items="${dayAppointment}" var="appointments">
													<c:if test="${'Patient' == PersonType}">													
														<tr>													
															<c:if test='${not empty appointments.headline}'>
																<td width="10%" bgcolor="#FFCCCC" bordercolor="black">
																	<c:out value="${appointments.timeOfAppointment}"/>																	
																</td>
															</c:if>
																<c:if test='${empty appointments.headline }'>
																	<td width="10%" bgcolor="#E0E0F8" bordercolor="black">
																		<a href="javascript:fn_updateDateOfAppointment('<c:out value="${appointments.timeOfAppointment}"/>','<fmt:formatDate pattern="MM/dd/yyyy" value="${AppointmentDate}"/>')" >
																			<c:out value="${appointments.timeOfAppointment}"/>
																		</a>
																	</td>
																</c:if>															
																<c:if test='${not empty appointments.headline}'>
																	<td width="90%" bgcolor="#FFCCCC" bordercolor="black">
																	</td>
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
																</td>
																<c:if test='${appointments.headline != "OOO"}'>
																	<c:if test='${appointments.confirmedIndicator == "N"}'>
																		<td align="left" width="33%" bgcolor="#3399FF">
																			<a href="#" onclick="fn_UpdateAppointment(${appointments.appointmentID});" style="text-decoration:none"  >
																				<font color="#FF9933" ><b>C</b></font>
																			</a>
																		</td>
																	</c:if>
																	<td align="left" width="33%" bgcolor="#3399FF">
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
												
										
					<spring:bind path="appointment.appointmentID">
						<input type="hidden" name="AppointmentID"  id="AppointmentID" value="<c:out value="${appointment.appointmentID}"/>"/>
					</spring:bind>
					<tr>
						<td align="center" colspan="2">
							<input type="button"  onClick="javascript:fn_rescheduleAppointmentDate();" alignment="center" value="Save" class="bsubmit"  width="75"/>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
