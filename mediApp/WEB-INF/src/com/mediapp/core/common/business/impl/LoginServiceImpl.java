package com.mediapp.core.common.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;


public class LoginServiceImpl implements LoginService {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private CommonDAO commonDAO;
	
	public Person authenticate(Person person) {		
		if (person.getEmailID() == ""){
			Person dbDetails = commonDAO.getPersonDetails(person);
			if (dbDetails !=null){
				if(dbDetails.getPassword().equals(person.getPassword())) {
					dbDetails.setAuthenticated(true);
					person.setAuthenticated(true);	
					person.setEmailID(dbDetails.getEmailID());
					person.setUsername(dbDetails.getEmailID());
					person.setPersonTypeString(dbDetails.getPersonTypeString());
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
		return person;
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

	public boolean updateProfile(Person person) {		
	return commonDAO.updateProfile(person);
}


	public List<String> checkIfeMailExists(Person person){
		int countOfEmails = commonDAO.checkIfeMailExists(person);
		List<String> errorList = new ArrayList<String>();		
		if(countOfEmails > 0){
			errorList.add("error.account.exists");
			
		}
		return errorList;
	}
}
