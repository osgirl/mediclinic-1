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
	  var numi = document.getElementById('counter');
      var num = (document.getElementById("counter").value - 1) + 2;
      numi.value = num;		
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
	  el0.name = "diagnosis[" + (num -1 )+ "].codeICD";
	  el0.id = "diagnosis[" + (num -1 )+ "].codeICD";
	  el0.size = 20;
	  cellLeft.appendChild(el0);
	  //add script
	  var ss = document.createElement('script');	  
	  var scr = "new Autocomplete('"+el0.name+"', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');";
	  ss.text = scr;
	  var hh = document.getElementsByTagName('head')[0];
	  hh.appendChild(ss);
	  
	  // right cell
	  var cellRight = row.insertCell(2);
	  var el = document.createElement('input');
	  el.type = 'text';
	  el.name = 'findPrescription[' + (num -1 )+']';
	  var pr = el.name;	  
	  el.id = 'findPrescription[' + (num -1 ) +']';
	  el.size = 20;	  
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);

	  //add script
	  var ss = document.createElement('script');
	  var scr = "new Autocomplete('"+el.name+"', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');";
	  ss.text = scr;
	  var hh = document.getElementsByTagName('head')[0];
	  hh.appendChild(ss);
	  
	  var cellRight = row.insertCell(3);
	  var el = document.createElement('input');
	  el.type = 'button';
	  el.value='>>';
	  el.name = 'btnAdd' + iteration;
	  el.id = 'btnAdd' + iteration;
	  el.setAttribute("class","bsubmit");
	  selName = "diagnosis[" + (num -1 )+ "].prescription" ;	 	  
	  el.onclick =  function() { fn_addToSelect(selName,pr) };
	  el.className='bsubmit';	   
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);
	  cellRight.appendChild(document.createElement("br"));
		
	  //delete button	  
	  var el = document.createElement('input');
	  el.type = 'button';
	  el.value='<<';
	  el.name = 'btnDel' + iteration;
	  el.id = 'btnDdd' + iteration;
	  el.setAttribute("class","bsubmit");
	//  el.setAttribute("onClick","javascript:fn_addPrescription();");  
	  el.onclick = function() { fn_addPrescription(); }; 
		  'javascript:fn_deletePrescription();';
	  el.className='bsubmit';	   
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);
	  
	  // select cell
	  var cellRightSel = row.insertCell(4);
	  var sel = document.createElement('<select multiple size=3 style="width: 15em">');
	  sel.name = "diagnosis[" + (num -1 )+ "].prescription" ;
	  el.size = 3;	  
	  //sel.options[0] = new Option('text zero', 'value0');
	  //sel.options[1] = new Option('text one', 'value1');
	  cellRightSel.appendChild(sel);

//start
	  // right cell
	  var cellRight = row.insertCell(2);
	  var el = document.createElement('input');
	  el.type = 'text';
	  el.name = 'findTest[' + (num -1 ) +']';	  
	  el.id = 'findTest[' + (num -1 ) +']';
	  testName = 'findTest[' + (num -1 ) +']';
	  el.size = 20;	  
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);

	  //add script
	  var ss = document.createElement('script');
	  var scr = "new Autocomplete('"+el.name+"', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');";
	  ss.text = scr;
	  var hh = document.getElementsByTagName('head')[0];
	  hh.appendChild(ss);
	  
	  var cellRight = row.insertCell(3);
	  var el = document.createElement('input');
	  el.type = 'button';
	  el.value='>>';
	  el.name = 'btnAdd' + iteration;
	  el.id = 'btnAdd' + iteration;
	  el.setAttribute("class","bsubmit");
	//  el.setAttribute("onClick","javascript:fn_addPrescription();");  
