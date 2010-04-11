package com.mediapp.web.controller.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.core.common.dao.impl.MediAppBaseDAOImpl;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.LogonDomain;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class AppointmentPopUpController extends MediAppBaseController  {
	 
	private final Log logger = LogFactory.getLog(getClass());
	LoginService loginService;
	ScheduleEMail sendeMail;
	public ScheduleEMail getSendeMail() {
		return sendeMail;
	}
	public void setSendeMail(ScheduleEMail sendeMail) {
		this.sendeMail = sendeMail;
	}

	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)
	throws Exception {
	/*	Person logon = (Person) command;
		List <CodeDecode> logonPersonType = loginService.getPersonType();
		if (request.getSession().getAttribute("logonCriteria") == null) {
			request.getSession().setAttribute("logonCriteria", logonPersonType);
		}

		Map < String , List > logonMap = new HashMap < String , List > ();
		logonMap.put("logonCriteria", logonPersonType);
*/
		Map < String , List > logonMap = new HashMap < String , List > ();
		return logonMap;
	}
	
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {		
	//	Person person = loginService.authenticate((Person)command);
		try{
			response.flushBuffer();
			response.setContentType("text/html; charset=UTF-8");
		    PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
		    out.write("{\n");
		    out.write(" query:'Li',\n");
		    out.write(" suggestions:['Liberia','Libyan Arab Jamahiriya','Liechtenstein','Lithuania'],\n");
		    out.write(" data:['LR','LY','LI','LT']\n");
		    out.write("}\n");
		    out.flush();		    
		}catch (IOException e){
			System.out.println("AppointmentPopUpController.onSubmit()");
		}
		
		
		return new ModelAndView(getSuccessView());
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
	
	@Override
	protected void onBindAndValidate(HttpServletRequest request,
			Object command, BindException errors) throws Exception {
		// TODO Auto-generated method stub
		super.onBindAndValidate(request, command, errors);
	}
	
}
