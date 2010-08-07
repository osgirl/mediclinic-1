IE7 = (navigator.appVersion.indexOf("MSIE 7.")==-1) ? false : true;
IE8 = (navigator.appVersion.indexOf("MSIE 8.")==-1) ? false : true;

if(!(IE7  || IE8)){
	alert("This application is tested on Internet Explorer 7 and higher. It may not work properly on this browser.");
}
/*function hide(menu){ 
	var menuStyle=document.getElementById(menu).style; 
	menuStyle.display="none";
} 
function show(menu) {
	var menuStyle=document.getElementById(menu).style; 
	menuStyle.display="block";
}
*/
function fn_showPatientRgFrm(){	
//	fn_hideDoctorRgFrm();
	var menuStyle=document.getElementById("RegistrationForm").style; 
	document.all("PersonType").selectedIndex = 1;
	menuStyle.display="block";
	document.getElementById("hRegisterMe").value ="Y";
	document.getElementById("username").value = "";
	document.getElementById("password").value="";
	document.getElementById("LoginButton").disabled = true;
	document.getElementById("username").disabled = true;
	document.getElementById("password").disabled= true;
	document.getElementById("PersonType").disabled = true;
	//alert(document.getElementById("hRegisterMe").value);
}
function fn_hidePatientRgFrm(){
	var menuStyle=document.getElementById("RegistrationForm").style; 
	menuStyle.display="none";
	document.getElementById("hRegisterMe").value ="N";

}
function fn_showDoctorRgFrm(){
	//fn_hidePatientRgFrm();
	document.all("PersonType").selectedIndex = 0;
	var menuStyle=document.getElementById("RegistrationForm").style; 
	menuStyle.display="block";
	document.getElementById("hRegisterMe").value ="Y";
	document.getElementById("username").value = "";
	document.getElementById("password").value="";
	document.getElementById("LoginButton").disabled = true;
	document.getElementById("username").disabled = true;
	document.getElementById("password").disabled= true;
	document.getElementById("PersonType").disabled = true;


}
function fn_hideDoctorRgFrm(){
	var menuStyle=document.getElementById("RegistrationForm").style; 
	menuStyle.display="none";
	document.getElementById("hRegisterMe").value ="N";
	
}

function fn_showMessage(){
	document.getElementById("username").value="";
	document.getElementById("password").value="";
	var indexValue = document.all("PersonType").selectedIndex;
	document.getElementById("hPersonType").value=document.all("PersonType")[indexValue].value;
	//alert(document.getElementById("hPersonType").value);
	//document.all("personTypeString").value=document.all("PersonType")[indexValue].value;
	//alert(document.all("personTypeString").value);
	//alert(document.getElementById("hRegisterMe").value);
	document.getElementById("PersonType").disabled = false;
	document.forms["logon"].submit();
}
function fn_submitLogin(){
	var indexValue = document.getElementById('PersonType').selectedIndex;
	//alert(document.getElementById('PersonType').options[indexValue].text);
	document.getElementById('hPersonType').value=document.getElementById('PersonType').options[indexValue].text;
	//alert(document.getElementById("hPersonType").value);
	
	document.forms["logon"].submit();
}
function fn_nextURL(URL){	
	window.location.href = URL;
	//document.forms["logon"].submit();
}

function fn_searchDoctor(){
	document.forms["searchDoctor"].submit();
}

function fn_dayAppointment(personID){	
	 window.location.href = "/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+document.getElementById('searchCriteria.dateOfAppointment').value+"&TakeAppointment=Y";
}

function fn_createAppointment(personID,doctorID,timeOfAppointment,appointmentDate){
	if (doctorID > 0){
		window.name = "Parent";
		var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:430px;dialogWidth:630px;status:no;edge:sunken';	
	    var c = window.showModalDialog('/createAppointment.htm?PersonID='+personID+"&DoctorID="+doctorID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment, window, WinSettings);
	}else{
		alert("Please take appointment by going through Search Doctor.");
	}
}

function fn_addAppointment(){	
	document.getElementById('dateOfAppointment').disabled=false;
	document.getElementById('timeOfAppointment').disabled=false;
	document.forms['createAppointment'].target="Parent";
    document.forms["createAppointment"].submit();
	document.forms['createAppointment'].method ="get";	
	document.forms['createAppointment'].action="dayAppointment.htm"; 
	document.forms['createAppointment'].submit();
	 self.close();
}

