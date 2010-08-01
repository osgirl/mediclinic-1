package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Time;

import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;


public class Appointment extends MediAppBaseDomain{
	private static final long serialVersionUID = 3L;
	
	private int appointmentID;
	
	private Date dateOfAppointment;
	
	private Time timeOfAppointment;
	
	private Time appointmentDuration;
	
	private Time appointmentEndTime;
	
	private String comments;
	
	private int patientID;
	
	private int patientPersonID;
	

	private int doctorPersonID;
	
	private int doctorID;
	
	private String confirmedIndicator;
	
	
	private List<Diagnosis> diagnosis = LazyList.decorate(
 				new ArrayList < Diagnosis > (),
				FactoryUtils.instantiateFactory(Diagnosis.class)); 
        

	
	private Date newDateProposed;
	
	private Time newTimeProposed;
	
	private Date followUpDate;
	
	private int referenceDoctorID;
	
	private String headline;	
	
	private int diagnosisID;
	
	private String doctorWorkStartTime;
	
	private String doctorWorkEndTime;
	
	private String workingHour;
	
	private String patientName;
	
	private String doctorName;
	
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

	public int getPatientPersonID() {
		return patientPersonID;
	}

	public void setPatientPersonID(int patientPersonID) {
		this.patientPersonID = patientPersonID;
	}

	
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


	public int getDiagnosisID() {
		return diagnosisID;
	}

	public void setDiagnosisID(int diagnosisID) {
		this.diagnosisID = diagnosisID;
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

	public List<Diagnosis> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(List<Diagnosis> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Time getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(Time appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	public String getWorkingHour() {
		return workingHour;
	}

	public void setWorkingHour(String workingHour) {
		this.workingHour = workingHour;
	}

	
}
