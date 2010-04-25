<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="com.mediapp.domain.common.Person"%>
<html>
	<head>
	    <title>mediApp</title>    
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" type="image/x-icon" />
	    <link href="<%=request.getContextPath()%>/css/mycss.css" rel="stylesheet" type="text/css">
	    <link href="<%=request.getContextPath()%>/css/autocomplete.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mediapp.js"></script>    
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/autocomplete.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/calendar.css">
	</head>
	<body>
	<script type="text/javascript">
	function addRowToTable()
	{
	  var tbl = document.getElementById('tblSample');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  
	  var cellRight = row.insertCell(0);
	  var el = document.createElement('input');
	  el.type = 'checkbox';
	  cellRight.appendChild(el);

	  // left cell
	  var cellLeft = row.insertCell(1);
	  //var textNode = document.createTextNode(iteration);
	  var el0 = document.createElement('input');
	  el0.type = 'text';
	  el0.name = 'txtRow' + iteration;
	  el0.id = 'txtRow' + iteration;
	  el0.size = 20;
	  cellLeft.appendChild(el0);
	  
	  // right cell
	  var cellRight = row.insertCell(2);
	  var el = document.createElement('input');
	  el.type = 'text';
	  el.name = 'txtRow' + iteration;
	  el.id = 'txtRow' + iteration;
	  el.size = 20;	  
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);

	  var cellRight = row.insertCell(3);
	  var el = document.createElement('input');
	  el.type = 'button';
	  el.value='>>';
	  el.name = 'btnAdd' + iteration;
	  el.id = 'btnAdd' + iteration;
	  el.setAttribute("class","bsubmit");
	//  el.setAttribute("onClick","javascript:fn_addPrescription();");  
	  el.onclick = function() { fn_addPrescription(); }; 
		  'javascript:fn_addPrescription();';
	  el.className='bsubmit';	   
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);

	  // select cell
	  var cellRightSel = row.insertCell(4);
	  var sel = document.createElement('<select multiple size=3 style="width: 15em;">');
	  sel.name = 'selRow' + iteration;
	  el.size = 3;	  
	  //sel.options[0] = new Option('text zero', 'value0');
	  //sel.options[1] = new Option('text one', 'value1');
	  cellRightSel.appendChild(sel);

	  var cellRight = row.insertCell(5);
	  var el = document.createElement('input');
	  el.type = 'button';
	  el.value='D';
	  el.name = 'btnDel' + iteration;
	  el.id = 'btnDdd' + iteration;
	  el.setAttribute("class","bsubmit");
	//  el.setAttribute("onClick","javascript:fn_addPrescription();");  
	  el.onclick = function() { fn_addPrescription(); }; 
		  'javascript:fn_deletePrescription();';
	  el.className='bsubmit';	   
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);
	  
	}
	function keyPressTest(e, obj)
	{
	  var validateChkb = document.getElementById('chkValidateOnKeyPress');
	  if (validateChkb.checked) {
	    var displayObj = document.getElementById('spanOutput');
	    var key;
	    if(window.event) {
	      key = window.event.keyCode; 
	    }
	    else if(e.which) {
	      key = e.which;
	    }
	    var objId;
	    if (obj != null) {
	      objId = obj.id;
	    } else {
	      objId = this.id;
	    }
	    displayObj.innerHTML = objId + ' : ' + String.fromCharCode(key);
	  }
	}
	function removeRowFromTable()
	{
	  var tbl = document.getElementById('tblSample');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
	function openInNewWindow(frm)
	{
	  // open a blank window
	  var aWindow = window.open('', 'TableAddRowNewWindow',
	   'scrollbars=yes,menubar=yes,resizable=yes,toolbar=no,width=400,height=400');
	   
	  // set the target to the blank window
	  frm.target = 'TableAddRowNewWindow';
	  
	  // submit
	  frm.submit();
	}
	function validateRow(frm)
	{
	  var chkb = document.getElementById('chkValidate');
	  if (chkb.checked) {
	    var tbl = document.getElementById('tblSample');
	    var lastRow = tbl.rows.length - 1;
	    var i;
	    for (i=1; i<=lastRow; i++) {
	      var aRow = document.getElementById('txtRow' + i);
	      if (aRow.value.length <= 0) {
	        alert('Row ' + i + ' is empty');
	        return;
	      }
	    }
	  }
	  openInNewWindow(frm);
	}
	</script>
		<form name="createAppointment" id="createAppointment" method="post" >		
			<div id="createApt"  style="display:block" align="center">
				<table  border=""  class="login" width=900>
					<tr bgcolor="lightblue">
						New Appointment
					</tr>
					<table  border=""  class="login" width=900>
						<tbody>
						<tr>
							<td>Headline :
								<spring:bind path="appointment.headline">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.headline}"/>"  disabled="disabled" />					
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td >Date :
								<spring:bind path="appointment.dateOfAppointment">
									<input type="text" name="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>" disabled="disabled" />
								</spring:bind>
								Time :
								<spring:bind path="appointment.timeOfAppointment">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.timeOfAppointment}"/>" disabled="disabled" />
								</spring:bind>
							</td>
							
						</tr>
						<tr>
							<td width="10%">Comments:							
								<spring:bind path="appointment.comments">
									<textarea name="${status.expression}"  value="${fn:trim(appointment.comments)}"  rows="2" cols="30" disabled="disabled">
									</textarea>													
								</spring:bind>
							</td>
						</tr>
							<spring:bind path="appointment.doctorID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorID}"/>"/>					
							</spring:bind>
							<spring:bind path="appointment.doctorPersonID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorPersonID}"/>"/>					
							</spring:bind>
						</tbody>
					</table>
					<table  border=""  class="login" width=900 id="tblSample">
						<tbody id="aa">						
						<tr>
							<td  width="1%">
							</td>						
							<td  width="33%">Diagnosis:
							</td>
							<td  width="30%">Find Prescription:
							</td>
							<td width="3%">
							</td>
							<td  width="30%">Prescription:
							</td>
							<td width="3%">
							</td>
							
						</tr>
						<tr>
							<td  width="1%">
									<input type="checkbox" name="radioBtn" />
							</td>
						
							<td  width="33%">
								<spring:bind path="appointment.diagnosis">
									<input type="text" name="${status.expression}"  value="${appointment.diagnosis}"/>
																						
								</spring:bind>
							</td>
							<td  width="30%">
									<input type="text" name="findPrescription"  value=""/>
							</td>
							<td width="3%">
								<input type="button"  onClick="javascript:fn_addPrescription();" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
							</td>
															
							<td  width="30%">
								<spring:bind path="appointment.prescription">
								<SELECT NAME="${status.expression}" MULTIPLE SIZE=3   style="width: 15em;">
									<OPTION VALUE="${status.expression}" >IbuProfen</OPTION>								
								</SELECT>
								</spring:bind>
							</td>
							<td width="3%" >
								<input type="button"  onClick="javascript:fn_deletePrescription();" alignment="center" value="D" class="bsubmit" id="btnDel" width="75" />
							</td>
							
						</tr>								
						  </tbody>
					</table>						
					<tr>
						<td align="center" colspan="2">
						<input type="button" onclick="addRowToTable();"  value="Add Row"  alignment="center"  class="bsubmit" id="beforeThis"/>
						<input type="button" onclick="removeRowFromTable();"  value="Remove Row"  alignment="center"  class="bsubmit" id="remove"/>															
						<input type="button"  onClick="javascript:fn_updateAppointmentDetails();" alignment="center" value="Save" class="bsubmit"  width="75"/>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
