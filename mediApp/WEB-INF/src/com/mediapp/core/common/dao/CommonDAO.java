package com.mediapp.core.common.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.smslib.InboundMessage;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.AppointmentForMonth;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.DoctorWorkTimings;
import com.mediapp.domain.common.HolidayCalendarList;
import com.mediapp.domain.common.IncomingMessages;
import com.mediapp.domain.common.MultiPartFileUploadBean;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.PatientDetails;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.ScheduleJob;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;

public interface CommonDAO {
	
	/**
	 * Returns the person object whose name and pwd is matching, else return null
	 * @param person
	 * @return
	 */
	public Person getPersonDetails(Person person) throws DataAccessException;
	
	public List <CodeDecode> getPersonType() throws DataAccessException;
	
	public boolean addNewMember(Person person) throws DataAccessException;
	
	public boolean addNewAppMentMember(Person person) throws DataAccessException;
	
	public boolean updateProfile(Person person)throws DataAccessException;

	public int checkIfeMailExists(Person person)  throws DataAccessException;
	
	public int checkIfUserExists(Person person)  throws DataAccessException;
	
	public boolean insertAddress(Person person) throws DataAccessException;
	
	public List <CodeDecode> getCodeValue(String codeCategory) throws DataAccessException;

	public List <SearchResult> getDoctors(SearchCriteria searchCriteria) throws DataAccessException;

	public List <CodeDecode> getAutoComplete(String codeCategory,String code) throws DataAccessException;
	
	public List <Appointment> getDayAppointment(int idPerson,Date dateOfAppointment,String personType , int doctorID) throws DataAccessException;

	public boolean insertNewAppointment(Appointment appointment) throws DataAccessException;
	
	public Person getPersonalProfile(int idPerson) throws DataAccessException;
	
	public Appointment getAppointment(int idAppointment) throws DataAccessException;
	
	public List <AppointmentForMonth> getMonthAppointment(int idPerson, Date dateOfAppointment) throws DataAccessException;

	public boolean updateDiagnosisAndTests(Appointment appointment) throws DataAccessException, DataIntegrityViolationException;
	
	public boolean scheduleJob(String action, Map<String, String> parms, String comments) throws DataAccessException;
	
	public Map getMenuItems(String userRole) throws DataAccessException;
	
	public boolean deleteAddress(Person person)throws DataAccessException;
	
	public boolean updateDoctorDetails(Person person)throws DataAccessException;
	
	public boolean insertDoctorWorkTimings(Person person)throws DataAccessException;

	public List <DoctorWorkTimings> getDoctorWorkTimingsForDay(int idPerson, Date dateOfAppointment, int doctorID) throws DataAccessException;
	
	public PatientDetails getPatientDetails(int idPerson) throws DataAccessException;
	
	public boolean updatePatientDetails(PatientDetails patientDetails) throws DataAccessException;

	public List <CodeDecode> getCodeDecode(String codeCategory) throws DataAccessException;

	public HolidayCalendarList getHolidays(int idPerson)  throws DataAccessException;

	public boolean insertHolidays(HolidayCalendarList holidayList) throws DataAccessException;
	
	public boolean insertPatientDocumentDetials(MultiPartFileUploadBean fileDetails) throws DataAccessException;

	public boolean updateAppointmentConfirmation (int appointmentID, String confirmationIndicator) throws DataAccessException;

	public List <ScheduleJob> getJobsToRun () throws DataAccessException;

	public Map getJobParms() throws DataAccessException;
	
	public boolean updateJobCompletionStatus (ScheduleJob job) throws DataAccessException;

	public NotificationDetails getNotificationDetails(Integer AppointmentID) throws DataAccessException;

	public List <CodeDecode> getDiagnosis(String code) throws DataAccessException;
	
	public List <CodeDecode> getPrescription(String code) throws DataAccessException;
	
	public List <CodeDecode> getTests(String code) throws DataAccessException;
	
	public boolean rescheduleAppointment(Appointment appointment) throws DataAccessException;
	
	public String getAppointmentList(int iPersonID) throws DataAccessException ;
	
	public List <Appointment> getAppointmentAll(int iPersonID) throws DataAccessException;
	
	public List <NotificationDetails> getNotificationDetailsAll(Integer iPersonID) throws DataAccessException;
	
	public boolean cancelAllAppointments(int iPersonID)throws DataAccessException;

	public String getWorkTimings(int idPerson) throws DataAccessException ;
	
	public List<List<Appointment>> getInbox(int  idPerson ) throws DataAccessException;
	
	public boolean insertInboundMessages(List<InboundMessage> messages)  throws DataAccessException;
	
	public boolean updateIncomingSMSJob (String oldProcessingId, String oldStatus, String newProcessingId, String newStatus) throws DataAccessException;
	
	public List<IncomingMessages> getReadMessages(String processingId)  throws DataAccessException;
	
	public boolean updateAppointmentConfirmationThruSMS (Appointment appointment) throws DataAccessException;
	
	public int checkIfAppointmentAvailable(Appointment appointment)throws DataAccessException;
	
	public Appointment checkIfAppointmentExists(Appointment appointment)throws DataAccessException;
	
	public boolean sendOutSMS(String recipient, String text) throws DataAccessException;
}
