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
	var indexValue = document.all("PersonType").selectedIndex;
	document.getElementById("hPersonType").value=document.all("PersonType")[indexValue].value;
	//alert(document.getElementById("hPersonType").value);
	document.forms["logon"].submit();
}