function fn_rescheduleAppointmentDate(){
	document.forms['rescheduleAppointment'].target="Parent";
	document.forms['rescheduleAppointment'].method ="post";
    document.forms["rescheduleAppointment"].submit();
	document.forms['rescheduleAppointment'].method ="post";
	document.forms['rescheduleAppointment'].action="dayAppointment.htm"; 
	document.forms['rescheduleAppointment'].submit();
	 self.close();
}

function fn_GetDayAppointment(indicator){
	var date = new Date(document.getElementById('AppointmentDate').value);
	window.name = "mySelf";
	document.forms['rescheduleAppointment'].target="mySelf";
	var currentMonth = date.getMonth()+1;
	if (indicator == 1){		
		var nextDay = date.getDate()-1;		
		document.getElementById('AppointmentDate').value = currentMonth+"/"+nextDay+"/"+ date.getFullYear();
		document.forms['rescheduleAppointment'].method ="get";
		document.forms["rescheduleAppointment"].submit();
	}
	if (indicator == 2){		
		var nextDay = date.getDate()+1;
		document.getElementById('AppointmentDate').value = currentMonth+"/"+nextDay+"/"+ date.getFullYear();		
		document.forms['rescheduleAppointment'].method ="get";
		document.forms["rescheduleAppointment"].submit();
	}
	
}

function fn_GetMonthAppointment(indicator){
	var date = new Date(document.getElementById('AppointmentDate').value);
	window.name = "mySelf";
	document.forms['rescheduleAppointment'].target="mySelf";
	if (indicator == 1){		
		document.getElementById('AppointmentDate').value = date.getMonth()+"/"+date.getDate()+"/"+ date.getFullYear();
		document.forms['rescheduleAppointment'].method ="get";
		document.forms["rescheduleAppointment"].submit();
	}
	if (indicator == 2){		
		var nextMonth = date.getMonth()+2;
		document.getElementById('AppointmentDate').value = nextMonth+"/"+date.getDate()+"/"+ date.getFullYear();
		document.forms['rescheduleAppointment'].method ="get";
		document.forms["rescheduleAppointment"].submit();
		
	}

}

function fn_updateDateOfAppointment(timeOfAppointment,appointmentDate){
	document.getElementById('dateOfAppointment').value =appointmentDate;
	document.getElementById('timeOfAppointment').value =timeOfAppointment;
}

function fn_GetMonthView(indicator){
	
	var date = new Date(document.getElementById('AppointmentDate').value);
	if (indicator == 1){		
		document.getElementById('AppointmentDate').value = date.getMonth()+"/"+date.getDate()+"/"+ date.getFullYear();		
		document.forms["takeAppointment"].submit();
	}
	if (indicator == 2){		
		var nextMonth = date.getMonth()+2;
		document.getElementById('AppointmentDate').value = nextMonth+"/"+date.getDate()+"/"+ date.getFullYear();		
		document.forms["takeAppointment"].submit();
		
	}
}

function fn_GetYearView(indicator){
	
	var date = new Date(document.getElementById('AppointmentDate').value);
	var month = date.getMonth()+1;
	if (indicator == 1){
		var prevYear = date.getFullYear()-1;		
		document.getElementById('AppointmentDate').value = month+"/"+date.getDate()+"/"+ prevYear;		
		document.forms["takeAppointment"].submit();
	}
	if (indicator == 2){		
		var nextYear = date.getFullYear()+1;
		document.getElementById('AppointmentDate').value = month+"/"+date.getDate()+"/"+ nextYear;		
		document.forms["takeAppointment"].submit();
	}
}

function fn_openAppointment(personID,timeOfAppointment,appointmentDate,appointmentID){
	//alert(appointmentID);
	//alert('/updateAppointment.htm?PersonID='+personID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment+"&AppointmentID="+appointmentID);
	window.name = "Parent";	
	var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:600px;dialogWidth:1500px;status:no;edge:sunken';	
    var c = window.showModalDialog('/updateAppointment.htm?PersonID='+personID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment+"&AppointmentID="+appointmentID, window, WinSettings);
    
	
}

function fn_rescheduleAppointment(personID,timeOfAppointment,appointmentDate,appointmentID){
	//alert(appointmentID);
	//alert('/updateAppointment.htm?PersonID='+personID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment+"&AppointmentID="+appointmentID);
	window.name = "Parent";	
	var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:600px;dialogWidth:1000px;status:no;edge:sunken';	
    var c = window.showModalDialog('/rescheduleAppointment.htm?PersonID='+personID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment+"&AppointmentID="+appointmentID, window, WinSettings);
    
	
}

