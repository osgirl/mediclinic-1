package com.mediapp.core.common.business.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;


public class LoginServiceImpl implements LoginService {

	protected final Log logger = LogFactory.getLog(getClass());

	private CommonDAO commonDAO;

	public Person authenticate(Person person) {		
		Person dbDetails = commonDAO.getPersonDetails(person);
		if (dbDetails !=null){
			if(dbDetails.getPassword().equals(person.getPassword())) {
				dbDetails.setAuthenticated(true);
				person.setAuthenticated(true);	
				person.setEmailID(dbDetails.getEmailID());
				person.setUsername(dbDetails.getUsername());
				person.setPersonTypeString(dbDetails.getPersonTypeString());
				person.setIdPerson(dbDetails.getIdPerson());
				person.setFirstName(dbDetails.getFirstName());
				person.setLastName(dbDetails.getLastName());
				person.setPackages(dbDetails.getPackages());
			} else {
				//dbDetails = person;
				dbDetails.setAuthenticated(false);	
			}
		}else{
			dbDetails = new Person();
			dbDetails.setAuthenticated(false);
		}
		if (logger.isInfoEnabled()) {
			logger.info("isAuthenticated : User " + person.getUsername() + " is " + person.isAuthenticated());
		}
		return dbDetails;
	}

	/**
	 * @param commonDAO the commonDAO to set
	 */
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	public List <CodeDecode> getPersonType() {
		return commonDAO.getPersonType();
	}
	@Override
	public boolean addNewMember(Person person) {		
		return commonDAO.addNewMember(person);
	}
	public boolean addNewAppMentMember(Person person) {		
		return commonDAO.addNewAppMentMember(person);
	}

	
	public boolean updateProfile(Person person) {	
		boolean updateSuccess = false;
		boolean successFlag = commonDAO.updateProfile(person);
		if (successFlag  ){
			successFlag = commonDAO.deleteAddress(person);
			if (successFlag){
				 successFlag = commonDAO.insertAddress(person);			 
				 if (successFlag){
					 if(!person.getPersonTypeString().equals(CommonCoreConstants.PATIENT)){
						 successFlag = commonDAO.updateDoctorDetails(person);
						 if (successFlag){
							 successFlag = commonDAO.insertDoctorWorkTimings(person);
						 }
					 }
					 if (successFlag){
						updateSuccess = true;
					 }
				 }
			}
		}
		return updateSuccess;
	}

	public List<String> checkIfeMailExists(Person person){
		int countOfEmails = commonDAO.checkIfeMailExists(person);
		List<String> errorList = new ArrayList<String>();		
		if(countOfEmails > 0){
			errorList.add("error.account.exists");

		}
		return errorList;
	}
	
	public List<String> checkIfUserExists(Person person){
		int countOfEmails = commonDAO.checkIfUserExists(person);
		List<String> errorList = new ArrayList<String>();		
		if(countOfEmails > 0){
			errorList.add("error.account.exists");

		}
		return errorList;
		
	}
	
	public List <CodeDecode> getSpecialities() {
		return commonDAO.getCodeValue(CommonCoreConstants.SPECIALITY);
	}

	public Map getMenuItems(int personID){		
		return commonDAO.getMenuItems(personID);
	}

}
