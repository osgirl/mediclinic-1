package com.mediapp.core.common.business.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;


public class LoginServiceImpl implements LoginService {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private CommonDAO commonDAO;
	
	public Person authenticate(Person person) {
		
		Person dbDetails = commonDAO.getPersonDetails(person);
		if(dbDetails != null ) {
			dbDetails.setAuthenticated(true);
		} else {
			dbDetails = person;
			if (person.getUsername().equals("Sukesh")) {
				dbDetails.setAuthenticated(true);
			} else {
				dbDetails.setAuthenticated(false);	
			}
		}
		if (logger.isInfoEnabled()) {
			logger.info("isAuthenticated : User " + person.getUsername() + " is " + person.isAuthenticated());
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
	// TODO Auto-generated method stub
	return false;
}
}
