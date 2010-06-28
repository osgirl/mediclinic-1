package com.mediapp.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;

import com.mediapp.domain.common.Diagnosis;
import com.mediapp.domain.common.HolidayCalendarList;
import com.mediapp.domain.common.Holidays;
import com.mediapp.web.constants.common.CommonWebConstants;

public class HolidayCalendarController extends MediAppBaseController  {
	
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
	    Map < String , Object > holidayMap = new HashMap < String , Object > ();
	    HolidayCalendarList holidayCalendar = new HolidayCalendarList();
	    List <Holidays> holiday = new ArrayList();
	    holidayCalendar.setHolidays(holiday);
	    holidayMap.put("holidayCalendar", holidayCalendar);
	    return holidayMap;

	}

}
