<%@ include file="/WEB-INF/jsp/include.jsp" %>
<div id="contentBodyLeft">
   <div id="contentBodyRight">
    <div id="contentBodyCenter">
    			<div class="stp" style="margin-bottom:1.5em;">
				<div class="or" style="margin:1em; padding:0;" >
    
     <div id="contentSingleEntry" style="">
      <div id="entries">
       <div class="entryAlone">
        <form name="pastHistory" id="pastHistory" method="post" >
        	<c:if test="${not empty SuccessMessage}">			
				<font color="green"><c:out value="${SuccessMessage}" /></font><br/>
			</c:if>
        
         <table width=900  border="1" class="layout"  > 
          <tr>
           <td> 
             <table width=200 align="left"   class="sample" style="border-width: 0px 0px 0px 0px;">  
             <menu:verticalMenuItemTag></menu:verticalMenuItemTag>
            </table>
            
            <div id="History"  style="display:block" align="center">
             <table  border=""  class="sample" width=680 cellpadding="200">
              <tr  >
               Personal Information
              </tr>
              <tr>
              		<spring:bind path="patientDetails.idPatient">
						<input type="hidden" name="${status.expression}"  value="<c:out value="${patientDetails.idPatient}"/>"/>					
					</spring:bind>
              
               <td >Weight: </td>
               <td >
                <spring:bind path="patientDetails.weight">                               
                 <input type="text"  name="weight"  value="<c:out value="${patientDetails.weight}"/>" style="WIDTH: 50px" onKeyUp="if(this.value.match(/\D/))this.value=this.value.replace(/\D/g,'')" onblur="if(this.value.match(/\D/))this.value=this.value.replace(/\D/g,'')" maxlength="3"/>
                 kg
                 <font color="red"><c:out value="${status.errorMessage}" /></font>
                </spring:bind>
                
               </td>
               <td >Height: </td>
               <td >
                <spring:bind path="patientDetails.height">                               
                 <input type="text"  name="height"  value="<c:out value="${patientDetails.height}"/>" style="WIDTH: 50px" onKeyUp="if(this.value.match(/\D/))this.value=this.value.replace(/\D/g,'')" onblur="if(this.value.match(/\D/))this.value=this.value.replace(/\D/g,'')" maxlength="3"/>
                 cm
                 <font color="red"><c:out value="${status.errorMessage}" /></font>
                </spring:bind>
                
               </td>
               
              </tr>
              <tr>
               <td >Blood Group: </td>
               <td >
                <spring:bind path="patientDetails.bloodGroup">
                 <select id="bloodGroup" name="bloodGroup" style="WIDTH: 100px">
                   <option value='' >-Select-</option>               	
                   <option value='A+' ${patientDetails.bloodGroup=='A+'?"selected=\"selected\"":"" }>A+</option>
                   <option value='A-' ${patientDetails.bloodGroup=='A-'?"selected=\"selected\"":"" }>A-</option>
                   <option value='B+' ${patientDetails.bloodGroup=='B+'?"selected=\"selected\"":"" } >B+</option>
                   <option value='B-' ${patientDetails.bloodGroup=='B-'?"selected=\"selected\"":"" }>B-</option>
                   <option value='AB+' ${patientDetails.bloodGroup=='AB+'?"selected=\"selected\"":"" }>AB+</option>
                   <option value='AB-' ${patientDetails.bloodGroup=='AB-'?"selected=\"selected\"":"" }>AB-</option>
                   <option value='O+' ${patientDetails.bloodGroup=='O+'?"selected=\"selected\"" :""}>O+</option>
                   <option value='O-' ${patientDetails.bloodGroup=='O-'?"selected=\"selected\"":"" }>O-</option>
                   
                   
                 </select>
                </spring:bind>
               </td>
              </tr>
             </table>
            </div>
            <div id="History"  style="display:block" align="center">
             <table  border=""  class="sample" width=680 cellpadding="200" >
              <tr >
               Allergies
              </tr>
              <tr>
               <td >
                 <input type="text" name="selectAllergy"  id="selectAllergy" value=""/>
                 
               </td>
		               <td >
		                
		                <input type="button"  onClick="javascript:fn_addToSelect('allergies','selectAllergy');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
		                </br>
		                <input type="button"  onClick="javascript:fn_deleteAllergy();" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
		               </td>                  
		               <td >
			                <spring:bind  path="patientDetails.allergies">
			                 	<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 25em;background:#cadef4;" size="3" multiple >
			                 		<c:forEach items="${patientDetails.allergies}" varStatus="legg">
			                   			<option value ="<c:out value="${patientDetails.allergies[legg.index]}"/>"><c:out value="${patientDetails.allergies[legg.index]}"/></option>
			                   		</c:forEach>  
			                 	</select>
			                	</spring:bind>
		               </td>
              </tr>
					<%  
					if(p.getPackages().contains("Patient")){
							
					%>
              
              <tr>
              <tr>
              </tr>
              	<td> Treatment History :
              	</td>
              	<td> 
              		<a href="javascript:void(0);" onClick="javascript:generateHistory(<%=p.getIdPerson() %>);" >
              			View 
					</a>
              	</td>
              </tr>
              <%}%>
              <tr>
              </tr>
              		
             </table>
              <table border="0" cellpadding="0" cellspacing="0" width="200" height="30"  align="bottom">       
					<tr>     
						<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;"  align="center">  
				  			<a href="javascript:void(0);" onClick="javascript:fn_saveHistory();" style="text-decoration:none"> 
				  				<font size="+1" color="#FFFFFF" >Save</font> 
				  			</a>
				  		</td>
					</tr>
				</table>
            </div>
            
            <div id="History"  style="display:block" align="right" >
              <table border="0" cellpadding="0" cellspacing="0" width="100" height="30"  align="right">       
					<tr>     
						<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;height:100%;"  align="center">  
				  			<a href="javascript:void(0);" onClick="javascript:fn_uploadFile();" style="text-decoration:none"> 
				  				<font size="+1" color="#FFFFFF" >Upload</font> 
				  			</a>
				  		</td>
					</tr>
				</table><br></br>
            
             <table  border=""  class="sample" width=680 cellpadding="200">
					<tr>
						<td>
						</td>						
						<td width="30%">File Name:
						</td>
						<td width="70%">Comments:
						</td>
					</tr>
					<c:forEach items="${patientDetails.uploadedFiles}" varStatus="uploadedFiles">
						<tr>
							<td>
							</td>						
						
							<td>
								<spring:bind path="patientDetails.uploadedFiles[${uploadedFiles.index}].fileName">
									<a href="javascript:fn_openFile('<c:out value="${patientDetails.uploadedFiles[uploadedFiles.index].filePath}"/>')" >
										<c:out value="${patientDetails.uploadedFiles[uploadedFiles.index].fileName}"/>
									</a>
								</spring:bind>
							</td>
							<td>
								<spring:bind path="patientDetails.uploadedFiles[${uploadedFiles.index}].comments">
								
									<c:out value="${fn:trim(patientDetails.uploadedFiles[uploadedFiles.index].comments)}"/>													
								</spring:bind>								
							</td>
						</tr>
					</c:forEach>
             </table>
            </div>
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