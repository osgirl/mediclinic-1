package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

public class PatientDetails extends MediAppBaseDomain{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1332232L; 
	
	private String weight;

	private String height;

	private String bloodGroup;
	
    private List<String> allergies = LazyList.decorate(
				new ArrayList < String > (),
			FactoryUtils.instantiateFactory(String.class)); 

    private List<String> fileNames = LazyList.decorate(
			new ArrayList < String > (),
		FactoryUtils.instantiateFactory(String.class));

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public List<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	} 

    
}
