package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.domain.common.Appointment;
import com.mediapp.web.constants.common.CommonWebConstants;

public class DayAppointmentController extends MediAppBaseController{
	CommonService commonService;
	
	
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		String sidPerson = request.getParameter("PersonID");		
		int idPerson = Integer.parseInt(sidPerson);
		String sAppointmentDate = request.getParameter("AppointmentDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Date dateOfAppointment = dateFormat.parse(sAppointmentDate);
	    List <Appointment> completeAppointmentList = commonService.getDayAppointment(idPerson, dateOfAppointment);
	    Map < String , Object > appointmentMap = new HashMap < String , Object > ();
	    appointmentMap.put(CommonWebConstants.DAY_APPOINTMENT, completeAppointmentList);
	    return appointmentMap;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	
	
}
