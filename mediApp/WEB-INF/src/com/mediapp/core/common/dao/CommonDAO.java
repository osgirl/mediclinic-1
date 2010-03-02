package com.mediapp.core.common.dao;

import org.springframework.dao.DataAccessException;

import com.mediapp.domain.common.Person;

/**
 * @author a461353
 *
 */
public interface CommonDAO {
	
	/**
	 * Returns the person object whose name and pwd is matching, else return null
	 * @param person
	 * @return
	 */
	public Person getPersonDetails(Person person) throws DataAccessException;

}
