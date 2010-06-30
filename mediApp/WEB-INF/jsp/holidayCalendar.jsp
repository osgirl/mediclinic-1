<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
   <div id="contentBodyRight">
    <div id="contentBodyCenter">
     <div id="contentSingleEntry" style="">
      <div id="entries">
       <div class="entryAlone">
        <form name="holidayCalendar" id="holidayCalendar" method="post" >
         <table width=900  border="1" class="layout"  > 
          <tr>
           <td> 
            <table width=100 align="left"  border="1" class="layout" > 
           <menu:verticalMenuItemTag></menu:verticalMenuItemTag> 
            </table>

            <div id="History"  style="display:block" align="center">
             <table  border=""  class="login" width=800 cellpadding="200" id="tblSample">
              <tr bgcolor="lightblue" >
               Add Holidays
              </tr>
              <tr >
               <td width="25%">Holiday Date:
               <td width="15%" align="left">Full Day:
               </td>
               <td width="15%" align="left">From Time:
               </td>
               <td width="15%" align="left">To Time:
               </td>
               <td width="25%" >
               </td>
              </tr>
              
              <tr>
              <td >
               <spring:bind path="holidayCalendar.holidays[0].holidayDate">
                <input type="text" name="${status.expression}" id="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${status.value}"/>"  style="WIDTH: 100px"/>                
               </spring:bind>
                 <script language="JavaScript">
                  new tcal ({
                   // form name
                   'formname': 'holidayCalendar',
                   // input name
                   'controlname': 'holidays[0].holidayDate'
                   });
                 </script>
              </td>                
              <td >
               <spring:bind path="holidayCalendar.holidays[0].fromTime">
                 <input type="checkbox" name="radioBtn" />
               </spring:bind>
              </td>
              <td >
               <spring:bind path="holidayCalendar.holidays[0].fromTime">
                <input type="text" name="${status.expression}" id="${status.expression}"  value="${status.value}" style="WIDTH: 100px"/>                
               </spring:bind>
              </td>
              <td >
               <spring:bind path="holidayCalendar.holidays[0].fromTime">
                <input type="text" name="${status.expression}" id="${status.expression}"  value="${status.value}" style="WIDTH: 100px"/>                
               </spring:bind>
              </td>
              
              </tr>
             </table>
            </div>
          </tr>
           <tr>
            <td align="center" colspan="2">
            <input type="hidden" value="1" id="counter"/>
            <input type="button" onclick="addRowToCalendar();"  value="Add Row"  alignment="center"  class="bsubmit" id="beforeThis"/>
            <input type="button" onclick="removeRowToCalendar();"  value="Remove Row"  alignment="center"  class="bsubmit" id="remove"/>               
            <input type="button"  onClick="javascript:fn_updateAppointmentDetails();" alignment="center" value="Save" class="bsubmit"  width="75"/>
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
