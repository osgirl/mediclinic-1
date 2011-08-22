package com.mediapp.web.controller.common;

import java.sql.Time;
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
import com.mediapp.domain.common.DoctorSearch;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.web.common.CustomTimeEditor;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;

public class CreateAppointmentController extends MediAppBaseController{
	CommonService commonService;
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
	
	
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		String sidPerson = request.getParameter("PersonID");		
		int idPerson = Integer.parseInt(sidPerson);		
		String sidDoctor = request.getParameter("DoctorID");		
		int idDoctor = Integer.parseInt(sidDoctor);
		String sAppointmentDate = request.getParameter("AppointmentDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Date dateOfAppointment = dateFormat.parse(sAppointmentDate);
	    String sAppointmentTime = request.getParameter("AppointmentTime");
	    Time timeOfAppointment = Time.valueOf(sAppointmentTime);
	    String userName = request.getParameter("UserName");
	    String doctorPersonID = request.getParameter("DoctorPersonID");	    
	    Person inputPerson = new Person();
	    inputPerson.setUsername(userName);
	    Person doctorPerson = commonService.getPersonDetails(inputPerson);
	    Map < String , Object > appointmentMap = new HashMap < String , Object > ();
	    Appointment appointment = new Appointment();
	    appointment.setDoctorID(idDoctor);
	    appointment.setDoctorPersonID(idPerson);	    
	    appointment.setDateOfAppointment(dateOfAppointment);
	    appointment.setTimeOfAppointment(timeOfAppointment);
	    appointmentMap.put("appointment", appointment);
	    appointmentMap.put("DoctorDetails", doctorPerson);
	    appointmentMap.put("UserName", userName);
	    List <CodeDecode> appointmentDuration = commonService.getCodeValue("APPOINTMENT_DURATION");
	    appointmentMap.put("appointmentDuration", appointmentDuration);
	    return appointmentMap;
	}

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		Appointment newAppointment =  (Appointment) command;
		String sidPerson = request.getParameter("PersonID");		
		int idPerson = Integer.parseInt(sidPerson);
		newAppointment.setDoctorPersonID(idPerson);
		Person patientPersonID = (Person)CommonWebUtil.getSessionAttribute(request, CommonWebConstants.USER_ID);
		newAppointment.setPatientPersonID(patientPersonID.getIdPerson());
		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);	
		newAppointment.setPatientPersonID(sessionPerson.getIdPerson());
		commonService.insertNewAppointment(newAppointment);
		sendeMail.scheduleNewAppointment(newAppointment);
		sendSMS.scheduleNewAppointment(newAppointment);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
		String sdate = sdf.format(newAppointment.getDateOfAppointment());
		request.setAttribute("SuccessMessage", CommonWebConstants.SUCCESS);
		return new ModelAndView(getSuccessView(),"appointment",newAppointment);
    }
	
@Override
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