function fn_Print(){
	window.open("about:blank","reportWindow");
	document.forms['updateAppointment'].target="reportWindow";
	document.forms['updateAppointment'].method ="post";
	document.forms['updateAppointment'].action="simpleReportCompile.pdf"; 
	document.forms['updateAppointment'].submit();
	
}

function fn_updateAppointmentDetails(){
    var num = (document.getElementById("counter").value - 1) + 1 ;    
    for(var i=0;i<num;i++) {    	
    	document.getElementById("diagnosis["+i+"].prescription").disabled = false;
    	document.getElementById("diagnosis["+i+"].diagnosisTest").disabled = false;
    } 
	document.forms['updateAppointment'].target="Parent";
    document.forms["updateAppointment"].submit();
	document.forms['updateAppointment'].method ="post";
	document.forms['updateAppointment'].action="dayAppointment.htm"; 
	document.forms['updateAppointment'].submit();
	 self.close();
}

function fn_addToSelect(selectName,tempName){
	//alert(selectName,tempName);
	if(document.getElementById(tempName).value == ""){
		alert("Please enter the text to be added.");
		document.getElementById(tempName).focus();
	}else{
		//alert();
		// Create an Option object
		var opt = document.createElement("OPTION");
		// Add an Option object to Drop Down/List Box
	    document.getElementById(selectName).options.add(opt);
	    // Assign text and value to Option object
	    opt.text = document.getElementById(tempName).value;
	    opt.value = document.getElementById(tempName).value;
	    opt.selected = "true";
	    document.getElementById(tempName).value = "";
	    document.getElementById(tempName).focus();
	    
	}
}

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
  var selName = "diagnosis[" + (num -1 )+ "].prescription" ;	 	  
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
  el.className='bsubmit';	   
  //el.onkeypress = keyPressTest;
  cellRight.appendChild(el);
  
  // select cell
  var cellRightSel = row.insertCell(4);
  var sel = document.createElement('<select multiple size=3 style="width: 15em">');
  sel.name = "diagnosis[" + (num -1 )+ "].prescription" ;
  sel.id = "diagnosis[" + (num -1 )+ "].prescription" ;
  el.size = 3;	  
  //sel.options[0] = new Option('text zero', 'value0');
  //sel.options[1] = new Option('text one', 'value1');
  cellRightSel.appendChild(sel);

//start
  // right cell
  var cellRight = row.insertCell(5);
  var el = document.createElement('input');
  el.type = 'text';
  el.name = 'findTest[' + (num -1 ) +']';	
  var pr1 = el.name;  
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
  
  var cellRight = row.insertCell(6);
  var el = document.createElement('input');
  el.type = 'button';
  el.value='>>';
  el.name = 'btnAdd' + iteration;
  el.id = 'btnAdd' + iteration;
  el.setAttribute("class","bsubmit");
  var selName1 = "diagnosis[" + (num -1 )+ "].diagnosisTest";
  el.onclick =  function() { fn_addToSelect(selName1,pr1) };
  testNames ="diagnosis[" + (num -1 )+ "].diagnosisTest";
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
  el.onclick = function() { fn_addPrescription(); }; 
  el.className='bsubmit';	   
  //el.onkeypress = keyPressTest;
  cellRight.appendChild(el);
  
  // select cell
  var cellRightSel = row.insertCell(7);
  var sel = document.createElement("<select multiple size=3 style='width: 15em'>");
  sel.name = "diagnosis[" + (num -1 )+ "].diagnosisTest";
  sel.id = "diagnosis[" + (num -1 )+ "].diagnosisTest";
  el.size = 3;	  
  cellRightSel.appendChild(sel);


//end
}
function removeRowFromTable()
{
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
}

function fn_uploadFile(){
	 window.name = "ParentWindow"; 
	 var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:300px;dialogWidth:700px;status:no;edge:sunken'; 
    var c = window.showModalDialog('/uploadFile.htm', window, WinSettings);
}

function fn_saveHistory(){
	document.getElementById("allergies").disabled = false;
	document.forms['pastHistory'].submit();
}

function fn_uploadSelectedFile(){
	 document.forms['uploadFile'].target="ParentWindow";
     document.forms["uploadFile"].submit();
	 document.forms['uploadFile'].method ="post";
	 document.forms['uploadFile'].action="pastHistory.htm"; 
	 document.forms['uploadFile'].submit();
	 //self.close();
}

