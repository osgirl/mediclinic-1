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
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.validation.Errors;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.DoctorSearch;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.web.common.CustomTimeEditor;
import com.mediapp.web.constants.common.CommonWebConstants;

public class UpdateAppointmentController extends MediAppBaseController{
	CommonService commonService;
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		Appointment ret = new Appointment();
		return ret;
	}
	@Override
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
		Appointment appointment = commonService.getAppointment(idAppointment);
		NotificationDetails notificationDetails = commonService.getNotificationDetails(idAppointment);
	    Map < String , Object > appointmentMap = new HashMap < String , Object > ();
	    appointmentMap.put(CommonWebConstants.DAY_APPOINTMENT, appointment);
	    appointmentMap.put("PersonID", idPerson);	    
	    appointmentMap.put("personID", idPerson);
	    appointmentMap.put("appointmentDate", dateOfAppointment);
	    appointmentMap.put("AppointmentID", idAppointment);	    
	    appointmentMap.put("Notification", notificationDetails);
	    String userName = request.getParameter("UserName");
	    appointmentMap.put("UserName", userName);
	    return appointmentMap;
	}

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		Appointment appointment = (Appointment) command;
		String sidAppointment = request.getParameter("AppointmentID");
		int idAppointment = Integer.parseInt(sidAppointment);
		appointment.setAppointmentID(idAppointment);
		commonService.updateAppointmentConfirmation(idAppointment, "Y");
		boolean status = commonService.updateDiagnosisAndTests(appointment);		
		return null;
    }

	
//	 protected ModelAndView processFormSubmission(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, BindException bindException) throws Exception {
//		 	Appointment a = (Appointment) object;		 	
//	        return new ModelAndView(getSuccessView(),CommonWebConstants.DAY_APPOINTMENT,object);
//	    }
	
	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
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
	

}