//	  el.onclick = new function() { fn_addPrescription(); }; 
	  testNames ="diagnosis[" + (num -1 )+ "].diagnosisTest";
	  'javascript:fn_addToSelect('+ testNames+','+testName+');';
	  el.className='bsubmit';	   
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);
	  cellRight.appendChild(document.createElement("br"));

	  //delete button
	  var el = document.createElement('input');
	  el.type = 'button';
	  el.value='<<';
	  el.name = 'btnDel' + iteration;
	  el.id = 'btnDel' + iteration;
	  el.setAttribute("class","bsubmit");
	//  el.setAttribute("onClick","javascript:fn_addPrescription();");  
	  el.onclick = function() { fn_addPrescription(); }; 
		  'javascript:fn_deleteTest();';
	  el.className='bsubmit';	   
	  //el.onkeypress = keyPressTest;
	  cellRight.appendChild(el);
	  
	  // select cell
	  var cellRightSel = row.insertCell(4);
	  var sel = document.createElement("<select multiple size=3 style='width: 15em'>");
	  sel.name = "diagnosis[" + (num -1 )+ "].diagnosisTest";
	  sel.id = "diagnosis[" + (num -1 )+ "].diagnosisTest";
	  
	  el.size = 3;	  
	  //sel.options[0] = new Option('text zero', 'value0');
	  //sel.options[1] = new Option('text one', 'value1');
	  cellRightSel.appendChild(sel);


