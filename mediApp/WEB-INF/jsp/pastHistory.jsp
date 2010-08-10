<%@ include file="/WEB-INF/jsp/include.jsp" %>
<div id="contentBodyLeft">
   <div id="contentBodyRight">
    <div id="contentBodyCenter">
     <div id="contentSingleEntry" style="">
      <div id="entries">
       <div class="entryAlone">
        <form name="pastHistory" id="pastHistory" method="post" >
         <table width=900  border="1" class="layout"  > 
          <tr>
           <td> 
            <table width=100 align="left"  border="1" class="layout" > 
             <menu:verticalMenuItemTag></menu:verticalMenuItemTag>
            </table>
            
            <div id="History"  style="display:block" align="center">
             <table  border=""  class="login" width=680 cellpadding="200">
              <tr bgcolor="lightblue" >
               Personal Details
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
            <div id="History"  style="display:block" align="right">
             <table  border=""  class="login" width=680 cellpadding="200" >
              <tr bgcolor="lightblue" >
               Allergies
              </tr>
              <tr>
               <td >
                 <input type="text" name="selectAllergy"  id="selectAllergy" value=""/>
                 <script type="text/javascript">
                   new Autocomplete('selectAllergy', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
                 </script>
                 
               </td>
		               <td >
		                
		                <input type="button"  onClick="javascript:fn_addToSelect('allergies','selectAllergy');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
		                </br>
		                <input type="button"  onClick="javascript:fn_deleteAllergy();" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
		               </td>                  
		               <td >
			                <spring:bind  path="patientDetails.allergies">
			                 	<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 25em;" size="3" multiple >
			                 		<c:forEach items="${patientDetails.allergies}" varStatus="legg">
			                   			<option value ="<c:out value="${patientDetails.allergies[legg.index]}"/>"><c:out value="${patientDetails.allergies[legg.index]}"/></option>
			                   		</c:forEach>  
			                 	</select>
			                	</spring:bind>
		               </td>
              </tr>
             </table>
             <input type="button"  onClick="javascript:fn_saveHistory();" alignment="center" value="Save" class="bsubmit" id="btnUpload" width="75" />
            </div>
            
            <div id="History"  style="display:block" align="right" >
             <table  border=""  class="login" width=680 cellpadding="200">
              <tr bgcolor="lightblue" >
               Upload Past History Files &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="button"  onClick="javascript:fn_uploadFile();" alignment="center" value="Upload" class="bsubmit" id="btnUpload" width="75" />
              </tr>
					<tr>
						<td>
						</td>						
						<td>File Name:
						</td>
						<td>Comments:
						</td>
					</tr>
					<c:forEach items="${patientDetails.uploadedFiles}" varStatus="uploadedFiles">
						<tr>
							<td>
								<spring:bind path="patientDetails.uploadedFiles[${uploadedFiles.index}].fileName">
									<a href="javascript:fn_openFile('<c:out value="${patientDetails.uploadedFiles[uploadedFiles.index].filePath}"/>')" >
										<c:out value="${patientDetails.uploadedFiles[uploadedFiles.index].fileName}"/>'
									</a>
								</spring:bind>
							</td>
							<td>
								<spring:bind path="patientDetails.uploadedFiles[${uploadedFiles.index}].comments">
									<textarea name="${status.expression}"  value="${fn:trim(patientDetails.uploadedFiles[${uploadedFiles.index}].comments)}"  rows="1" cols="100" disabled="disabled">
									</textarea>													
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
     </div>
    </div>
   </div>
  </div>
  
<%@ include file="/WEB-INF/jsp/footer.jsp" %>  