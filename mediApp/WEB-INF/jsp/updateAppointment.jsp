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
	    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
	    <link href="<%=request.getContextPath()%>/css/autocomplete.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>    
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/customalert.js"></script>		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">
	</head>
	<body>
		<form name="updateAppointment" id="updateAppointment" method="post" >
			<div class="stp" style="margin-bottom:1.5em;" >
				<div class="or" style="margin:1em; padding:0;" >
					<table border="0" cellpadding="3" class="sample" cellspacing="0" width=450 height=300 align="center">
						<tr bgcolor="lightblue">
							<font style="text-align: center;font-size: 120%;font-weight: bold;">Appointment Details</font>
						</tr>
						<tr>
							<td >Appointment With:</td>
							<td class="sansa">
								<c:out value="${Notification.patientName}"></c:out> 
							</td>
							<td></td>
							<td></td>
						</tr>
						
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
									<input type="text" name="${status.expression}"  id="${status.expression}" value="<c:out value="${appointment.appointmentDuration}"/>" disabled="disabled" width="10"/>
								</spring:bind>
							</td>
						</tr>

						<tr>
							<td >Comments:</td>
							<td class="sansa">
								<spring:bind path="appointment.comments">
									<textarea name="${status.expression}"  value="${fn:trim(appointment.comments)}"  rows="6" cols="25" ></textarea>													
								</spring:bind>
							</td>
						</tr>
							<spring:bind path="appointment.doctorID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorID}"/>"/>					
							</spring:bind>
							<spring:bind path="appointment.appointmentEndTime">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.appointmentEndTime}"/>"/>					
							</spring:bind>
							<spring:bind path="appointment.doctorPersonID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorPersonID}"/>"/>
							</spring:bind>
							<input type="hidden" name="PersonID"  value="${PersonID}"/>
							<input type="hidden" name="AppointmentDate"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>"/>							
							<input type="hidden" name="AppointmentID"  value="${appointment.appointmentID}"/>
							<input type="hidden" name="UserName"  value="${UserName}"/>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="400" height="30" >						         
						<tr >     
							<c:if test="${appointment.confirmedIndicator == 'N'}">
								<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;height:100%;width:33%"  align="center">  
						  			<a href="#" onClick="javascript:fn_confirmAppointment();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Confirm</font> 
						  			</a>
						  		</td>
					  		</c:if>
					  		<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;height:100%;width:33%" align="center">  
					  			<a href="#" onClick="self.close();" style="text-decoration:none"> 
					  				<font size="+1" color="#FFFFFF" >Close</font>
					  			</a>
					  		</td>
						</tr>
					</table> 										
					
				</div>
			</div>

		</form>
	</body>
</html>
