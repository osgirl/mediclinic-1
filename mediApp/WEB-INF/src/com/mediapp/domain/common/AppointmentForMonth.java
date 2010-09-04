package com.mediapp.domain.common;

import java.util.Date;

public class AppointmentForMonth extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 4L;

	private Date dateOfAppointment;
	
	private int appointmentCount;
	
	private String isWorking;

	public String getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(String isWorking) {
		this.isWorking = isWorking;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public int getAppointmentCount() {
		return appointmentCount;
	}

	public void setAppointmentCount(int appointmentCount) {
		this.appointmentCount = appointmentCount;
	}


}
