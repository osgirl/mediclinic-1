package com.mediapp.web.controller.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.core.common.business.impl.ScheduleSMS;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;

public class InboxController extends MediAppBaseController{

	CommonService commonService;
	ScheduleEMail sendeMail;

	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		Person personID = (Person)CommonWebUtil.getSessionAttribute(request, CommonWebConstants.USER_ID);
		List <List<Appointment>> inboxList =		commonService.getInbox(personID.getIdPerson());
		Map < String , Object > inboxMap = new HashMap < String , Object > ();
		inboxMap.put("NeedConfirmation", inboxList.get(0));
		inboxMap.put("AppointmentNow", inboxList.get(1));
		inboxMap.put("personID", personID.getIdPerson());
		return inboxMap;
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		return null;
	}
	
	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

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
