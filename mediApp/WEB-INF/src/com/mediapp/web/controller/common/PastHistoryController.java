package com.mediapp.web.controller.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.domain.common.PatientDetails;
import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;

public class PastHistoryController extends MediAppBaseController  {

	CommonService commonService;
	
	
	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)throws Exception {
		Map < String , Object > logonMap = new HashMap < String , Object > ();
		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		int idPerson = sessionPerson.getIdPerson(); 
		PatientDetails patientDetails = commonService.getPatientDetails(idPerson);
		Map < String , Object > rtnPatientDetails = new HashMap < String , Object > ();
		rtnPatientDetails.put(CommonWebConstants.PATIENT_DETAILS, patientDetails);
		return rtnPatientDetails;
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		PatientDetails patientDetails = (PatientDetails)command;
		boolean successFlag = commonService.updatePatientDetails(patientDetails);
		request.setAttribute("SuccessMessage", CommonWebConstants.SUCCESS);
		return new ModelAndView(getSuccessView(),CommonWebConstants.PATIENT_DETAILS, patientDetails);
	}
}
