package com.mediapp.domain.common;

import java.sql.Time;


public class SearchResult extends MediAppBaseDomain{

	private static final long serialVersionUID = 110L;

    private int idPerson;
    
	private String doctorFirstName;
	
	private String doctorMiddleName;
	
	private String doctorLastName;
	
	private String address1;
	
	private String address2;
	
	private String locality;
	
	private String city;
	
	private String state;
	
	private String country;

    private Integer landlinePhoneNumber;
    
    private Integer cellPhoneNumber;

    private String emailID;
    
    private String speciality;
	
	private Time workStartTime;
	
	private Time workEndTime;
	
	private String mondayWorking;
	
	private String tuesdayWorking;
	
	private String wednesdayWorking;
	
	private String thursdayWorking;
	
	private String fridayWorking;
	
	private String saturdayWorking;
	
	private String sundayWorking;

	private String workDays;
	
	public String getWorkDays() {
		return workDays;
	}

	public void setWorkDays(String workDays) {
		StringBuffer s = new StringBuffer("");
		if( this.workDays ==null ){
			s.append(workDays);
			this.workDays = s.toString();			
		}else if(this.workDays != null ){
			s.append(this.workDays);			
			s.append("-");
			s.append(workDays);
			this.workDays = s.toString();			
		}
	}

	public String getDoctorFirstName() {
		return doctorFirstName;
	}

	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}

	public String getDoctorMiddleName() {
		return doctorMiddleName;
	}

	public void setDoctorMiddleName(String doctorMiddleName) {
		this.doctorMiddleName = doctorMiddleName;
	}

	public String getDoctorLastName() {
		return doctorLastName;
	}

	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getccountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Time getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(Time workStartTime) {
		this.workStartTime = workStartTime;
	}

	public Time getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(Time workEndTime) {
		this.workEndTime = workEndTime;
	}

	public String getMondayWorking() {
		return mondayWorking;
	}

	public void setMondayWorking(String mondayWorking) {
		this.mondayWorking = mondayWorking;
		if ("Y".equals(mondayWorking)==true){
			setWorkDays("M");
		}
	}

	public String getTuesdayWorking() {
		return tuesdayWorking;
	}

	public void setTuesdayWorking(String tuesdayWorking) {
		this.tuesdayWorking = tuesdayWorking;
		if ("Y".equals(tuesdayWorking)==true){
			setWorkDays("Tu");
		}

	}

	public String getWednesdayWorking() {
		return wednesdayWorking;
	}

	public void setWednesdayWorking(String wednesdayWorking) {
		this.wednesdayWorking = wednesdayWorking;
		if ("Y".equals(wednesdayWorking)==true){
			setWorkDays("W");
		}


	}

	public String getThursdayWorking() {
		return thursdayWorking;
	}

	public void setThursdayWorking(String thursdayWorking) {
		this.thursdayWorking = thursdayWorking;
		if ("Y".equals(thursdayWorking)==true){
			setWorkDays("Th");
		}

	}

	public String getFridayWorking() {
		return fridayWorking;
	}

	public void setFridayWorking(String fridayWorking) {
		this.fridayWorking = fridayWorking;
		if ("Y".equals(fridayWorking)==true){
			setWorkDays("F");
		}
	}

	public String getSaturdayWorking() {
		return saturdayWorking;
	}

	public void setSaturdayWorking(String saturdayWorking) {
		this.saturdayWorking = saturdayWorking;
		if ("Y".equals(saturdayWorking)==true){
			setWorkDays("Sa");
		}

	}

	public String getSundayWorking() {
		return sundayWorking;
	}

	public void setSundayWorking(String sundayWorking) {
		this.sundayWorking = sundayWorking;
		if ("Y".equals(sundayWorking)==true){
			setWorkDays("Su");
		}
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public Integer getLandlinePhoneNumber() {
		return landlinePhoneNumber;
	}

	public void setLandlinePhoneNumber(Integer landlinePhoneNumber) {
		this.landlinePhoneNumber = landlinePhoneNumber;
	}

	public Integer getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(Integer cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	
}
