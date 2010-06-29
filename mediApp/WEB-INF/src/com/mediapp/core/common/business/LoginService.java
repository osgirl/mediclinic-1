/**
 * 
 */
package com.mediapp.core.common.business;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;

public interface LoginService {
	
	/**
	 * Checks if user is valid user, if yes then sets the
	 * person details.
	 * @param person
	 * @return
	 */
	public Person authenticate(Person person);
	
	public List <CodeDecode> getPersonType() ;
	
	public boolean addNewMember(Person person);

	public boolean updateProfile(Person person);
	
	public List<String> checkIfeMailExists(Person person);

	public List <CodeDecode> getSpecialities() ;

	public Map getMenuItems(String userRole);
}
