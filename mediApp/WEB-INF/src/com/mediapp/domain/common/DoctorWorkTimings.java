package com.mediapp.domain.common;

import java.sql.Time;

public class DoctorWorkTimings extends MediAppBaseDomain{
	private static final long serialVersionUID = 34L;

	private String workDayName;
	
	private Time startTime;
	
	private Time endTime;

	public String getWorkDayName() {
		return workDayName;
	}

	public void setWorkDayName(String workDayName) {
		this.workDayName = workDayName;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	
}
