package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.domain.common.Appointment;

public class DayAppointmentController extends MediAppBaseController{
	CommonService commonService;
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String sidPerson = request.getParameter("PersonID");
		int idPerson = Integer.parseInt(sidPerson);
		String sAppointmentDate = request.getParameter("AppointmentDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	    Date dateOfAppointment = dateFormat.parse(sAppointmentDate);
	    List <Appointment> completeAppointmentList = commonService.getDayAppointment(idPerson, dateOfAppointment);
		return completeAppointmentList;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	
	
}
