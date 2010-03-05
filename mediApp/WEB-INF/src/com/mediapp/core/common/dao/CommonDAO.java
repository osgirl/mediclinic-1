package com.mediapp.core.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;

public interface CommonDAO {
	
	/**
	 * Returns the person object whose name and pwd is matching, else return null
	 * @param person
	 * @return
	 */
	public Person getPersonDetails(Person person) throws DataAccessException;
	
	public List <CodeDecode> getPersonType() throws DataAccessException;
	
	public boolean addNewMember(Person person) throws DataAccessException;

}
