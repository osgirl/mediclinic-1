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
	
	private int doctorID;
	
	private int appointmentSetterID;
	
	private String confirmedIndicator;
	
	private Date newDateProposed;
	
	private Time newTimeProposed;
	
	private Date followUpDate;
	
	private int referenceDoctorID;
	
	private String headline;	
	

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
