package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.ReportPackage;

public class Appointments {
	List <List<Appointment>> inboxList = new ArrayList<List<Appointment>>();

	public List<List<Appointment>> getInboxList() {
		return inboxList;
	}

	public void setInboxList(List<List<Appointment>> inboxList) {
		this.inboxList = inboxList;
	}
}
