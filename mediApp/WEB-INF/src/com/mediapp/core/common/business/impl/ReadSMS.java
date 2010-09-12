package com.mediapp.core.common.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.smslib.AGateway;
import org.smslib.ICallNotification;
import org.smslib.IGatewayStatusNotification;
import org.smslib.IInboundMessageNotification;
import org.smslib.IOrphanedMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Service;
import org.smslib.AGateway.GatewayStatuses;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.Message.MessageTypes;
import org.smslib.modem.SerialModemGateway;


public class ReadSMS {
	Service srv;
	 public  synchronized  List<InboundMessage> getAllSMS() throws Exception{
			
			InboundNotification inboundNotification = new InboundNotification();
			CallNotification callNotification = new CallNotification();
			GatewayStatusNotification statusNotification = new GatewayStatusNotification();
			OrphanedMessageNotification orphanedMessageNotification = new OrphanedMessageNotification();
			srv = new Service();
			SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM1", 9600, "SIMCOM_SIM300", "300");
			gateway.setInbound(true);
			gateway.setOutbound(true);
			gateway.setSimPin("0000");
			this.srv.setInboundMessageNotification(inboundNotification);
			this.srv.setCallNotification(callNotification);
			this.srv.setGatewayStatusNotification(statusNotification);
			this.srv.setOrphanedMessageNotification(orphanedMessageNotification);
			
			//srv.setOutboundMessageNotification(outboundNotification);
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
			
			List<InboundMessage> msgList = new ArrayList<InboundMessage>();
			this.srv.readMessages(msgList, MessageClasses.ALL);
//			for (InboundMessage msgs : msgList)
//				System.out.println(msgs);
//			srv.stopService();
			return msgList;
	 }
	 
		public class InboundNotification implements IInboundMessageNotification
		{
			public void process(AGateway gateway, MessageTypes msgType, InboundMessage msg)
			{
				if (msgType == MessageTypes.INBOUND) System.out.println(">>> New Inbound message detected from Gateway: " + gateway.getGatewayId());
				else if (msgType == MessageTypes.STATUSREPORT) System.out.println(">>> New Inbound Status Report message detected from Gateway: " + gateway.getGatewayId());
				System.out.println(msg);
			}
		}

		public class CallNotification implements ICallNotification
		{
			public void process(AGateway gateway, String callerId)
			{
				System.out.println(">>> New call detected from Gateway: " + gateway.getGatewayId() + " : " + callerId);
			}
		}

		public class GatewayStatusNotification implements IGatewayStatusNotification
		{
			public void process(AGateway gateway, GatewayStatuses oldStatus, GatewayStatuses newStatus)
			{
				System.out.println(">>> Gateway Status change for " + gateway.getGatewayId() + ", OLD: " + oldStatus + " -> NEW: " + newStatus);
			}
		}

		public class OrphanedMessageNotification implements IOrphanedMessageNotification
		{
			public boolean process(AGateway gateway, InboundMessage msg)
			{
				System.out.println(">>> Orphaned message part detected from " + gateway.getGatewayId());
				System.out.println(msg);
				// Since we are just testing, return FALSE and keep the orphaned message part.
				return false;
			}
		}
	 
}
