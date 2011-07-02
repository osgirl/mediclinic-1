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


public class LoginController extends MediAppBaseController  {
	 
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
		Person logon = (Person) command;
		List <CodeDecode> logonPersonType = loginService.getPersonType();
		if (request.getSession().getAttribute("logonCriteria") == null) {
			request.getSession().setAttribute("logonCriteria", logonPersonType);
		}

		Map < String , List > logonMap = new HashMap < String , List > ();
		logonMap.put("logonCriteria", logonPersonType);

		
		return logonMap;
	}
	
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {		
		Person person = loginService.authenticate((Person)command);
		String personType = request.getParameter("hPersonType");

		if (null !=request ){	
		//	String eMailID = request.getParameter("emailID");
			String eMailID = person.getEmailID();
		//	person.setEmailID(eMailID);
			String isRegistering = request.getParameter("hRegisterMe");
			String SuccessMessage = "You have been registered. An email has been sent with password";			
			if (isRegistering.equals("Y")){		
					CodeDecode personCode = new CodeDecode();
					personCode.setCodeDecode(personType);
					person.setPersonType(personCode);
					boolean state =loginService.addNewMember(person);
					if(state){
						//sendeMail.send(eMailID, CommonWebConstants.REG_EMAIL_TYPE);
						sendeMail.scheduleRegistration(eMailID, CommonWebConstants.REG_EMAIL_TYPE,eMailID);
						sendSMS.scheduleRegistration(person.getCellPhoneNumber(), CommonWebConstants.REG_EMAIL_TYPE, person.getIdPerson());
					//	errorList.add("error.register.success");
						request.setAttribute("SuccessMessage", SuccessMessage);
						//CommonWebUtil.addErrorMessagesInReq(request, errorList);
						logger.info(" Login success!");					
				}					
					
				return new ModelAndView(getFormView(),CommonWebConstants.USER_ID, person);
			}
		}
		CommonWebUtil.setSessionAttribute(request, CommonWebConstants.USER_ID, person);		
		HttpSession sessionObj = request.getSession(true);
		sessionObj.setAttribute("menuItems", loginService.getMenuItems(person.getIdPerson()));
		if(person.getLastName()!= null){
			return new ModelAndView("redirect:/takeAppointment.htm",CommonWebConstants.USER_ID, person);	
		}else{
			return new ModelAndView("redirect:/personalProfile.htm",CommonWebConstants.USER_ID, person);
		}
		
    }
	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	protected void onBind(HttpServletRequest request, Object command, BindException errors) throws Exception {
		Person logon = (Person) command;
		String personType = request.getParameter("hPersonType");			
		logon.setPersonTypeString(personType);
	}
}
