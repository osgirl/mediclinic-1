package com.mediapp.web.controller.common;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.domain.common.Appointment;
import com.mediapp.web.constants.common.CommonWebConstants;

public class CreateAppointmentController extends MediAppBaseController{
	CommonService commonService;
	
	
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		String sidPerson = request.getParameter("PersonID");		
		int idPerson = Integer.parseInt(sidPerson);
		System.out.println("Doc is"+ sidPerson);
		String sAppointmentDate = request.getParameter("AppointmentDate");
		System.out.println("Doc is 1 "+ sAppointmentDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Date dateOfAppointment = dateFormat.parse(sAppointmentDate);
	    String sAppointmentTime = request.getParameter("AppointmentTime");
	    System.out.println("Doc is 2 "+ sAppointmentTime);
	    Time timeOfAppointment = Time.valueOf(sAppointmentTime);
	    //List <Appointment> completeAppointmentList = commonService.getDayAppointment(idPerson, dateOfAppointment);
	    Map < String , Object > appointmentMap = new HashMap < String , Object > ();
	    //appointmentMap.put(CommonWebConstants.DAY_APPOINTMENT, completeAppointmentList);
	    //appointmentMap.put("personID", idPerson);
	    //appointmentMap.put("appointmentDate", dateOfAppointment);
	    //appointmentMap.put("appointmentTime", sAppointmentTime);
	    Appointment appointment = new Appointment();
	    appointment.setDoctorID(idPerson);
	    appointment.setDateOfAppointment(dateOfAppointment);
	    appointment.setTimeOfAppointment(timeOfAppointment);
	    System.out.println("time is "+ appointment.getTimeOfAppointment());
	    appointmentMap.put("appointment", appointment);
	    return appointmentMap;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

}
