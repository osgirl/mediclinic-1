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
	
	private int idPatient;
	
	private String weight;

	private String height;

	private String bloodGroup;
	
    private List<String> allergies = LazyList.decorate(
				new ArrayList < String > (),
			FactoryUtils.instantiateFactory(String.class)); 

    private List<MultiPartFileUploadBean> uploadedFiles = LazyList.decorate(
			new ArrayList < MultiPartFileUploadBean > (),
		FactoryUtils.instantiateFactory(MultiPartFileUploadBean.class));

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}


    public List<MultiPartFileUploadBean> getUploadedFiles() {
		return uploadedFiles;
	}

	public void setUploadedFiles(List<MultiPartFileUploadBean> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}

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

    
}
