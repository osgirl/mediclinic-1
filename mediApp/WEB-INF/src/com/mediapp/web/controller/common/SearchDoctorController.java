package com.mediapp.web.controller.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.web.constants.common.CommonWebConstants;

public class SearchDoctorController  extends MediAppBaseController  {
	LoginService loginService;
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)throws Exception {
		//Person person = (Person) command;
		Map < String , Object > logonMap = new HashMap < String , Object > ();
		Person person = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		List <CodeDecode> speciality = loginService.getSpecialities();
		if (request.getSession().getAttribute("speciality") == null) {
			request.getSession().setAttribute("speciality", speciality);
		}
		SearchCriteria searchCriteria = new SearchCriteria();
		logonMap.put("speciality", speciality);
		return logonMap;
	}


}
