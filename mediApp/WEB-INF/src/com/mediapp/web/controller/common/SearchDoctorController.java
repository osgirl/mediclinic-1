package com.mediapp.web.controller.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.business.LoginService;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;

public class SearchDoctorController  extends MediAppBaseController  {
	LoginService loginService;
	
	CommonService commonService;
	
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
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

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {		
		SearchCriteria searchCriteria = ((SearchCriteria)command);
		List <SearchResult> searchResults = commonService.getDoctors(searchCriteria);
		return new ModelAndView(getSuccessView(),CommonWebConstants.SEARCH_RESULTS, searchResults);
    }

}
