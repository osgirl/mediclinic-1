package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.ReportPackage;

public class AppointmentList {
	List<Appointment> appointmentList = new ArrayList<Appointment>();

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}


}
