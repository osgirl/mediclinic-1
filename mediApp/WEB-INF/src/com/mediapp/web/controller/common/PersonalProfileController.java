package com.mediapp.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class PersonalProfileController extends MediAppBaseController  {
	LoginService loginService;
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)throws Exception {
		//Person person = (Person) command;
		System.out.println("hi");
		Map < String , Object > logonMap = new HashMap < String , Object > ();
		Person person = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		System.out.println("person2"+person.getPersonTypeString());
		System.out.println("person2"+person.getUsername());		

		//Person person = loginService.authenticate(person)
		logonMap.put("person", person );
		

		
		return logonMap;
	}
	
	
	
/*protected Object formBackingObject(HttpServletRequest request) throws Exception {
		Person person = (Person) CommonWebUtil.getSessionAttribute(request, CommonWebConstants.USER_ID);
		System.out.println("person"+person.getFirstName());
		return person;
	} */
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		Person person = (Person)command;
		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		person.setEmailID(sessionPerson.getEmailID());
		person.setUsername(sessionPerson.getUsername());
		person.setPersonTypeString(sessionPerson.getPersonTypeString());
		loginService.updateProfile(person);
		return new ModelAndView(getFormView(),CommonWebConstants.USER_ID, person);
	}
		
	
}