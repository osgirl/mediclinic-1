/**
 * 
 */
package com.mediapp.core.common.business;

import com.mediapp.domain.common.Person;

/**
 * @author A461353
 *
 */
public interface LoginService {
	
	/**
	 * Checks if user is valid user, if yes then sets the
	 * person details.
	 * @param person
	 * @return
	 */
	public Person authenticate(Person person);

}
