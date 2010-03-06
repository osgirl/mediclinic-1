package com.mediapp.web.validator.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mediapp.domain.common.Person;


public class LoginValidator implements Validator {

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
			if (person.getEmailID()==""){
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
				}
			}
		}		
	}
}
