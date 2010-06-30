<%@ include file="/WEB-INF/jsp/include.jsp" %>
<div id="contentBodyLeft">
   <div id="contentBodyRight">
    <div id="contentBodyCenter">
     <div id="contentSingleEntry" style="">
      <div id="entries">
       <div class="entryAlone">
        <form name="searchDoctor" id="searchDoctor" method="post" >
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
               <td >Weight: </td>
               <td >
                <spring:bind path="patientDetails.weight">                               
                 <input type="text"  name="weight"  value="<c:out value="${status.value}"/>" style="WIDTH: 50px"/>
                 kg
                 <font color="red"><c:out value="${status.errorMessage}" /></font>
                </spring:bind>
                
               </td>
               <td >Height: </td>
               <td >
                <spring:bind path="patientDetails.height">                               
                 <input type="text"  name="height"  value="<c:out value="${status.value}"/>" style="WIDTH: 50px"/>
                 cm
                 <font color="red"><c:out value="${status.errorMessage}" /></font>
                </spring:bind>
                
               </td>
               
              </tr>
              <tr>
               <td >Blood Group: </td>
               <td >
                <spring:bind path="patientDetails.bloodGroup">
                 <select id="bloodGroup" name="bloodGroup" style="WIDTH: 80px">
                   <option value='A+' >A+</option>
                   <option value='A-' >A-</option>
                   <option value='B+' >B+</option>
                   <option value='B-' >B-</option>
                   <option value='AB+' >AB+</option>
                   <option value='AB-' >AB-</option>
                   <option value='O+' >O+</option>
                   <option value='O-' >O-</option>
                   
                   
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
                
                <input type="button"  onClick="javascript:fn_addToSelect(<c:out value="${patientDetails.allergies}"/>,<c:out value="${selectAllergy}"/>);" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
                </br>
                <input type="button"  onClick="javascript:fn_deletePrescription();" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
               </td>                  
               <td >
                
                <spring:bind  path="patientDetails.allergies">
                 <select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 25em;" size="3" multiple disabled="disabled">
                  <c:forEach items="${patientDetails.allergies}" varStatus="legg">
                   <option value ="<c:out value="${patientDetails.allergies}"/>"><c:out value="${patientDetails.allergies}"/></option>  
                  </c:forEach>
                 </select>
                </spring:bind>
               </td>
              </tr>
             </table>
            </div>
            <div id="History"  style="display:block" align="right" >
             <table  border=""  class="login" width=680 cellpadding="200">
              <tr bgcolor="lightblue" >
               Upload Past History Files &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="button"  onClick="javascript:fn_uploadFile();" alignment="center" value="Upload" class="bsubmit" id="btnUpload" width="75" />
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