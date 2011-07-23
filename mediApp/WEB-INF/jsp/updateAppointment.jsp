<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="com.mediapp.domain.common.Person"%>

<%@page import="com.mediapp.domain.common.NotificationDetails"%><html>
	<head>
	    <title>AppMent</title>
	    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
	    <link href="<%=request.getContextPath()%>/css/autocomplete.css" rel="stylesheet" type="text/css">
	    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />
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
		<form name="updateAppointment" id="updateAppointment" method="post" >
			<div class="stp" style="margin-bottom:1.5em;" >
				<div class="or" style="margin:1em; padding:0;" >
					<table border="0" cellpadding="3" class="sample" cellspacing="0" width=850 height=325 align="center">
					<input type="hidden" value="1" id="counter"/>
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
							<spring:bind path="appointment.doctorPersonID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorPersonID}"/>"/>
							</spring:bind>
							<input type="hidden" name="PersonID"  value="${PersonID}"/>
							<input type="hidden" name="AppointmentDate"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>"/>							
							<input type="hidden" name="AppointmentID"  value="${appointment.appointmentID}"/>
							<input type="hidden" name="UserName"  value="${UserName}"/>
							
					<%	Person p = (Person)request.getSession().getAttribute("person");
						NotificationDetails n = (NotificationDetails) request.getAttribute("Notification");
					%>
					<%  
					if(!p.getEmailID().equals(n.getPatientEmailAddress()) &&
							p.getPackages().contains("Doctor")){
							
					%>
					<c:if test="${appointment.confirmedIndicator == 'Y'}">
						
						<table  border=""  class="sample" width=850 height=40  align="center">
							<tr>
								<td></td>
								<td>Diagnosis Details</td>
								<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
						  			<a href="javascript:void(0);" onClick="javascript:fn_showDiagnosis();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Add</font> 
						  			</a>
						  		</td>
							</tr>
						
						</table>							
						<table  border=""  id="tblSample" class="sample" width=850 height= 80  align="center">
							<tbody id="aa">						
							<tr>
								<td>Diagnosis:
								</td>
								<td  >Prescription:
								</td>
								<td>Tests:
								</td>
							</tr>
							
						<c:choose>
							<c:when test="${!empty appointment.diagnosis[0].codeICD}">
							
								<c:forEach items="${appointment.diagnosis}" varStatus="diagnosisAndtest">
									<script type="text/javascript">
											var num = (document.getElementById("counter").value - 1) + 2;
											document.getElementById("counter").value = num;
									</script>
									
									<tr>
										<td  >
											<spring:bind path="appointment.diagnosis[${diagnosisAndtest.index}].codeICD">												
												
												<input type="text" name="<c:out value="${status.expression}"/>"  value="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].codeICD}"/>" />
												<script type="text/javascript">
														new Autocomplete('<c:out value="diagnosis[${diagnosisAndtest.index}].codeICD"/>', { serviceUrl:'/appointmentPopUp.htm' },'table.DIAGNOSIS');
												</script>
												
																									
											</spring:bind>
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
											<spring:bind path="appointment.diagnosis[0].codeICD">
												<input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>"/>
												<script type="text/javascript">
														new Autocomplete('<c:out value="diagnosis[0].codeICD"/>', { serviceUrl:'/appointmentPopUp.htm' },'table.DIAGNOSIS');
												</script>
																									
											</spring:bind>
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
							
							</tbody>
						</table>
							  	
					</c:if>
					<%} %>
					</table>
					
					<table border="0" cellpadding="0" cellspacing="0" width="450" height="30" align="center">						         
						<tr >     
							
							<%if(!p.getEmailID().equals(n.getPatientEmailAddress())){ %>
							
							<c:if test="${appointment.confirmedIndicator == 'N'}">
								<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
						  			<a href="javascript:void(0);" onClick="javascript:fn_confirmAppointment();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Confirm</font> 
						  			</a>
						  		</td>
					  		</c:if>
							<c:if test="${appointment.confirmedIndicator == 'Y'}">
								<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
						  			<a href="javascript:void(0);" onClick="javascript:fn_updateAppointmentDetails();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Save</font> 
						  			</a>
						  		</td>
					  		</c:if>
					  		
								<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
						  			<a href="javascript:void(0);" onClick="" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Follow Up</font> 
						  			</a>
						  		</td>
					  		
					  		<%} %>
					  		
					  		<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%" align="center">  
					  			<a href="javascript:void(0);" onClick="javascript:fn_close();" style="text-decoration:none"> 
					  				<font size="+1" color="#FFFFFF" >Close</font>
					  			</a>
					  		</td>
						</tr>
					</table> 										
					
				</div>
			</div>
			<div style="width: 518px; height: 287px;visibility:hidden" id="windowcontent">
		         <table  border=""  id="diagnosisTable" width=700 height=300 class="sample" style="border-width: 0px 0px 0px 0px;">
			           <tr>
			           		<td width="40%"> Diagnosis:
			           		</td>
			           		<td width="20%">
				           </td>
			           		               
				            <td width="40%">
									<input type="text" name="diagnosis" id="diagnosis"  disabled="disabled" />
									<script type="text/javascript">
											new Autocomplete('diagnosis', { serviceUrl:'/appointmentPopUp.htm' },'table.DIAGNOSIS');
									</script>
				           </td>
	        		   </tr>
			           <tr>               
				            <td >
				            	Add Prescription:
				           </td>
				           <td>
				           </td>
				           <td>
				           </td>
	        		   </tr>

	           			<tr >
	           				<td>
	           					<input type="text" name="findPrescription"  id="findPrescription" value="" disabled="disabled"/>
								<script type="text/javascript">
										new Autocomplete('findPrescription', { serviceUrl:'/appointmentPopUp.htm' },'table.PRESCRIPTION');
								</script>
	           				
				           </td>
				           <td>
				           		<input type="button"  onClick="javascript:fn_addToSelect('prescriptionList','findPrescription');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
								</br>
								<input type="button"  onClick="javascript:fn_deleteFromList('prescriptionList');" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
				           
				           </td>
				           <td>
								<select  name="prescriptionList" id="prescriptionList" style="width: 15em;" size="3" multiple disabled="disabled" >
				           </td>
	           			</tr>
			           <tr>               
				            <td >
				            	Add Test:
				           </td>
				           <td>
				           </td>
				           <td>
				           </td>
	        		   </tr>

	           			<tr >
	           				<td>
	           					<input type="text" name="findTest"  id="findTest" value="" disabled="disabled"/>
								<script type="text/javascript">
										new Autocomplete('findTest', { serviceUrl:'/appointmentPopUp.htm' },'table.PRESCRIPTION');
								</script>
	           				
				           </td>
				           <td>
				           		<input type="button"  onClick="javascript:fn_addToSelect('testList','findTest');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
								</br>
								<input type="button"  onClick="javascript:fn_deleteFromList('testList');" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
				           
				           </td>
				           <td>
								<select  name="testList" id="testList" style="width: 15em;" size="3" multiple disabled="disabled">
				           </td>
	           			</tr>
	         		</table>
					<table border="0" cellpadding="0" cellspacing="0" width="700" height="40" class="sample">						         
						<tr >     
							<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
					  			<a href="javascript:void(0);" onClick="javascript:fn_addDetails();" style="text-decoration:none"> 
					  				<font size="+1" color="#FFFFFF" >Add</font> 
					  			</a>
					  		</td>
							<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
					  			<a href="javascript:void(0);" onClick="javascript:fn_close();" style="text-decoration:none"> 
					  				<font size="+1" color="#FFFFFF" >Close</font> 
					  			</a>
					  		</td>
					  	</tr>
					  	
					  </table>	         		
			</div>
			
		</form>
	</body>
</html>
