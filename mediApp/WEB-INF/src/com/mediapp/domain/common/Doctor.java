package com.mediapp.domain.common;

public class Doctor extends MediAppBaseDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private int idPerson;
	
	private int idDoctor;
	
	private String specialization;
	
	private String workStartTime;
	
	private String workEndTime;
	
	private String mondayWorking;
	
	private String tuesdayWorking;
	
	private String wednesdayWorking;
	
	private String thursdayWorking;
	
	private String fridayWorking;
	
	private String saturdayWorking;
	
	private String sundayWorking;

	private String registrationNumber;
	

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}

	public String getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}

	public String getMondayWorking() {
		return mondayWorking;
	}

	public void setMondayWorking(String mondayWorking) {
		this.mondayWorking = mondayWorking;
	}

	public String getTuesdayWorking() {
		return tuesdayWorking;
	}

	public void setTuesdayWorking(String tuesdayWorking) {
		this.tuesdayWorking = tuesdayWorking;
	}

	public String getWednesdayWorking() {
		return wednesdayWorking;
	}

	public void setWednesdayWorking(String wednesdayWorking) {
		this.wednesdayWorking = wednesdayWorking;
	}

	public String getThursdayWorking() {
		return thursdayWorking;
	}

	public void setThursdayWorking(String thursdayWorking) {
		this.thursdayWorking = thursdayWorking;
	}

	public String getFridayWorking() {
		return fridayWorking;
	}

	public void setFridayWorking(String fridayWorking) {
		this.fridayWorking = fridayWorking;
	}

	public String getSaturdayWorking() {
		return saturdayWorking;
	}

	public void setSaturdayWorking(String saturdayWorking) {
		this.saturdayWorking = saturdayWorking;
	}

	public String getSundayWorking() {
		return sundayWorking;
	}

	public void setSundayWorking(String sundayWorking) {
		this.sundayWorking = sundayWorking;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


}

