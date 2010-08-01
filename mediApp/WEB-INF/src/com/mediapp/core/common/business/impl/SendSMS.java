package com.mediapp.core.common.business.impl;

import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.NotificationDetails;


public class SendSMS {
    public  synchronized  void sendSMSForRegistration(String cellPhoneNumber) throws Exception{
		Service srv;
		OutboundMessage msg;
		OutboundNotification outboundNotification = new OutboundNotification();
		srv = new Service();
		SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM1", 9600, "SIMCOM_SIM300", "300");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin("0000");
		srv.setOutboundMessageNotification(outboundNotification);
		srv.addGateway(gateway);
		boolean success = false;
		while (!success){
			try{
				srv.startService();
				success=true;
			}catch (org.smslib.GatewayException se){
				System.err.println("stacktrace"+se);
				wait(200);

			}
		}
		msg = new OutboundMessage(cellPhoneNumber, "Hello from MediApp.Your password is 'mediApp'. ");
		srv.sendMessage(msg);
		System.out.println(msg);
		srv.stopService();
    }

    public  synchronized  void sendSMSForNewAppointment( Appointment  appointment, NotificationDetails notificationDetails) throws Exception{
		Service srv;
		OutboundMessage msg;
		OutboundNotification outboundNotification = new OutboundNotification();
		srv = new Service();
		SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM1", 9600, "SIMCOM_SIM300", "300");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin("0000");
		srv.setOutboundMessageNotification(outboundNotification);
		srv.addGateway(gateway);
		boolean success = false;
		while (!success){
			try{
				srv.startService();
				success=true;
			}catch (org.smslib.GatewayException se){
				System.err.println("stacktrace"+se);
				wait(200);

			}
		}
		msg = new OutboundMessage(notificationDetails.getDoctorMobileNumber(), notificationDetails.getPatientName()+" has set appointment on "+appointment.getDateOfAppointment()+". Please logon and confirm.Thanks.");
		srv.sendMessage(msg);
		System.out.println(msg);
		srv.stopService();
    }


    public  synchronized  void sendSMSForAppointmentConfirmation( Appointment  appointment, NotificationDetails notificationDetails) throws Exception{
		Service srv;
		OutboundMessage msg;
		OutboundNotification outboundNotification = new OutboundNotification();
		srv = new Service();
		SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM1", 9600, "SIMCOM_SIM300", "300");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin("0000");
		srv.setOutboundMessageNotification(outboundNotification);
		srv.addGateway(gateway);
		boolean success = false;
		while (!success){
			try{
				srv.startService();
				success=true;
			}catch (org.smslib.GatewayException se){
				System.err.println("stacktrace"+se);
				wait(200);

			}
		}
		msg = new OutboundMessage(notificationDetails.getPatientMobileNumber(), " Appointment on "+appointment.getDateOfAppointment()+" at "+ appointment.getTimeOfAppointment()+" with "+notificationDetails.getDoctorName()+" is confirmed. Please logon and confirm.Thanks.");
		srv.sendMessage(msg);
		System.out.println(msg);
		srv.stopService();
    }

    
	public class OutboundNotification implements IOutboundMessageNotification
	{
		public void process(AGateway gateway, OutboundMessage msg)
		{
			System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
			System.out.println(msg);
		}
	}

}
