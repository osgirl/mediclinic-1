package com.mediapp.core.common.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;


public class CommonDAOImpl extends MediAppBaseDAOImpl implements CommonDAO {

	public Person getPersonDetails(Person person) throws DataAccessException {
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Key", person.getKey());
		criteria.put("Username", person.getUsername());
		criteria.put("PersonType", person.getPersonTypeString());
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
			insertObject("common.insertNewPerson",person );
			return true;
	}
	
	public int getMaxPersonId() throws DataAccessException {
		return (Integer) getObject("common.maxPersonId", null);
	}
	
	public boolean updateProfile(Person person)throws DataAccessException{
 		updateObject("common.updateProfile", person);
		return true;
	}
	
	public boolean insertAddress(Person person)throws DataAccessException{
		updateObject("common.insertAddress", person);
		return true;
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
		Map<String,String> criteria =  new HashMap < String, String > () ;		
		criteria.put("FirstName", searchCriteria.getDoctorFirstName());
		criteria.put("LastName", searchCriteria.getDoctorLastName());
		criteria.put("MiddleInitial", searchCriteria.getDoctorMiddleInitial());
		criteria.put("Speciality", searchCriteria.getSpeciality());
		criteria.put("Locality", searchCriteria.getLocality());		
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
		String codeLike = "%"+code+"%";
		criteria.put("Code", codeLike);
		List <CodeDecode> codeValueList= (ArrayList<CodeDecode>) getList("common.autoComplete",criteria );	
		return codeValueList;
	}

	
	
}
