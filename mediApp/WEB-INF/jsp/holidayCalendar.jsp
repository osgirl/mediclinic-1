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
             <table  border=""  class="login" id="tblHoliday" width=800 cellpadding="200" id="tblSample">
              <tr bgcolor="lightblue" >
               Add Holidays
              </tr>
              <tr >
              	<td width="5%">
              	</td>
               <td width="25%">Holiday Date:
               </td>
               <td width="70%" align="left">Comments:
               </td>
              </tr>
              
             
		       <c:forEach items="${holidayCalendar.holidays}" varStatus="holidays">
			        <tr>
			        	<td>
			        		<input type="checkbox"  name="deleteChk" id="deleteChk" />
			        	</td>
	                   <td >
	                    <spring:bind path="holidayCalendar.holidays[${holidays.index}].holidayDate">
	                     <input type="text" name="${status.expression}" id="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${holidayCalendar.holidays[holidays.index].holidayDate}"/>"  style="WIDTH: 100px" onblur="check_date(this)"/>                
	                    </spring:bind>
	                      <script language="JavaScript">
	                       new tcal ({
	                        // form name
	                        'formname': 'holidayCalendar',
	                        // input name
	                        'controlname': '<c:out value="holidays[${holidays.index}].holidayDate"/>'
	                        });
	                      </script>
	                   </td>                
	                   <td >
	                    <spring:bind path="holidayCalendar.holidays[${holidays.index}].comments">
	                     <input type="text" name="${status.expression}" id="${status.expression}"  value="${holidayCalendar.holidays[holidays.index].comments}" style="WIDTH: 400px"/>
	                                     
	                    </spring:bind>
	                   </td>
		         	</tr>
		       </c:forEach>
              
            
             </table>
            </div>
          </tr>
           <tr>
            <td align="center" colspan="2">
            
	            <input type="hidden" value="1" id="counter"/>
	            <input type="hidden" value="N" id="AddOperation" name="AddOperation"/>
	            <input type="button" onclick="addRowToCalendar();"  value="Add Row"  alignment="center"  class="bsubmit" id="beforeThis"/>
	            <input type="button" onclick="deleteRow('tblHoliday',this.form);"  value="Remove Row"  alignment="center"  class="bsubmit" id="remove"/>               
	            <input type="button"  onClick="javascript:fn_updateHolidayCalendar();" alignment="center" value="Save" class="bsubmit"  width="75"/>
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
 