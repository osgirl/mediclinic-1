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
								<form name="admin" id="admin" method="get" >
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
												<table  border=""  class="sample" width=720 cellpadding="200">
												<tr>
													<td> Select AppMate:
													</td>
													<td>
														<spring:bind  path="admin.personID">
															<select id="<c:out value="${status.expression}"/>" name="<c:out value="${status.expression}"/>"  style="WIDTH: 150px">
																<c:forEach items="${personIDS}" var="data">
																	<option value='${data}' >${data}</option>
																</c:forEach>
															</select>
														</spring:bind>
													</td>
												</tr>
												<tr>
													<td> Select Pacakages:
													</td>
													<td>
										                <spring:bind  path="admin.packages">
										                 	<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 25em;" size="3" multiple >
										                 		<c:forEach items="${allPackages}" varStatus="legg">
										                   			<option value ="<c:out value="${allPackages[legg.index].codeDecode}"/>"><c:out value="${allPackages[legg.index].codeDecode}"/></option>
										                   		</c:forEach>  
										                 	</select>
										                	</spring:bind>
													
													</td>
												</tr>
													
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