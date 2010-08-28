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

public class SignUpValidator implements Validator {
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
			
			if(null==person.getUsername() ||""==person.getUsername()){
				errors.rejectValue("username","error.required.field" ,
						null, "Field Blank.");
			}else{
				List<String> errorList = new ArrayList<String>();
				errorList = loginService.checkIfUserExists(person);
				if(errorList.size()>0){						
					errors.rejectValue("username", errorList.get(0),
							null, "Already Exists.");
				}			

			}
			if(null==person.getPassword()||""==person.getPassword()){
				errors.rejectValue("password","error.required.field" ,
						null, "Field Blank.");
			}
			if(null==person.getEmailID()||""==person.getEmailID()){
				errors.rejectValue("emailID","error.required.field" ,
						null, "Field Blank.");
			}else{
				EmailValidator emailValidate = EmailValidator.getInstance();
				boolean isValid = emailValidate.isValid(person.getEmailID());
				if (!isValid){
					errors.rejectValue("emailID", "error.login.invalid.email",
							null, "Invalid EmailID.");
					
				}

				
			}
			if(null==person.getCellPhoneNumber()||""==person.getCellPhoneNumber()){
				errors.rejectValue("cellPhoneNumber","error.required.field" ,
						null, "Field Blank.");
			}

		}		
	}

}
