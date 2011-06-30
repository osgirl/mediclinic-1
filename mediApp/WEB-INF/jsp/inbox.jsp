<%@ include file="/WEB-INF/jsp/include.jsp" %>


		
<%@page import="com.mediapp.domain.common.Person"%>
	<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
				        	<div class="stp" style="margin-bottom:1.5em;">
				<div class="or" style="margin:1em; padding:0;" >
				
					<div id="contentSingleEntry" style="">
						<div id="entries">
						<script>
							var cacheonimg = new Image ();
							var cacheoffimg = new Image ();
							cacheonimg.src = '/images/refresh_1.png';
							cacheoffimg.src = '/images/refresh_0.png';

							var cacheonimgdown = new Image ();
							var cacheoffimgdown = new Image ();
							cacheonimgdown.src = '/images/up_0.png';
							cacheoffimgdown.src = '/images/down_0.png';

							var cacheonimgdown1 = new Image ();
							var cacheoffimgdown1 = new Image ();
							cacheonimgdown1.src = '/images/up_0.png';
							cacheoffimgdown1.src = '/images/down_0.png';

							var cacheonimgdownM = new Image ();
							var cacheoffimgdownM = new Image ();
							cacheonimgdownM.src = '/images/up_0.png';
							cacheoffimgdownM.src = '/images/down_0.png';

							
							var cacheonimgshow = new Image ();
							var cacheoffimgshow = new Image ();
							cacheonimgshow.src = '/images/show_0.png';
							cacheoffimgshow.src = '/images/show_0.png';
							
						</script>
						
							<div class="entryAlone">
								<form name="inbox" id="inbox" method="get" >
									<input type="hidden" name="AppointmentID"  id="AppointmentID" value=""/>
									<input type="hidden" name="UserName"  id="UserName" value="${UserName}"/>
									<input type="hidden" name="TakeAppointment"  id="TakeAppointment" value="${TakeAppointment}"/>
									<input type="hidden" name="PersonID"  id="PersonID" value="${personID}"/>
											<table width=900  border="1" class="layout"  >
												<tr>
													<td style="vertical-align: top">
														<table width=200 align="left"   class="sample" style="border-width: 0px 0px 0px 0px;"> 	
										                   <tr>
										        	           	<td>
										            		       	<menu:verticalMenuItemTag></menu:verticalMenuItemTag>
										                   		</td>
										                   </tr>
														</table>
													</td>
													<td>
														<table  border="0"   width=680 height="20">															
															<tr>
																<td align="right">
																	<a href="/inbox.htm" id="refresh" onMouseover="document.buttonimg.src=eval('cacheonimg.src')" onMouseout="document.buttonimg.src=eval('cacheoffimg.src')">
																		<img src="/images/refresh_0.png" name="buttonimg" width="100" height="15" alt="Refresh">   
																	</a>
																</td>
															</tr>
														</table>
														<table  border="0"   width=680 height="20">
															<table border="1" cellpadding="3"  bordercolor="green" cellspacing="0" width="680">
																<tr>
																	<td width="98%" bgcolor="#EFF5FB" height="20">
																		Reminder of Appointments (<c:out value="${fn:length(AppointmentNow)}"></c:out>)
																	</td>
																	<td >
																		<a href="javascript:void(0);" onclick="javascript:fn_showReminder();" >
																			<img src="/images/down_0.png" name="buttonimgdown"  alt="Refresh">   
																		</a>
															
																	</td>
																</tr>
																<tr>
																	<td>
																		<div  id="remindme" style="display:none" >
																			<c:forEach items="${AppointmentNow}" var="appointments">
																				<table width=650  border="1" class="layout"  align="left">
																					<tr class="sansa">
																						<td >
																							<b>Headline: </b> <c:out value="${appointments.headline}"/>
																						</td>
																						<td align="right">
																							<a href="javascript:void(0);" onclick="javascript:fn_openAppointmentInbox('${personID}','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointments.dateOfAppointment}"/>',''${appointments.appointmentID}','${appointments.timeOfAppointment}');" onMouseover="document.buttonimgshow.src=eval('cacheonimgshow.src')" onMouseout="document.buttonimgshow.src=eval('cacheoffimgshow.src')">
																								<img src="/images/show_0.png" name="buttonimgshow" alt="Show details">   
																							</a>
																						</td>
																					</tr>
																					<tr>
																						<td class="sansa">
																							<b>Setup by: </b> <c:out value="${appointments.patientFirstName} "/><c:out value="${appointments.patientMiddleInitial} "/><c:out value="${appointments.patientLastName} "/>
																						</td>
																						<td>
																						</td>
																					</tr>
																					<tr>
																						<td class="sansa">
																							<b>Date and Time: </b> <fmt:formatDate type="date" value="${appointments.dateOfAppointment}"/> at  <c:out value="${appointments.timeOfAppointment} "/>
																						</td>
																						<td>
																						</td>
																					</tr> 
																				</table>
																			</c:forEach>
																		</div>
																	</td>
																	<td>
																	</td>
																</tr>
															</table>
															<table border="1" cellpadding="3"  bordercolor="green" cellspacing="0" width="680">
																<tr>
																	<td width="98%" bgcolor="#EFF5FB" height="20">
																		Reminder of My Appointments (<c:out value="${fn:length(MyAppointmentNow)}"></c:out>)
																	</td>
																	<td >
																		<a href="javascript:void(0);" onclick="javascript:fn_showMyReminder();" >
																			<img src="/images/down_0.png" name="buttonimgdownM"  alt="Refresh">   
																		</a>
																	</td>
																</tr>
																<tr>
																	<td>
																		<div  id="remindMy" style="display:none" align="right">
																			<c:forEach items="${MyAppointmentNow}" var="appointments">
																				<table width=650  border="1" class="layout"  >
																					<tr class="sansa">
																						<td >
																							<b>Headline: </b> <c:out value="${appointments.headline}"/>
																						</td>
																						<td align="right">
																							<a href="javascript:void(0);" onclick="javascript:fn_openAppointmentInbox('${personID}','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointments.dateOfAppointment}"/>','${appointments.appointmentID}','${appointments.timeOfAppointment}');" onMouseover="document.buttonimgshow.src=eval('cacheonimgshow.src')" onMouseout="document.buttonimgshow.src=eval('cacheoffimgshow.src')">
																								<img src="/images/show_0.png" name="buttonimgshow" alt="Show details">   
																							</a>
																						</td>
																					</tr>
																					<tr>
																						<td class="sansa">
																							<b>Setup by: </b> <c:out value="${appointments.patientFirstName} "/><c:out value="${appointments.patientMiddleInitial} "/><c:out value="${appointments.patientLastName} "/>
																						</td>
																						<td>
																						</td>
																					</tr>
																					<tr>
																						<td class="sansa">
																							<b>Date and Time: </b> <fmt:formatDate type="date" value="${appointments.dateOfAppointment}"/> at  <c:out value="${appointments.timeOfAppointment} "/>
																						</td>
																						<td>
																						</td>
																					</tr> 
																				</table>
																			</c:forEach>
																		</div>
																	</td>
																	<td>
																	</td>
														
																</tr>
															</table>
															<table border="1" cellpadding="3" bordercolor="green" cellspacing="0" width="680" >
																<tr>
																	<td width="98%" bgcolor="#EFF5FB" height="20">
																		Waiting Confirmation (<c:out value="${fn:length(NeedConfirmation)}"></c:out>)
																	</td>
																	<td >
																		<a href="javascript:void(0);" onclick="javascript:fn_confirmIt();" >
																			<img src="/images/down_0.png" name="buttonimgdown1"  alt="Refresh">   
																		</a>
														
																	</td>
																</tr>
																<tr>
																	<td>
																		<div  id="confirmit" style="display:none" align="center">
																			<c:forEach items="${NeedConfirmation}" var="appointments">
																				<table width=650  border="1" class="layout"  >
																					<tr class="sansa">
																						<td >
																							<b>Headline: </b> <c:out value="${appointments.headline}"/>
																						</td>
																						<td align="right">
																							<a href="javascript:void(0);" onclick="javascript:fn_openAppointmentInbox('${personID}','<fmt:formatDate pattern="MM/dd/yyyy" value="${appointments.dateOfAppointment}"/>','${appointments.appointmentID}','${appointments.timeOfAppointment}');" onMouseover="document.buttonimgshow.src=eval('cacheonimgshow.src')" onMouseout="document.buttonimgshow.src=eval('cacheoffimgshow.src')">
																								<img src="/images/show_0.png" name="buttonimgshow" alt="Show details">   
																							</a>
																						</td>
																					</tr>
																					<tr>
																						<td class="sansa">
																							<b>Setup by: </b> <c:out value="${appointments.patientFirstName} "/><c:out value="${appointments.patientMiddleInitial} "/><c:out value="${appointments.patientLastName} "/>
																						</td>
																						<td>
																						</td>
																					</tr>
																					<tr>
																						<td class="sansa">
																							<b>Date and Time: </b> <fmt:formatDate type="date" value="${appointments.dateOfAppointment}"/> at  <c:out value="${appointments.timeOfAppointment} "/>
																						</td>
																						<td>
																						</td>
																					</tr> 
																				</table>
																			</c:forEach>
																		</div>
																	</td>
																	<td>
																	</td>
																</tr>
															</table>
														
														</table>															

															
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
	
<%@ include file="/WEB-INF/jsp/footer.jsp" %>