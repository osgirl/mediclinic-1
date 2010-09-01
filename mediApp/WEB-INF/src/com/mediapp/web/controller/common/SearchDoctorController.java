package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.business.LoginService;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.DoctorSearch;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;
import com.mediapp.web.common.CustomTimeEditor;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;

public class SearchDoctorController  extends MediAppBaseController  {
	LoginService loginService;
	CommonService commonService;
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)throws Exception {
		Map < String , Object > logonMap = new HashMap < String , Object > ();
		DoctorSearch doctorSearch = new DoctorSearch();
		doctorSearch.setSearchCriteria(new SearchCriteria());
		List <SearchResult> searchResult = new ArrayList<SearchResult>();
		searchResult.add(new SearchResult());
		doctorSearch.setSearchResult(searchResult);
		logonMap.put(CommonWebConstants.DOCTOR_SEARCH, doctorSearch);
		List <CodeDecode> personType = commonService.getCodeValue("PERSONTYPE");
		logonMap.put("personType", personType);		

		return logonMap;
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		DoctorSearch doctorSearch =  (DoctorSearch) command;		
		SearchCriteria searchCriteria =doctorSearch.getSearchCriteria();
		doctorSearch.setSearchResult(commonService.getDoctors(searchCriteria));	
		List <CodeDecode> personType = commonService.getCodeValue("PERSONTYPE");
		request.setAttribute("personType", personType);
		return new ModelAndView(getSuccessView(),CommonWebConstants.DOCTOR_SEARCH, doctorSearch);
    }
	
	protected void onBind(HttpServletRequest request, Object command, BindException errors) throws Exception {		
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

	
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	
	

}


