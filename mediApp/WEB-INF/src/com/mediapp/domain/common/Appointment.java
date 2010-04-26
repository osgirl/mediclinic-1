package com.mediapp.domain.common;

import java.util.Date;
import java.sql.Time;


public class Appointment extends MediAppBaseDomain{
	private static final long serialVersionUID = 3L;
	
	private int appointmentID;
	
	private Date dateOfAppointment;
	
	private Time timeOfAppointment;
	
	private Time appointmentDuration;
	
	private String comments;
	
	private int patientID;
	
	private int doctorPersonID;
	
	private int doctorID;
	
	private String confirmedIndicator;
	
	private Date newDateProposed;
	
	private Time newTimeProposed;
	
	private Date followUpDate;
	
	private int referenceDoctorID;
	
	private String headline;	
	
	private int diagnosisID;
	
	private String codeICD;
	
	private String prescription;
	
	private String lNotes;
	
	private String diagnosis;
	
	private String allergy;	
	
	private String suggestedTest;
	
	private String testValue;
	
	private String testResultUnit;
	
	private String doctorWorkStartTime;
	
	private String doctorWorkEndTime;
	
	public String getDoctorWorkStartTime() {
		return doctorWorkStartTime;
	}

	public void setDoctorWorkStartTime(String doctorWorkStartTime) {
		this.doctorWorkStartTime = doctorWorkStartTime;
	}

	public String getDoctorWorkEndTime() {
		return doctorWorkEndTime;
	}

	public void setDoctorWorkEndTime(String doctorWorkEndTime) {
		this.doctorWorkEndTime = doctorWorkEndTime;
	}

	public String getSuggestedTest() {
		return suggestedTest;
	}

	public void setSuggestedTest(String suggestedTest) {
		this.suggestedTest = suggestedTest;
	}

	public String getTestValue() {
		return testValue;
	}

	public void setTestValue(String testValue) {
		this.testValue = testValue;
	}

	public String getTestResultUnit() {
		return testResultUnit;
	}

	public void setTestResultUnit(String testResultUnit) {
		this.testResultUnit = testResultUnit;
	}

	public int getDiagnosisID() {
		return diagnosisID;
	}

	public void setDiagnosisID(int diagnosisID) {
		this.diagnosisID = diagnosisID;
	}

	public String getCodeICD() {
		return codeICD;
	}

	public void setCodeICD(String codeICD) {
		this.codeICD = codeICD;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getlNotes() {
		return lNotes;
	}

	public void setlNotes(String lNotes) {
		this.lNotes = lNotes;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public int getDoctorPersonID() {
		return doctorPersonID;
	}

	public void setDoctorPersonID(int doctorPersonID) {
		this.doctorPersonID = doctorPersonID;
	}


	public Time getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(Time appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}
	
	
	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getConfirmedIndicator() {
		return confirmedIndicator;
	}

	public void setConfirmedIndicator(String confirmedIndicator) {
		this.confirmedIndicator = confirmedIndicator;
	}

	public Date getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public int getReferenceDoctorID() {
		return referenceDoctorID;
	}

	public void setReferenceDoctorID(int referenceDoctorID) {
		this.referenceDoctorID = referenceDoctorID;
	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}	

	public Time getTimeOfAppointment() {
		return timeOfAppointment;
	}

	public void setTimeOfAppointment(Time timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public void setNewDateProposed(Date newDateProposed) {
		this.newDateProposed = newDateProposed;
	}

	public Date getNewDateProposed() {
		return newDateProposed;
	}

	public void setNewTimeProposed(Time newTimeProposed) {
		this.newTimeProposed = newTimeProposed;
	}

	public Time getNewTimeProposed() {
		return newTimeProposed;
	}


}
