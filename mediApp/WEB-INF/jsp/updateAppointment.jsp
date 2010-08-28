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
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">
	</head>
	<body>
	<script type="text/javascript">
	</script>
		<form name="updateAppointment" id="updateAppointment" method="post" >
			<div class="stp" style="margin-bottom:1.5em;">
				<div class="or" style="margin:1em; padding:0;" >
								
		
					<%Person p = (Person)request.getSession().getAttribute("person");
							pageContext.setAttribute("PersonID",p.getIdPerson()); 
							pageContext.setAttribute("PersonType",p.getPersonTypeString());%>
		
			<div id="createApt"  style="display:block" align="center">
				<table  border=""  class="login" width=1246>
					<tr bgcolor="lightblue" align="center">
						<font style="text-align: center;font-size: 120%;font-weight: bold;">Update Appointment</font>
					</tr>
					<table  border=""  class="login" width=1246>
						<tr>
							<td>Headline : &nbsp;&nbsp; 
								<spring:bind path="appointment.headline">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.headline}"/>"  disabled="disabled" style="width: 700px" />					
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td >Date : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<spring:bind path="appointment.dateOfAppointment">
									<input type="text" name="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>" disabled="disabled" style="width: 200px"/>
								</spring:bind>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								Time : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<spring:bind path="appointment.timeOfAppointment">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.timeOfAppointment}"/>" disabled="disabled" style="width: 200px"/>
								</spring:bind>
							</td>
							
						</tr>
						
						<tr>
							<td width="10%">Comments : 							
								<spring:bind path="appointment.comments">
									<textarea name="${status.expression}"    rows="2" cols="100" disabled="disabled" align="left">
									${fn:trim(appointment.comments)}
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
							
							<input type="hidden" name="PersonID"  value="<c:out value="${PersonID}"/>"/>
							<input type="hidden" name="AppointmentDate"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>"/>
							
							
						
					</table>					
					<spring:bind path="appointment.appointmentID">
						<input type="hidden" name="AppointmentID"  id="AppointmentID" value="<c:out value="${appointment.appointmentID}"/>"/>
					</spring:bind>
					<c:if test="${PersonType == 'Doctor'}">										
					<table  border=""  class="login" width=1200 id="tblSample">
						<tbody id="aa">						
						<tr>
							<td>
							</td>						
							<td>Diagnosis:
							</td>
							<td>Find Prescription:
							</td>
							<td>
							</td>
							<td  >Prescription:
							</td>
							<td>Find Test:
							</td>
							<td>
							</td>
							<td>Tests:
							</td>
							
						</tr>
						<input type="hidden" value="1" id="counter"/>
						
						<c:choose>
							<c:when test="${!empty appointment.diagnosis[0].codeICD}">
							
								<c:forEach items="${appointment.diagnosis}" varStatus="diagnosisAndtest">
									<script type="text/javascript">
											var num = (document.getElementById("counter").value - 1) + 2;
											document.getElementById("counter").value = num;
									</script>
									
									<tr>
										<td  >
												<input type="checkbox" name="radioBtn"  id="${diagnosisAndtest.index}" />
										</td>
									
										<td  >
											<spring:bind path="appointment.diagnosis[${diagnosisAndtest.index}].codeICD">												
												
												<input type="text" name="<c:out value="${status.expression}"/>"  value="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].codeICD}"/>" />
												<script type="text/javascript">
														new Autocomplete('<c:out value="diagnosis[${diagnosisAndtest.index}].codeICD"/>', { serviceUrl:'/appointmentPopUp.htm' },'table.DIAGNOSIS');
												</script>
												
																									
											</spring:bind>
										</td>
										<td >
												<input type="text" name="findPrescription[${diagnosisAndtest.index}]"  id="findPrescription[0]" value=""/>
												<script type="text/javascript">
														new Autocomplete('<c:out value="findPrescription[${diagnosisAndtest.index}]"/>', { serviceUrl:'/appointmentPopUp.htm' },'table.PRESCRIPTION');
												</script>
												
										</td>
										<td >
											
											<input type="button"  onClick="javascript:fn_addToSelect('diagnosis[${diagnosisAndtest.index}].prescriptionList','findPrescription[${diagnosisAndtest.index}]');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
											</br>
											<input type="button"  onClick="javascript:fn_deletePrescription(${diagnosisAndtest.index});" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
										</td>																		
										<td >
											
											<spring:bind  path="appointment.diagnosis[${diagnosisAndtest.index}].prescriptionList">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 15em;" size="3" multiple >
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList[legg.index]}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList[legg.index]}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
										<td >
												<input type="text" name="findTest[${diagnosisAndtest.index}]"  value=""/>
										</td>
										<script type="text/javascript">
												new Autocomplete('<c:out value="findTest[${diagnosisAndtest.index}]"/>', { serviceUrl:'/appointmentPopUp.htm' },'table.TEST');
										</script>
										
										<td >
											<input type="button"  onClick="javascript:fn_addToSelect('diagnosis[${diagnosisAndtest.index}].testList','findTest[${diagnosisAndtest.index}]');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
											</br>
											<input type="button"  onClick="javascript:fn_deleteTest(${diagnosisAndtest.index});" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
											
										</td>
																		
										<td >
											<spring:bind path="appointment.diagnosis[${diagnosisAndtest.index}].testList">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 15em;" size="3" multiple >
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].testList}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].testList[legg.index]}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].testList[legg.index]}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
										
									</tr>								
								</c:forEach>
							</c:when>
							<c:otherwise>
									<tr>
										<td  >
												<input type="checkbox" name="radioBtn" />
										</td>
									
										<td  >
											<spring:bind path="appointment.diagnosis[0].codeICD">
												<input type="text" name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>"/>
												<script type="text/javascript">
														new Autocomplete('<c:out value="diagnosis[0].codeICD"/>', { serviceUrl:'/appointmentPopUp.htm' },'table.DIAGNOSIS');
												</script>
																									
											</spring:bind>
										</td>
										<td >
												<input type="text" name="findPrescription[0]"  value=""/>
												<script type="text/javascript">
														new Autocomplete('findPrescription[0]', { serviceUrl:'/appointmentPopUp.htm' },'table.PRESCRIPTION');
												</script>
												
										</td>
										<td >
											
											<input type="button"  onClick="javascript:fn_addToSelect('diagnosis[0].prescriptionList','findPrescription[0]');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
											</br> 
											<input type="button"  onClick="javascript:fn_deletePrescription(0);" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
										</td>
																		
																		
										<td >
											<spring:bind path="appointment.diagnosis[0].prescriptionList">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="WIDTH: 280px" size="3" multiple >													
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescription}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
										<td >
												<input type="text" name="findTest[0]"  value=""/>
										</td>
										<script type="text/javascript">
												new Autocomplete('findTest[0]', { serviceUrl:'/appointmentPopUp.htm' },'table.TEST');
										</script>
										
										<td >
											<input type="button"  onClick="javascript:fn_addToSelect('diagnosis[0].testList','findTest[0]');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
											</br>
											<input type="button"  onClick="javascript:fn_deleteTest(0);" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
										</td>
																		
										<td >
											<spring:bind path="appointment.diagnosis[0].testList">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="WIDTH: 280px" size="3" multiple onclick="javascript:fn_moveDiv(event);" >
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].testList}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].testList}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].diagnosisTest}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
									</tr>								
							
							</c:otherwise>
						</c:choose>
						<div id="TestResult" style="display:none" >
							<tr>
								<td> 
								</td>
							</tr>
						</div>
						  </tbody>
					</table>
</c:if>											
					<tr>
						<td align="center" colspan="2">
						<c:if test="${PersonType == 'Doctor'}">
							<input type="button" onclick="addRowToTable();"  value="Add Row"  alignment="center"  class="bsubmit" id="beforeThis"/>
							<input type="button" onclick="removeRowFromTable();"  value="Remove Row"  alignment="center"  class="bsubmit" id="remove"/>
							<input type="button"  onClick="javascript:fn_updateAppointmentDetails();" alignment="center" value="Save" class="bsubmit"  width="75"/>
							
						</c:if>
						<input type="button"  onClick="javascript:fn_Print();" alignment="center" value="Print" class="bsubmit"  width="75"/>
						<input type="button"  onClick="self.close();" alignment="center" value="Close" class="bsubmit"  width="75"/>
						
						</td>
					</tr>
				</table>
			</div>
			</div>
			</div>
		</form>
	</body>
</html>
