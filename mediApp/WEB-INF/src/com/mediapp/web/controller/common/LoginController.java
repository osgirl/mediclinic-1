/**
 * 
 */
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
import com.mediapp.core.common.dao.impl.MediAppBaseDAOImpl;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.LogonDomain;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class LoginController extends MediAppBaseController  {
	 
	private final Log logger = LogFactory.getLog(getClass());
	LoginService loginService;
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		Person person = loginService.authenticate((Person)command);
		if (!person.isAuthenticated()) {
			 /*errors.rejectValue("password", "error.login.invalid",
                     null, "Invalid login");*/
			List<String> errorList = new ArrayList<String>();
			errorList.add("error.login.invalid");
			CommonWebUtil.addErrorMessagesInReq(request, errorList);
			 logger.info(" Login failed.");
			return new ModelAndView(getFormView(),CommonWebConstants.USER_ID, person);
		} else {
			CommonWebUtil.setSessionAttribute(request, CommonWebConstants.USER_ID, person);
		}
		return new ModelAndView(getSuccessView());
    }
	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
