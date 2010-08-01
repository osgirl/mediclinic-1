package com.mediapp.domain.common;

public class NotificationDetails extends MediAppBaseDomain{
	private static final long serialVersionUID = 33L;
	
	private String patientName;
	
	private String doctorName;
	
	private String patientEmailAddress;
	
	private String doctorEmailAddress;
	
	private String patientMobileNumber;
	
	private String doctorMobileNumber;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientEmailAddress() {
		return patientEmailAddress;
	}

	public void setPatientEmailAddress(String patientEmailAddress) {
		this.patientEmailAddress = patientEmailAddress;
	}

	public String getDoctorEmailAddress() {
		return doctorEmailAddress;
	}

	public void setDoctorEmailAddress(String doctorEmailAddress) {
		this.doctorEmailAddress = doctorEmailAddress;
	}

	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	public String getDoctorMobileNumber() {
		return doctorMobileNumber;
	}

	public void setDoctorMobileNumber(String doctorMobileNumber) {
		this.doctorMobileNumber = doctorMobileNumber;
	}
	
	

}
