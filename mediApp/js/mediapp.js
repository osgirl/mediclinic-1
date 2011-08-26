context =location.pathname.split("/")[1];

function fn_signUp(){
	var e = document.forms["appmentSignUp"].elements;
	if(e['password'].value != e['repassword'].value){
		alert("Passwords entered in the two fields are not same. Please enter it again.");
		e['repassword'].value = "";
		e['password'].value ="";
	}else{
		document.forms["appmentSignUp"].submit();
	}
}
function fn_login(){
	document.forms["appMentlogin"].submit();
}
function fn_showType(){
	var menuStyle=document.getElementById("TypeForm").style; 
	menuStyle.display="block";
}
function fn_openFile(fileName){
	window.open("/"+context+"/download.htm?file="+fileName,"download","location=0,status=0,toolbar=0,directories=0,resizable=0,scrollbars=1");
}
function fn_Print(type){
	if(type == 1){
		window.open("/"+context+"/generateMedicalReport.pdf?AppointmentID="+document.getElementById('AppointmentID').value,"Print","location=0,status=0,toolbar=0,directories=0,resizable=0,scrollbars=1");
	}else{
		window.open("/"+context+"/simpleReportCompile.pdf?AppointmentID="+document.getElementById('AppointmentID').value,"Print","location=0,status=0,toolbar=0,directories=0,resizable=0,scrollbars=1");
	}
	
}
function fn_showPatientRgFrm(){
	document.getElementById("Doctor").disabled =true;
	var menuStyle=document.getElementById("RegistrationForm").style; 
	document.getElementById("PersonType").value ="Patient";
	menuStyle.display="block";
	document.getElementById("hRegisterMe").value ="Y";
	document.getElementById("username").value = "";
	document.getElementById("password").value="";
	document.getElementById("LoginButton").disabled = true;
	document.getElementById("username").disabled = true;
	document.getElementById("password").disabled= true;
	document.getElementById("PersonType").disabled = true;
}
function fn_hidePatientRgFrm(){
	var menuStyle=document.getElementById("RegistrationForm").style; 
	menuStyle.display="none";
	document.getElementById("hRegisterMe").value ="N";

}
function fn_showDoctorRgFrm(){
	document.getElementById("Patient").disabled =true;
	document.getElementById("PersonType").value ="Doctor";
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
	document.getElementById("hPersonType").value=document.getElementById("PersonType").value;
	document.forms["logon"].submit();
}
function fn_submitLogin(){	
	document.getElementById('hPersonType').value=document.getElementById('PersonType').value;
}
function fn_nextURL(URL){	
	window.location.href = URL;
}
function fn_searchDoctor(){
	if(CkDate(document.getElementById('searchCriteria.dateOfAppointment'),'mm/dd/yyyy')){
		document.forms["searchDoctor"].submit();
	}
}

