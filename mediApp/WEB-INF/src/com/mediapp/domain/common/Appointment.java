package com.mediapp.domain.common;

import java.util.Date;

public class Appointment extends MediAppBaseDomain{
	private static final long serialVersionUID = 3L;
	
	private int appointmentID;
	
	private Date dateTimeOfAppointment; 
	
	private String comments;
	
	private int patientID;
	
	private int doctorID;
	
	private int appointmentSetterID;
	
	private String confirmedIndicator;
	
	
	private Date newDateTimeProposed;
	
	private Date followUpDate;
	
	private int referenceDoctorID;

	public int getAppointmentSetterID() {
		return appointmentSetterID;
	}

	public void setAppointmentSetterID(int appointmentSetterID) {
		this.appointmentSetterID = appointmentSetterID;
	}

	public String getConfirmedIndicator() {
		return confirmedIndicator;
	}

	public void setConfirmedIndicator(String confirmedIndicator) {
		this.confirmedIndicator = confirmedIndicator;
	}

	public Date getNewDateTimeProposed() {
		return newDateTimeProposed;
	}

	public void setNewDateTimeProposed(Date newDateTimeProposed) {
		this.newDateTimeProposed = newDateTimeProposed;
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

	public Date getDateTimeOfAppointment() {
		return dateTimeOfAppointment;
	}

	public void setDateTimeOfAppointment(Date dateTimeOfAppointment) {
		this.dateTimeOfAppointment = dateTimeOfAppointment;
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
	
}
