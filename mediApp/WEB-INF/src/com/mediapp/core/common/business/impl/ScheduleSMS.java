package com.mediapp.core.common.business.impl;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smslib.AGateway;
import org.smslib.Group;
import org.smslib.IOutboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.HolidayCalendarList;
import com.mediapp.domain.common.IncomingMessages;
import com.mediapp.domain.common.NotificationDetails;

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
    	boolean status=true;
    	//boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
    	return status;
    }

    @SuppressWarnings("unchecked")
	public boolean scheduleNewAppointment( Appointment newAppointment) {
    //	Map<String,String> criteria =  new HashMap < String, String > () ;
    //	criteria.put("SMSType", "newAppointment");
    	Integer iAppointmentID = new Integer(newAppointment.getAppointmentID());
    //	String sAppointmentID = iAppointmentID.toString();
    	//criteria.put("AppointmentID",sAppointmentID );
		NotificationDetails notification = commonDAO
				.getNotificationDetails(iAppointmentID);
		String text = notification.getPatientName()+" has set appointment on "+ convertStringToDate(newAppointment.getDateOfAppointment())+ " at "+ newAppointment.getTimeOfAppointment() +". Please logon and confirm.Thanks.";
		boolean status = commonDAO.sendOutSMS(notification.getDoctorMobileNumber(), text);
    	//boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
    	return status;
    }
    
	private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			df.setLenient(false);
			// System.out.println("created");
			return df;
		}
	};

	private static final ThreadLocal<SimpleDateFormat> timeFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			df.setLenient(false);
			// System.out.println("created");
			return df;
		}
	};
	
	public static String convertStringToDate(Date date) {
		return dateFormat.get().format(date);
	}

	public static String convertStringToTime(Time time) {
		return dateFormat.get().format(time);
	}

    
    @SuppressWarnings("unchecked")
	public boolean scheduleRescheduleAppointment( Appointment newAppointment) {
//    	Map<String,String> criteria =  new HashMap < String, String > () ;
 //   	criteria.put("SMSType", "rescheduledAppointment");
    	Integer iAppointmentID = new Integer(newAppointment.getAppointmentID());
//    	String sAppointmentID = iAppointmentID.toString();
 //   	criteria.put("AppointmentID",sAppointmentID );
  //  	boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
		NotificationDetails notification = commonDAO
		.getNotificationDetails(iAppointmentID);
		String text = notification.getPatientName()+" has rescheduled appointment to "+ convertStringToDate(newAppointment.getDateOfAppointment())+ " at "+ newAppointment.getTimeOfAppointment() +". Please logon and confirm.Thanks.";
		boolean status = commonDAO.sendOutSMS(notification.getDoctorMobileNumber(), text);

    	return status;
    }

    @SuppressWarnings("unchecked")
	public boolean scheduleAppointmentConfirmation(int appointmentID) {
/*    	Map<String,String> criteria =  new HashMap < String, String > () ;
    	criteria.put("SMSType", "appointmentConfirmation");
    	Integer iAppointmentID = new Integer( appointmentID);
    	String sAppointmentID = iAppointmentID.toString();
    	criteria.put("AppointmentID",sAppointmentID );
    	boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
*/
		NotificationDetails notification = commonDAO
		.getNotificationDetails(appointmentID);
		Appointment appointment = commonDAO
		.getAppointment(appointmentID);
		String text = notification.getDoctorMobileNumber() +" has confirmed appointment "+ convertStringToDate(appointment.getDateOfAppointment())+ " at "+ appointment.getTimeOfAppointment() +".";
		boolean status = commonDAO.sendOutSMS(notification.getPatientMobileNumber(), text);

    	return status;
    }
    
    public boolean scheduleAppointmentCancellation(int idPerson){
/*    	Map<String,String> criteria =  new HashMap < String, String > () ;
    	criteria.put("SMSType", "cancelAllAppointment");
    	Integer iPersonID = new Integer(idPerson);
    	String sPersonID = iPersonID.toString();
    	criteria.put("PersonID",sPersonID );
    	boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
*/
		List<Appointment> appointment = commonDAO
		.getAppointmentAll(idPerson);
		List<NotificationDetails> notification = commonDAO
		.getNotificationDetailsAll(idPerson);
		int count = 0;
		boolean status =true;
		commonDAO.sendOutSMSBatchClient(notification, appointment);
/*		for (Appointment eachAppointment : appointment) {
			String text = notification.get(count).getDoctorMobileNumber() +" has cancelled appointment "+ convertStringToDate(eachAppointment.getDateOfAppointment().toString())+ " at "+ convertStringToTime(eachAppointment.getDateOfAppointment().toString()) +".";
			status = commonDAO.sendOutSMS(notification.get(count).getPatientMobileNumber(), text);
			count = count + 1;
		}
*/

    	return status;
    }

    public boolean sendErrorSMS(IncomingMessages readMessage,String message){
/*    	Map<String,String> criteria =  new HashMap < String, String > () ;
    	criteria.put("SMSType", "sendErrorSMS");
    	criteria.put("PhoneNumber", readMessage.getSenderNumber());
    	criteria.put("Message", message);
    	boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
*/
    	String text = "Error occurred in processing your SMS.";
    	boolean status = commonDAO.sendOutSMS(readMessage.getSenderNumber(), text);
    	
    	return status;
    }

    
}
