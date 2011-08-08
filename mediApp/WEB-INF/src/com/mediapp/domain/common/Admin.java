package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

public class Admin  extends MediAppBaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1234L;


	private String personID;
	
	private List<String> packages = LazyList.decorate(
			new ArrayList < String > (),
		FactoryUtils.instantiateFactory(String.class));

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	} 



}
