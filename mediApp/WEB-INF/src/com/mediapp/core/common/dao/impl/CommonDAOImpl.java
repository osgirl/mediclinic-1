/**
 * 
 */
package com.mediapp.core.common.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;


public class CommonDAOImpl extends MediAppBaseDAOImpl implements CommonDAO {

	public Person getPersonDetails(Person person) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Person getPersonType() throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", "PERSON_TY");
		try{
			CodeDecode codeDecode = null;
			codeDecode= (CodeDecode) getList("common.getPersonType",criteria );
			person.setPersonType(codeDecode);
			System.out.println("DAO"+ person);
		
		}catch(DataAccessException se){
			System.out.println(se.toString());
		}
		return person;
	}

	
}
