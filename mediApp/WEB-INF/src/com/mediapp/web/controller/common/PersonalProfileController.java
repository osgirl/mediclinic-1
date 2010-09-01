package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.domain.common.Address;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.DoctorWorkTimings;
import com.mediapp.domain.common.Person;
import com.mediapp.web.common.CustomTimeEditor;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class PersonalProfileController extends MediAppBaseController  {
	LoginService loginService;
	
	CommonService commonService;
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)throws Exception {
		Person person = (Person) command;
		Map < String , Object > logonMap = new HashMap < String , Object > ();
		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);		
		person = commonService.getPersonalProfile(sessionPerson.getIdPerson());
		logonMap.put("person", person );
		List <CodeDecode> personType = commonService.getCodeValue("PERSONTYPE");
		logonMap.put("personType", personType);		
		return logonMap;
	}
	
	
	
/*protected Object formBackingObject(HttpServletRequest request) throws Exception {
		Person person = (Person) CommonWebUtil.getSessionAttribute(request, CommonWebConstants.USER_ID);
		return person;
	} */
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		Person person = (Person)command;
		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		person.setEmailID(sessionPerson.getEmailID());
		person.setUsername(sessionPerson.getUsername());
		if(null == person.getPersonTypeString() && "".equals(person.getPersonTypeString())){
			person.setPersonTypeString("AppMent");
		}
		//person.setPersonTypeString(sessionPerson.getPersonTypeString());
		boolean updateSuccess = loginService.updateProfile(person);
		person.setAuthenticated(true);
		request.getSession().removeAttribute(CommonWebConstants.USER_ID);
		CommonWebUtil.setSessionAttribute(request, CommonWebConstants.USER_ID, person);
		return new ModelAndView(getFormView(),CommonWebConstants.USER_ID, person);
	}
		
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		 String dateFormat = getMessageSourceAccessor().getMessage("format.date",
	     "MM/dd/yyyy");
		 SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		 df.setLenient(true);
		 binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
	     df, true));
		 String dateFormat1 = getMessageSourceAccessor().getMessage("format.date",
	     "HH:mm:ss");
		 SimpleDateFormat df1 = new SimpleDateFormat(dateFormat1);
		 df.setLenient(true);
		 binder.registerCustomEditor(java.sql.Time.class, new CustomTimeEditor(
	     df1, true));
		}
	
	protected void onBind(HttpServletRequest request, Object command, BindException errors) throws Exception {
		 Person logon = (Person) command;
		 //logon.getDoctorWorkTiming().remove(logon.getDoctorWorkTiming().size()-1);
		 for(DoctorWorkTimings eachTiming : logon.getDoctorWorkTiming()){			
		   if("Sunday".equals(eachTiming.getWorkDayName())){
		    logon.getDoctorDetails().setSundayWorking("Y");
		   }else if("Monday".equals(eachTiming.getWorkDayName())){
		    logon.getDoctorDetails().setMondayWorking("Y");
		   }else if("Tuesday".equals(eachTiming.getWorkDayName())){
		    logon.getDoctorDetails().setTuesdayWorking("Y");
		   }else if("Wednesday".equals(eachTiming.getWorkDayName())){
		    logon.getDoctorDetails().setWednesdayWorking("Y");
		   }else if("Thursday".equals(eachTiming.getWorkDayName())){
		    logon.getDoctorDetails().setThursdayWorking("Y");
		   }else if("Friday".equals(eachTiming.getWorkDayName())){
		    logon.getDoctorDetails().setFridayWorking("Y");
		   }else if("Saturday".equals(eachTiming.getWorkDayName())){
		    logon.getDoctorDetails().setSaturdayWorking("Y");
		   }
		 }  
		
		/*		Person logon = (Person) command;
		List errorsList = errors.getAllErrors();
		int i = 0;
		while(i < errorsList.size() ){
			System.out.println("error is "+ errorsList.get(i).toString());
			
		}
*/	
		//Person logon = (Person) command;
		//System.out.println("request value "+ request.getParameter("doctorWorkTiming[1].workDayName"));
		//System.out.println("controller values" + logon.getDoctorWorkTiming().get(0).getWorkDayName());
	//	String address1 = request.getParameter("address1");
	//	String address2 = request.getParameter("address2");	
	//	String locality = request.getParameter("locality");	
	//	String city = request.getParameter("city");	
	//	String state = request.getParameter("state");	
	//	String country = request.getParameter("country");
	//	String birthDate = request.getParameter("dateOOfBirth");
	//	if(null != birthDate && "" != birthDate) {
	//		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
	//		logon.setDateOfBirth(formatDate.parse(birthDate));
	//	}
	//	logon.setAddress(new Address());
	//	logon.getAddress().setAddress1(address1);
	//	logon.getAddress().setAddress2(address2);
	//	logon.getAddress().setLocality(locality);
	//	logon.getAddress().setCity(city);
	//	logon.getAddress().setState(state);
	//	logon.getAddress().setCountry(country);
	}

/*	public void initFormatters(DataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
		}*/

	
}