function CkDate(obj,format){
	 if (typeof(obj)=='string') obj=document.myform[obj];
	 var date=obj.value.split('/');
	 var mydate=new Date(date[2],date[(format.charAt(0)=='d')?1:0]-1,date[(format.charAt(0)=='d')?0:1]);
	 if (mydate<new Date().setHours(0,0,0,0)){
	  alert('Date cannot be past date.');
	  return false;
	 }
	 return true;
}
function CkDateValue(obj,format){
	 var date=obj.split('/');
	 var mydate=new Date(date[2],date[(format.charAt(0)=='d')?1:0]-1,date[(format.charAt(0)=='d')?0:1]);
	 if (mydate<new Date().setHours(0,0,0,0)){
	  alert('Date cannot be past date.');
	  return false;
	 }
	 return true;
}
function fn_dayAppointment(personID, userName){	
	 window.location.href = "/"+context+"/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+document.getElementById('searchCriteria.dateOfAppointment').value+"&UserName="+userName+"&TakeAppointment=Y";
}
function fn_createAppointment(personID,doctorID,timeOfAppointment,appointmentDate,userName,doctorPersonID){
	if(CkDateValue(appointmentDate,'mm/dd/yyyy')){		 
		if (userName !=""){
			window.name = "Parent";
			var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:400px;dialogWidth:630px;status:no;edge:sunken';	
			var url = "/"+context+'/createAppointment.htm?PersonID='+personID+"&DoctorID="+doctorID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment+"&UserName="+userName+"&DoctorPersonID="+doctorPersonID;
			var rurl= "/"+context+"/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+appointmentDate+"&UserName="+userName+"&TakeAppointment=Y";
			jQuery.showModalDialog({
				 url: url,
				 dialogArguments: null,
				 height: 500,
				 width: 900,
				 scrollable: false,
				 onClose: function(){  var returnedValue = this.returnValue;window.location.href=rurl;  }
			});


		}else{
			alert("We are sorry, there seems to be some issue with the appmate profile with whom you are trying to take appointment.");
		}
	}
}
var firstSubmit = 0;
function fn_addAppointment(){	
	document.getElementById('dateOfAppointment').disabled=false;
	document.getElementById('timeOfAppointment').disabled=false;
	if ((navigator.userAgent.indexOf("Chrome"))==-1) {
	document.forms['createAppointment'].target="Parent";
	}
	//window.close();
	var form=document.getElementById('createAppointment');
    form.setAttribute('target', 'iframeDialog');
    form.submit();
}
function fn_rescheduleAppointmentDate(){
	//window.close();
	document.getElementById('dateOfAppointment').disabled=false;
	document.getElementById('timeOfAppointment').disabled=false;
	var form=document.getElementById('rescheduleAppointment');
    form.setAttribute('target', 'iframeDialog');
    form.submit();
}
function fn_GetDayAppointment(indicator){
	var date = new Date(document.getElementById('AppointmentDate').value);
	window.name = "mySelf";
	document.forms['rescheduleAppointment'].target="mySelf";
	var currentMonth = date.getMonth()+1;
	if (indicator == 1){		
		var nextDay = date.getDate()-1;		
		document.getElementById('AppointmentDate').value = currentMonth+"/"+nextDay+"/"+ date.getFullYear();
	}
	if (indicator == 2){		
		var nextDay = date.getDate()+1;
		document.getElementById('AppointmentDate').value = currentMonth+"/"+nextDay+"/"+ date.getFullYear();		
	}
	document.forms['rescheduleAppointment'].method ="get";
	document.forms["rescheduleAppointment"].submit();
}
function fn_GetMonthAppointment(indicator){
	var date = new Date(document.getElementById('AppointmentDate').value);
	window.name = "mySelf";
	document.forms['rescheduleAppointment'].target="mySelf";
	if (indicator == 1){		
		document.getElementById('AppointmentDate').value = date.getMonth()+"/"+date.getDate()+"/"+ date.getFullYear();
	}
	if (indicator == 2){		
		var nextMonth = date.getMonth()+2;
		document.getElementById('AppointmentDate').value = nextMonth+"/"+date.getDate()+"/"+ date.getFullYear();
	}
	document.forms['rescheduleAppointment'].method ="get";
	document.forms["rescheduleAppointment"].submit();
}
function fn_GetDayAppointmentDayView(indicator){
	var date = new Date(document.getElementById('AppointmentDate').value);
	window.name = "mySelf";
	document.forms['dayAppointment'].target="mySelf";
	var currentMonth = date.getMonth()+1;
	if (indicator == 1){		
		var nextDay = date.getDate()-1;		
		document.getElementById('AppointmentDate').value = currentMonth+"/"+nextDay+"/"+ date.getFullYear();
	}
	if (indicator == 2){		
		var nextDay = date.getDate()+1;
		document.getElementById('AppointmentDate').value = currentMonth+"/"+nextDay+"/"+ date.getFullYear();		
	}
	document.forms['dayAppointment'].method ="get";
	document.forms["dayAppointment"].submit();
}
function fn_GetMonthAppointmentDayView(indicator){
	var date = new Date(document.getElementById('AppointmentDate').value);
	window.name = "mySelf";
	document.forms['dayAppointment'].target="mySelf";
	if (indicator == 1){		
		document.getElementById('AppointmentDate').value = date.getMonth()+"/"+date.getDate()+"/"+ date.getFullYear();
	}
	if (indicator == 2){		
		var nextMonth = date.getMonth()+2;
		document.getElementById('AppointmentDate').value = nextMonth+"/"+date.getDate()+"/"+ date.getFullYear();
	}
	document.forms['dayAppointment'].method ="get";
	document.forms["dayAppointment"].submit();
}
function fn_updateDateOfAppointment(timeOfAppointment,appointmentDate){
	if (CkDateValue(appointmentDate,'mm/dd/yyyy')){		
		document.getElementById('dateOfAppointment').value =appointmentDate;
		document.getElementById('timeOfAppointment').value =timeOfAppointment;
	}
}
function fn_GetMonthView(indicator){
	var date = new Date(document.getElementById('AppointmentDate').value);
	if (indicator == 1){		
		document.getElementById('AppointmentDate').value = date.getMonth()+"/01/"+ date.getFullYear();		
		document.forms["takeAppointment"].submit();
	}
	if (indicator == 2){	
		var nextMonth = date.getMonth()+2;
		document.getElementById('AppointmentDate').value = nextMonth+"/01/"+ date.getFullYear();		
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
function fn_openAppointment(takeAppointment){
	var personID = document.getElementById('PersonID').value;
	var appointmentDate=document.getElementById('AppointmentDateR').value;
    var appointmentID=document.getElementById('AppointmentID').value;    
    var timeOfAppointment=document.getElementById('TimeOfAppointment').value;		
    var UserName=document.getElementById('UserName').value;    
	window.name = "Parent";	
	var myObject = new Object();
	myObject.URL = '/dayAppointment.htm';
	var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:400px;dialogWidth:670px;status:no;edge:sunken';
	var url = "/"+context+'/updateAppointment.htm?PersonID='+personID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment+"&AppointmentID="+appointmentID+"&UserName="+UserName;	
	var rurl= "/"+context+"/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+appointmentDate+"&UserName="+UserName+"&TakeAppointment=N";
	jQuery.showModalDialog({
		 url: url,
		 dialogArguments: null,
		 height: 900,
		 width: 1000,
		 scrollable: false,
		 onClose: function(){  var returnedValue = this.returnValue;window.location.href=rurl;  }
	});
}
function fn_openAppointmentInbox(personID,appointmentDate,appointmentID,timeOfAppointment){
	window.name = "Parent";
	var myObject = new Object();
	myObject.URL = 'inbox.htm';
	var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:400px;dialogWidth:670px;status:no;edge:sunken';
	var url = '/updateAppointment.htm?PersonID='+personID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment+"&AppointmentID="+appointmentID;
	jQuery.showModalDialog({
		 url: url,
		 dialogArguments: null,
		 height: 500,
		 width: 900,
		 scrollable: false,
		 onClose: function(){  var returnedValue = this.returnValue;window.location.href="/"+context+"/inbox.htm";  }
	});
}
function fn_rescheduleAppointment(){
	window.name = "Parent";
	var personID = document.getElementById('PersonID').value;
	var appointmentDate=document.getElementById('AppointmentDateR').value;
    var appointmentID=document.getElementById('AppointmentID').value;    
    var timeOfAppointment=document.getElementById('TimeOfAppointment').value;		
    var UserName=document.getElementById('UserName').value;
	var WinSettings = 'scroll:no;help:0;center:yes;resizable:yes;dialogHeight:630px;dialogWidth:1000px;status:no;edge:sunken';	
	var url = "/"+context+'/rescheduleAppointment.htm?PersonID='+personID+"&AppointmentDate="+appointmentDate+"&AppointmentTime="+timeOfAppointment+"&AppointmentID="+appointmentID+"&UserName="+UserName;
	var rurl= "/"+context+"/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+appointmentDate+"&UserName="+UserName+"&TakeAppointment=N";
	jQuery.showModalDialog({
		 url: url,
		 dialogArguments: null,
		 height: 900,
		 width: 900,
		 scrollable: false,
		 onClose: function(){  var returnedValue = this.returnValue;window.location.href=rurl;  }
	});
}
function fn_confirmAppointment(){
	//window.close();
	var form=document.getElementById('updateAppointment');
    form.setAttribute('target', 'iframeDialog');
    form.submit();
}
function fn_deletePrescription(num){
	  var elSel = document.getElementById("diagnosis["+num+"].prescriptionList");
	  var i;
	  for (i = elSel.length - 1; i>=0; i--) {
	    if (elSel.options[i].selected) {
	      elSel.remove(i);
	    }
	  }
}
function fn_deleteFromList(listName){
	  var elSel = document.getElementById(listName);
	  var i;
	  for (i = elSel.length - 1; i>=0; i--) {
	    if (elSel.options[i].selected) {
	      elSel.remove(i);
	    }
	  }
}
function fn_deleteTest(num){
	  var elSel = document.getElementById("diagnosis["+num+"].testList");
	  var i;
	  for (i = elSel.length - 1; i>=0; i--) {
	    if (elSel.options[i].selected) {
	      elSel.remove(i);
	    }
	  }

}
function fn_updateAppointmentDetails(){

    var num = (document.getElementById("counter").value - 2) + 1 ;
    
    for(var j=0;j<num;j++) {    	
    	var elSel = document.getElementById("diagnosis["+j+"].codeICD");
    	  elSel.disabled = false;
    	var elSel = document.getElementById("diagnosis["+j+"].prescriptionList");
	  elSel.disabled = false;
  	  var elSel = document.getElementById("diagnosis["+j+"].testList");
  	  elSel.disabled = false;
	  for(var i = 0; i < document.getElementById("diagnosis["+j+"].prescriptionList").options.length; i++){
		     document.getElementById("diagnosis["+j+"].prescriptionList").options[i].selected = true;
	  }
	  for(var i = 0; i < document.getElementById("diagnosis["+j+"].testList").options.length; i++){
		     document.getElementById("diagnosis["+j+"].testList").options[i].selected = true;
	  }
															
  	  
    }
    
	//window.close();
	var form=document.getElementById('updateAppointment');
    form.setAttribute('target', 'iframeDialog');
    form.submit();


}

function fn_addToSelect(selectName,tempName){
	if(document.getElementById(tempName).value == ""){
		alert("Please enter the text to be added.");
		document.getElementById(tempName).focus();
	}else{
		var opt = document.createElement("OPTION");
	    document.getElementById(selectName).options.add(opt);
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
  var num = (document.getElementById("counter").value - 1) + 2 -1;
  numi.value = num;		
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  // if there's no header row in the table, then iteration = lastRow + 1
  var iteration = lastRow;
  var row = tbl.insertRow(lastRow);  
  if(num==1  ){
	  document.getElementById("diagnosis[0].codeICD").value= document.getElementById("finddiagnosis").value;
	  document.getElementById("diagnosis[0].codeICD").disabled=true;
	  for(var i = 0; i < document.getElementById("prescriptionList").options.length; i++){
		     var newElem = document.createElement("OPTION");
		     newElem.text = document.getElementById("prescriptionList").options[i].text;
		     newElem.value = document.getElementById("prescriptionList").options[i].value;
		     document.getElementById("diagnosis[0].prescriptionList").options.add(newElem);
		     document.getElementById("diagnosis[0].prescriptionList").options[i].selected = true;
		  }
	  document.getElementById("diagnosis[0].prescriptionList").disabled=true;
	  for(var i = 0; i < document.getElementById("testList").options.length; i++){
		     var newElem = document.createElement("OPTION");
		     newElem.text = document.getElementById("testList").options[i].text;
		     newElem.value = document.getElementById("testList").options[i].value;
		     document.getElementById("diagnosis[0].testList").options.add(newElem);
		     document.getElementById("diagnosis[0].testList").options[i].selected = true;
		  }
	  document.getElementById("diagnosis[0].testList").disabled=true;
	  num=num+1;
	  document.getElementById("counter").value  =num;
	  return true;
  }
  var cellLeft = row.insertCell(0);
  var el0 = document.createElement('input');
  el0.type = 'text';
  el0.name = "diagnosis[" + (num -1 )+ "].codeICD";
  el0.id = "diagnosis[" + (num -1 )+ "].codeICD";
  el0.size = 20;
  el0.setAttribute("disabled","true");  
  el0.style.background ="#cadef4";
  cellLeft.appendChild(el0);
  document.getElementById(el0.name).value= document.getElementById("finddiagnosis").value;

  // select cell
  var cellRightSel = row.insertCell(1);
  var sel = document.createElement("SELECT");
  sel.multiple =true;  
  sel.name = "diagnosis[" + (num -1 )+ "].prescriptionList" ;
  sel.id = "diagnosis[" + (num -1 )+ "].prescriptionList" ;
  sel.size = 3;	  
  sel.setAttribute("disabled","true");
  sel.style.width="15em";
  sel.style.background ="#cadef4";
  cellRightSel.appendChild(sel);
  for(var i = 0; i < document.getElementById("prescriptionList").options.length; i++){
     var newElem = document.createElement("OPTION");
     newElem.text = document.getElementById("prescriptionList").options[i].text;
     newElem.value = document.getElementById("prescriptionList").options[i].value;
     document.getElementById(sel.id).options.add(newElem);
     document.getElementById(sel.id).options[i].selected = true;
  }
  
  // select cell
  var cellRightSel = row.insertCell(2);
  var sel = document.createElement("SELECT");
  sel.multiple =true;  
  sel.name = "diagnosis[" + (num -1 )+ "].testList" ;
  sel.id = "diagnosis[" + (num -1 )+ "].testList" ;
  sel.size = 3;	  
  sel.setAttribute("disabled","true");
  sel.style.width="15em";
  sel.style.background ="#cadef4";
  cellRightSel.appendChild(sel);
  for(var i = 0; i < document.getElementById("testList").options.length; i++){
     var newElem = document.createElement("OPTION");
     newElem.text = document.getElementById("testList").options[i].text;
     newElem.value = document.getElementById("testList").options[i].value;
     document.getElementById(sel.id).options.add(newElem);
     document.getElementById(sel.id).options[i].selected = true;
  }
  num=num+1;
  document.getElementById("counter").value  =num;

//end
}
function removeRowFromTable()
{
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
  var num = (document.getElementById("counter").value - 2) + 1 ;
  //alert(document.getElementById("counter").value);
  document.getElementById("counter").value = num;
  //alert(document.getElementById("counter").value);
}

function deleteRow(tableID,form) {  
        var table = document.getElementById(tableID);
        var totalChkBoxs = form.deleteChk.length;
        for(var i=0; i<totalChkBoxs; i++) {  
            var row = table.rows[i+1];
            if(null != form.deleteChk && true == form.deleteChk[i].checked) {
                table.deleteRow(i+2);
                totalChkBoxs=totalChkBoxs-1;
            }
        }  
}  


function fn_uploadFile(){
	 window.name = "ParentWindow"; 
	 //var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:300px;dialogWidth:700px;status:no;edge:sunken'; 
    //var c = window.showModalDialog('/uploadFile.htm', window, WinSettings);
	var url = "/"+context+'/uploadFile.htm';
	var rurl= "/"+context+"/pastHistory.htm";
	jQuery.showModalDialog({
		 url: url,
		 dialogArguments: null,
		 height: 300,
		 width: 750,
		 scrollable: false,
		 onClose: function(){  var returnedValue = this.returnValue;window.location.href=rurl;  }
	});
    
}

function fn_deleteAllergy(){
	  var elSel = document.getElementById('allergies');
	  var i;
	  for (i = elSel.length - 1; i>=0; i--) {
	    if (elSel.options[i].selected) {
	      elSel.remove(i);
	    }
	  }

}
function fn_saveHistory(){
	//document.getElementById("allergies").disabled = false;
	  var elSel = document.getElementById('allergies');
	  var i;
	  for (i = elSel.length - 1; i>=0; i--) {
	   elSel.options[i].selected = true;
	  }

	document.forms['pastHistory'].submit();
}

function fn_uploadSelectedFile(){
	window.close();
	var form=document.getElementById('uploadFile');
    form.setAttribute('target', 'iframeDialog');
    form.submit();
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

function check_date(field){
	var checkstr = "0123456789";
	var DateField = field;
	var Datevalue = "";
	var DateTemp = "";
	var seperator = "/";
	var day;
	var month;
	var year;
	var leap = 0;
	var err = 0;
	var i;
	   err = 0;
	   DateValue = DateField.value;
	   /* Delete all chars except 0..9 */
	   for (i = 0; i < DateValue.length; i++) {
		  if (checkstr.indexOf(DateValue.substr(i,1)) >= 0) {
		     DateTemp = DateTemp + DateValue.substr(i,1);
		  }
	   }
	   DateValue = DateTemp;
	   /* Always change date to 8 digits - string*/
	   /* if year is entered as 2-digit / always assume 20xx */
	   if (DateValue.length == 6) {
	      DateValue = DateValue.substr(0,4) + '20' + DateValue.substr(4,2); }
	   if (DateValue.length != 8) {
	      err = 19;}
	   /* year is wrong if year = 0000 */
	   year = DateValue.substr(4,4);
	   if (year == 0) {
	      err = 20;
	   }
	   /* Validation of month*/
	   month = DateValue.substr(0,2);
	   if ((month < 1) || (month > 12)) {
	      err = 21;
	   }
	   /* Validation of day*/
	   day = DateValue.substr(2,2);
	   if (day < 1) {
	     err = 22;
	   }
	   /* Validation leap-year / february / day */
	   if ((year % 4 == 0) || (year % 100 == 0) || (year % 400 == 0)) {
	      leap = 1;
	   }
	   if ((month == 2) && (leap == 1) && (day > 29)) {
	      err = 23;
	   }
	   if ((month == 2) && (leap != 1) && (day > 28)) {
	      err = 24;
	   }
	   /* Validation of other months */
	   if ((day > 31) && ((month == "01") || (month == "03") || (month == "05") || (month == "07") || (month == "08") || (month == "10") || (month == "12"))) {
	      err = 25;
	   }
	   if ((day > 30) && ((month == "04") || (month == "06") || (month == "09") || (month == "11"))) {
	      err = 26;
	   }
	   /* if 00 ist entered, no error, deleting the entry */
	   if ((day == 0) && (month == 0) && (year == 00)) {
	      err = 0; day = ""; month = ""; year = ""; seperator = "";
	   }
	   /* if no error, write the completed date to Input-Field (e.g. 13.12.2001) */
	   if (err == 0) {
	      DateField.value = month + seperator + day + seperator + year;
	   }
	   /* Error-message if err != 0 */
	   else {
	      alert("Date is incorrect!");
	      DateField.select();
		  DateField.focus();
	   }
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
window.location.href = "/"+context+"/dayAppointment.htm?selectedDate="+myElement.children["calDateText"].innerText+"&selectedMpnth="+document.all("tbSelMonth").value+"&selectedYear="+document.all("tbSelYear").value; 
      }
   }
}
function getAppointment(personID,appointmentDate){	
	window.location.href = "/"+context+"/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+appointmentDate;	
}

function fn_moveDiv(event){
	x=event.clientX;
	y=event.clientY;
	//alert(x+","+y);
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

function fn_showReminder(){
	if(document.buttonimgdown.src==eval('cacheoffimgdown.src')){
		document.buttonimgdown.src=eval('cacheonimgdown.src');
		document.getElementById('remindme').style.display='block';
	}else{
		document.buttonimgdown.src=eval('cacheoffimgdown.src');
		document.getElementById('remindme').style.display='none';
	}
}
function fn_showMyReminder(){
	if(document.buttonimgdownM.src==eval('cacheoffimgdownM.src')){
		document.buttonimgdownM.src=eval('cacheonimgdownM.src');
		document.getElementById('remindMy').style.display='block';
	}else{
		document.buttonimgdownM.src=eval('cacheoffimgdownM.src');
		document.getElementById('remindMy').style.display='none';
	}
}


function fn_confirmIt(){	
	if(document.buttonimgdown1.src==eval('cacheoffimgdown1.src')){
		document.buttonimgdown1.src=eval('cacheonimgdown1.src');
		document.getElementById('confirmit').style.display='block';
	}else{
		document.buttonimgdown1.src=eval('cacheoffimgdown1.src');
		document.getElementById('confirmit').style.display='none';
	}
}

function showbox(event,a) {
	var e = event || window.event;
	 if (!e)
	   var e = window.event;
	   var linkID = e.srcElement? e.srcElement.id : this.id;
	   var helpbox = document.getElementById('helpbox');

	   //var pos = getRelativeCoordinates(event, document.getElementById('reference'));

	   //You can even attach Common Text for each helpbox/Tipbox to be displayed
	   //Note: here "Click here..." is a common text and will be displayed on top of every Tips displayed.
	   //Similarly You can even attach common code at the end of each helptext.
	   helpbox.innerHTML =  a;
	   helpbox.style.display = 'block';

	   var posx = (typeof e.pageX!= 'undefined')? e.pageX : e.clientX + (document.documentElement? document.documentElement.scrollLeft
	: document.body.scrollLeft);

	 var posy = (typeof e.pageY!= 'undefined')? e.pageY
	: e.clientY + (document.documentElement? document.documentElement.scrollTop
	: document.body.scrollTop);

	<!-- set x-axis and y-axis position for displaying helpbox/tipbox here -->
	helpbox.style.top = posy  + 'px';
	helpbox.style.left = posx + 'px';

	}


	<!-- code for hidding helpbox -->
	function hidebox() {
	 document.getElementById('helpbox').style.display = 'none';
	}


var displayTime, speed, wait, banner1, banner2, link1, link2, bannerIndex, bannerLocations, bannerURLs;

function initVar() {
  displayTime = 3; // The amount of time each banner will be displayed in seconds.
  speed = 5; // The speed at which the banners is moved (1 - 10, anything above 5 is not recommended).
  wait = true;

  banner1 = document.getElementById("banner1");
  banner2 = document.getElementById("banner2");
  link1 = document.getElementById("link1");
  link2 = document.getElementById("link2");

  banner1 = document.getElementById("banner1");
  banner2 = document.getElementById("banner2");

  banner1.style.left = 0;
  banner2.style.left = 500;

  bannerIndex = 1;

  /* Important: In order for this script to work properly, please make sure that the banner graphic and the
  URL associated with it have the same index in both, the bannerLocations and bannerURLs arrays.
  Duplicate URLs are permitted. */

  // Enter the location of the banner graphics in the array below.
  bannerLocations = new Array("/"+context+"/images/oie_shake_hands_concepts_3.jpg","/images/oie_medical.jpg");

  // Enter the URL's to which the banners will link to in the array below.
  bannerURLs = new Array("/"+context+"/appmentSignUp.htm","appmentSignUp.htm");
}

function moveBanner(){
  if(!wait){
    banner1.style.left = parseInt(banner1.style.left) -  (speed * 5);
    banner2.style.left = parseInt(banner2.style.left) - (speed * 5);
    if(parseInt(banner1.style.left) <= -500){
      banner1.style.left = 500;
      bannerIndex = (bannerIndex < (bannerLocations.length - 1)) ? ++bannerIndex :0;
      banner1.src = bannerLocations[bannerIndex];
      link1.href = bannerURLs[bannerIndex];
      wait = true;
    }
    if(parseInt(banner2.style.left) <= -500){
      banner2.style.left = 500;
      bannerIndex = (bannerIndex < (bannerLocations.length - 1)) ? ++bannerIndex :0;
      banner2.src = bannerLocations[bannerIndex];
      link2.href = bannerURLs[bannerIndex];
      wait = true;
    }

    setTimeout("moveBanner()",100);
  } else {
      wait = false;
      setTimeout("moveBanner()", displayTime * 1000);
  }
}


/**
 * Retrieve the absolute coordinates of an element.
 *
 * @param element
 *   A DOM element.
 * @return
 *   A hash containing keys 'x' and 'y'.
 */
function getAbsolutePosition(element) {
  var r = { x: element.offsetLeft, y: element.offsetTop };
  if (element.offsetParent) {
    var tmp = getAbsolutePosition(element.offsetParent);
    r.x += tmp.x;
    r.y += tmp.y;
  }
  return r;
};
 
/**
 * Retrieve the coordinates of the given event relative to the center
 * of the widget.
 *
 * @param event
 *   A mouse-related DOM event.
 * @param reference
 *   A DOM element whose position we want to transform the mouse coordinates to.
 * @return
 *    A hash containing keys 'x' and 'y'.
 */
function getRelativeCoordinates(event, reference) {
  var x, y;
  event = event || window.event;
  var el = event.target || event.srcElement;
 
  if (!window.opera && typeof event.offsetX != 'undefined') {
    // Use offset coordinates and find common offsetParent
    var pos = { x: event.offsetX, y: event.offsetY };
 
    // Send the coordinates upwards through the offsetParent chain.
    var e = el;
    while (e) {
      e.mouseX = pos.x;
      e.mouseY = pos.y;
      pos.x += e.offsetLeft;
      pos.y += e.offsetTop;
      e = e.offsetParent;
    }
 
    // Look for the coordinates starting from the reference element.
    var e = reference;
    var offset = { x: 0, y: 0 }
    while (e) {
      if (typeof e.mouseX != 'undefined') {
        x = e.mouseX - offset.x;
        y = e.mouseY - offset.y;
        break;
      }
      offset.x += e.offsetLeft;
      offset.y += e.offsetTop;
      e = e.offsetParent;
    }
 
    // Reset stored coordinates
    e = el;
    while (e) {
      e.mouseX = undefined;
      e.mouseY = undefined;
      e = e.offsetParent;
    }
  }
  else {
    // Use absolute coordinates
    var pos = getAbsolutePosition(reference);
    x = event.pageX  - pos.x;
    y = event.pageY - pos.y;
  }
  // Subtract distance to middle
  return { x: x, y: y };
}
 
window.onload = function () {
  //document.getElementById('more_clicky').onmousedown =
  //document.getElementById('other_clicky').onmousedown =
}

function fn_showDiagnosis(){
//	document.updateAppointment.diagnosis.disabled = false;
//	document.updateAppointment.findPrescription.disabled = false;
//	document.updateAppointment.prescriptionList.disabled = false;
//	document.updateAppointment.findTest.disabled = false;
//	document.updateAppointment.testList.disabled = false;
	var w, h, l, t;
	
	w = 700;
	h = 360;
	l = 100;
	t = 100;
	displayFloatingDiv('windowcontent', 'AppMent', w, h, l, t);
}

function fn_addDetails(){
	//document.updateAppointment.diagnosis.disabled = true;
	//document.updateAppointment.findPrescription.disabled = true;
	//document.updateAppointment.prescriptionList.disabled = true;
	//document.updateAppointment.findTest.disabled = true;
	//document.updateAppointment.testList.disabled = true;
	addRowToTable();
	hiddenFloatingDiv('windowcontent');
}

function fn_showOptions(event,loggedUserID,calendarUserID,appointmentTime,appointmentDate,appointmentID,confirmationIndicator){
    var e =event || window.event;   
    var pos = getRelativeCoordinates(e, document.getElementById('reference'));
    var r = document.getElementById('reference');
    var m = document.getElementById('movingDiv');
    if (loggedUserID == calendarUserID){
    	document.getElementById('confirm').style.display="none";
    	document.getElementById('propose').style.display="none";
    }else{
    	if(confirmationIndicator !='N'){
    		document.getElementById('confirm').style.display="none";
    	}else{
    		document.getElementById('open').style.display="none";
    	}
    	document.getElementById('reschedule').style.display="none";
    	document.getElementById('cancel').style.display="none";
    }    
    document.getElementById('AppointmentDateR').value=appointmentDate;
    document.getElementById('AppointmentID').value=appointmentID;
    document.getElementById('TimeOfAppointment').value=appointmentTime;    
    m.style.left = pos.x +'px' ;
    m.style.top = pos.y +'px';
	var menuStyle=document.getElementById('movingDiv').style; 
	menuStyle.display="block";

	
}

var commonPasswords = new Array('password', 'pass', '1234', '1246'); 
 
var numbers = "0123456789"; 
var lowercase = "abcdefghijklmnopqrstuvwxyz"; 
var uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
var punctuation = "!.@$£#*()%~<>{}[]"; 
 
function checkPassword(password) { 
 
    var combinations = 0; 
 
    if (contains(password, numbers) > 0) { 
        combinations += 10; 
    } 
 
    if (contains(password, lowercase) > 0) { 
        combinations += 26; 
    } 
 
    if (contains(password, uppercase) > 0) { 
        combinations += 26; 
    } 
 
    if (contains(password, punctuation) > 0) { 
        combinations += punctuation.length; 
    } 
 
    // work out the total combinations 
    var totalCombinations = Math.pow(combinations, password.length); 
 
    // if the password is a common password, then everthing changes... 
    if (isCommonPassword(password)) { 
        totalCombinations = 75000 // about the size of the dictionary 
    } 
 
    // work out how long it would take to crack this (@ 200 attempts per second) 
    var timeInSeconds = (totalCombinations / 200) / 2; 
 
    // this is how many days? (there are 86,400 seconds in a day. 
    var timeInDays = timeInSeconds / 86400 
 
    // how long we want it to last 
    var lifetime = 365; 
 
    // how close is the time to the projected time? 
    var percentage = timeInDays / lifetime; 
 
    var friendlyPercentage = cap(Math.round(percentage * 100), 100); 
    if (totalCombinations != 75000 && friendlyPercentage < (password.length * 5)) { 
        friendlyPercentage += password.length * 5; 
    } 
 
    var progressBar = document.getElementById("progressBar"); 
    progressBar.style.width = friendlyPercentage + "%"; 
 
    if (percentage > 1) { 
        // strong password 
        progressBar.style.backgroundColor = "#3bce08"; 
        return; 
    } 
 
    if (percentage > 0.5) { 
        // reasonable password 
        progressBar.style.backgroundColor = "#ffd801"; 
        return; 
    } 
 
    if (percentage > 0.10) { 
        // weak password 
        progressBar.style.backgroundColor = "orange"; 
        return; 
    } 
 
    // useless password! 
    if (percentage <= 0.10) { 
        // weak password 
        progressBar.style.backgroundColor = "red"; 
        return; 
    } 
 
 
} 
 
function cap(number, max) { 
    if (number > max) { 
        return max; 
    } else { 
        return number; 
    } 
} 
 
function isCommonPassword(password) { 
 
    for (i = 0; i < commonPasswords.length; i++) { 
        var commonPassword = commonPasswords[i]; 
        if (password == commonPassword) { 
            return true; 
        } 
    } 
 
    return false; 
 
} 
 
function contains(password, validChars) { 
 
    count = 0; 
 
    for (i = 0; i < password.length; i++) { 
        var char = password.charAt(i); 
        if (validChars.indexOf(char) > -1) { 
            count++; 
        } 
    } 
 
    return count; 
} 
 
 
 
//** Animated Collapsible DIV v2.0- (c) Dynamic Drive DHTML code library: http://www.dynamicdrive.com.
//** May 24th, 08'- Script rewritten and updated to 2.0.
//** June 4th, 08'- Version 2.01: Bug fix to work with jquery 1.2.6 (which changed the way attr() behaves).
//** March 5th, 09'- Version 2.2, which adds the following:
			//1) ontoggle($, divobj, state) event that fires each time a DIV is expanded/collapsed, including when the page 1st loads
			//2) Ability to expand a DIV via a URL parameter string, ie: index.htm?expanddiv=jason or index.htm?expanddiv=jason,kelly

//** March 9th, 09'- Version 2.2.1: Optimized ontoggle event handler slightly.
//** July 3rd, 09'- Version 2.4, which adds the following:
			//1) You can now insert rel="expand[divid] | collapse[divid] | toggle[divid]" inside arbitrary links to act as DIV togglers
			//2) For image toggler links, you can insert the attributes "data-openimage" and "data-closedimage" to update its image based on the DIV state

var animatedcollapse={
divholders: {}, //structure: {div.id, div.attrs, div.$divref, div.$togglerimage}
divgroups: {}, //structure: {groupname.count, groupname.lastactivedivid}
lastactiveingroup: {}, //structure: {lastactivediv.id}
preloadimages: [],

show:function(divids){ //public method
	if (typeof divids=="object"){
		for (var i=0; i<divids.length; i++)
			this.showhide(divids[i], "show")
	}
	else
		this.showhide(divids, "show")
},

hide:function(divids){ //public method
	if (typeof divids=="object"){
		for (var i=0; i<divids.length; i++)
			this.showhide(divids[i], "hide")
	}
	else
		this.showhide(divids, "hide")
},

toggle:function(divid){ //public method
	if (typeof divid=="object")
		divid=divid[0]
	this.showhide(divid, "toggle")
},

addDiv:function(divid, attrstring){ //public function
	this.divholders[divid]=({id: divid, $divref: null, attrs: attrstring})
	this.divholders[divid].getAttr=function(name){ //assign getAttr() function to each divholder object
		var attr=new RegExp(name+"=([^,]+)", "i") //get name/value config pair (ie: width=400px,)
		return (attr.test(this.attrs) && parseInt(RegExp.$1)!=0)? RegExp.$1 : null //return value portion (string), or 0 (false) if none found
	}
	this.currentid=divid //keep track of current div object being manipulated (in the event of chaining)
	return this
},

showhide:function(divid, action){
	var $divref=this.divholders[divid].$divref //reference collapsible DIV
	if (this.divholders[divid] && $divref.length==1){ //if DIV exists
		var targetgroup=this.divgroups[$divref.attr('groupname')] //find out which group DIV belongs to (if any)
		if ($divref.attr('groupname') && targetgroup.count>1 && (action=="show" || action=="toggle" && $divref.css('display')=='none')){ //If current DIV belongs to a group
			if (targetgroup.lastactivedivid && targetgroup.lastactivedivid!=divid) //if last active DIV is set
				this.slideengine(targetgroup.lastactivedivid, 'hide') //hide last active DIV within group first
				this.slideengine(divid, 'show')
			targetgroup.lastactivedivid=divid //remember last active DIV
		}
		else{
			this.slideengine(divid, action)
		}
	}
},

slideengine:function(divid, action){
	var $divref=this.divholders[divid].$divref
	var $togglerimage=this.divholders[divid].$togglerimage
	if (this.divholders[divid] && $divref.length==1){ //if this DIV exists
		var animateSetting={height: action}
		if ($divref.attr('fade'))
			animateSetting.opacity=action
		$divref.animate(animateSetting, $divref.attr('speed')? parseInt($divref.attr('speed')) : 500, function(){
			if ($togglerimage){
				$togglerimage.attr('src', ($divref.css('display')=="none")? $togglerimage.data('srcs').closed : $togglerimage.data('srcs').open)
			}
			if (animatedcollapse.ontoggle){
				try{
					animatedcollapse.ontoggle(jQuery, $divref.get(0), $divref.css('display'))
				}
				catch(e){
					alert("An error exists inside your \"ontoggle\" function:\n\n"+e+"\n\nAborting execution of function.")
				}
			}
		})
		return false
	}
},

generatemap:function(){
	var map={}
	for (var i=0; i<arguments.length; i++){
		if (arguments[i][1]!=null){ //do not generate name/value pair if value is null
			map[arguments[i][0]]=arguments[i][1]
		}
	}
	return map
},

init:function(){
	var ac=this
	jQuery(document).ready(function($){
		animatedcollapse.ontoggle=animatedcollapse.ontoggle || null
		var urlparamopenids=animatedcollapse.urlparamselect() //Get div ids that should be expanded based on the url (['div1','div2',etc])
		var persistopenids=ac.getCookie('acopendivids') //Get list of div ids that should be expanded due to persistence ('div1,div2,etc')
		var groupswithpersist=ac.getCookie('acgroupswithpersist') //Get list of group names that have 1 or more divs with "persist" attribute defined
		if (persistopenids!=null) //if cookie isn't null (is null if first time page loads, and cookie hasnt been set yet)
			persistopenids=(persistopenids=='nada')? [] : persistopenids.split(',') //if no divs are persisted, set to empty array, else, array of div ids
		groupswithpersist=(groupswithpersist==null || groupswithpersist=='nada')? [] : groupswithpersist.split(',') //Get list of groups with divs that are persisted
		jQuery.each(ac.divholders, function(){ //loop through each collapsible DIV object
			this.$divref=$('#'+this.id)
			if ((this.getAttr('persist') || jQuery.inArray(this.getAttr('group'), groupswithpersist)!=-1) && persistopenids!=null){ //if this div carries a user "persist" setting, or belong to a group with at least one div that does
				var cssdisplay=(jQuery.inArray(this.id, persistopenids)!=-1)? 'block' : 'none'
			}
			else{
				var cssdisplay=this.getAttr('hide')? 'none' : null
			}
			if (urlparamopenids[0]=="all" || jQuery.inArray(this.id, urlparamopenids)!=-1){ //if url parameter string contains the single array element "all", or this div's ID
				cssdisplay='block' //set div to "block", overriding any other setting
			}
			else if (urlparamopenids[0]=="none"){
				cssdisplay='none' //set div to "none", overriding any other setting
			}
			this.$divref.css(ac.generatemap(['height', this.getAttr('height')], ['display', cssdisplay]))
			this.$divref.attr(ac.generatemap(['groupname', this.getAttr('group')], ['fade', this.getAttr('fade')], ['speed', this.getAttr('speed')]))
			if (this.getAttr('group')){ //if this DIV has the "group" attr defined
				var targetgroup=ac.divgroups[this.getAttr('group')] || (ac.divgroups[this.getAttr('group')]={}) //Get settings for this group, or if it no settings exist yet, create blank object to store them in
				targetgroup.count=(targetgroup.count||0)+1 //count # of DIVs within this group
				if (jQuery.inArray(this.id, urlparamopenids)!=-1){ //if url parameter string contains this div's ID
					targetgroup.lastactivedivid=this.id //remember this DIV as the last "active" DIV (this DIV will be expanded). Overrides other settings
					targetgroup.overridepersist=1 //Indicate to override persisted div that would have been expanded
				}
				if (!targetgroup.lastactivedivid && this.$divref.css('display')!='none' || cssdisplay=="block" && typeof targetgroup.overridepersist=="undefined") //if this DIV was open by default or should be open due to persistence								
					targetgroup.lastactivedivid=this.id //remember this DIV as the last "active" DIV (this DIV will be expanded)
				this.$divref.css({display:'none'}) //hide any DIV that's part of said group for now
			}
		}) //end divholders.each
		jQuery.each(ac.divgroups, function(){ //loop through each group
			if (this.lastactivedivid && urlparamopenids[0]!="none") //show last "active" DIV within each group (one that should be expanded), unless url param="none"
				ac.divholders[this.lastactivedivid].$divref.show()
		})
		if (animatedcollapse.ontoggle){
			jQuery.each(ac.divholders, function(){ //loop through each collapsible DIV object and fire ontoggle event
				animatedcollapse.ontoggle(jQuery, this.$divref.get(0), this.$divref.css('display'))
			})
		}
 		//Parse page for links containing rel attribute
		var $allcontrols=$('a[rel]').filter('[rel^="collapse["], [rel^="expand["], [rel^="toggle["]') //get all elements on page with rel="collapse[]", "expand[]" and "toggle[]"
		$allcontrols.each(function(){ //loop though each control link
			this._divids=this.getAttribute('rel').replace(/(^\w+)|(\s+)/g, "").replace(/[\[\]']/g, "") //cache value 'div1,div2,etc' within identifier[div1,div2,etc]
			if (this.getElementsByTagName('img').length==1 && ac.divholders[this._divids]){ //if control is an image link that toggles a single DIV (must be one to one to update status image)
				animatedcollapse.preloadimage(this.getAttribute('data-openimage'), this.getAttribute('data-closedimage')) //preload control images (if defined)
				$togglerimage=$(this).find('img').eq(0).data('srcs', {open:this.getAttribute('data-openimage'), closed:this.getAttribute('data-closedimage')}) //remember open and closed images' paths
				ac.divholders[this._divids].$togglerimage=$(this).find('img').eq(0) //save reference to toggler image (to be updated inside slideengine()
				ac.divholders[this._divids].$togglerimage.attr('src', (ac.divholders[this._divids].$divref.css('display')=="none")? $togglerimage.data('srcs').closed : $togglerimage.data('srcs').open)
			}
			$(this).click(function(){ //assign click behavior to each control link
				var relattr=this.getAttribute('rel')
				var divids=(this._divids=="")? [] : this._divids.split(',') //convert 'div1,div2,etc' to array 
				if (divids.length>0){
					animatedcollapse[/expand/i.test(relattr)? 'show' : /collapse/i.test(relattr)? 'hide' : 'toggle'](divids) //call corresponding public function
					return false
				}
			}) //end control.click
		})// end control.each

		$(window).bind('unload', function(){
			ac.uninit()
		})
	}) //end doc.ready()
},

uninit:function(){
	var opendivids='', groupswithpersist=''
	jQuery.each(this.divholders, function(){
		if (this.$divref.css('display')!='none'){
			opendivids+=this.id+',' //store ids of DIVs that are expanded when page unloads: 'div1,div2,etc'
		}
		if (this.getAttr('group') && this.getAttr('persist'))
			groupswithpersist+=this.getAttr('group')+',' //store groups with which at least one DIV has persistance enabled: 'group1,group2,etc'
	})
	opendivids=(opendivids=='')? 'nada' : opendivids.replace(/,$/, '')
	groupswithpersist=(groupswithpersist=='')? 'nada' : groupswithpersist.replace(/,$/, '')
	this.setCookie('acopendivids', opendivids)
	this.setCookie('acgroupswithpersist', groupswithpersist)
},

getCookie:function(Name){ 
	var re=new RegExp(Name+"=[^;]*", "i"); //construct RE to search for target name/value pair
	if (document.cookie.match(re)) //if cookie found
		return document.cookie.match(re)[0].split("=")[1] //return its value
	return null
},

setCookie:function(name, value, days){
	if (typeof days!="undefined"){ //if set persistent cookie
		var expireDate = new Date()
		expireDate.setDate(expireDate.getDate()+days)
		document.cookie = name+"="+value+"; path=/; expires="+expireDate.toGMTString()
	}
	else //else if this is a session only cookie
		document.cookie = name+"="+value+"; path=/"
},

urlparamselect:function(){
	window.location.search.match(/expanddiv=([\w\-_,]+)/i) //search for expanddiv=divid or divid1,divid2,etc
	return (RegExp.$1!="")? RegExp.$1.split(",") : []
},

preloadimage:function(){
	var preloadimages=this.preloadimages
	for (var i=0; i<arguments.length; i++){
		if (arguments[i] && arguments[i].length>0){
			preloadimages[preloadimages.length]=new Image()
			preloadimages[preloadimages.length-1].src=arguments[i]
		}
	}
}

} 
 

// start new modal
var $dialog = null;

jQuery.showModalDialog = function(options) {

    var defaultOptns = {
        url: null,
        dialogArguments: null,
        height: 'auto',
        width: 'auto',
        position: 'center',
        resizable: true,
        scrollable: true,
        onClose: function() { },
        returnValue: null,
        doPostBackAfterCloseCallback: false,
        postBackElementId: null
    };

    var fns = {
        close: function() {
            opts.returnValue = $dialog.returnValue;
            $dialog = null;
            opts.onClose();
            if (opts.doPostBackAfterCloseCallback) {
                postBackForm(opts.postBackElementId);
            }
        },
        adjustWidth: function() { $frame.css("width", "100%"); }
    };

    // build main options before element iteration

    var opts = jQuery.extend({}, defaultOptns, options);

    var $frame = jQuery('<iframe id="iframeDialog" name="iframeDialog" />');

    if (opts.scrollable)
        $frame.css('overflow', 'auto');

    $frame.css({
        'padding': 0,
        'margin': 0,
        'padding-bottom': 10
    });

    var $dialogWindow = $frame.dialog({
        autoOpen: true,
        modal: true,
        width: opts.width,
        height: opts.height,
        resizable: opts.resizable,
        position: opts.position,
        overlay: {
            opacity: 0.5,
            background: "black"
        },
        close: fns.close,
        resizeStop: fns.adjustWidth
    });

    $frame.attr('src', opts.url);
    fns.adjustWidth();
    $frame.load(function() {
        if ($dialogWindow) {
            var maxTitleLength = 50;
            var title =jQuery(this).contents().find("title").html();
            if(title !=null){
	            if (title.length > maxTitleLength) {
	                title = title.substring(0, maxTitleLength) + '...';
	            }
	            $dialogWindow.dialog('option', 'title', title);
            }     
        }
    });

	    $dialog = new Object();
	    $dialog.dialogArguments = opts.dialogArguments;
	    $dialog.dialogWindow = $dialogWindow;
	    $dialog.returnValue = null;
}

function postBackForm(targetElementId) {
    var theform;
    theform = document.forms[0];
    theform.__EVENTTARGET.value = targetElementId;
    theform.__EVENTARGUMENT.value = "";
    theform.submit();
}


//end new modal
//close modal
var prntWindow = getParentWindowWithDialog(); //$(top)[0];

var $dlg = prntWindow && prntWindow.$dialog;

function getParentWindowWithDialog() {
	var p = window.parent;
	var previousParent = p;
	while (p != null) {
		if (jQuery(p.document).find('#iframeDialog').length) return p;

		p = p.parent;

		if (previousParent == p) return null;

		// save previous parent

		previousParent = p;
	}
	return null;
}

function setWindowReturnValue(value) {
	if ($dlg) $dlg.returnValue = value;
	window.returnValue = value; // in case popup is called using showModalDialog

}

function getWindowReturnValue() {
	// in case popup is called using showModalDialog

	if (!$dlg && window.returnValue != null)
		return window.returnValue;

	return $dlg && $dlg.returnValue;
}

if ($dlg) window.dialogArguments = $dlg.dialogArguments;
if ($dlg) window.close = function() { if ($dlg) $dlg.dialogWindow.dialog('close'); };
//END of dialog Required Code

function fn_close() {
    //setWindowReturnValue('The Return Value. And Passed Dialog Arguments: ' + window.dialogArguments);
	
	window.close();
    
  //   $dlg.dialogWindow.dialog('close');
}

//close modal

//diming
//************************************************************************************
//Copyright (C) 2006, Massimo Beatini
//
//This software is provided "as-is", without any express or implied warranty. In 
//no event will the authors be held liable for any damages arising from the use 
//of this software.
//
//Permission is granted to anyone to use this software for any purpose, including 
//commercial applications, and to alter it and redistribute it freely, subject to 
//the following restrictions:
//
//1. The origin of this software must not be misrepresented; you must not claim 
// that you wrote the original software. If you use this software in a product, 
// an acknowledgment in the product documentation would be appreciated but is 
// not required.
//
//2. Altered source versions must be plainly marked as such, and must not be 
// misrepresented as being the original software.
//
//3. This notice may not be removed or altered from any source distribution.
//
//************************************************************************************

//
//global variables
//
var isMozilla;
var objDiv = null;
var originalDivHTML = "";
var DivID = "";
var over = false;

//
//dinamically add a div to 
//dim all the page
//
function buildDimmerDiv()
{
 document.write('<div id="dimmer" class="dimmer" style="width:'+ window.screen.width + 'px; height:' + window.screen.height +'px"></div>');
}


//
//
//
function displayFloatingDiv(divId, title, width, height, left, top) 
{
	DivID = divId;

	document.getElementById('dimmer').style.visibility = "visible";

 document.getElementById(divId).style.width = width + 'px';
 document.getElementById(divId).style.height = height + 'px';
 document.getElementById(divId).style.left = left + 'px';
 document.getElementById(divId).style.top = top + 'px';
	
	var addHeader;
	
	if (originalDivHTML == "")
	    originalDivHTML = document.getElementById(divId).innerHTML;
	/*
	addHeader = '<table style="width:' + width + 'px" class="floatingHeader">' +
	            '<tr><td ondblclick="void(0);" onmouseover="over=true;" onmouseout="over=false;" style="cursor:move;height:18px">' + title + '</td>' + 
	            '<td style="width:18px" align="right"><a href="javascript:hiddenFloatingDiv(\'' + divId + '\');void(0);">' + 
	            '<img alt="Close..." title="Close..." src="/images/close.jpg" border="0"></a></td></tr></table>';
	*/
	//add to your div an header	
//	document.getElementById(divId).innerHTML = addHeader + originalDivHTML;
	
	
	document.getElementById(divId).className = 'dimming';
	document.getElementById(divId).style.visibility = "visible";


}


//
//
//
function hiddenFloatingDiv(divId) 
{
	//document.getElementById(divId).innerHTML = originalDivHTML;
	document.getElementById(divId).style.visibility='hidden';
	document.getElementById('dimmer').style.visibility = 'hidden';
	document.getElementById(divId).style.visibility = "hidden";
	DivID = "";
}

//
//
//
function MouseDown(e) 
{
 if (over)
 {
     if (isMozilla) {
         objDiv = document.getElementById(DivID);
         X = e.layerX;
         Y = e.layerY;
         return false;
     }
     else {
         objDiv = document.getElementById(DivID);
         objDiv = objDiv.style;
         X = event.offsetX;
         Y = event.offsetY;
     }
 }
}


//
//
//
function MouseMove(e) 
{
 if (objDiv) {
     if (isMozilla) {
         objDiv.style.top = (e.pageY-Y) + 'px';
         objDiv.style.left = (e.pageX-X) + 'px';
         return false;
     }
     else 
     {
         objDiv.pixelLeft = event.clientX-X + document.body.scrollLeft;
         objDiv.pixelTop = event.clientY-Y + document.body.scrollTop;
         return false;
     }
 }
}
function MouseUp() 
{
 objDiv = null;
}
function init()
{
 // check browser
 isMozilla = (document.all) ? 0 : 1;


 if (isMozilla) 
 {
     document.captureEvents(Event.MOUSEDOWN | Event.MOUSEMOVE | Event.MOUSEUP);
 }

 document.onmousedown = MouseDown;
 document.onmousemove = MouseMove;
 document.onmouseup = MouseUp;

 // add the div
 // used to dim the page
	buildDimmerDiv();

}

//call init
init();

//diming

function generateHistory(personID){
	
	window.open("/"+context+"/generateHistory.pdf?PatientID="+personID,"History","location=0,status=0,toolbar=0,directories=0,resizable=0,scrollbars=1");
}

function fn_updatePackage(){	
	admin.method="post";
	admin.submit(); 

}

function fn_populatePackage(){
	selObj = document.getElementById('packages');
	document.getElementById('personIDSel').value=document.getElementById('personID').value;
	for (var i = 0; i < selObj.length; i++)
		selObj.options[i].selected = false;

	admin.method="get";
	admin.submit(); 
	
}

var str =window.location.toString();
var htm = str.indexOf(".htm");
var sls = str.indexOf("/");
var sls = str.indexOf("/",(sls-1)+3);
var sls = str.indexOf("/",(sls-1)+3);
//alert(str.substring(sls,htm+4));
var url = str.substring(sls,htm+4);
if(null != url){
	document.getElementById(url).style.fontWeight ='900';
	document.getElementById(url).style.backgroundColor = "#CCCCB4";
}
function fn_easyBugs(){
	if(document.getElementById('easyBugDiv').style.display == 'none'){
		document.getElementById('easyBugDiv').style.display = 'block';	
	}else{
		document.getElementById('easyBugDiv').style.display = 'none';
	}
	 
	document.getElementById('if').src='http://www.easy-bugs.com/projects/appment/issues/new.widget';
}