package com.mediapp.core.common.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smslib.AGateway;
import org.smslib.Group;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.Appointment;

public class ScheduleSMS {
	private CommonDAO commonDAO;

	public CommonDAO getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
    
    @SuppressWarnings("unchecked")
	public boolean scheduleRegistration(  String phoneNumber, String SMSType,  int personID) {
    	Map<String,String> criteria =  new HashMap < String, String > () ;
    	criteria.put("PhoneNumber", phoneNumber);
    	criteria.put("SMSType", SMSType);
    	Integer iPersonID = new Integer(personID);
    	String sPersonID = iPersonID.toString();
    	criteria.put("PersonID", sPersonID);
    	
    	boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
    	return status;
    }

    @SuppressWarnings("unchecked")
	public boolean scheduleNewAppointment( Appointment newAppointment) {
    	Map<String,String> criteria =  new HashMap < String, String > () ;
    	criteria.put("SMSType", "newAppointment");
    	Integer iAppointmentID = new Integer(newAppointment.getAppointmentID());
    	String sAppointmentID = iAppointmentID.toString();
    	criteria.put("AppointmentID",sAppointmentID );
    	boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
    	return status;
    }

    @SuppressWarnings("unchecked")
	public boolean scheduleAppointmentConfirmation(int appointmentID) {
    	Map<String,String> criteria =  new HashMap < String, String > () ;
    	criteria.put("SMSType", "appointmentConfirmation");
    	Integer iAppointmentID = new Integer( appointmentID);
    	String sAppointmentID = iAppointmentID.toString();
    	criteria.put("AppointmentID",sAppointmentID );
    	boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
    	return status;
    }

}
