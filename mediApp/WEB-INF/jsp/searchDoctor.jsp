<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="searchDoctor" id="searchDoctor" method="post" >
									<table width=700  border="1" class="layout"  >	
										<tr>
											<td>	
												<table width=100 align="left"  border="1" class="layout" >	
													<tr>
														<td>
															<input type="button"  alignment="center" value="Past History" class="gsubmit"  />
														</td>
													</tr>
													<tr>
														<td>															
															<input type="button"  onClick="javascript:fn_nextURL('/takeAppointment.htm');" alignment="center" value="My Appointments" class="gsubmit"  />
														</td>
													</tr>
													<tr>
														<td>
															<input type="button"  alignment="center" value="Upload Documents" class="gsubmit"  />																																												
														</td>
													</tr>
													
														
														
												</table>

												<div id="Search"  style="display:block" align="center">
													<table  border=""  class="login" width=450>
														<tr bgcolor="lightblue">
															Search Doctor
														<tr>
															<td >Doctor Name:</td>
															<td>	<input type="text" name="doctorname"  />	
															</td>
														</tr>
														<tr>
															<td>Speciality:</td>
																<td>		
																<input type="hidden" id="hSpeciality" name="hSpeciality"></input>
																<select id="Speciality" name="Speciality" style="WIDTH: 180px">
																	<c:forEach items="${speciality}" var="data">
																		<option value='${data.codeDecode}' >${data.codeDecode}</option>
																	</c:forEach>
																</select>
															</td>
														</tr>
						

													<tr>
														<td width="40%">Date: </td>
														<td width="40%">
															<input type="hidden" id="hDateOfAppointment" name="hDateOfAppointment"></input>
															<input type="text" name="dateOfAppointment"   />		
														</td>
														<td width="20%">
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'searchDoctor',
																			// input name
																			'controlname': 'dateOfAppointment'
																			});
																	</script>
																
														</td>
													</tr>
													<tr>
														<td >Locality: </td>
														<td >
															<input type="hidden" id="hLocality" name="hLocality"></input>
															<input type="text" name="locality" id="locality" />		
															<script type="text/javascript">
																new Autocomplete('locality', { serviceUrl:'/appointmentPopUp.htm' });
															</script>
	
														</td>
													</tr>
													<tr>
														<td align="center" colspan="2">
															<input type="hidden" id="hSearch" name="hSearch"></input>
															<input type="button"  onClick="javascript:fn_searchDoctor();" alignment="center" value="Search" class="bsubmit"  width="75"/>
														</td>
													</tr>
														
													</table>
												</div>
												
									</tr>	
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