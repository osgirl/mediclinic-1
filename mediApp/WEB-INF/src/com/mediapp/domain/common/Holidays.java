package com.mediapp.domain.common;

import java.util.Date;

public class Holidays extends MediAppBaseDomain{
    /**
	 * 
	 */
	private static final long serialVersionUID = 133212232L; 
	
	private Date holidayDate;
	
	private String fromTime;
	
	private String toTime;

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	
}
