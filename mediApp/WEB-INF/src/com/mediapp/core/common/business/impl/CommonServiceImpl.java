package com.mediapp.core.common.business.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;

public class CommonServiceImpl implements CommonService{

	protected final Log logger = LogFactory.getLog(getClass());

	private CommonDAO commonDAO;

	public List <CodeDecode> getAutoComplete(String codeCategory,String code){
		return commonDAO.getAutoComplete( codeCategory,code);
		
	}

	public CommonDAO getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	public List <SearchResult> getDoctors(SearchCriteria searchCriteria){

		if (searchCriteria.getDateOfAppointment() == null){
			GregorianCalendar calendar = new GregorianCalendar();
			Date now = calendar.getTime();
			searchCriteria.setDateOfAppointment(now);			
		}
		
		return commonDAO.getDoctors(searchCriteria);
	}
	
	public List <Appointment> getDayAppointment(int idPerson,Date dateOfAppointment) {
		List <Appointment> appointmentList =commonDAO.getDayAppointment(idPerson, dateOfAppointment);
		
		List <Appointment> completeAppointmentList = new ArrayList();		
		Appointment eachAppointment = new Appointment();
		Time iTime = Time.valueOf(CommonCoreConstants.WORK_START_TIME);
		while (iTime.compareTo(Time.valueOf(CommonCoreConstants.WORK_END_TIME))<= 0){			
			eachAppointment.setTimeOfAppointment(iTime);
			for(Appointment loopAppointment:appointmentList){
				if (loopAppointment.getTimeOfAppointment().compareTo(iTime)==0){
					eachAppointment.setAppointmentDuration(loopAppointment.getAppointmentDuration());
					eachAppointment.setHeadline(loopAppointment.getHeadline());
					
				}
			}			
			completeAppointmentList.add(eachAppointment);
			eachAppointment = new Appointment();
			Calendar now = Calendar.getInstance();
			now.setTime((Time)iTime.clone());
			iTime = new Time(1);
			now.add(Calendar.MINUTE, CommonCoreConstants.INTERVAL_MINUTE);
			iTime.setTime(now.getTimeInMillis());
		}
		return completeAppointmentList;
		
	}
}
