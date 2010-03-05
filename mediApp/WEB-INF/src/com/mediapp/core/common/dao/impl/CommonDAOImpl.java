/**
 * 
 */
package com.mediapp.core.common.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public List <CodeDecode> getPersonType() throws DataAccessException {
		Person person = null;		
		Map<String,String> criteria =  new HashMap < String, String > () ;
		criteria.put("Category", "PERSON_TY");
		List <CodeDecode> CodeValueList =  new ArrayList() ;
		try{
			List <String>codeValuesString= (ArrayList<String>) getList("common.getPersonType",criteria );
			for(String eachCodeValue : codeValuesString){
				CodeDecode codeValue = new CodeDecode();
				codeValue.setCodeDecode(eachCodeValue);
				CodeValueList.add(codeValue);
			}
		}catch(DataAccessException se){
			System.out.println(se.toString());
			System.err.println("stacktrace"+se);
		}
		return CodeValueList;
	}

	@Override
	public boolean addNewMember(Person person) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}
}