//end
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
		<form name="updateAppointment" id="updateAppointment" method="post" >		
			<div id="createApt"  style="display:block" align="center">
				<table  border=""  class="login" width=1246>
					<tr bgcolor="lightblue" align="center">
						<font style="text-align: center;font-size: 120%;font-weight: bold;">Update Appointment</font>
					</tr>
					<table  border=""  class="login" width=1246>
						<tr>
							<td>Headline : &nbsp;&nbsp; 
								<spring:bind path="appointment.headline">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.headline}"/>"  disabled="disabled" style="width: 700px" />					
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td >Date : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<spring:bind path="appointment.dateOfAppointment">
									<input type="text" name="${status.expression}"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${appointment.dateOfAppointment}"/>" disabled="disabled" style="width: 200px"/>
								</spring:bind>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								Time : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<spring:bind path="appointment.timeOfAppointment">
									<input type="text" name="${status.expression}"  value="<c:out value="${appointment.timeOfAppointment}"/>" disabled="disabled" style="width: 200px"/>
								</spring:bind>
							</td>
							
						</tr>
						
						<tr>
							<td width="10%">Comments : 							
								<spring:bind path="appointment.comments">
									<textarea name="${status.expression}"  value="${fn:trim(appointment.comments)}"  rows="2" cols="100" disabled="disabled">
									</textarea>													
								</spring:bind>
							</td>
							<td align="center" >
								<input type="button"  onClick="javascript:fn_addToSelect();" alignment="center" value="Reschedule" class="bsubmit" id="btnReschedule" width="75" />							
							</td>
						</tr>
							<spring:bind path="appointment.doctorID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorID}"/>"/>					
							</spring:bind>
							<spring:bind path="appointment.doctorPersonID">
								<input type="hidden" name="${status.expression}"  value="<c:out value="${appointment.doctorPersonID}"/>"/>					
							</spring:bind>
						
					</table>					
					<table  border=""  class="login" width=1200 id="tblSample">
						<tbody id="aa">						
						<tr>
							<td>
							</td>						
							<td>Diagnosis:
							</td>
							<td>Find Prescription:
							</td>
							<td>
							</td>
							<td  >Prescription:
							</td>
							<td>Find Test:
							</td>
							<td>
							</td>
							<td>Tests:
							</td>
							
						</tr>
						<input type="hidden" value="1" id="counter"/>
						<c:choose>
							<c:when test="${!empty appointment.diagnosis}">

								<c:forEach items="${appointment.diagnosis}" varStatus="diagnosisAndtest">
									<script type="text/javascript">
												var num = document.getElementById("counter").value + 1;
												document.getElementById("counter").value = num;
									</script>
									
									<tr>
										<td  >
												<input type="checkbox" name="radioBtn" />
										</td>
									
										<td  >
											<spring:bind path="appointment.diagnosis[${diagnosisAndtest.index}].codeICD">
												<input type="text" name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>" />
												<script type="text/javascript">
														new Autocomplete('<c:out value="diagnosis[${diagnosisAndtest.index}].codeICD"/>', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
												</script>
												
																									
											</spring:bind>
										</td>
										<td >
												<input type="text" name="findPrescription[${diagnosisAndtest.index}]"  id="findPrescription[0]" value=""/>
												<script type="text/javascript">
														new Autocomplete('<c:out value="findPrescription[${diagnosisAndtest.index}]"/>', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
												</script>
												
										</td>
										<td >
											
											<input type="button"  onClick="javascript:fn_addToSelect(<c:out value="diagnosis[${diagnosisAndtest.index}].prescription"/>,<c:out value="findPrescription[${diagnosisAndtest.index}]"/>);" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
											</br> &nbsp;
											<input type="button"  onClick="javascript:fn_deletePrescription();" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
										</td>																		
										<td >
											
											<spring:bind  path="appointment.diagnosis[${diagnosisAndtest.index}].prescription">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 15em;" size="3" multiple disabled="disabled">
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].prescription}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescription[legg.index]}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescription[legg.index]}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
										<td >
												<input type="text" name="findTest[${diagnosisAndtest.index}]"  value=""/>
										</td>
										<script type="text/javascript">
												new Autocomplete('<c:out value="findTest[${diagnosisAndtest.index}]"/>', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
										</script>
										
										<td >
											<input type="button"  onClick="javascript:fn_addToSelect(<c:out value="diagnosis[${diagnosisAndtest.index}].diagnosisTest"/>,<c:out value="findTest[${diagnosisAndtest.index}]"/>);" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
											</br>
											<input type="button"  onClick="javascript:fn_deleteD();" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
											
										</td>
																		
										<td >
											<spring:bind path="appointment.diagnosis[${diagnosisAndtest.index}].diagnosisTest">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="width: 15em;" size="3" multiple disabled="disabled">
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].diagnosisTest}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].diagnosisTest[legg.index]}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].diagnosisTest[legg.index]}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
										
									</tr>								
								</c:forEach>
							</c:when>
							<c:otherwise>
									<tr>
										<td  >
												<input type="checkbox" name="radioBtn" />
										</td>
									
										<td  >
											<spring:bind path="appointment.diagnosis[0].codeICD">
												<input type="text" name="<c:out value="${status.expression}"/>"  value="<c:out value="${status.value}"/>"/>
												<script type="text/javascript">
														new Autocomplete('<c:out value="diagnosis[0].codeICD"/>', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
												</script>
																									
											</spring:bind>
										</td>
										<td >
												<input type="text" name="findPrescription[0]"  value=""/>
												<script type="text/javascript">
														new Autocomplete('findPrescription[0]', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
												</script>
												
										</td>
										<td >
											
											<input type="button"  onClick="javascript:fn_addToSelect('diagnosis[0].prescription','findPrescription[0]');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
											</br> 
											<input type="button"  onClick="javascript:fn_deletePrescription();" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
										</td>
																		
																		
										<td >
											<spring:bind path="appointment.diagnosis[0].prescription">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="WIDTH: 280px" size="3" multiple disabled="disabled">													
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].prescription}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescription[legg.index]}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].prescription[legg.index]}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
										<td >
												<input type="text" name="findTest[0]"  value=""/>
										</td>
										<script type="text/javascript">
												new Autocomplete('findTest[0]', { serviceUrl:'/appointmentPopUp.htm' },'SPECIALTITY');
										</script>
										
										<td >
											<input type="button"  onClick="javascript:fn_addToSelect('diagnosis[0].diagnosisTest','findTest[0]');" alignment="center" value=">>" class="bsubmit" id="btnAdd" width="75" />
											</br>
											<input type="button"  onClick="javascript:fn_deleteD();" alignment="center" value="<<" class="bsubmit" id="btnDel" width="75" />
										</td>
																		
										<td >
											<spring:bind path="appointment.diagnosis[0].diagnosisTest">
												<select  name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" style="WIDTH: 280px" size="3" multiple onclick="javascript:fn_moveDiv(event);" disabled="disabled">
													<c:forEach items="${appointment.diagnosis[diagnosisAndtest.index].diagnosisTest}" varStatus="legg">
														<option value ="<c:out value="${appointment.diagnosis[diagnosisAndtest.index].diagnosisTest[legg.index]}"/>"><c:out value="${appointment.diagnosis[diagnosisAndtest.index].diagnosisTest[legg.index]}"/></option>		
													</c:forEach>
												</select>
											</spring:bind>
										</td>
									</tr>								
							
							</c:otherwise>
						</c:choose>
						<div id="TestResult" style="display:none" >
							<tr>
								<td> 
								</td>
							</tr>
						</div>
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
