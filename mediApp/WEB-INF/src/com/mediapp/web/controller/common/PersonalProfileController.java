package com.mediapp.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class PersonalProfileController extends MediAppBaseController  {
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)
	throws Exception {
		//Person person = (Person) command;
		Map < String , List > logonMap = new HashMap < String , List > ();
		Person person = (Person) CommonWebUtil.getSessionAttribute(request, CommonWebConstants.USER_ID);
//		logonMap.put("logonCriteria", );

		
		return logonMap;
	}
}