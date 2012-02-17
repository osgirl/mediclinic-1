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
	    <input type="hidden" name="context" id="context" value="<%=request.getContextPath()%>"/>
	    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
	    <link href="<%=request.getContextPath()%>/css/autocomplete.css" rel="stylesheet" type="text/css">
	    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />
	    <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    	<script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>    
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">
	</head>
	<body>
		<form name="updateAppointment" id="updateAppointment" method="post" >
			<input type="hidden" name="context" id="context" value="<%=request.getContextPath()%>"/>
			<c:if test="${not empty SuccessMessage}">			
				<font color="green"><c:out value="${SuccessMessage}" /></font><br/>
					<table border="0" cellpadding="0" cellspacing="0" width="700" height="40" class="sample">						         
						<tr >     
					  		<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%" align="center">  
					  			<a href="javascript:void(0);" onClick="javascript:fn_close();" style="text-decoration:none"> 
					  				<font size="+1" color="#FFFFFF" >Close</font>
					  			</a>
					  		</td>
					  	</tr>
					  	
					  </table>	         		
				
			</c:if>
		<c:if test="${empty SuccessMessage}">
			<div class="stp" style="margin-bottom:1.5em;" >
				<div class="or" style="margin:1em; padding:0;" >
					<font style="text-align: center;font-size: 120%;font-weight: bold;">Appointment Details</font>
					<table border="0" cellpadding="0" class="sample" cellspacing="0" width=850  align="center" >
					<input type="hidden" value="1" id="counter"/>
						<tr >
							<td width="15%">With:</td>
							<td width="35%" class="sansa">
								<c:out value="${Notification.patientName}"></c:out> 
							</td>
							<td width="15%">Purpose :</td>
							<td width="35%" class="sansa">
									<c:out value="${appointment.headline}"/>					
							</td>							
						</tr>
						<tr>
						</tr>
						<tr>
							<td width="15%" >At:</td>
							<td width="35%" class="sansa">
								<fmt:formatDate pattern="dd MMM yyyy" value="${appointment.dateOfAppointment}"/> at
								<fmt:formatDate pattern="hh:mm a" value="${appointment.timeOfAppointment}"/>
							</td>
							<td width="15%">Duration :</td>
							<td width="35%" class="sansa">
									<fmt:formatDate pattern="KK:mm " value="${appointment.appointmentDuration}"/>									
							</td>
						</tr>
						<tr>
							<td width="15%">Comments:</td>
							<td width="35%" class="sansa">
								<c:out value="${fn:trim(appointment.comments)}"/>
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
					if((null != n && !p.getEmailID().equals(n.getPatientEmailAddress())) &&
							p.getPackages().contains("Doctor")){
							
					%>
					<c:if test="${appointment.confirmedIndicator == 'Y'}">
						
						<table  border=""  class="sample" width=850   align="center">
							<tr>
								<td></td>
								<td align="center" width="80%">Diagnosis Details</td>
							</tr>
							<tr>
								<td >Previous History:</td>
								<td class="sansa">
									<spring:bind path="appointment.previousHistory">
										<textarea name="${status.expression}"  rows="3" cols="50" >${fn:trim(appointment.previousHistory)}</textarea>													
									</spring:bind>
								</td>
							</tr>
							<tr>								
								<td >Complain:</td>
								<td class="sansa">
									<spring:bind path="appointment.presentingComplain">
										<textarea name="${status.expression}"  rows="3" cols="50" >${fn:trim(appointment.presentingComplain)}</textarea>													
									</spring:bind>
								</td>
							</tr>
								<td >BP:&nbsp;&nbsp;&nbsp;&nbsp;
									<spring:bind path="appointment.bP">
										<input type="text" name="${status.expression}"  id="${status.expression}" value="<c:out value="${appointment.bP}"/>"  size="7"/>													
									</spring:bind>
								</td>
								<td >
									Pulse:&nbsp;&nbsp;&nbsp;&nbsp;
									<spring:bind path="appointment.pulse">
										<input type="text" name="${status.expression}"  id="${status.expression}" value="<c:out value="${appointment.pulse}"/>"  size="2"/>													
									</spring:bind> 		
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									Temperature :&nbsp;&nbsp;&nbsp;&nbsp;
									<spring:bind path="appointment.temperature">
										<input type="text" name="${status.expression}"  id="${status.expression}" value="<c:out value="${appointment.temperature}"/>"  size="2"/>													
									</spring:bind> 		
									
								</td>
							</tr>
						
						</table>							
						<table  border=""  id="tblSample" class="sample" width=850   align="center">
							<tbody id="aa">		
							<tr height="40">
								<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat ;background-position: top center;"  align="center">  
						  			<a href="javascript:void(0);" onClick="javascript:fn_showDiagnosis();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Add</font> 
						  			</a>
						  		</td>
								<td></td>
								<td></td>
							</tr>				
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
									
									<tr >
										<td  >
											<spring:bind path="appointment.diagnosis[${diagnosisAndtest.index}].codeICD">												
												
												<input type="text"  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" value="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].codeICD}"/>" disabled="disabled" style="background:#cadef4;border:1px solid #93b4d9"/>
																									
											</spring:bind>
										</td>
										<td >
											
											<spring:bind  path="appointment.diagnosis[${diagnosisAndtest.index}].prescriptionList">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 15em;background:#cadef4;border:1px solid #93b4d9" size="3" multiple disabled="disabled" >
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList[legg.index]}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList[legg.index]}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
										<td >
											<spring:bind path="appointment.diagnosis[${diagnosisAndtest.index}].testList">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 15em;background:#cadef4;border:1px solid #93b4d9" size="3" multiple disabled="disabled" >
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
												<input type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" disabled="disabled" style="background:#cadef4;border:1px solid #93b4d9"/>
												<script type="text/javascript">
														new Autocomplete('<c:out value="diagnosis[0].codeICD"/>', { serviceUrl:'/appointmentPopUp.htm' },'table.DIAGNOSIS');
												</script>
																									
											</spring:bind>
										</td>
										<td >
											<spring:bind path="appointment.diagnosis[0].prescriptionList">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="WIDTH: 280px;background:#cadef4;border:1px solid #93b4d9" size="3" multiple disabled="disabled" >													
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescriptionList}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescription}" /></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
										<td >
											<spring:bind path="appointment.diagnosis[0].testList">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="WIDTH: 280px;background:#cadef4;border:1px solid #93b4d9" size="3" multiple onclick="javascript:fn_moveDiv(event);" disabled="disabled" >
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
							
							<%if(null != n && !p.getEmailID().equals(n.getPatientEmailAddress())){ %>
							
							<c:if test="${appointment.confirmedIndicator == 'N'}">
								<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
						  			<a href="javascript:void(0);" onClick="javascript:fn_confirmAppointment();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Confirm</font> 
						  			</a>
						  		</td>
					  		</c:if>
							<c:if test="${appointment.confirmedIndicator == 'Y'}">
								<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
						  			<a href="javascript:void(0);" onClick="javascript:fn_updateAppointmentDetails();" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Save</font> 
						  			</a>
						  		</td>
					  		</c:if>
					  		
								<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
						  			<a href="javascript:void(0);" onClick="" style="text-decoration:none"> 
						  				<font size="+1" color="#FFFFFF" >Follow Up</font> 
						  			</a>
						  		</td>
					  		
					  		<%} %>
					  		
					  		<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%" align="center">  
					  			<a href="javascript:void(0);" onClick="javascript:fn_close();" style="text-decoration:none"> 
					  				<font size="+1" color="#FFFFFF" >Close</font>
					  			</a>
					  		</td>
						</tr>
					</table> 										
					
				</div>
			</div>
			<div style="width: 518px; height: 287px;visibility:hidden" id="windowcontent">
			<table style="width:700px" class="floatingHeader">
			    <tr>
			       	<td ondblclick="void(0);" onmouseover="over=true;" onmouseout="over=false;" style="cursor:move;height:18px">
			       		Add Diagnosis 
			       	</td>
			       	<td style="width:18px" align="right">
			       		<a href="javascript:hiddenFloatingDiv('windowcontent');void(0);">
			       			<img alt="Close..." title="Close..." src="<%=request.getContextPath()%>/images/close.jpg" border="0">
			       		</a>
			       	</td>
			     </tr>
			</table>
		         <table  border=""  id="diagnosisTable" width=700 height=300 class="sample" style="border-width: 0px 0px 0px 0px;">
			           <tr>
			           		<td width="40%"> Diagnosis:
			           		</td>
			           		<td width="20%">
				           </td>
			           		               
				            <td width="40%">
									<input  type="text" name="finddiagnosis" id="finddiagnosis"   />
									<script type="text/javascript">											
											new Autocomplete('finddiagnosis', { serviceUrl:'/appointmentPopUp.htm' },'table.DIAGNOSIS');
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
	           					<input type="text" name="findPrescription"  id="findPrescription" value="" />
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
								<select  name="prescriptionList" id="prescriptionList" style="width: 15em;" size="3" multiple  >
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
	           					<input type="text" name="findTest"  id="findTest" value="" />
								<script type="text/javascript">
										new Autocomplete('findTest', { serviceUrl:'/appointmentPopUp.htm' },'table.TEST');
								</script>
	           				
				           </td>
				           <td>
				           		<input type="button"  onClick="javascript:fn_addToSelect('testList','findTest');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
								</br>
								<input type="button"  onClick="javascript:fn_deleteFromList('testList');" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
				           
				           </td>
				           <td>
								<select  name="testList" id="testList" style="width: 15em;" size="3" multiple >
				           </td>
	           			</tr>
	         		</table>
					<table border="0" cellpadding="0" cellspacing="0" width="700" height="40" class="sample">						         
						<tr >     
							<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
					  			<a href="javascript:void(0);" onClick="javascript:fn_addDetails();" style="text-decoration:none"> 
					  				<font size="+1" color="#FFFFFF" >Add</font> 
					  			</a>
					  		</td>
							<td  style="background: url(<%=request.getContextPath()%>/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%"  align="center">  
					  			<a href="javascript:void(0);" onClick="javascript:hiddenFloatingDiv('windowcontent');void(0);" style="text-decoration:none"> 
					  				<font size="+1" color="#FFFFFF" >Close</font> 
					  			</a>
					  		</td>
					  	</tr>
					  	
					  </table>	         		
			</div>
			</c:if>
		</form>
	</body>
</html>
