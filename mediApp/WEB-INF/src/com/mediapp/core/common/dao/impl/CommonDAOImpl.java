package com.mediapp.core.common.dao.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.AppointmentForMonth;
import com.mediapp.domain.common.AppointmentTO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Diagnosis;
import com.mediapp.domain.common.DoctorWorkTimings;
import com.mediapp.domain.common.HolidayCalendarList;
import com.mediapp.domain.common.Holidays;
import com.mediapp.domain.common.MultiPartFileUploadBean;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.PatientDetails;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.ScheduleJob;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;



public class CommonDAOImpl extends MediAppBaseDAOImpl implements CommonDAO {

	public Person getPersonDetails(Person person) throws DataAccessException {
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Key", person.getKey());
		criteria.put("Username", person.getUsername());
		return (Person) getObject("common.authenticateUser", criteria);
	}

	public List <CodeDecode> getPersonType() throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", "PERSON_TY");
		List <CodeDecode> CodeValueList =  new ArrayList() ;
		try{
			List <String>codeValuesString= (ArrayList<String>) getList("common.getPersonType",criteria );
			for(String eachCodeValue : codeValuesString){
				CodeDecode codeValue = new CodeDecode();
				codeValue.setCodeDecode(eachCodeValue);
				CodeValueList.add(codeValue);
			}
		}catch(DataAccessException se){
			System.out.println(se.toString());
			System.err.println("stacktrace"+se);
		}
		return CodeValueList;
	}

	public int checkIfeMailExists(Person person)  throws DataAccessException {

		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("emailID", person.getEmailID());
		Integer countOfeMail = null;
		countOfeMail = (Integer) getObject("common.checkeMailExists",criteria );
		
		return countOfeMail.intValue();
	}
	
	public boolean addNewMember(Person person) throws DataAccessException {
			person.setPersonTypeString(person.getPersonType().getCodeDecode());
			person.setPassword("mediApp");			
			boolean insertStatus = false;
			Map<String,Object> criteria =  new HashMap < String, Object > () ;
			criteria.put("SequenceName","s_person_id" );
			Integer personID =  (Integer)getObject("common.getNextVal",criteria );
			person.setIdPerson(personID.intValue());
			insertStatus=insertObject("common.insertNewPerson",person );
			if (insertStatus){
				if (person.getPersonTypeString().equals(CommonCoreConstants.DOCTOR)){
					insertStatus= insertObject("common.insertDoctor",person );
				}else{
					insertStatus=insertObject("common.insertPatient",person );
				}
				person.setUsername(person.getEmailID());
				Person personNew = getPersonDetails(person);
				person.setIdPerson(personNew.getIdPerson());
			}
			return insertStatus;
	}
	
	public int getMaxPersonId() throws DataAccessException {
		return (Integer) getObject("common.maxPersonId", null);
	}
	
	public boolean updateProfile(Person person)throws DataAccessException{
 		int count = updateObject("common.updateProfile", person);
 		boolean flag=false;
 		if (count > 0){
 			flag = true;
 		}
		return flag;
	}
	
	public boolean insertAddress(Person person)throws DataAccessException{
		int count=updateObject("common.insertAddress", person);
 		boolean flag=false;
 		if (count > 0){
 			flag = true;
 		}
		return flag;
	}

	public List <CodeDecode> getCodeValue(String codeCategory) throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", codeCategory);
		List <CodeDecode> CodeValueList =  new ArrayList() ;
		try{
			List <String>codeValuesString= (ArrayList<String>) getList("common.getPersonType",criteria );
			for(String eachCodeValue : codeValuesString){
				CodeDecode codeValue = new CodeDecode();
				codeValue.setCodeDecode(eachCodeValue);
				CodeValueList.add(codeValue);
			}
		}catch(DataAccessException se){
			System.out.println(se.toString());
			System.err.println("stacktrace"+se);
		}
		return CodeValueList;
	}

	public List <SearchResult> getDoctors(SearchCriteria searchCriteria) throws DataAccessException{
		Person person = null;		
		Map<String,Object> criteria =  new HashMap < String, Object > () ;		
		criteria.put("FirstName", searchCriteria.getDoctorFirstName());
		criteria.put("LastName", searchCriteria.getDoctorLastName());
		criteria.put("MiddleInitial", searchCriteria.getDoctorMiddleInitial());
		criteria.put("Speciality", searchCriteria.getSpeciality());
		criteria.put("Locality", searchCriteria.getLocality());		
		criteria.put("HolidayDate", searchCriteria.getDateOfAppointment());
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(searchCriteria.getDateOfAppointment());
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		
		if(CommonCoreConstants.DAY_IS_MONDAY == dayOfWeek){
			criteria.put("MondayWorking", "Y");
		}else {
			criteria.put("MondayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_TUESDAY == dayOfWeek){
			criteria.put("TuesdayWorking", "Y");
		}else{
			criteria.put("TuesdayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_WEDNESDAY == dayOfWeek){
			criteria.put("WednesdayWorking", "Y");
		}else{
			criteria.put("WednesdayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_THURSDAY == dayOfWeek){
			criteria.put("ThursdayWorking", "Y");
		}else{
			criteria.put("ThursdayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_FRIDAY == dayOfWeek){
			criteria.put("FridayWorking", "Y");
		}else{
			criteria.put("FridayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_SATURDAY == dayOfWeek){
						criteria.put("SaturdayWorking", "Y");
		}else{
			criteria.put("SaturdayWorking", null);
		}
		if (CommonCoreConstants.DAY_IS_SUNDAY == dayOfWeek){
			criteria.put("SundayWorking", "Y");
		}else{
			criteria.put("SundayWorking", null);
		}
	
		List <SearchResult> searchResultList =  new ArrayList() ;
		try{
			searchResultList= (ArrayList<SearchResult>) getList("common.searchDoctor",criteria );
		}catch(DataAccessException se){
			System.out.println(se.toString());
			System.err.println("stacktrace"+se);
		}
		return searchResultList;
	}
	
	public List <CodeDecode> getAutoComplete(String codeCategory,String code) throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", codeCategory);
		String codeLike = code+"%";
		criteria.put("Code", codeLike);
		List <CodeDecode> codeValueList= (ArrayList<CodeDecode>) getList("common.autoComplete",criteria );	
		return codeValueList;
	}

	public List <Appointment> getDayAppointment(int idPerson,Date dateOfAppointment,String personType, int doctorID) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;		
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		Integer idDoctorInt = new Integer(doctorID);
		criteria.put("DoctorID", idDoctorInt);		
		
		criteria.put("DateOfAppointment", dateOfAppointment);	
		List <Appointment> appointmentList =new ArrayList();
		if (personType.equals(CommonCoreConstants.DOCTOR)){
			 appointmentList = (ArrayList<Appointment>) getList("common.dayAppointment",criteria );	
		}else{
			 appointmentList = (ArrayList<Appointment>) getList("common.dayAppointmentForPatient",criteria );
		}
			
		return appointmentList;
		
		
	}	
	public boolean insertNewAppointment(Appointment appointment) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		criteria.put("SequenceName","s_appointment_id" );
		Integer appointmentID =  (Integer)getObject("common.getNextVal",criteria );
		appointment.setAppointmentID(appointmentID.intValue());
		insertObject("common.insertNewAppointment",appointment );
		return true;		
	}	

	public Person getPersonalProfile(int idPerson) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		Person completeDetails = (Person) getObject("common.getPersonalProfile",criteria );
		if (completeDetails.getPersonTypeString().equals(CommonCoreConstants.DOCTOR)){
			List<DoctorWorkTimings> workTimings = (ArrayList<DoctorWorkTimings>) getList("common.getDoctorWorkTimings",criteria );
			int i = 0;
			for(DoctorWorkTimings  eachPerson: workTimings){				
				completeDetails.getDoctorWorkTiming().get(i).setWorkDayName(eachPerson.getWorkDayName());
				completeDetails.getDoctorWorkTiming().get(i).setStartTime(eachPerson.getStartTime());
				completeDetails.getDoctorWorkTiming().get(i).setEndTime(eachPerson.getEndTime());
				i = i+1;
			}
			
		}
		
		return completeDetails;		
	}
	
	public Appointment getAppointment( int idAppointment) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		criteria.put("AppointmentID", idAppointment);		
		List<AppointmentTO> appointment = (ArrayList<AppointmentTO>) getList("common.getAppointment",criteria );
		Appointment appointmentLast = new Appointment();
		appointmentLast.setHeadline(appointment.get(0).getHeadline());
		appointmentLast.setComments(appointment.get(0).getComments());
		appointmentLast.setConfirmedIndicator(appointment.get(0).getConfirmedIndicator());
		appointmentLast.setAppointmentID(appointment.get(0).getAppointmentID());
		appointmentLast.setDateOfAppointment(appointment.get(0).getDateOfAppointment());
		appointmentLast.setTimeOfAppointment(appointment.get(0).getTimeOfAppointment());
		appointmentLast.setAppointmentDuration(appointment.get(0).getAppointmentDuration());
		appointmentLast.setConfirmedIndicator(appointment.get(0).getConfirmationIndicator());
		appointmentLast.setDoctorID(appointment.get(0).getDoctorID());
		List <Diagnosis> diagnosis = new ArrayList();
		int currentIDDiagnosis = 0;
		Diagnosis eachDiagnosis = new Diagnosis();
		List <String> prescriptionList = new ArrayList<String>();
		List <String> testList = new ArrayList<String>();
		String previousPrescription =null;
		String previousTest=null;
		for(AppointmentTO  eachAppointment: appointment){
			if (eachAppointment.getDiagnosisID()!= currentIDDiagnosis){
				if(currentIDDiagnosis!=0){
					eachDiagnosis.setPrescriptionList(prescriptionList);
					eachDiagnosis.setTestList(testList);
					diagnosis.add(eachDiagnosis); 
				}
				eachDiagnosis= new Diagnosis();
				prescriptionList = new ArrayList<String>();
				testList = new ArrayList<String>();

				currentIDDiagnosis = eachAppointment.getDiagnosisID();
				eachDiagnosis.setCodeICD(eachAppointment.getCodeICD());
				 
			}
				prescriptionList.add(eachAppointment.getPrescription());
				testList.add(eachAppointment.getDiagnosisTest());
		}
		if (prescriptionList.size()>0){
			Set prescriptionSet = new HashSet(prescriptionList);
			ArrayList uniquePrescriptionList = new ArrayList(prescriptionSet);
			eachDiagnosis.setPrescriptionList(uniquePrescriptionList);
		}
		if(testList.size()>0){
			Set testSet = new HashSet(testList);
			ArrayList uniquetestList = new ArrayList(testSet);
			eachDiagnosis.setTestList(uniquetestList);
			
		}
		diagnosis.add(eachDiagnosis); 
		appointmentLast.setDiagnosis(diagnosis);
		return appointmentLast;
		
	}

	@Override
	public List<AppointmentForMonth> getMonthAppointment(int idPerson,
			Date dateOfAppointment) throws DataAccessException {
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		criteria.put("DateOfAppointment", dateOfAppointment);
		List<AppointmentForMonth>  appointmentForMonth = (ArrayList<AppointmentForMonth>) getList("common.getMonthAppointment",criteria );	
		return appointmentForMonth;
	}

	public boolean updateDiagnosisAndTests(Appointment appointment) throws DataAccessException,DataIntegrityViolationException{
		deleteObject("common.deletePrescription", appointment);
		deleteObject("common.deleteTests", appointment);
		deleteObject("common.deleteDiagnosis", appointment);
		System.out.println("delete done");
		int count = appointment.getDiagnosis().size();
		Integer countInteger = new Integer(count);
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		criteria.put("SequenceName","s_diagnosis_id" );
		criteria.put("HowMuch",countInteger );
		Integer maxDianosisID =  (Integer)getObject("common.bulkNextVal",criteria );
		System.out.println("sid is "+ maxDianosisID + " "+countInteger);
		int minDiagnosisID = maxDianosisID.intValue() - count;
		int whileCounter = 0;
		while(minDiagnosisID <=maxDianosisID){
			appointment.getDiagnosis().get(whileCounter).setDiagnosisID(minDiagnosisID);
			whileCounter = whileCounter+1;
			minDiagnosisID = minDiagnosisID+1;
		}
		try { 
			this.getSqlMapClient().startBatch(); 
			for (int i = 0; i < appointment.getDiagnosis().size(); i++) {
				
				criteria =  new HashMap < String, Object > () ;
				Integer appointmentID = new Integer(appointment.getAppointmentID() );
				criteria.put("AppointmentID",appointmentID);
				Integer diagnosisID = new Integer(appointment.getDiagnosis().get(i).getDiagnosisID() );				
				criteria.put("DiagnosisID", diagnosisID);
				criteria.put("Prescription", appointment.getDiagnosis().get(i).getPrescription());
				criteria.put("ICDCode", appointment.getDiagnosis().get(i).getCodeICD());
				if(appointment.getDiagnosis().get(i).getCodeICD() !=null){
					getSqlMapClient().insert("common.insertNewDiagnosis",
							criteria);	
				}
				
			} 
			int insertCount = this.getSqlMapClient().executeBatch();
			//System.out.println("count "+insertCount);
			this.getSqlMapClient().startBatch(); 
			for (int i = 0; i < appointment.getDiagnosis().size(); i++) {
				criteria =  new HashMap < String, Object > () ;
				Integer diagnosisID = new Integer(appointment.getDiagnosis().get(i).getDiagnosisID() );				
				for(String eachTest:appointment.getDiagnosis().get(i).getTestList()){
					criteria =  new HashMap < String, Object > () ;
					criteria.put("DiagnosisID", diagnosisID);
					criteria.put("diagnosisTest", eachTest);
					criteria.put("diagnosisTestResultValue", appointment.getDiagnosis().get(i).getDiagnosisTestResultValue());
					criteria.put("diagnosisTestResultUnit", appointment.getDiagnosis().get(i).getDiagnosisTestResultUnit());
					if(eachTest!=null){
						getSqlMapClient().insert("common.insertNewTests",
								criteria);
					}

				}
			} 
			insertCount = this.getSqlMapClient().executeBatch();

			this.getSqlMapClient().startBatch(); 
			for (int i = 0; i < appointment.getDiagnosis().size(); i++) {
				Integer diagnosisID = new Integer(appointment.getDiagnosis().get(i).getDiagnosisID() );
				for(String eachPrescription:appointment.getDiagnosis().get(i).getPrescriptionList()){
					criteria =  new HashMap < String, Object > () ;
					criteria.put("DiagnosisID", diagnosisID);
					criteria.put("prescriptionName", eachPrescription);
					criteria.put("dosage", "");
					if(eachPrescription!=null){
						getSqlMapClient().insert("common.insertNewPrescription",
								criteria);
					}
				}
			} 
			insertCount = this.getSqlMapClient().executeBatch();

			} catch (SQLException e) { 
			throw new DataIntegrityViolationException(e.getMessage()); 
			} 

		
		return true;
	}
	
	public boolean scheduleJob(String action, Map<String, String> parms, String comments) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		criteria.put("SequenceName","s_schedule_job" );
		criteria.put("HowMuch",1 );
		Integer scheduleID =  (Integer)getObject("common.bulkNextVal",criteria );
		criteria =  new HashMap < String, Object > () ;
		criteria.put("Action", action);
		criteria.put("Comments", comments);
		criteria.put("ScheduleID", scheduleID);
		insertObject("common.insertScheduleJob",criteria );
		try
		{
			this.getSqlMapClient().startBatch(); 
			Iterator it = parms.entrySet().iterator();
		    while (it.hasNext()) { 
		        Map.Entry pairs = (Map.Entry)it.next(); 
				criteria =  new HashMap < String, Object > () ;
				criteria.put("InputParmName", pairs.getKey());
				criteria.put("InputParmValue", pairs.getValue());
				criteria.put("ScheduleID", scheduleID);				
				getSqlMapClient().insert("common.insertJobInputs",
						criteria);
	//	        System.out.println(pairs.getKey() + " = " + pairs.getValue()); 
		    } 			
			int insertCount = this.getSqlMapClient().executeBatch();

		}catch (SQLException e) { 
			throw new DataIntegrityViolationException(e.getMessage()); 
		} 
		
		return true;
		
	}

	public Map getMenuItems(String userRole) throws DataAccessException{
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("UserRole", userRole);
		return  getMap("common.getMenuItems", criteria,"menu_name", "menu_url");		
	}

	public boolean deleteAddress(Person person)throws DataAccessException{
		//boolean flag=deleteObject("common.deleteAddress", person);
		return deleteObject("common.deleteAddress", person);
	}

	public boolean updateDoctorDetails(Person person)throws DataAccessException{
 		int count = updateObject("common.updateDoctorDetails", person);
 		boolean flag=false;
 		if (count > 0){
 			flag = true;
 		}
		return flag;
		
	}
	
	public boolean insertDoctorWorkTimings(Person person)throws DataAccessException{
		boolean successFlag = false;
		int insertCount;
		try { 
			Map<String,Object> criteria =  new HashMap < String, Object > () ;
			Integer doctorID = person.getDoctorDetails().getIdDoctor();
			successFlag =deleteObject("common.deleteDoctorWorkTimings", person);
			this.getSqlMapClient().startBatch(); 
			for (int i = 0; i < person.getDoctorWorkTiming().size(); i++) {
				if(null != person.getDoctorWorkTiming().get(i).getWorkDayName()){
					criteria =  new HashMap < String, Object > () ;
					String workDayName = person.getDoctorWorkTiming().get(i).getWorkDayName();
					criteria.put("WorkDay",workDayName);
					Date startTime = person.getDoctorWorkTiming().get(i).getStartTime();				
					criteria.put("StartTime", startTime);
					Date endTime = person.getDoctorWorkTiming().get(i).getEndTime();
					criteria.put("EndTime", endTime);
					criteria.put("DoctorID", doctorID);				
					getSqlMapClient().insert("common.insertDoctorWorkTimings",
							criteria);
				}
			}
			insertCount = this.getSqlMapClient().executeBatch();
		}catch (SQLException e) { 
			throw new DataIntegrityViolationException(e.getMessage()); 
		} 
		if (person.getDoctorWorkTiming().size() == insertCount){
			successFlag = true;
		}
		return successFlag;
		
	}

	public List <DoctorWorkTimings> getDoctorWorkTimingsForDay(int idPerson, Date dateOfAppointment, int doctorID) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		Integer idDoctorInt = new Integer(idPerson);
		criteria.put("DoctorID", idDoctorInt);
		criteria.put("AppointmentDate", dateOfAppointment);		
		List<DoctorWorkTimings> workTimings = (ArrayList<DoctorWorkTimings>) getList("common.getDoctorWorkTimingsForDay",criteria );
		return   workTimings;
	}
	
	public PatientDetails getPatientDetails(int idPerson) throws DataAccessException{
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		PatientDetails patientDetails = (PatientDetails)getObject("common.getPatientDetails", criteria);		
		List<String> allegeries = (ArrayList<String>) getList("common.getAllergies", criteria);
		patientDetails.setAllergies(allegeries);
		List<MultiPartFileUploadBean> uploadedFiles = (ArrayList<MultiPartFileUploadBean>) getList("common.getuploadedFiles", criteria);
		patientDetails.setUploadedFiles(uploadedFiles);
		return patientDetails;
	}

	public boolean updatePatientDetails(PatientDetails patientDetails) throws DataAccessException{
 		int count = updateObject("common.updatePatientDetails", patientDetails); 		
 		boolean flag=false;
 		if (count > 0){
 			try { 
 				this.getSqlMapClient().startBatch(); 
 				Map<String,Object> criteria =  new HashMap < String, Object > () ;
 				for (int i =0;i < patientDetails.getAllergies().size();i++){
 					criteria =  new HashMap < String, Object > () ;
 					criteria.put("PatientID", new Integer (patientDetails.getIdPatient()));
 					criteria.put("Allergy", patientDetails.getAllergies().get(i));
 					getSqlMapClient().insert("common.insertAllergies",
 							criteria);
 				}
 				count = this.getSqlMapClient().executeBatch();
 				if (count > 0){
 					flag = true;
 				}
 			}catch (SQLException e) { 
 				throw new DataIntegrityViolationException(e.getMessage()); 
 			} 			
 		}
 		return flag;
	}

	public List <CodeDecode> getCodeDecode(String codeCategory) throws DataAccessException {
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", codeCategory);
		List <CodeDecode> codeValueList= (ArrayList<CodeDecode>) getList("common.codeDecode",criteria );	
		return codeValueList;
	}

	public HolidayCalendarList getHolidays(int idPerson){
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(idPerson);
		criteria.put("PersonID", idPersonInt);		
		List <Holidays> holidays = (ArrayList <Holidays>) getList("common.getHolidays", criteria);
		HolidayCalendarList holidayList = new HolidayCalendarList();
		holidayList.setHolidays(holidays);
		return holidayList;
	}

	public boolean insertHolidays(HolidayCalendarList holidayList) throws DataAccessException{
 		int count = 0;
 		boolean flag=false;
		Map<String,Object> criteria =  new HashMap < String, Object > () ;
		Integer idPersonInt = new Integer(holidayList.getIdDoctorPerson());
		criteria.put("PersonID", idPersonInt);		
		Person completeDetails = (Person) getObject("common.getPersonalProfile",criteria );
		holidayList.setIdDoctorSingle(completeDetails.getDoctorDetails().getIdDoctor());
		deleteObject("common.deleteHolidays", holidayList);			

		try { 
			this.getSqlMapClient().startBatch(); 
			for (Holidays holidays : holidayList.getHolidays()){
				if(holidays !=null && holidays.getHolidayDate() !=null){
					holidays.setIdDoctor(completeDetails.getDoctorDetails().getIdDoctor());
					getSqlMapClient().insert("common.insertHolidays",
							holidays);
				}
			}
			count = this.getSqlMapClient().executeBatch();
			if (count > 0){
				flag = true;
			}
		}catch (SQLException e) { 
			throw new DataIntegrityViolationException(e.getMessage()); 
		} 			
 		return flag;
	}

	public boolean insertPatientDocumentDetials(MultiPartFileUploadBean fileDetails) throws DataAccessException{
		return insertObject("common.insertPatientDocument",fileDetails );
	}

	public boolean updateAppointmentConfirmation (int appointmentID) throws DataAccessException{
		int numberOfRecords =updateObject("common.updateAppointmentConfirmation", appointmentID);
		boolean flag = false;
		if(numberOfRecords==1){
			flag=true;
		}
		return flag;
	}
	
	public List <ScheduleJob> getJobsToRun () throws DataAccessException{
		//getMap("common.getMenuItems", criteria,"menu_name", "menu_url");
		return (ArrayList<ScheduleJob>) getList("common.getJobDetails",null);
	}

	public Map getJobParms() throws DataAccessException{
		return  getMap("common.getMenuItems", null,"input_parameter_name", "input_parameter_value");		
	}

	public boolean updateJobCompletionStatus (ScheduleJob job) throws DataAccessException{
		int numberOfRecords =updateObject("common.updateJobCompletionStatus", job);
		boolean flag = false;
		if(numberOfRecords==1){
			flag=true;
		}
		return flag;
	}

	
	public NotificationDetails getNotificationDetails(Integer appointmentID) throws DataAccessException{
		Map<String,Integer> criteria =  new HashMap < String, Integer> () ;
		criteria.put("AppointmentID", appointmentID);
		return  (NotificationDetails) getObject("common.getDetailsForNotification", criteria);		
	}

	public List <CodeDecode> getDiagnosis(String code) throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		//criteria.put("Category", codeCategory);
		String codeLike = code+"%";
		criteria.put("Code", codeLike);
		List <CodeDecode> codeValueList= (ArrayList<CodeDecode>) getList("common.getICDCode",criteria );	
		return codeValueList;
	}

	
	public List <CodeDecode> getPrescription(String code) throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		//criteria.put("Category", codeCategory);
		String codeLike = code+"%";
		criteria.put("Code", codeLike);
		List <CodeDecode> codeValueList= (ArrayList<CodeDecode>) getList("common.getPrescription",criteria );	
		return codeValueList;
	}

	public List <CodeDecode> getTests(String code) throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		//criteria.put("Category", codeCategory);
		String codeLike = code+"%";
		criteria.put("Code", codeLike);
		List <CodeDecode> codeValueList= (ArrayList<CodeDecode>) getList("common.getTests",criteria );	
		return codeValueList;
	}

	public boolean rescheduleAppointment(Appointment appointment) throws DataAccessException{
 		int count = updateObject("common.rescheduleAppointment", appointment);
 		boolean flag=false;
 		if (count > 0){
 			flag = true;
 		}
		return flag;
		
	}	

	public String getAppointmentList(int iPersonID) throws DataAccessException {
		Integer personID = new Integer(iPersonID);
		Map<String,Integer> criteria =  new HashMap < String, Integer > () ;
		criteria.put("PersonID", personID);
		String appointmentList= (String) getObject("common.authenticateUser", criteria);	
		return appointmentList;
	}
	
	public List <Appointment> getAppointmentAll(int iPersonID) throws DataAccessException{
		Integer personID = new Integer(iPersonID);
		Map<String,Integer> criteria =  new HashMap < String, Integer > () ;
		criteria.put("PersonID", personID);
		return (List <Appointment>) getList("common.getAllAppointmentList",criteria );
	}
	
	public List <NotificationDetails> getNotificationDetailsAll(Integer iPersonID) throws DataAccessException{
		Integer personID = new Integer(iPersonID);
		Map<String,Integer> criteria =  new HashMap < String, Integer > () ;
		criteria.put("PersonID", personID);
		return  (List <NotificationDetails>) getList("common.getDetailsForNotificationAll", criteria);		
	}

	public boolean cancelAllAppointments(int iPersonID)throws DataAccessException{
		Integer personID = new Integer(iPersonID);
 		int count = updateObject("common.cancelAllAppointment", personID);
 		boolean flag=false;
 		if (count > 0){
 			flag = true;
 		}
		return flag;
	}

}
