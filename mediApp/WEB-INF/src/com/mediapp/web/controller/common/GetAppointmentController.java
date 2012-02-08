package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.mediapp.domain.common.AppointmentList;
import com.mediapp.domain.common.Person;
import com.mediapp.web.common.CustomTimeEditor;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;

public class GetAppointmentController extends MediAppBaseController{
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
	    return null;
	}

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{
		String sidPerson = request.getParameter("PersonID");
		int idPerson = Integer.parseInt(sidPerson);
		String sAppointmentDate = request.getParameter("AppointmentDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date dateOfAppointment = null;
		if(null== sAppointmentDate){
			dateOfAppointment = new Date();
		}else{
			dateOfAppointment = dateFormat.parse(sAppointmentDate);
		}
		AppointmentList completeAppointmentList = new AppointmentList();
		completeAppointmentList.setAppointmentList(commonService.getAppointments(idPerson, dateOfAppointment));
		return new ModelAndView(getFormView(),"appointments",completeAppointmentList);
    }

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
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


}
