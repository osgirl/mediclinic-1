<%@ include file="/WEB-INF/jsp/include.jsp" %>

<script>
function ajaxCall(){
	new Ajax.Request('/appointmentPopUp.htm',
			{
			 method:'get',
			 onSuccess: function(transport){
			   var response = transport.responseText || "no response text";
			   alert("Success! \n\n" + response);
			   alert(document.getElementById('test1').InnerHTML);
			   document.getElementById('test1').InnerHTML="hey";
			   alert();
			   },
			 onFailure: function(){ alert('Something went wrong...') }
			});

}

</script>		
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="personalProfile" id="personalProfile" method="post" >
									<table width=700  border="1" class="layout"  >	
										<tr>
											<td>	
												<table width=100 align="left"  border="1" class="layout" >	
													<tr>
														<td>
															<input type="button" onClick="javascript:fn_nextURL('/personalProfile.htm');" alignment="center" value="Personal Details" class="gsubmit"    />
														</td>
													</tr>
													<tr>
														<td>
															<input type="button"  alignment="center" value="Past History" class="gsubmit"  />
														</td>
													</tr>
													<tr>
														<td>															
															<input type="button"  alignment="center" value="Take Appointment" class="gsubmit"  />
														</td>
													</tr>
													<tr>
														<td>
															<input type="button"  alignment="center" value="Reschedule" class="gsubmit"  />																																												
														</td>
													</tr>
													<tr></tr>
														<tr>
															<td align="center" bgcolor="lightblue">Search</td>
														</tr>
														<tr>
															<td>Doctor Name: </td>
														</tr>
														<tr>
															<td >
																<input type="text"  name="firstName"    value=""  />
															</td>
														</tr>
														<tr>
															<td>Speciality:</td>
														</tr>
														<tr>
															<td >
															<select >
																<option>-Select-</option>
															</select>

															</td>
														</tr>

													<tr>
														<td >Date: </td>
													</tr>
													<tr>
														<td >																
																<input type="text" name="aDate"  />
																	<script language="JavaScript">
																		new tcal ({
																			// form name
																			'formname': 'personalProfile',
																			// input name
																			'controlname': 'aDate'
																			});
																	</script>
																
														</td>
													</tr>
													<tr>
														<td >Locality: </td>
													</tr>
													<tr>
														<td >
															<input type="text"  name="firstName"    value=""  />														
														</td>
													</tr>
													<tr>
														<td align="center" colspan="2">
															<input type="submit"  alignment="center" value="Search" class="bsubmit"  width="75"/>
														</td>
													</tr>
														
														
												</table>

												<div id="Personal Details"  style="display:block" align="center">
												<table  border=""  class="login" width=450>
													<tr>hi</tr>
													<tr>
															<td width="10" bgcolor="lightblue">9:00 AM </td>
															<td width="300" bgcolor="lightblue" ><a onclick="javascript:ajaxCall();">hi</a><span id="test1">hi</span></td>
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
					</div>
				</div>
			</div>
		</div>
		
<%@ include file="/WEB-INF/jsp/footer.jsp" %>