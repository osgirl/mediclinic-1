package com.mediapp.web.constants.common;

public interface CommonWebConstants {

	String USER_ID = "person";
	
	String LOGIN_URL = "/logon.htm";
	
	String WELCOMEPAGE_URL = "/welcomePage.htm";
	
	String REG_EMAIL_TYPE = "registration";
	
	String CODE_CATEGORY = "codeCategory";
	
	String CODE_QUERY = "query";
	
	String SEARCH_RESULTS = "searchResults";
	
	String DOCTOR_SEARCH = "doctorSearch";
	
	String DAY_APPOINTMENT = "appointment";

	 // String MENU_TABLE_START_TAG = "  <tr><td><table width=100 align='left'  border='1' class='layout' > ";
	 
	 //String VERTICAL_MENU_BUTTON_TAG = "<tr><td><input type='button' onClick='javascript:fn_nextURL(";
	 String VERTICAL_MENU_BUTTON_TAG = "<tr><td style='background: url(/images/menubutton_0.png) no-repeat;overflow: hidden;background-position: top center;background-size: 100%;width:100%;height:40;'  align='center'><a href='javascript:void(0);' onClick='fn_nextURL(";
	 String QUOTES ="\""; 
	 
	 //String VERTICAL_MENU_BUTTON_AFTER_ONCLICK_TAG = " );' alignment='center' value='";
	 String VERTICAL_MENU_BUTTON_AFTER_ONCLICK_TAG =");' style='text-decoration:none;font: BOOK ANTIQUA;' ><font size='+1' color='blue' >";
//	 String VERTICAL_MENU_BUTTON_AFTER_VALUE_TAG = "' class='gsubmit'    /></td></tr> ";
	 String VERTICAL_MENU_BUTTON_AFTER_VALUE_TAG ="</font></a></td></tr><tr><td></td></tr>"; 
	// String MENU_TABLE_END_TAG = "</table></td></tr>";

	 String PATIENT_DETAILS = "patientDetails";

	 String DOCTOR = "Doctor";
}