//new script
function fn_addRowForWorkHours()
{

  if ((document.getElementById('sundayWorking').checked ==true || 
		  document.getElementById('mondayWorking').checked ==true || 
		  document.getElementById('tuesdayWorking').checked ==true ||
		  document.getElementById('wednesdayWorking').checked ==true ||
		  document.getElementById('thursdayWorking').checked ==true ||
		  document.getElementById('fridayWorking').checked ==true ||
		  document.getElementById('saturdayWorking').checked ==true) &&
		  document.getElementById('startTime').value !="" &&
		  document.getElementById('endTime').value != "" )
	{
	  
	  if(document.getElementById('sundayWorking').checked ==true ){
		  fn_addRowForTime("Sunday"); 
	  }
	  if(document.getElementById('mondayWorking').checked ==true ){
		  fn_addRowForTime("Monday"); 
	  }
	  if(document.getElementById('tuesdayWorking').checked ==true ){
		  fn_addRowForTime("Tuesday"); 
	  }
	  if(document.getElementById('wednesdayWorking').checked ==true ){
		  fn_addRowForTime("Wednesday"); 
	  }
	  if(document.getElementById('thursdayWorking').checked ==true ){
		  fn_addRowForTime("Thursday"); 
	  }
	  if(document.getElementById('fridayWorking').checked ==true ){
		  fn_addRowForTime("Friday"); 
	  }
	  if(document.getElementById('saturdayWorking').checked ==true ){
		  fn_addRowForTime("Saturday"); 
	  }	
  	}else{
	  if(document.getElementById('sundayWorking').checked ==false & 
			  document.getElementById('mondayWorking').checked ==false & 
			  document.getElementById('tuesdayWorking').checked ==false &
			  document.getElementById('wednesdayWorking').checked ==false &
			  document.getElementById('thursdayWorking').checked ==false &
			  document.getElementById('fridayWorking').checked ==false &
			  document.getElementById('saturdayWorking').checked ==false ){
		  alert("Please select day.");
	  }
	  if(document.getElementById('startTime').value == ""){
		  alert("Please enter start time.");
	  }
	  if(document.getElementById('endTime').value == ""){
		  alert("Please enter end time.");
	  }

	  
  	}
  var numi = document.getElementById('counter').value;
  var num = (document.getElementById("counter").value - 1) + 1 -1;

}

function fn_addRowForTime(dayName){
	  var numi = document.getElementById('counter');	  
	  var num = (document.getElementById("counter").value - 1) + 1;	    
	  var tbl = document.getElementById('tblWorkHours');
	  var lastRow = tbl.rows.length;
	  if (numi.value==1){
		  document.getElementById("doctorWorkTiming[0].workDayName").readonly = false;
		  document.getElementById("doctorWorkTiming[0].workDayName").size=10;
		  document.getElementById("doctorWorkTiming[0].workDayName").value= dayName;
		  document.getElementById("doctorWorkTiming[0].startTime").value= document.getElementById("startTime").value;
		  document.getElementById("doctorWorkTiming[0].startTime").size=10;
		  document.getElementById("doctorWorkTiming[0].endTime").value= document.getElementById("endTime").value;
		  document.getElementById("doctorWorkTiming[0].endTime").size=10;
	  }else{		  
	  // if there's no header row in the table, then iteration = lastRow + 1
		  
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var cellLeft = row.insertCell(0);
		  var el0 = document.createElement('input');
		  el0.type = 'text';		  
		  el0.name = "doctorWorkTiming[" + (num -1 )+ "].workDayName";
		  el0.id = "doctorWorkTiming[" + (num -1 )+ "].workDayName";
		  el0.size = 10;
		  cellLeft.appendChild(el0);
		  document.getElementById(el0.id).readonly = true;
		  document.getElementById(el0.id).value= dayName;
		  
		  var lowercaseDayName = dayName.toLowerCase();	  
		  document.getElementById("doctorDetails."+lowercaseDayName+"Working").value = "Y";
		  
		  var cellLeft = row.insertCell(1);
		  var el0 = document.createElement('input');
		  el0.type = 'text';
		  el0.name = "doctorWorkTiming[" + (num -1 )+ "].startTime";
		  el0.id = "doctorWorkTiming[" + (num -1 )+ "].startTime";
		  el0.size = 10;
		  cellLeft.appendChild(el0);
		  document.getElementById(el0.id).readonly = true;
		  document.getElementById(el0.id).value= document.getElementById("startTime").value;
			  
		  var cellLeft = row.insertCell(2);
		  var el0 = document.createElement('input');
		  el0.type = 'text';
		  el0.name = "doctorWorkTiming[" + (num -1 )+ "].endTime";
		  el0.id = "doctorWorkTiming[" + (num -1 )+ "].endTime";
		  el0.size = 10;
		  cellLeft.appendChild(el0);
		  document.getElementById(el0.id).readonly = true;
		  document.getElementById(el0.id).value= document.getElementById("endTime").value;
	  }
		//alert(document.all.sundayWorking.checked);
	  numi.value = num+1;
//	 show("tblWorkHours");
}

