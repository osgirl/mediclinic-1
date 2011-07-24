<%@ include file="/WEB-INF/jsp/include.jsp" %>


		
<%@page import="com.mediapp.domain.common.Person"%>
	<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
				        	<div class="stp" style="margin-bottom:1.5em;">
				<div class="or" style="margin:1em; padding:0;" >
				
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="dayAppointment" id="dayAppointment" method="post" >
									<input type="hidden" name="AppointmentID"  id="AppointmentID" value=""/>
									<input type="hidden" name="UserName"  id="UserName" value="${UserName}"/>
									<input type="hidden" name="TakeAppointment"  id="TakeAppointment" value="${TakeAppointment}"/>
									<input type="hidden" name="PersonID"  id="PersonID" value="${personID}"/>
											<table width=900  border="1" class="layout"  > 	
												<tr>
													<td>	
														<table width=200 align="left"   class="sample" style="border-width: 0px 0px 0px 0px;"> 	
										                   <tr>
										        	           	<td>
										            		       	<menu:verticalMenuItemTag></menu:verticalMenuItemTag>
										                   		</td>
										                   </tr>
														</table>
														<div id="dayAppointments"  style="display:block" align="center">
															<table  border=""  class="appointment" width=680>
															<c:if test="${TakeAppointment eq 'Y'}">
																		<font size="1" color="black" >Please click on time link below to book an appointment. Available times are shown in white. Blocked times are shown in green.</font>
															</c:if>
															
																<tr>
																	<td align="center">
																		<table border="0" cellpadding="3" class="sample1" cellspacing="0" width="100%">																	
																			<tr>
																				<td align="left" width="33%" bgcolor="#eeeeee">
																					<a href="javascript:void(0);" onclick="fn_GetMonthAppointmentDayView(1);" style="text-decoration:none" >
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
																					<a href="javascript:void(0);" onclick="fn_GetMonthAppointmentDayView(2);" style="text-decoration:none">
																					<font color="#ff0000"><b>&gt;&gt;</b></font>
																					</a>
																				</td>
																			</tr>
																			<tr>
																				<td align="left" width="33%" bgcolor="#eeeeee">
																					<a href="javascript:void(0);" onclick="fn_GetDayAppointmentDayView(1);" style="text-decoration:none">
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
																					<a href="javascript:void(0);" onclick="fn_GetDayAppointmentDayView(2);" style="text-decoration:none" >
																					<font color="#ff0000"><b>&gt;</b></font>
																					</a>
																				</td>
																			</tr>
																		</table>
																		<table border="0" cellpadding="3"  cellspacing="0" width="100%">																		
																			<c:forEach items="${appointment}" var="appointments">
																				<tr>	
																					<c:choose>
																						<c:when test='${not empty appointments.headline}'>
																							<td width="10%" bgcolor="#E0F8EC" >
																								<c:out value="${appointments.timeOfAppointment}"/>
																							</td>
																						</c:when>
																						<c:otherwise>
																							<td width="10%" bgcolor="#EFF5FB"  style="border-width: 1px 1px 1px 1px;border-style: solid solid solid solid;border-color: #cadef4 #cadef4 #cadef4 #cadef4;">																						
																								<c:choose>
																									<c:when test='${TakeAppointment eq "Y"}'>
																										<a href="javascript:void(0);" onclick="javascript:fn_createAppointment('${personID}','${appointments.doctorID}','${appointments.timeOfAppointment}','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointmentDate}"/>','${UserName}','${appointments.doctorPersonID}');" >
																											<c:out value="${appointments.timeOfAppointment}"/>
																										</a>
																									</c:when>
																									<c:otherwise>
																										<c:out value="${appointments.timeOfAppointment}"/>
																									</c:otherwise>
																								</c:choose>	
																							</td>
																						</c:otherwise>
																					</c:choose>	
																					<c:if test='${not empty appointments.headline}'>
																						<td width="85%" bgcolor="#E0F8EC" >
																							<c:if test='${appointments.headline != "OOO" && TakeAppointment ne "Y"}'>
																								<c:out value="${appointments.headline}"/>
																							</c:if>
																						</td>
																						<c:if test='${appointments.headline != "OOO" && TakeAppointment ne "Y"}'>
																							<td  style="background: url(/images/arrowbutton_0.png) no-repeat;overflow: hidden;background-position: top left;"  align="center" onmouseover="this.style.cursor='hand'" id="clickMe" onclick="fn_showOptions(event,'${LoggedOnUserID}','${appointments.patientPersonID}','${appointments.timeOfAppointment}','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointmentDate}"/>','${appointments.appointmentID}','${appointments.confirmedIndicator}');">  
																				  			</td>
																				  		</c:if>
																					</c:if>
																					<c:if test='${empty appointments.headline}'>
																						<td width="85%" bgcolor="#EFF5FB" style="border-width: 1px 1px 1px 1px;padding: 1px 1px 1px 1px;border-style: groove groove groove groove;border-color: green green green green;-moz-border-radius: 12px 12px 12px 12px;">	
																						</td>
																					</c:if>
																				</tr>

																			</c:forEach>
																		</table>																			
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
					</div></div></div>
				</div>
			</div>
	</div>
	<div style="margin-left: -100px; top: -40px; background: white; width: 200px; height: 200px; position: relative;" id="reference">
		<div id="movingDiv" class="stp1" style="top=0;left=0;position:absolute;;margin-bottom:1.5em;display:none" >
		         <table  border=""  id="menuTable" width=130 class="sample" style="border-width: 0px 0px 0px 0px;">
       				<input type="hidden" name="TimeOfAppointment"  id="TimeOfAppointment" />
   					<input type="hidden" name="AppointmentDateR"  id="AppointmentDateR" />
   					<input type="hidden" name="AppointmentID"  id="AppointmentID" />
		         
			           <tr>               
				            <td id="confirm">
								<a href="javascript:void(0);" onClick="javascript:fn_openAppointment('N');document.getElementById('movingDiv').style.display='none';" style="text-decoration:none" class="sansa"> 
									<font size="+1" color="blue" >Confirm</font> 
								</a>
				           </td>
	        		   </tr>
			           <tr>               
				            <td id="open">
								<a href="javascript:void(0);" onClick="document.getElementById('movingDiv').style.display='none';javascript:fn_openAppointment('N');" style="text-decoration:none" class="sansa"> 
									<font size="+1" color="blue" >Open</font> 
								</a>
				           </td>
	        		   </tr>

	           			<tr id="reschedule">
	           				<td>
								<a href="javascript:void(0);" onClick="document.getElementById('movingDiv').style.display='none';javascript:fn_rescheduleAppointment();" style="text-decoration:none"  class="sansa"  > 
									<font size="+1" color="blue" >Postpone</font> 
								</a>
				           </td>
	           			</tr>
	           			<tr id="propose">
	           				<td>
								<a href="javascript:void(0);" onClick="document.getElementById('movingDiv').style.display='none';" style="text-decoration:none"  class="sansa"  > 
									<font size="+1" color="blue" >Propose Time</font> 
								</a>
				           </td>
	           			</tr>	           			
			           <tr id="cancel">               
				            <td>
								<a href="javascript:void(0);" onClick="document.getElementById('movingDiv').style.display='none';" style="text-decoration:none"  class="sansa"> 
									<font size="+1" color="blue" >Cancel</font> 
								</a>
				           </td>
	        		   </tr>
			           <tr>               
				            <td id="print">
								<a href="javascript:void(0);" onClick="document.getElementById('movingDiv').style.display='none';javascript:fn_Print();" style="text-decoration:none" class="sansa"> 
									<font size="+1" color="blue" >Print</font> 
								</a>
				           </td>
	        		   </tr>
	        		   
			           <tr id="close">               
				            <td>
								<a href="javascript:void(0);" onClick="document.getElementById('movingDiv').style.display='none';" style="text-decoration:none"  class="sansa"> 
									<font size="+1" color="blue" >Close</font> 
								</a>
				           </td>
	        		   </tr>
	           			
	         		</table>
		</div>				  		
	</div>															
	
<%@ include file="/WEB-INF/jsp/footer.jsp" %>