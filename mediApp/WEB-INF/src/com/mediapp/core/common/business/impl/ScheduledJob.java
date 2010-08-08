package com.mediapp.core.common.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.task.TaskExecutor;

import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.core.common.dao.impl.CommonDAOImpl;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.ScheduleJob;

public class ScheduledJob {

	private List<ScheduleJob> jobDetails;
	
	  private TaskExecutor taskExecutor;
	  
	  private ScheduleEMail sendEmail ;

	  private CommonDAO commonDAO;
	  
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
		      	  if(CommonCoreConstants.REG_EMAIL_TYPE.equals(eachJob.getParameters().get("EmailType"))){
		      		  sendEmail.sendEmailForRegistration(eachJob.getParameters().get("EmailTo"));
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

		        }else if ("SMS".equals(eachJob.getActionToPerform()) ){
		  		  SendSMS sendSMS = new SendSMS( );
		      	  if(CommonCoreConstants.REG_EMAIL_TYPE.equals(eachJob.getParameters().get("SMSType"))){
		      		  try{
		      			  sendSMS.sendSMSForRegistration(eachJob.getParameters().get("PhoneNumber")) ;  
		      		  }catch (Exception se){
		      			System.out.println(se.toString());
		    			System.err.println("stacktrace"+se);

		      		  }
		      	  }else if("newAppointment".equals(eachJob.getParameters().get("SMSType"))){
		      		  Integer iAppointmentID = new Integer(eachJob.getParameters().get("AppointmentID"));		      		  
		      		  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
		      		  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
		      		  try{
		      			  sendSMS.sendSMSForNewAppointment(appointment, notification) ;  
		      		  }catch (Exception se){
		      			System.out.println(se.toString());
		    			System.err.println("stacktrace"+se);

		      		  }
		      		  
		      	  }else if("appointmentConfirmation".equals(eachJob.getParameters().get("SMSType"))){
		      		  Integer iAppointmentID = new Integer(eachJob.getParameters().get("AppointmentID"));		      		  
		      		  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
		      		  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
		      		  try{
		      			  sendSMS.sendSMSForAppointmentConfirmation(appointment, notification) ;  
		      		  }catch (Exception se){
		      			System.out.println(se.toString());
		    			System.err.println("stacktrace"+se);

		      		  }
		      		  
		      	  }else if("rescheduledAppointment".equals(eachJob.getParameters().get("SMSType"))){
		      		  Integer iAppointmentID = new Integer(eachJob.getParameters().get("AppointmentID"));		      		  
		      		  Appointment appointment = commonDAO.getAppointment(iAppointmentID.intValue());		      		  
		      		  NotificationDetails notification = commonDAO.getNotificationDetails(iAppointmentID);
		      		  try{
		      			  sendSMS.sendSMSForRescheduledAppointment(appointment, notification) ;  
		      		  }catch (Exception se){
		      			System.out.println(se.toString());
		    			System.err.println("stacktrace"+se);

		      		  }
		      		  
		      	  }else if("cancelAllAppointment".equals(eachJob.getParameters().get("SMSType"))){
		      		  Integer iPersonID = new Integer(eachJob.getParameters().get("PersonID"));
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
		        if (eachJob.getActionToPerform()!=null ){
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
		  for(ScheduleJob eachScheduleJob: jobDetailsToUse){
        	taskExecutor.execute(new ProcessJobInner(eachScheduleJob));
		  }

	 }

}
