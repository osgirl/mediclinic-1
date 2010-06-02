package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.domain.common.AppointmentForMonth;
import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;

public class TakeAppointmentController extends MediAppBaseController {
	CommonService commonService;

	
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		Person person =(Person)CommonWebUtil.getSessionAttribute(request,CommonWebConstants.USER_ID);
		int idPerson = person.getIdPerson();
		String sAppointmentDate = request.getParameter("AppointmentDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");	
		Date dateOfAppointment = null;
		if(null== sAppointmentDate){			
			dateOfAppointment = new Date();			
		}else{
			dateOfAppointment = dateFormat.parse(sAppointmentDate);
		}		
	    List <AppointmentForMonth> completeAppointmentList = commonService.getMonthAppointment(idPerson, dateOfAppointment);
	    System.out.println("size is "+completeAppointmentList.size());
	    Map < String , Object > appointmentMap = new HashMap < String , Object > ();
	    appointmentMap.put(CommonWebConstants.DAY_APPOINTMENT, completeAppointmentList);
	    appointmentMap.put("personID", idPerson);	    
	    return appointmentMap;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	

}
