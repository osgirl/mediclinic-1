function hide(menu){ 
	var menuStyle=document.getElementById(menu).style; 
	menuStyle.display="none";
} 
function show(menu) {
	var menuStyle=document.getElementById(menu).style; 
	menuStyle.display="block";
}
function fn_showPatientRgFrm(){	
	fn_hideDoctorRgFrm();
	var menuStyle=document.getElementById("PatientRegistrationForm").style; 
	menuStyle.display="block";
}
function fn_hidePatientRgFrm(){
	var menuStyle=document.getElementById("PatientRegistrationForm").style; 
	menuStyle.display="none";
}
function fn_showDoctorRgFrm(){
	fn_hidePatientRgFrm();
	var menuStyle=document.getElementById("DoctorRegistrationForm").style; 
	menuStyle.display="block";
}
function fn_hideDoctorRgFrm(){
	var menuStyle=document.getElementById("DoctorRegistrationForm").style; 
	menuStyle.display="none";
}
function fn_showMessage(){
	var menuStyle=document.getElementById("showMessage").style; 
	menuStyle.display="block";

}
