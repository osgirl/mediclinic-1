<%@ include file="/jsp/include.jsp" %>


		
<%@page import="com.mediapp.domain.common.Person"%>
	<div id="contentBodyLeft">
			<div id="contentBodyRight">
				<div id="contentBodyCenter">
				        	<div class="stp" style="margin-bottom:1.5em;">
				<div class="or" style="margin:1em; padding:0;" >
				
					<div id="contentSingleEntry" style="">
						<div id="entries">
							<div class="entryAlone">
								<form name="inbox" id="inbox" method="get" >
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
																<td >
																	<spring:bind path="reportPackage.reportName">				
																		<select id="${status.expression}" name="${status.expression}" style="WIDTH: 300px" onchange="javascript:loadFrame();">
																			<option >-Select-</option>
																			<c:forEach items="${Reports}" var="data">
																				<option value='${data}' >${data}</option>
																			</c:forEach>
																		</select>
																	 </spring:bind>  
																
																</td>
															</tr>
														</table>
														<div id="SearchFrame">
														</div>
														<input type="hidden" name="PatientID" id="PatientID" value="<%=p.getIdPerson()%>"/>
															<iframe id="ReportTab" width="680" height="500">
															</iframe>
															<script>
																var myMap = [];
																//var emptyMap = {};
															</script>
															<%@page import="java.util.Map"%>
															<%@page import="java.util.HashMap"%>
															<%@page import="java.util.Iterator"%>
													           <% 
													           Map < String , String > pack = (HashMap < String , String >)request.getAttribute("ReportMap");
													           Iterator it = pack.entrySet().iterator();
														        while (it.hasNext()) {
														        	Map.Entry pairs = (Map.Entry)it.next();
													           %>
													           <script>
													          // emptyMap['<%=pairs.getKey()%>'] = 'a';
														       myMap['<%=pairs.getKey()%>'] = '<%=pairs.getValue()%>';
													           //alert(myMap['<%=pairs.getKey()%>']);
													           </script>
													           <%
													           }
													           %>
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
	
<%@ include file="/jsp/footer.jsp" %>