function saveProfile(){
	  var numi = document.getElementById('counter');	  
	  var num = (document.getElementById("counter").value - 1) + 1 - 1;
	  numi.value=num;
	  
	  document.forms["personalProfile"].submit();
}
//end new script

function fn_UpdateAppointment(appointmentID){
	document.getElementById('AppointmentID').value=appointmentID;
	document.forms["dayAppointment"].submit();
}

//calendar UI scripts
function addRowToCalendar()
{
   document.getElementById('AddOperation').value = "Y";
    holidayCalendar.method="post";
// holidayCalendar.target = "selectFunds";
    holidayCalendar.submit(); 
//end
}

function fn_updateHolidayCalendar(){
   document.getElementById('AddOperation').value = "N";
    holidayCalendar.method="post";
// holidayCalendar.target = "selectFunds";
    holidayCalendar.submit(); 

}

function removeRowFromCalendar()
{
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
}

//calendar UI scripts end


//calendar
var dDate = new Date();
var dCurMonth = dDate.getMonth();
var dCurDayOfMonth = dDate.getDate();
var dCurYear = dDate.getFullYear();
var objPrevElement = new Object();

function fToggleColor(myElement) {
var toggleColor = "#ff0000";
if (myElement.id == "calDateText") {
if (myElement.color == toggleColor) {
myElement.color = "";
} else {
myElement.color = toggleColor;
   }
} else if (myElement.id == "calCell") {
for (var i in myElement.children) {
if (myElement.children[i].id == "calDateText") {
if (myElement.children[i].color == toggleColor) {
myElement.children[i].color = "";
} else {
myElement.children[i].color = toggleColor;
            }
         }
      }
   }
}
function fSetSelectedDay(myElement){
if (myElement.id == "calCell") {
if (!isNaN(parseInt(myElement.children["calDateText"].innerText))) {
myElement.bgColor = "#c0c0c0";
objPrevElement.bgColor = "";
document.all.calSelectedDate.value = parseInt(myElement.children["calDateText"].innerText);
objPrevElement = myElement;
//alert(myElement.children["calDateText"].innerText);
document.all("selectedDate").value = myElement.children["calDateText"].innerText;
document.all("selectedMonth").value =document.all("tbSelMonth").value;
document.all("selectedYear").value =document.all("tbSelYear").value;
window.location.href = "/dayAppointment.htm?selectedDate="+myElement.children["calDateText"].innerText+"&selectedMpnth="+document.all("tbSelMonth").value+"&selectedYear="+document.all("tbSelYear").value; 
      }
   }
}
function getAppointment(personID,appointmentDate){	
	window.location.href = "/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+appointmentDate;	
}

function fn_moveDiv(event){
	x=event.clientX;
	y=event.clientY;
	alert(x+","+y);
	document.getElementById('TestResult').style.top = y +'px';  
	document.getElementById('TestResult').style.left = x +'px';
	document.getElementById('TestResult').style.display="block"; 
	

	
}

