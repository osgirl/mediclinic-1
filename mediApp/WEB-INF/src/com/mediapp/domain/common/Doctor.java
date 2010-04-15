package com.mediapp.domain.common;

public class Doctor extends MediAppBaseDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private int idPerson;
	
	private int idDoctor;
	
	private String specilization;
	
	private String workStartTime;
	
	private String workEndTime;
	
	private char mondayWorking;
	
	private char tuesdayWorking;
	
	private char wednesdayWorking;
	
	private char thursdayWorking;
	
	private char fridayWorking;
	
	private char saturdayWorking;
	
	private char sundayWorking;

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

	public String getSpecilization() {
		return specilization;
	}

	public void setSpecilization(String specilization) {
		this.specilization = specilization;
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

	public char getMondayWorking() {
		return mondayWorking;
	}

	public void setMondayWorking(char mondayWorking) {
		this.mondayWorking = mondayWorking;
	}

	public char getTuesdayWorking() {
		return tuesdayWorking;
	}

	public void setTuesdayWorking(char tuesdayWorking) {
		this.tuesdayWorking = tuesdayWorking;
	}

	public char getWednesdayWorking() {
		return wednesdayWorking;
	}

	public void setWednesdayWorking(char wednesdayWorking) {
		this.wednesdayWorking = wednesdayWorking;
	}

	public char getThursdayWorking() {
		return thursdayWorking;
	}

	public void setThursdayWorking(char thursdayWorking) {
		this.thursdayWorking = thursdayWorking;
	}

	public char getFridayWorking() {
		return fridayWorking;
	}

	public void setFridayWorking(char fridayWorking) {
		this.fridayWorking = fridayWorking;
	}

	public char getSaturdayWorking() {
		return saturdayWorking;
	}

	public void setSaturdayWorking(char saturdayWorking) {
		this.saturdayWorking = saturdayWorking;
	}

	public char getSundayWorking() {
		return sundayWorking;
	}

	public void setSundayWorking(char sundayWorking) {
		this.sundayWorking = sundayWorking;
	}
}

