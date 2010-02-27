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
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class LoginController extends MediAppBaseController  {
	 
	MediAppBaseDAOImpl dao;
	LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public Map referenceData(HttpServletRequest request,Object command,Errors errors){
		Person person = loginService.getPersonType();
		Map<String,Person> logon =  new HashMap < String, Person > () ;
		logon.put("personType",person );
		System.out.println("personType"+person.toString());
		return logon;
		
	}
	public ModelAndView onSubmit(Object command) throws ServletException {
        //return new ModelAndView(new RedirectView());
		return new ModelAndView(getSuccessView());
    }
	/**
	 * @param dao the dao to set
	 */
/*	public void setDao(MediAppBaseDAOImpl dao) {
//		this.dao = dao;
//		dao.testDBConnectivity();
	}
	*/
	public MediAppBaseDAOImpl getDao() {
		return dao;
	}
	public void setDao(MediAppBaseDAOImpl dao) {
		this.dao = dao;
	}
}