function fGetDaysInMonth(iMonth, iYear) {
var dPrevDate = new Date(iYear, iMonth, 0);
return dPrevDate.getDate();
}
function fBuildCal(iYear, iMonth, iDayStyle) {
var aMonth = new Array();
aMonth[0] = new Array(7);
aMonth[1] = new Array(7);
aMonth[2] = new Array(7);
aMonth[3] = new Array(7);
aMonth[4] = new Array(7);
aMonth[5] = new Array(7);
aMonth[6] = new Array(7);
var dCalDate = new Date(iYear, iMonth-1, 1);
var iDayOfFirst = dCalDate.getDay();
var iDaysInMonth = fGetDaysInMonth(iMonth, iYear);
var iVarDate = 1;
var i, d, w;
if (iDayStyle == 2) {
aMonth[0][0] = "Sunday";
aMonth[0][1] = "Monday";
aMonth[0][2] = "Tuesday";
aMonth[0][3] = "Wednesday";
aMonth[0][4] = "Thursday";
aMonth[0][5] = "Friday";
aMonth[0][6] = "Saturday";
} else if (iDayStyle == 1) {
aMonth[0][0] = "Sun";
aMonth[0][1] = "Mon";
aMonth[0][2] = "Tue";
aMonth[0][3] = "Wed";
aMonth[0][4] = "Thu";
aMonth[0][5] = "Fri";
aMonth[0][6] = "Sat";
} else {
aMonth[0][0] = "Su";
aMonth[0][1] = "Mo";
aMonth[0][2] = "Tu";
aMonth[0][3] = "We";
aMonth[0][4] = "Th";
aMonth[0][5] = "Fr";
aMonth[0][6] = "Sa";
}
for (d = iDayOfFirst; d < 7; d++) {
aMonth[1][d] = iVarDate;
iVarDate++;
}
for (w = 2; w < 7; w++) {
for (d = 0; d < 7; d++) {
if (iVarDate <= iDaysInMonth) {
aMonth[w][d] = iVarDate;
iVarDate++;
      }
   }
}
return aMonth;
}
function fDrawCal(iYear, iMonth, iCellWidth, iCellHeight, sDateTextSize, sDateTextWeight, iDayStyle) {
var myMonth;
myMonth = fBuildCal(iYear, iMonth, iDayStyle);
document.write("<table border='1'>")
document.write("<tr>");
document.write("<td align='center' style='FONT-FAMILY:Arial;FONT-SIZE:12px;FONT-WEIGHT: bold'>" + myMonth[0][0] + "</td>");
document.write("<td align='center' style='FONT-FAMILY:Arial;FONT-SIZE:12px;FONT-WEIGHT: bold'>" + myMonth[0][1] + "</td>");
document.write("<td align='center' style='FONT-FAMILY:Arial;FONT-SIZE:12px;FONT-WEIGHT: bold'>" + myMonth[0][2] + "</td>");
document.write("<td align='center' style='FONT-FAMILY:Arial;FONT-SIZE:12px;FONT-WEIGHT: bold'>" + myMonth[0][3] + "</td>");
document.write("<td align='center' style='FONT-FAMILY:Arial;FONT-SIZE:12px;FONT-WEIGHT: bold'>" + myMonth[0][4] + "</td>");
document.write("<td align='center' style='FONT-FAMILY:Arial;FONT-SIZE:12px;FONT-WEIGHT: bold'>" + myMonth[0][5] + "</td>");
document.write("<td align='center' style='FONT-FAMILY:Arial;FONT-SIZE:12px;FONT-WEIGHT: bold'>" + myMonth[0][6] + "</td>");
document.write("</tr>");
for (w = 1; w < 7; w++) {
document.write("<tr>")
for (d = 0; d < 7; d++) {
document.write("<td align='left' valign='top' width='" + iCellWidth + "' height='" + iCellHeight + "' id=calCell style='CURSOR:Hand' onMouseOver='fToggleColor(this)' onMouseOut='fToggleColor(this)' onclick=fSetSelectedDay(this)>");
if (!isNaN(myMonth[w][d])) {
document.write("<font id=calDateText onMouseOver='fToggleColor(this)' style='CURSOR:Hand;FONT-FAMILY:Arial;FONT-SIZE:" + sDateTextSize + ";FONT-WEIGHT:" + sDateTextWeight + "' onMouseOut='fToggleColor(this)' onclick=fSetSelectedDay(this)>" + myMonth[w][d] + "</font>");
} else {
document.write("<font id=calDateText onMouseOver='fToggleColor(this)' style='CURSOR:Hand;FONT-FAMILY:Arial;FONT-SIZE:" + sDateTextSize + ";FONT-WEIGHT:" + sDateTextWeight + "' onMouseOut='fToggleColor(this)' onclick=fSetSelectedDay(this)> </font>");
}
document.write("</td>")
}
document.write("</tr>");
}
document.write("</table>")
}
function fUpdateCal(iYear, iMonth) {
myMonth = fBuildCal(iYear, iMonth);
objPrevElement.bgColor = "";
document.all.calSelectedDate.value = "";
for (w = 1; w < 7; w++) {
for (d = 0; d < 7; d++) {
if (!isNaN(myMonth[w][d])) {
calDateText[((7*w)+d)-7].innerText = myMonth[w][d];
} else {
calDateText[((7*w)+d)-7].innerText = " ";
         }
      }
   }
}

