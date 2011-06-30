<%@ page session="false"%>

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
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />
	    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
	    <link href="<%=request.getContextPath()%>/css/autocomplete.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    	<script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>    
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/customalert.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">
	</head>
	<body>
		<form name="rescheduleAppointment" id="rescheduleAppointment" method="post" >
			<div class="stp" style="margin-bottom:1.5em;" >
				<div class="or" style="margin:1em; padding:0;" >
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
					<table border="0" cellpadding="3" class="sample" cellspacing="0" width=680 height=300 align="center">
						<table border="0" cellpadding="3" class="sample" cellspacing="0" width=680 height=250 align="center">
							<tr bgcolor="lightblue">
								<font style="text-align: center;font-size: 120%;font-weight: bold;">Reschedule Appointment</font>
							</tr>
							<tr>
								<td >Appointment With:</td>
								<td class="sansa">
									<c:out value="${DoctorDetails.firstName} "></c:out> 
									<c:out value="${DoctorDetails.middleInitial}"></c:out>
									<c:out value="${DoctorDetails.lastName}"></c:out>
								</td>
								<td></td>
								<td></td>
							</tr>
							<input type="hidden" name="UserName"  value="${UserName}"/>
							<input type="hidden" name="AppointmentID"  id="AppointmentID" value="${AppointmentID}"/>
							<input type="hidden" name="PersonID"  id="PersonID" value="${PersonID}"/>
							<input type="hidden" name="AppointmentDate"  id="AppointmentDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${AppointmentDate}"/>">
							<tr>
								<td >Headline :</td>
								<td class="sansa">
									<spring:bind path="appointment.headline">
										<input type="text" name="${status.expression}"  value="<c:out value="${appointment.headline}"/>" disabled="disabled"/>					
									</spring:bind>
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td >Date :</td>
								<td class="sansa">
									<spring:bind path="appointment.dateOfAppointment">
										<input type="text" name="${status.expression}" id="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>" disabled="disabled" />
									</spring:bind>
								</td>
								<td></td>
								<td></td>
							</tr>
	
							<tr>
								<td >Time :</td>
								<td class="sansa">
									<spring:bind path="appointment.timeOfAppointment">
										<input type="text" name="${status.expression}"  id="${status.expression}" value="<c:out value="${appointment.timeOfAppointment}"/>" disabled="disabled" />
									</spring:bind>
								</td>
								<td>Duration :</td>
								<td class="sansa">
									<spring:bind path="appointment.appointmentDuration">
										<select id="${status.expression}" name="${status.expression}" style="WIDTH: 150px">
											<c:forEach items="${appointmentDuration}" var="data">
												<option value='${data.codeDecode}' >${data.codeDecode}</option>
											</c:forEach>
										</select>
									</spring:bind>
								</td>
							</tr>
	
							<tr>
								<td >Comments:</td>
								<td class="sansa">
									<spring:bind path="appointment.comments">
										<textarea name="${status.expression}"  value="${fn:trim(appointment.comments)}"  rows="3" cols="25" ></textarea>													
									</spring:bind>
								</td>
							</tr>
								<input type="hidden" name="PersonID"  value="<c:out value="${appointment.doctorPersonID}"/>"/>
								<input type="hidden" name="AppointmentDate"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>"/>								
						</table>
						<div id="dayAppointments"  style="display:block" align="center">
							<table  border=""  class="appointment" width=680>
								<tr>
									<td align="center">
										<table border="0" cellpadding="3" class="sample1" cellspacing="0" width="100%">																	
											<tr>
												<td align="left" width="33%" bgcolor="#eeeeee">
													<a href="javascript:void(0);" onclick="fn_GetMonthAppointment(1);" style="text-decoration:none" >
													<font color="#ff0000"><b>&lt;&lt;</b></font>
													</a>
												</td>
												<td align="center" bgcolor="#eeeeee" valign="middle" width="33%" >
													<font size="3" color="#ff0000" face="verdana,arial,helvetica">
														<input type="hidden" name="AppointmentMonth" value="<fmt:formatDate pattern="MM" value="${AppointmentDate}"/>">
														<input type="hidden" name="AppointmentYear" value="<fmt:formatDate pattern="yyyy" value="${AppointmentDate}"/>">
														<input type="hidden" name="AppointmentDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${AppointmentDate}"/>">																																							
														<b><fmt:formatDate pattern="MMMMMMMMM" value="${AppointmentDate}"/></b>
													</font>
												</td>
												<td align="right" width="33%" bgcolor="#eeeeee" >
													<a href="javascript:void(0);" onclick="fn_GetMonthAppointment(2);" style="text-decoration:none">
													<font color="#ff0000"><b>&gt;&gt;</b></font>
													</a>
												</td>
											</tr>
											<tr>
												<td align="left" width="33%" bgcolor="#eeeeee">
													<a href="javascript:void(0);" onclick="fn_GetDayAppointment(1);" style="text-decoration:none">
													<font color="#ff0000"><b>&lt;</b></font>
													</a>
												</td>
												<td align="center" bgcolor="#eeeeee" valign="middle" >
													<font size="3" color="#ff0000" face="verdana,arial,helvetica">
														<input type="hidden" name="AppointmentMonth" value="<fmt:formatDate pattern="MM" value="${AppointmentDate}"/>">
														<input type="hidden" name="AppointmentYear" value="<fmt:formatDate pattern="yyyy" value="${AppointmentDate}"/>">
														<b><fmt:formatDate pattern="d" value="${AppointmentDate}"/></b>
													</font>
												</td>
												<td align="right" width="33%" bgcolor="#eeeeee">
													<a href="javascript:void(0);" onclick="fn_GetDayAppointment(2);" style="text-decoration:none" >
													<font color="#ff0000"><b>&gt;</b></font>
													</a>
												</td>
											</tr>
										</table>
										<div style="overflow:auto;height:240px;" >										
											<table border="0" cellpadding="3"  cellspacing="0" width="100%" >
												<c:forEach items="${dayAppointment}" var="appointments">
													<tr>	
														<c:choose>
															<c:when test='${not empty appointments.headline}'>
																<td width="10%" bgcolor="#E0F8EC" >
																	<c:out value="${appointments.timeOfAppointment}"/>
																</td>
															</c:when>
															<c:otherwise>
																<td width="10%" bgcolor="#EFF5FB"  style="border-width: 1px 1px 1px 1px;border-style: solid solid solid solid;border-color: #cadef4 #cadef4 #cadef4 #cadef4;">																						
																	<a href="javascript:void(0);" onclick="javascript:fn_updateDateOfAppointment('<c:out value="${appointments.timeOfAppointment}"/>','<fmt:formatDate pattern="MM/dd/yyyy" value="${AppointmentDate}"/>')" >
																		<c:out value="${appointments.timeOfAppointment}"/>
																	</a>
																</td>
															</c:otherwise>
														</c:choose>	
														<c:if test='${not empty appointments.headline}'>
															<td width="85%" bgcolor="#E0F8EC" >
															</td>
														</c:if>
														<c:if test='${empty appointments.headline}'>
															<td width="85%" bgcolor="#EFF5FB" style="border-width: 1px 1px 1px 1px;padding: 1px 1px 1px 1px;border-style: groove groove groove groove;border-color: green green green green;-moz-border-radius: 12px 12px 12px 12px;">	
															</td>
														</c:if>
													</tr>
		
												</c:forEach>
											</table>
										</div>																			
									</td>
								</tr>
							</table>
						</div>
						
						<table border="0" cellpadding="0" cellspacing="0" width="400" height="30"  align="center">         
							<tr >     
								<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
						  			<a href="javascript:void(0);" onClick="javascript:fn_rescheduleAppointmentDate();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Postpone</font> 
						  			</a>
						  		</td>
						  		<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%" align="center">  
						  			<a href="javascript:void(0);" onClick="self.close();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Close</font>
						  			</a>
						  		</td>
							</tr>
						</table> 										
					</table>	
				</div>
			</div>

		</form>
	</body>
</html>
