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
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">
	</head>
	<body>
		<form name="createAppointment" id="createAppointment" method="post" >
			<div id="createApt"  style="display:block" align="center">
				<table  border=""  class="login" width=900>
					<tr bgcolor="lightblue">
						New Appointment
					</tr>
					<table  border=""  class="login" width=900>
						<tr>
							<td>Headline :
								<spring:bind path="appointment.headline">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.headline}"/>"  disabled="disabled" />					
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td >Date :
								<spring:bind path="appointment.dateOfAppointment">
									<input type="text" name="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>" disabled="disabled" />
								</spring:bind>
								Time :
								<spring:bind path="appointment.timeOfAppointment">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.timeOfAppointment}"/>" disabled="disabled" />
								</spring:bind>
							</td>
							
						</tr>
						<tr>
							<td width="10%">Comments:							
								<spring:bind path="appointment.comments">
									<textarea name="${status.expression}"  value="${fn:trim(appointment.comments)}"  rows="2" cols="30" disabled="disabled">
									</textarea>													
								</spring:bind>
							</td>
						</tr>
							<spring:bind path="appointment.doctorID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorID}"/>"/>					
							</spring:bind>
							<spring:bind path="appointment.doctorPersonID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorPersonID}"/>"/>					
							</spring:bind>
					</table>
					<table  border=""  class="login" width=900>
						<tr>
							<td  width="33%">Diagnosis:
							</td>
							<td  width="33%">Find Prescription:
							</td>
							<td  width="33%">Prescription:
							</td>
						</tr>
						<tr>
							<td  width="33%">
								<spring:bind path="appointment.diagnosis">
									<input type="text" name="${status.expression}"  value="${appointment.diagnosis}"/>
																						
								</spring:bind>
							</td>
							<td  width="33%">
									<input type="text" name="findPrescription"  value=""/>
									<input type="button"  onClick="javascript:fn_addPrescription();" alignment="center" value=">>" class="bsubmit"  width="75"/>
							</td>
															
							<td  width="33%">
								<spring:bind path="appointment.prescription">
								<SELECT NAME="${status.expression}" MULTIPLE SIZE=3 >
									<OPTION VALUE="${status.expression}" >IbuProfen								
								</SELECT>
									
																						
								</spring:bind>
							</td>
	
						</tr>

					</table>						
					<tr>
						<td align="center" colspan="2">															
						<input type="button"  onClick="javascript:fn_updateAppointmentDetails();" alignment="center" value="Update" class="bsubmit"  width="75"/>
						</td>
					</tr>
	
				</table>
			</div>
		</form>
	</body>
</html>
