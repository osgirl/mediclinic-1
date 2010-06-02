package com.mediapp.core.common.business.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.mediapp.domain.common.AppointmentForMonth;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
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
		Time iTime = Time.valueOf(appointmentList.get(0).getDoctorWorkStartTime());
		while (iTime.compareTo(Time.valueOf(appointmentList.get(0).getDoctorWorkEndTime()))<= 0){			
			eachAppointment.setTimeOfAppointment(iTime);
			for(Appointment loopAppointment:appointmentList){
				if (loopAppointment.getTimeOfAppointment().compareTo(iTime)==0){
					eachAppointment.setAppointmentDuration(loopAppointment.getAppointmentDuration());
					eachAppointment.setHeadline(loopAppointment.getHeadline());					
				}
				eachAppointment.setDoctorID(loopAppointment.getDoctorID());
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
	public boolean insertNewAppointment(Appointment appointment){
		return commonDAO.insertNewAppointment(appointment);
	}

	public Person getPersonalProfile(int personID){
		return commonDAO.getPersonalProfile(personID);
	}
	
	public Appointment getAppointment(int idPerson,Date dateOfAppointment) {
		return commonDAO.getAppointment(idPerson, dateOfAppointment);
	}
	
	public List <CodeDecode> getCodeValue(String codeCategory){
		return commonDAO.getCodeValue(codeCategory);
	}

	@Override
	public List<AppointmentForMonth> getMonthAppointment(int idPerson,
			Date dateOfAppointment) {
		List<AppointmentForMonth>  appointmentForMonth = commonDAO.getMonthAppointment(idPerson, dateOfAppointment);
		List <AppointmentForMonth> completeAppointmentList = new ArrayList();
		AppointmentForMonth dayAppointment = new AppointmentForMonth();
		Calendar calendar = Calendar.getInstance();
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int iday = 1;
		Date date1 = dateOfAppointment;
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("MM");
		String smonth =sdf.format(date1);
		Integer iimonth = new Integer(smonth);
		int imonth = iimonth.intValue();
		SimpleDateFormat sdf1;
		sdf1 = new SimpleDateFormat("yyyy");
		String syear =sdf1.format(date1);
		Integer iiyear = new Integer(syear);
		int iyear = iiyear.intValue();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	    int weekday = calendar.get(Calendar.DAY_OF_WEEK);
	    int iblank =0;
	    while(iblank < weekday){
	    	//Calendar idummyc = Calendar.getInstance();
	    	//idummyc.set(1999, 12, 31);
	    	//dayAppointment.setDateOfAppointment(idummyc.getTime());
	    	completeAppointmentList.add(dayAppointment);
	    	dayAppointment = new AppointmentForMonth();
	    	iblank=iblank+1;
	    }
		if(appointmentForMonth== null){
			while (iday <=days){
				Calendar icalendar = Calendar.getInstance();
				icalendar.set(iyear, imonth, iday);
				Date setDate = icalendar.getTime();			
				dayAppointment.setDateOfAppointment(setDate);
				dayAppointment.setAppointmentCount(0);
				completeAppointmentList.add(dayAppointment);
				dayAppointment = new AppointmentForMonth();
				iday = iday+1;
			}

		}else{
			while (iday <=days){
				Calendar icalendar = Calendar.getInstance();
				icalendar.set(iyear, imonth, iday);
				Date setDate = icalendar.getTime();			
				dayAppointment.setDateOfAppointment(setDate);
				dayAppointment.setAppointmentCount(0);
				for(AppointmentForMonth loopappointmentForMonth : appointmentForMonth){
					Calendar date = Calendar.getInstance();
					date.setTime(loopappointmentForMonth.getDateOfAppointment());
					int currentDay = date.get(Calendar.DATE);
					if(currentDay == iday){
						dayAppointment.setAppointmentCount(loopappointmentForMonth.getAppointmentCount());
					}				
				}
				completeAppointmentList.add(dayAppointment);
				dayAppointment = new AppointmentForMonth();
				iday = iday+1;
			}
		}
		return completeAppointmentList;
	}
}
