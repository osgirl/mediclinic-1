package com.mediapp.core.common.business;

import java.util.Date;
import java.util.List;

import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.AppointmentForMonth;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;

public interface CommonService {

	public List <CodeDecode> getAutoComplete(String codeCategory,String code) ;
	
	public List <SearchResult> getDoctors(SearchCriteria searchCriteria);
	
	public List <Appointment> getDayAppointment(int idPerson,Date dateOfAppointment) ;
	
	public boolean insertNewAppointment(Appointment appointment);
	
	public Person getPersonalProfile(int personID);
	
	public Appointment getAppointment(int idPerson,Date dateOfAppointment, int idAppointment) ;
	
	public List <CodeDecode> getCodeValue(String codeCategory) ;
	
	public List <AppointmentForMonth> getMonthAppointment(int idPerson, Date dateOfAppointment);
	
}
