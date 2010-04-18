function hide(menu){ 
	var menuStyle=document.getElementById(menu).style; 
	menuStyle.display="none";
} 
function show(menu) {
	var menuStyle=document.getElementById(menu).style; 
	menuStyle.display="block";
}
function fn_showPatientRgFrm(){	
//	fn_hideDoctorRgFrm();
	var menuStyle=document.getElementById("RegistrationForm").style; 
	document.all("PersonType").selectedIndex = 1;
	menuStyle.display="block";
}
function fn_hidePatientRgFrm(){
	var menuStyle=document.getElementById("RegistrationForm").style; 
	menuStyle.display="none";
}
function fn_showDoctorRgFrm(){
	//fn_hidePatientRgFrm();
	document.all("PersonType").selectedIndex = 0;
	var menuStyle=document.getElementById("RegistrationForm").style; 
	menuStyle.display="block";
}
function fn_hideDoctorRgFrm(){
	var menuStyle=document.getElementById("RegistrationForm").style; 
	menuStyle.display="none";
}

function fn_showMessage(){
	document.getElementById("username").value="";
	document.getElementById("password").value="";
	var indexValue = document.all("PersonType").selectedIndex;
	document.getElementById("hPersonType").value=document.all("PersonType")[indexValue].value;
	//alert(document.getElementById("hPersonType").value);
	//document.all("personTypeString").value=document.all("PersonType")[indexValue].value;
	//alert(document.all("personTypeString").value);
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
	/* var form = document.forms['searchDoctor'];	   
	 var hidVar = document.createElement("input");
	 hidVar.type = "hidden";	 
	 hidVar.name = "PersonID";
	 hidVar.id = "PersonID";
	 hidVar.value = personID;
	 form.appendChild(hidVar);	 
	 hidVar.name = "AppointmentDate";
	 hidVar.id = "AppointmentDate";
	 hidVar.value = document.getElementById('dateOfAppointment').value;	 
	 form.appendChild(hidVar); 
	 window.method = "GET"; */
//	alert(<%=request.getContextPath()%>+"/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+document.getElementById('dateOfAppointment').value;);
//	var context = <%=request.getContextPath()%>;
//	alert("context"+context);
//	alert(document.getElementById('context').value);
	 window.location.href = "/dayAppointment.htm?PersonID="+personID+"&AppointmentDate="+document.getElementById('dateOfAppointment').value;
	 
	 
}

function fn_createAppointment(personID,appointmentDate){
	
	var myArgs=new Array();
	myArgs[0] = personID;
	myArgs[1] = appointmentDate;
	   
	var WinSettings = 'help:0;center:yes;resizable:yes;dialogHeight:430px;dialogWidth:630px;status:no;edge:sunken';
	alert(WinSettings );
    var c = window.showModalDialog('/createAppointment.htm', myArgs, WinSettings);

}
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