package com.mediapp.core.common.business.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.AppointmentForMonth;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.DoctorWorkTimings;
import com.mediapp.domain.common.HolidayCalendarList;
import com.mediapp.domain.common.MultiPartFileUploadBean;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.PatientDetails;
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
	
	public List <Appointment> getDayAppointment(int idPerson,Date dateOfAppointment, String personType, int doctorID) {
		List <Appointment> appointmentList =commonDAO.getDayAppointment(idPerson, dateOfAppointment,personType, doctorID);
		 List<DoctorWorkTimings> workTimings =new ArrayList();
		 if (personType.equals("Take")){
			workTimings = commonDAO.getDoctorWorkTimingsForDay(idPerson, dateOfAppointment,doctorID);		
			long startTimingLong=0;	
			String startTiming=null;
			long endTimingLong=0;
			String endTiming=null;
			for(DoctorWorkTimings workTimingEach : workTimings){
				if(0 == startTimingLong){
					startTimingLong = workTimingEach.getStartTime().getTime();
					startTiming = workTimingEach.getStartTime().toString();
				}else{
					if ((workTimingEach.getStartTime().getTime() -startTimingLong) < 0){
						startTimingLong = workTimingEach.getStartTime().getTime();
						startTiming = workTimingEach.getStartTime().toString();
					} 
				}
				if(0 == endTimingLong){
					endTimingLong = workTimingEach.getEndTime().getTime();
					endTiming = workTimingEach.getEndTime().toString();
				}else{
					if(workTimingEach.getEndTime().getTime()-endTimingLong > 0){
						endTimingLong = workTimingEach.getEndTime().getTime();
						endTiming = workTimingEach.getEndTime().toString();
					}
				}
			}
			if(appointmentList.size()>0){
				appointmentList.get(0).setDoctorWorkStartTime(startTiming);
				appointmentList.get(0).setDoctorWorkEndTime(endTiming);
			}
		}else{
//			List <CodeDecode> workStartTiming = appmentCache.getcodeDecodeForCategory("WORKSTARTTIME");
//			List <CodeDecode> workEndTiming = appmentCache.getcodeDecodeForCategory("WORKENDTIME");
			if (appointmentList.size() > 0){
				appointmentList.get(0).setDoctorWorkStartTime(CommonCoreConstants.WORK_START_TIME);
				appointmentList.get(0).setDoctorWorkEndTime(CommonCoreConstants.WORK_END_TIME);
			}else{
				appointmentList = new ArrayList<Appointment>();	
				appointmentList.add(new Appointment());
				appointmentList.get(0).setDoctorWorkStartTime(CommonCoreConstants.WORK_START_TIME);
				appointmentList.get(0).setDoctorWorkEndTime(CommonCoreConstants.WORK_END_TIME);

			}
		}
		List <Appointment> completeAppointmentList = new ArrayList();
		if(appointmentList.size()>0){					
			Appointment eachAppointment = new Appointment();
			Time iTime = Time.valueOf(appointmentList.get(0).getDoctorWorkStartTime());
			Time appointmentEndTime = Time.valueOf("00:00:00"); 
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss"); 
			boolean workingOrNot =true;
			while (iTime.compareTo(Time.valueOf(appointmentList.get(0).getDoctorWorkEndTime()))<= 0){			
				eachAppointment.setTimeOfAppointment(iTime);
				if ( (iTime.getTime()-appointmentEndTime.getTime() >= 0)){
					for(Appointment loopAppointment:appointmentList){
						if (loopAppointment.getHeadline()!=null && iTime.compareTo(loopAppointment.getTimeOfAppointment())==0){
							eachAppointment.setAppointmentDuration(loopAppointment.getAppointmentDuration());
							eachAppointment.setHeadline(loopAppointment.getHeadline());
							eachAppointment.setComments(loopAppointment.getComments());					
							eachAppointment.setConfirmedIndicator(loopAppointment.getConfirmedIndicator());
							eachAppointment.setAppointmentID(loopAppointment.getAppointmentID());
							eachAppointment.setPatientPersonID(loopAppointment.getPatientPersonID());
							appointmentEndTime.setTime(loopAppointment.getAppointmentEndTime().getTime());
						}
						if(personType.equals(CommonCoreConstants.DOCTOR)){
							eachAppointment.setDoctorID(loopAppointment.getDoctorID());
						}
					}
					workingOrNot =true;
					for(DoctorWorkTimings eachWorkTiming:workTimings){
						if(iTime.compareTo(eachWorkTiming.getEndTime())>0){
							if(workingOrNot ){
								workingOrNot=false;
							}
						}else{
							if(!workingOrNot && iTime.compareTo(eachWorkTiming.getStartTime())>= 0){
								workingOrNot=true;
							}
						}
					}
					if(!workingOrNot){
						eachAppointment.setHeadline("OOO");
					}
				}else{
					eachAppointment.setHeadline("OOO");
				}	
				eachAppointment.setWorkingHour("N");
				for(DoctorWorkTimings workTimingEach : workTimings){
				    if ( workTimingEach.getStartTime().compareTo(iTime) > 0 && workTimingEach.getEndTime().compareTo(iTime) < 0){
				     eachAppointment.setWorkingHour("Y");
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
		}
		return completeAppointmentList;
		
	}
	public boolean insertNewAppointment(Appointment appointment){
		return commonDAO.insertNewAppointment(appointment);
	}

	public Person getPersonalProfile(int personID){
		return commonDAO.getPersonalProfile(personID);
	}
	
	public Appointment getAppointment( int idAppointment) {
		return commonDAO.getAppointment(idAppointment);
	}
	
	public List <CodeDecode> getCodeValue(String codeCategory){
		return commonDAO.getCodeValue(codeCategory);
	}

	@Override
	public List<AppointmentForMonth> getMonthAppointment(int idPerson,
			Date dateOfAppointment) {
		List<AppointmentForMonth>  appointmentForMonth = commonDAO.getMonthAppointment(idPerson, dateOfAppointment);
		String workDays = commonDAO.getWorkTimings(idPerson);
		String[] workdayList = workDays.split(",");
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
		int imonth = iimonth.intValue()-1;
		SimpleDateFormat sdf1;
		sdf1 = new SimpleDateFormat("yyyy");
		String syear =sdf1.format(date1);
		Integer iiyear = new Integer(syear);
		int iyear = iiyear.intValue();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	    int weekday = calendar.get(Calendar.DAY_OF_WEEK);
	    int iblank =1;
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
				calendar = Calendar.getInstance();
				calendar.set(Calendar.DAY_OF_MONTH,iday );
			    weekday = calendar.get(Calendar.DAY_OF_WEEK);
			    dayAppointment.setIsWorking(workdayList[weekday-1]);
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
				calendar = Calendar.getInstance();
				calendar.set(Calendar.DAY_OF_MONTH,iday );
			    weekday = calendar.get(Calendar.DAY_OF_WEEK);
			    dayAppointment.setIsWorking(workdayList[weekday-1]);
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
	
	public boolean updateDiagnosisAndTests(Appointment appointment) {
		return commonDAO.updateDiagnosisAndTests(appointment);
	}

	public PatientDetails getPatientDetails(int idPerson){
		return commonDAO.getPatientDetails(idPerson);
	}

	public boolean updatePatientDetails(PatientDetails patientDetails){
		return commonDAO.updatePatientDetails(patientDetails);
	}
	
	public List <CodeDecode> getCodeDecode(String codeCategory) {
		return commonDAO.getCodeDecode(codeCategory);
	}

	public HolidayCalendarList getHolidays(int idPerson){
		return commonDAO.getHolidays(idPerson);
	}
	
	public boolean insertHolidays(HolidayCalendarList holidayList) {
		boolean flag = true;
		flag = commonDAO.insertHolidays(holidayList);
		flag=commonDAO.cancelAllAppointments(holidayList.getIdDoctorPerson());
		return flag;
	}

	public boolean insertPatientDocumentDetials(MultiPartFileUploadBean fileDetails) {
		return commonDAO.insertPatientDocumentDetials(fileDetails);
	}
	
	public boolean updateAppointmentConfirmation (int appointmentID, String confirmationIndicator) {
		return commonDAO.updateAppointmentConfirmation(appointmentID, confirmationIndicator);
	}

	public List <CodeDecode> getDiagnosis(String code){
		return commonDAO.getDiagnosis(code);
	}

	public List <CodeDecode> getPrescription(String code){
		return commonDAO.getPrescription(code);
	}

	public List <CodeDecode> getTests(String code) {
		return commonDAO.getTests(code);
	}

	public boolean rescheduleAppointment(Appointment appointment){
		return commonDAO.rescheduleAppointment(appointment);
	}

	public Person getPersonDetails(Person person){
		return commonDAO.getPersonDetails(person);
	}
	
	public NotificationDetails getNotificationDetails(Integer appointmentID){
		return commonDAO.getNotificationDetails(appointmentID);
	}
	
	public List<List<Appointment>> getInbox(int  idPerson ) {
		return commonDAO.getInbox(idPerson);
	}

}
