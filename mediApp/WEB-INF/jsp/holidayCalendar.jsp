<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page import="com.mediapp.domain.common.Person"%><div id="contentBodyLeft">
   <div id="contentBodyRight">
    <div id="contentBodyCenter">
     <div id="contentSingleEntry" style="">
     
      <div id="entries">
       <div class="entryAlone">
        <form name="holidayCalendar" id="holidayCalendar" method="post" >
        	<div class="stp" style="margin-bottom:1.5em;">
				<div class="or" style="margin:1em; padding:0;" >
								
        
         <table width=900  border="1" class="sample"  > 
          <tr>
           <td> 
            <table width=200 align="left"   class="sample" style="border-width: 0px 0px 0px 0px;">  
                   <tr>
        	           	<td>
            		       	<menu:verticalMenuItemTag></menu:verticalMenuItemTag>
                   		</td>
                   </tr>
                   <tr>
				  		<td>
					  		<iframe src="http://www.google.com/talk/service/badge/Show?tk=z01q6amlq78e1h9cn20207vosv2jub8nkh611ud07qu384ke37nqvenakpfnbeifrsg7l6qilun85qrshcphp2rtskqlr34cj16vv3j7n2sp1vmcpb1lsol8nejbkct5os0o75p8oco7mf878qik9ov02df8a1q6mk45l5cr3&amp;w=200&amp;h=60" allowtransparency="true" frameborder="0" height="60" width="200"></iframe>
				  		</td>
                   
                   </tr>
            </table>
            <div id="History"  style="display:block" align="center">
             <table  border=""  class="sample" id="tblHoliday" width=680 cellpadding="200" id="tblSample"> 
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
				<table border="0" cellpadding="0" cellspacing="0" width="400" height="30" >         
					<tr >     
						<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;height:100%;width:33%"  align="center">  
				  			<a href="javascript:void(0);" onClick="javascript:addRowToCalendar();" style="text-decoration:none"> 
				  				<font size="+1" color="#FFFFFF" >Add Row</font> 
				  			</a>
				  		</td>
				  		<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;height:100%;width:33%" align="center">  
				  			<a href="javascript:void(0);" onClick="javascript:deleteRow('tblHoliday',this.form);" style="text-decoration:none"> 
				  				<font size="+1" color="#FFFFFF" >Delete Row</font>
				  			</a>
				  		</td>
				  		<td  style="background: url(/images/submitbutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;height:100%;width:33%" align="center">  
				  			<a href="javascript:void(0);" onClick="javascript:fn_updateHolidayCalendar();" style="text-decoration:none"> 
				  				<font size="+1" color="#FFFFFF" >Save</font> 
				  			</a>
				  		</td>
				  		
					</tr>
				</table> 										
            </td>
           </tr>
          
          </table>
          </div></div>
          
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
 