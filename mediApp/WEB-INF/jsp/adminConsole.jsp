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
														<input type="hidden" name="personIDSel" id="personIDSel" value=""/>
														<spring:bind  path="admin.personID">
															<select id="<c:out value="${status.expression}"/>" name="<c:out value="${status.expression}"/>"  style="WIDTH: 150px" onchange="javascript:fn_populatePackage();">
															<option>-Select-</option>
																<c:forEach items="${personIDS}" var="data">
																	<option value='${data}' ${data==personIDSel?"selected=\"selected\"":"" } >${data}</option>
																</c:forEach>
															</select>
														</spring:bind>
													</td>
												</tr>
												<tr>
													<td> Select Packages:
													</td>
													<td>
														<%@page import="com.mediapp.domain.common.CodeDecode"%>
											           <%@page import="java.util.ArrayList"%>
											           <%@page import="java.util.List"%>
											           <%int i = 0; 
											           
											           String chk="";
											           List<CodeDecode> allPackages = (ArrayList<CodeDecode>)request.getAttribute("allPackages");
											           List<String> personPackages = (ArrayList<String>)request.getAttribute("selectedPackages");
											           
											           %>
													
										                <spring:bind  path="admin.packages">
										                 	<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 25em;" size="3" multiple >
										                 		<c:forEach items="${allPackages}" varStatus="legg">
																<%
																chk="";		
																if(personPackages != null){
																	for(String packages: personPackages){
																		if(packages.equals(allPackages.get(i).getCodeDecode())){								
																			chk = "selected";
																		}
																	}
																	
																}
																i++;
																%>
										                 		
										                   			<option value ="<c:out value="${allPackages[legg.index].codeDecode}"/>" <%=chk %>><c:out value="${allPackages[legg.index].codeDecode}" /></option>
										                   		</c:forEach>  
										                 	</select>
									                	</spring:bind>
													
													</td>
												</tr>
													
												</table>
											</td>
										</tr>
           <tr>
            <td align="center" colspan="2">
            
				<table border="0" cellpadding="0" cellspacing="0" width="400" height="30" >         
					<tr >     
				  		<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;width:33%" align="center">  
				  			<a href="javascript:void(0);" onClick="javascript:fn_updatePackage();" style="text-decoration:none"> 
				  				<font size="+1" color="#FFFFFF" >Save</font> 
				  			</a>
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