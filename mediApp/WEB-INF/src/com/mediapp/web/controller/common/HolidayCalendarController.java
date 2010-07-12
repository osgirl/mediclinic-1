package com.mediapp.web.controller.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


import com.mediapp.domain.common.HolidayCalendarList;
import com.mediapp.domain.common.Holidays;
import com.mediapp.web.common.CustomTimeEditor;
import com.mediapp.web.constants.common.CommonWebConstants;

public class HolidayCalendarController extends MediAppBaseController  {
 
 @Override
 protected Map referenceData(HttpServletRequest request, Object command,
   Errors errors) throws Exception {
  HolidayCalendarList holidays = (HolidayCalendarList)command;
     Map < String , Object > holidayMap = new HashMap < String , Object > ();
     HolidayCalendarList holidayCalendar = new HolidayCalendarList();
     List <Holidays> holiday = new ArrayList();
     for (Holidays h : holidays.getHolidays()){
      holiday.add(h);
     }
     int currentSize = holidays.getHolidays().size();
     for(int i =0;i < 5;i++){
      Holidays hld = new Holidays();
      holiday.add(hld);
     }
//     holidayCalendar.setHolidays(holiday);
     holidays.setHolidays(holiday);
     holidayMap.put("holidayCalendar", holidays);
     return holidayMap;
 }


 public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
  HolidayCalendarList holidays = (HolidayCalendarList)command;
     Map < String , Object > holidayMap = new HashMap < String , Object > ();
     HolidayCalendarList holidayCalendar = new HolidayCalendarList();
     List <Holidays> holiday = new ArrayList();
     for (Holidays h : holidays.getHolidays()){
      holiday.add(h);
     }
     int currentSize = holidays.getHolidays().size();
     for(int i =0;i < 5;i++){
      Holidays hld = new Holidays();
      holiday.add(hld);
     }
     holidays.setHolidays(holiday);
     holidayMap.put("holidayCalendar", holidays);
  
  return new ModelAndView(getSuccessView(),"holidayCalendar", holidays );
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

