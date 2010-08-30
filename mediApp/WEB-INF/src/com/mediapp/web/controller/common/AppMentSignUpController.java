package com.mediapp.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.core.common.business.impl.ScheduleSMS;
import com.mediapp.core.common.dao.impl.MediAppBaseDAOImpl;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.LogonDomain;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class AppMentSignUpController extends MediAppBaseController  {
	 
	private final Log logger = LogFactory.getLog(getClass());
	LoginService loginService;
	ScheduleEMail sendeMail;
	public ScheduleEMail getSendeMail() {
		return sendeMail;
	}
	public void setSendeMail(ScheduleEMail sendeMail) {
		this.sendeMail = sendeMail;
	}

	ScheduleSMS sendSMS;
	
	
	public ScheduleSMS getSendSMS() {
		return sendSMS;
	}
	public void setSendSMS(ScheduleSMS sendSMS) {
		this.sendSMS = sendSMS;
	}
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)
	throws Exception {
		Map < String , Object > signUpMap = new HashMap < String , Object > ();
		return signUpMap;
	}
	
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {		
		Person person = (Person)command;
		if (null !=request ){	
			String SuccessMessage = "Thank you for registering. An email has been sent with user name and password.You will be redirected to login page now...";			
					
					boolean state =loginService.addNewAppMentMember(person);
					if(state){
						sendeMail.scheduleRegistration(person.getEmailID(), CommonWebConstants.REG_EMAIL_TYPE,person.getUsername());
						request.setAttribute("SuccessMessage", SuccessMessage);
						logger.info(" Login success!");
						//person.setAuthenticated(true);
						//CommonWebUtil.setSessionAttribute(request, CommonWebConstants.USER_ID, person);		
						//HttpSession sessionObj = request.getSession(true);
					//	sessionObj.setAttribute("menuItems", loginService.getMenuItems(person.getPersonTypeString()));

				}					
			
		}
		return new ModelAndView(getFormView(),CommonWebConstants.USER_ID, person);
		
    }
	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
