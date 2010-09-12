package com.mediapp.core.common.business.impl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.smslib.InboundMessage;
import org.springframework.core.task.TaskExecutor;

import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.core.common.dao.impl.CommonDAOImpl;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.IncomingMessages;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.ScheduleJob;

public class ScheduledJob {

	private List<ScheduleJob> jobDetails;
	
	  private TaskExecutor taskExecutor;
	  
	  private ScheduleEMail sendEmail ;

	  private CommonDAO commonDAO;
	  
	private enum MessageTypes
		{
			/**
			 * Schedule an Appointment.
			 */
			SCD,
			/**
			 * Re-Schedule an Appointment.
			 */
			RESCD,
			/**
			 * Cancel an Appointment.
			 */
			CANCEL,
			/**
			 * View available slots for AppMent.
			 */
			GETTIME,
			/**
			 * Help.
			 */
			HELP
		}
	  
	  public List<ScheduleJob> getJobDetails() {
		return jobDetails;
	}


	public void setJobDetails(List<ScheduleJob> jobDetails) {
		this.jobDetails = jobDetails;
	}


	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}


	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}


	public ScheduleEMail getSendEmail() {
		return sendEmail;
	}


	public void setSendEmail(ScheduleEMail sendEmail) {
		this.sendEmail = sendEmail;
	}


	public CommonDAO getCommonDAO() {
		return commonDAO;
	}


	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}



	  private class ProcessJobInner implements Runnable {
			
			private ScheduleJob eachJob;
			
			public ProcessJobInner(ScheduleJob eachJob){
				this.eachJob = eachJob;
			}
			
		    public void run() {
		    	
		        if ("Email".equals(eachJob.getActionToPerform()) ){
		  		  ScheduleEMail sendEmail = new ScheduleEMail( );
			        if (eachJob.getActionToPerform()!=null ){
			        	eachJob.setJobStatus("UPRS");
			        	boolean status =commonDAO.updateJobCompletionStatus(eachJob);
			        }

		      	  if(CommonCoreConstants.REG_EMAIL_TYPE.equals(eachJob.getParameters().get("EmailType"))){
		      		  Person inputPerson = new Person();
		      		  inputPerson.setUsername(eachJob.getParameters().get("UserName"));		      		  
		      		  sendEmail.sendEmailForRegistration(commonDAO.getPersonDetails(inputPerson));
		      	  }else if("newAppointment".equals(eachJob.getParameters().get("EmailType"))){
		      		  Integer iAppointmentID = new Integer(eachJob.getParameters().get("AppointmentID"));		      		  
		      		  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
		      		  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
		      		  sendEmail.sendEmailForNewAppointment(appointment, notification);
		      	  }else if("appointmentConfirmation".equals(eachJob.getParameters().get("EmailType"))){
		      		  Integer iAppointmentID = new Integer(eachJob.getParameters().get("AppointmentID"));		      		  
		      		  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
		      		  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
		      		  sendEmail.sendEmailForRescheduledAppointment(appointment, notification);
		      	  }else if("rescheduledAppointment".equals(eachJob.getParameters().get("EmailType"))){
		      		  Integer iAppointmentID = new Integer(eachJob.getParameters().get("AppointmentID"));		      		  
		      		  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
		      		  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
		      		  sendEmail.sendEmailForRescheduledAppointment(appointment, notification);
		      	  }else if("cancelAllAppointment".equals(eachJob.getParameters().get("EmailType"))){
		      		  Integer iPersonID = new Integer(eachJob.getParameters().get("PersonID"));
		      		  List <Appointment> appointment = commonDAO.getAppointmentAll(iPersonID);		      		  
		      		  List <NotificationDetails> notification = commonDAO.getNotificationDetailsAll(iPersonID);
		      		  try{
		      			  int count = 0;
		      			  for(Appointment eachAppointment:appointment){
		      				  sendEmail.sendEmailForCancellationAllAppointment(eachAppointment, notification.get(count));
		      				  count=count+1;
		      			  }
		      		  }catch (Exception se){
		      			System.out.println(se.toString());
		    			System.err.println("stacktrace"+se);

		      		  }
		      		  
		      	  }

		        }
		        if (eachJob.getActionToPerform()!=null ){
		        	eachJob.setJobStatus("CMPL");
		        	boolean status =commonDAO.updateJobCompletionStatus(eachJob);
		        }
		      }
		  }

	  
	  public void processJob(List<ScheduleJob> jobDetails) {
		  this.jobDetails = jobDetails;
		  int prevJobId = 0;
		  List<ScheduleJob> jobDetailsToUse = new ArrayList<ScheduleJob>();
		  HashMap <String,String> parmObject =  new HashMap < String, String > () ;
		  ScheduleJob tempScheduleJob = new ScheduleJob();
		  for(ScheduleJob eachjobToSchedule: jobDetails) {
	       	if(prevJobId !=  eachjobToSchedule.getJobId()){	       		
	       		if(prevJobId > 0){
	       			tempScheduleJob.setParameters(parmObject);
	       			jobDetailsToUse.add(tempScheduleJob);	
	       		}	       		
	       		prevJobId = eachjobToSchedule.getJobId();
	       		tempScheduleJob = new ScheduleJob();
	       		parmObject =  new HashMap < String, String > () ;
	       		tempScheduleJob.setActionToPerform(eachjobToSchedule.getActionToPerform());
	       		tempScheduleJob.setComments(eachjobToSchedule.getComments());
	       		tempScheduleJob.setJobId(eachjobToSchedule.getJobId());
	       		parmObject.put(eachjobToSchedule.getParameterName(), eachjobToSchedule.getParameterValue());	       		
	       	}else{
	       		parmObject.put(eachjobToSchedule.getParameterName(), eachjobToSchedule.getParameterValue());
	       	}
		  }
		  tempScheduleJob.setParameters(parmObject);
		  jobDetailsToUse.add(tempScheduleJob);
		  List<ScheduleJob> jobDetailsToUseForSMS = new ArrayList<ScheduleJob>();
		  for(ScheduleJob eachScheduleJob: jobDetailsToUse){
			if("SMS".equals(eachScheduleJob.getActionToPerform())){
				jobDetailsToUseForSMS.add(eachScheduleJob);
			}else{
				taskExecutor.execute(new ProcessJobInner(eachScheduleJob));
			}
		  }
    	try{
    		ReadSMS readSMS = new ReadSMS();
    		List<InboundMessage>messageList=readSMS.getAllSMS();
    		if(messageList.size()>0){
    			commonDAO.insertInboundMessages(messageList);	
    		}
    	}catch (Exception se){
			System.out.println(se.toString());
			System.err.println("stacktrace"+se);

	    }
		  
		if(jobDetailsToUseForSMS.size()>0){
		  taskExecutor.execute(new ProcessJobInnerSMS(jobDetailsToUseForSMS));
		}
		  String uuid = UUID.randomUUID().toString();
			 boolean status = commonDAO.updateIncomingSMSJob(null, "SCDL", uuid, "UPRS");
			  if(status){
				  List<IncomingMessages> incomingMessages =commonDAO.getReadMessages(uuid);
				  for(IncomingMessages eachMessage: incomingMessages){
					  taskExecutor.execute(new ProcessReadSMS(eachMessage));
				  }

			  
			  }

	 }
	  
	  private class ProcessJobInnerSMS implements Runnable {
			
			private List<ScheduleJob> allSMSJobs;
			
			public ProcessJobInnerSMS(List<ScheduleJob> allSMSJobs){
				this.allSMSJobs = allSMSJobs;
			}
			
		    public void run() {
		    	  for(ScheduleJob eachjobToSchedule: allSMSJobs) {
				  if ("SMS".equals(eachjobToSchedule.getActionToPerform()) ){
					  SendSMS sendSMS = new SendSMS( );
				  if(CommonCoreConstants.REG_EMAIL_TYPE.equals(eachjobToSchedule.getParameters().get("SMSType"))){
					  try{
						  sendSMS.sendSMSForRegistration(eachjobToSchedule.getParameters().get("PhoneNumber")) ;  
					  }catch (Exception se){
						System.out.println(se.toString());
						System.err.println("stacktrace"+se);

					  }
				  }else if("newAppointment".equals(eachjobToSchedule.getParameters().get("SMSType"))){
					  Integer iAppointmentID = new Integer(eachjobToSchedule.getParameters().get("AppointmentID"));		      		  
					  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
					  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
					  try{
						  sendSMS.sendSMSForNewAppointment(appointment, notification) ;  
					  }catch (Exception se){
						System.out.println(se.toString());
						System.err.println("stacktrace"+se);

					  }

				  }else if("appointmentConfirmation".equals(eachjobToSchedule.getParameters().get("SMSType"))){
					  Integer iAppointmentID = new Integer(eachjobToSchedule.getParameters().get("AppointmentID"));		      		  
					  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
					  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
					  try{
						  sendSMS.sendSMSForAppointmentConfirmation(appointment, notification) ;  
					  }catch (Exception se){
						System.out.println(se.toString());
						System.err.println("stacktrace"+se);

					  }

				  }else if("rescheduledAppointment".equals(eachjobToSchedule.getParameters().get("SMSType"))){
					  Integer iAppointmentID = new Integer(eachjobToSchedule.getParameters().get("AppointmentID"));		      		  
					  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
					  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
					  try{
						  sendSMS.sendSMSForRescheduledAppointment(appointment, notification) ;  
					  }catch (Exception se){
						System.out.println(se.toString());
						System.err.println("stacktrace"+se);

					  }

				  }else if("cancelAllAppointment".equals(eachjobToSchedule.getParameters().get("SMSType"))){
					  Integer iPersonID = new Integer(eachjobToSchedule.getParameters().get("PersonID"));
					  //String appointmentList = commonDAO.getAppointmentList(iPersonID);
					  List <Appointment> appointment = commonDAO.getAppointmentAll(iPersonID);		      		  
					  List <NotificationDetails> notification = commonDAO.getNotificationDetailsAll(iPersonID);
					  try{
						  int count = 0;
						  for(Appointment eachAppointment:appointment){
							sendSMS.sendSMSForAllCancelledAppointment(eachAppointment, notification.get(count)) ;
							count=count+1;
							wait(200);
						  }
						  //sendSMS.sendSMSForRescheduledAppointment(appointment, notification) ;  
					  }catch (Exception se){
						System.out.println(se.toString());
						System.err.println("stacktrace"+se);

					  }

				  }
				}
			        if (eachjobToSchedule.getActionToPerform()!=null ){
			        	boolean status =commonDAO.updateJobCompletionStatus(eachjobToSchedule);
			        }

		        }
		      }
		  }
	  
	  private class ProcessReadSMS implements Runnable {
			private IncomingMessages readMessage;
			
			public ProcessReadSMS(IncomingMessages readMessage){
				this.readMessage = readMessage;
			}
		  public void run() {
			  boolean exists = false;
			  MessageTypes action = null;
			  String[] splitString =null;
			  for(MessageTypes eachElement : EnumSet.allOf(MessageTypes.class)){
				  splitString=readMessage.getMessageText().split(" ");
				  if(eachElement.name().equals(splitString[0])){
					  exists=true;
					  action= eachElement.valueOf(splitString[0]);
					  break;
				  }
			  }
			  switch (action){
			  	case CANCEL:
			  	case GETTIME:
			  	case RESCD:
			  	case SCD:
			  	case HELP:
			  	default:
			  }
			  
		  }
	  }
}