//calendar
/*
//csengine for appointment
//Get Cookie Function
function getCookie(name) {
 var cname = name + "=";
 var dc = document.cookie;

 if (dc.length > 0) {
 begin = dc.indexOf(cname);
 if (begin != -1) {
 begin += cname.length;
 end = dc.indexOf(";", begin);
 if (end == -1) end = dc.length;
 return unescape(dc.substring(begin, end));
 }
 }
 return null;
}

//Set Cookie Function
function setCookie(name, value, expires, path, domain, secure) {
 document.cookie = name + "=" + escape(value) +
 ((expires == null) ? "" : "; expires=" + expires.toGMTString()) +
 ((path == null) ? "" : "; path=" + path) +
 ((domain == null) ? "" : "; domain=" + domain) +
 ((secure == null) ? "" : "; secure");
}

//Delete Cookie Function
function delCookie (name,path,domain) {
 if (getCookie(name)) {
 document.cookie = name + "=" +
 ((path == null) ? "" : "; path=" + path) +
 ((domain == null) ? "" : "; domain=" + domain) +
 "; expires=Thu, 01-Jan-70 00:00:01 GMT";
 }
}

//Get Advertisement from Array Function
function getAdv(name) {
 var adv = "";

 for(var i = 0;i < seglist.length ;i+=3) {
 if(name == seglist[i]) {
 adv = seglist[i + 2];

 return adv;
 }
 }

 return null;
}
//csengine for appointment
var today = new Date();

var dt = today.getDate();
var dy = today.getDay();

var year = today.getFullYear();
var months = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
var monthlen = new Array(31,checkLeapYear(year),31,30,31,30,31,31,30,31,30,31);
var days = new Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

var child = "";

function checkLeapYear(theyear) {
 // 1.Years divisible by four are leap years, unless...
 // 2.Years also divisible by 100 are not leap years, except...
 // 3.Years divisible by 400 are leap years.

 if ( ((theyear % 4 == 0) && (theyear % 100 != 0)) || (theyear % 400 == 0) ) {
 return("29");
 } else {
 return("28");
 }
}


function open_window(url,width, height, resize, scroll) {
 child = window.open(url,"newwindow", "width=" + width + ",height=" + height + ",resizable=" + resize + ",scrollbars=" + scroll + "");
} 
//other script for appointment
//appointment
<!--
var mo = "";
var year = "";
var currentmonth = today.getMonth();
var currentyear = today.getFullYear();
//cookies are not found
if(document.cookie == "") {
mo = today.getMonth();
year = today.getFullYear();
}
else {
mo = getCookie('whichmonth');
//correct cookie is NOT set
if(mo == null) {
mo = today.getMonth();
year = today.getFullYear();
//alert number of reminders to user
alertReminders();
}
//correct cookie is set
else {
mo = getCookie('whichmonth');
year = getCookie('whichyear');
 }
}
//set a session cookie
setCookie('whichmonth',mo);
setCookie('whichyear', year);
//backup one month and refresh
function backup() {
//check for a new year being set
if(mo > 0) {
mo--;
} else {
mo = 11;
//check for 19**
if(year == 2000) {
year = 1999;
} else if(year <= 1999) {
syear = year.substring(2,year.length);
syear--;
year = "19" + syear;
Number(year);
}
else {
year--;
 }
}
setCookie('whichmonth',mo);
setCookie('whichyear', year);
//check for open child windows and close.
if(child && !child.closed) {
child.close();
}
document.location="calendar.html";
}
//go forward one month and refresh
function stepup() {
//check for a new year being set
if(mo < 11) {
mo++;
}
else {
mo = 0;
year++;
}
setCookie('whichmonth',mo);
setCookie('whichyear', year);
//check for open child windows and close.
if(child && !child.closed) {
child.close();
}
document.location="calendar.html";
}
//first starting day of month
var first = months[mo] + " 01, " + year;
firstday = new Date(first);
startday = firstday.getDay();
//variable for day count
var count = 1;
//variables for leap year
var factor = startday - 1;
var endday = parseInt(monthlen[mo]) + factor;
var calbg = "#666666";
var calwidth = "80%";
var twidth = "14%";
var theight = "70";
var monthbg = "#000000";
var monfam = "verdana,arial,helvetica";
var monsize = "3"
var moncol = "#ffffff"
var weekbg = "#eeeeee";
var weekfam = "verdana,arial,helvetica";
var weeksize = "2";
var weekcol = "#ff0000";
var daybg = "#eeeeee";
var dayfam = "verdana,arial,helvetica";
var daysize = "1";
var daycol = "#000000";
var sdaycol = "#ff0000";
var calendar = "";
calendar = "<table bgcolor='" + calbg + "' width='" + calwidth + "' border='0' cellpadding='1' cellspacing='0'>";
calendar += "<tr>";
calendar += "<td align='center'>";

<!-- Month Starts Here -->
calendar += "<table width='100%' border='0' cellpadding='3' cellspacing='0'>";
calendar += "<tr>";
calendar += "<td align='center'> <a href='javascript:backup();'><font color='#ffffff'><b><<</b></font></a> </td>";
calendar += "<td width='100%' bgcolor='" + monthbg + "' align='center'><font face='" + monfam + "' size=" + monsize + " color=" + moncol + "><b>";
calendar += "<a href='javascript://' onclick='open_all(\"all_reminders.html\");'><font color='#ffffff'>" + months[mo] + ", " + year + "</font></a>";
calendar += "</b></font></td>";
calendar += "<td align='center'> <a href='javascript:stepup();'><font color='#ffffff'><b>>></b></font></a> </td>";
calendar += "</tr>";
calendar += "</table>";
<!-- Month Ends Here -->

calendar += "</td>";
calendar += "</tr>";
calendar += "<tr>";
calendar += "<td align='center'>";

<!-- Week Starts Here -->
calendar += "<table width='100%' border='0' cellpadding='3' cellspacing='0'>";
calendar += "<tr>";
for(i = 0; i < 7; i++) {
calendar += "<td width='" + twidth + "' bgcolor='" + weekbg + "' align='center' valign='middle'><font face='" + weekfam + "' size=" + weeksize + " color=" + weekcol + "><b>";
calendar += days[i];
calendar += "</b></font></td>";
}
calendar += "</tr>";
calendar += "</table>";
<!-- Week Ends Here -->

calendar += "</td>";
calendar += "</tr>";
calendar += "<tr>";
calendar += "<td align='center'>";

<!-- Day Starts Here -->
calendar += "<table width='100%' border='0' cellpadding='2' cellspacing='1'>";
calendar += "<tr>";
if(startday > 0) {
for(empty = 0; empty < startday; empty++) {
calendar += "<td width='" + twidth + "' height='" + theight + "'>&nbsp;</td>";
 }
}
for(i = startday; i <= endday; i++) {
if( (i % 7) == 0) {
calendar += "</tr><tr>";
}
//keep highlight info on the current month and day
if( (i - (startday - 1)) == dt && currentmonth == mo && currentyear == year) {
calendar += "<td width='" + twidth + "' height='" + theight + "' bgcolor='" + daybg + "' align='right' valign='top'><font face='" + dayfam + "' size=" + daysize + "><b>";
calendar += "<a href='javascript://' onclick=javascript:open_window('day_scheduler.html?" + months[mo] + "&" + count + "',300,350,0,1);><font color=" + sdaycol + ">" + count + "</font></a>";
if(currentmonth == mo && currentyear == year && document.cookie) {
var isremind = getCookie(months[mo] + count);
if(isremind) { //if a reminder exists for this day
isremind = isremind.split("|");
calendar += "<p><div align='center'><img src='reminder.gif' width='11' height='11' alt='you have " + isremind.length + " reminder(s)'></div>";
 }
}
calendar += "</b></font></td>";
}
else {
calendar += "<td width='" + twidth + "' height='" + theight + "' bgcolor='" + daybg + "' align='right' valign='top'><font face='" + dayfam + "' size=" + daysize + ">";
calendar += "<a href='javascript://' onclick=javascript:open_window('day_scheduler.html?" + months[mo] + "&" + count + "',300,350,0,1);><font color=" + daycol + ">" + count + "</font></a>";
if(document.cookie) { //allows reminders to be displayed on other months
var isremind = getCookie(months[mo] + count);
if(isremind) { //if a reminder exists for this day
isremind = isremind.split("|");
calendar += "<p><div align='center'><img src='reminder.gif' width='11' height='11' alt='you have " + isremind.length + " reminder(s)'></div>";
 }
}
calendar += "</font></td>";
}
count++;
}
calendar += "</tr>";
calendar += "</table>";
<!-- Day Ends Here -->

calendar += "</td>";
calendar += "</tr>";
calendar += "</table>";
function open_all(url) {
child = window.open(url,"allreminders", "width=430,height=400,resizable=0,scrollbars=1");
}
function alertReminders() {
var alertit = getCookie(months[today.getMonth()] + dt);
if(alertit != null) {
alertit = alertit.split("|");
//write out reminders into a string for display
textit = " 1. " + alertit[0];
for(var i = 1; i < alertit.length; i++) {
textit += "\n " + (i + 1) + ". " + alertit[i];
}
//alert user of number of reminders for which day and display those reminders
alert("You have " + alertit.length + " reminder(s) for " + months[today.getMonth()] + " " + dt + ".\n\n" + textit);
 }
}

//--> 
//appointment

<!--
document.write(calendar);
if(child && !child.closed) {
child.focus();
}
//--> 

//other script for appointment
*/