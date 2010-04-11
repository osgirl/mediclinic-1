package com.mediapp.domain.common;

import java.util.Date;


public class SearchCriteria  extends MediAppBaseDomain{

	private static final long serialVersionUID = 10L;

	private String doctorName;
	
	private String speciality;
	
	private Date dateOfAppointment;
	
	private String locality;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

}
