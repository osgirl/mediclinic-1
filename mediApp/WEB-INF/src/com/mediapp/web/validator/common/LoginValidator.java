package com.mediapp.web.validator.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mediapp.core.common.business.LoginService;
import com.mediapp.domain.common.Person;


public class LoginValidator implements Validator {
	LoginService loginService;
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	private final Log logger = LogFactory.getLog(getClass());

	public boolean supports(Class clazz) {
		return clazz.equals(Person.class);
	}

	public void validate(Object obj, Errors errors) {
		Person person = (Person) obj;		
		if (person == null ) {	
			errors.rejectValue("username", "error.login.not-specified", null,
			"Value required.");
			
		} else {
			logger.info("Validating user credentials for: "
				+ person.getUsername());
			if (person.getUsername() == null || person.getUsername().trim().length() == 0) {
				logger.info(" 1 Validating user credentials for: "
					+ person.getUsername());
				errors.rejectValue("username", "error.login.invalid-user",
					null, "Incorrect Username.");
			} if (person.getPassword() == null || person.getPassword().trim().length() == 0) {
				logger.info(" 3 Validating user credentials for: "
					+ person.getUsername());
				errors.rejectValue("password", "error.login.invalid-pass",
					null, "Incorrect Password.");
			}else{
				Person dbPerson = loginService.authenticate(person);
				if (logger.isInfoEnabled()) {
					logger.info("Authentication status : " + dbPerson.isAuthenticated());
				}

				if (!dbPerson.isAuthenticated()) {						
					errors.rejectValue("username", "error.login.invalid",
							null, "Login failed.");
				}
			}
		}		
	}
}
