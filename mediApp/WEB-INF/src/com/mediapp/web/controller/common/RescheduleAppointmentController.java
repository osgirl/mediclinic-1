package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.core.common.business.impl.ScheduleSMS;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.web.common.CustomTimeEditor;
import com.mediapp.web.constants.common.CommonWebConstants;

public class RescheduleAppointmentController extends MediAppBaseController{
	
	CommonService commonService;

	
	public CommonService getCommonService() {
		return commonService;
	}


	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}


	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		String sidPerson = request.getParameter("PersonID");		
		int idPerson = Integer.parseInt(sidPerson);		
		String sidAppointment = request.getParameter("AppointmentID");		
		int idAppointment = Integer.parseInt(sidAppointment);
		String sAppointmentDate = request.getParameter("AppointmentDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		
		Date dateOfAppointment = null;
		if(null== sAppointmentDate){			
			dateOfAppointment = new Date();			
		}else{
			dateOfAppointment = dateFormat.parse(sAppointmentDate);
		}		
		Appointment appointment = commonService.getAppointment(idPerson, dateOfAppointment,idAppointment);		
		List <Appointment> completeAppointmentList = commonService.getDayAppointment(idPerson, dateOfAppointment,CommonWebConstants.DOCTOR,appointment.getDoctorID());
	    Map < String , Object > appointmentMap = new HashMap < String , Object > ();
	    appointmentMap.put(CommonWebConstants.DAY_APPOINTMENT, appointment);
	    appointmentMap.put("dayAppointment", completeAppointmentList);
	    appointmentMap.put("PersonID", idPerson);	    
	    appointmentMap.put("AppointmentDate", dateOfAppointment);
	    appointmentMap.put("AppointmentID", idAppointment);
	    List <CodeDecode> appointmentDuration = commonService.getCodeValue("APPOINTMENT_DURATION");
	    appointmentMap.put("appointmentDuration", appointmentDuration);
	    return appointmentMap;

	}

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		Appointment appointment = (Appointment) command;
		String sidAppointment = request.getParameter("AppointmentID");		
		int idAppointment = Integer.parseInt(sidAppointment);
		appointment.setAppointmentID(idAppointment);
		boolean status = commonService.rescheduleAppointment(appointment);
		sendeMail.scheduleRescheduleAppointment(appointment);
		sendSMS.scheduleRescheduleAppointment(appointment);

		return null;
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


	
	ScheduleEMail sendeMail;
	public ScheduleEMail getSendeMail() {
		return sendeMail;
	}
	public void setSendeMail(ScheduleEMail sendeMail) {
		this.sendeMail = sendeMail;
	}

	ScheduleSMS sendSMS;
	
	
	public ScheduleSMS getSendSMS() {
		return sendSMS;
	}
	public void setSendSMS(ScheduleSMS sendSMS) {
		this.sendSMS = sendSMS;
	}


}
