package com.mediapp.core.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;

public interface CommonDAO {
	
	/**
	 * Returns the person object whose name and pwd is matching, else return null
	 * @param person
	 * @return
	 */
	public Person getPersonDetails(Person person) throws DataAccessException;
	
	public List <CodeDecode> getPersonType() throws DataAccessException;
	
	public boolean addNewMember(Person person) throws DataAccessException;
	
	public boolean updateProfile(Person person)throws DataAccessException;

	public int checkIfeMailExists(Person person)  throws DataAccessException;
	
	public boolean insertAddress(Person person) throws DataAccessException;
	
	public List <CodeDecode> getCodeValue(String codeCategory) throws DataAccessException;

	public List <SearchResult> getDoctors(SearchCriteria searchCriteria) throws DataAccessException;

	public List <CodeDecode> getAutoComplete(String codeCategory,String code) throws DataAccessException;

	
}
