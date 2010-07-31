package com.mediapp.core.common.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.task.TaskExecutor;

import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.core.common.dao.impl.CommonDAOImpl;
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
				  //ScheduleEMail sendEmail = new ScheduleEMail( );
				  sendEmail.send(eachJob.getParameters().get("EmailTo"), eachJob.getParameters().get("EmailType"));
				  //CommonDAO dao = new CommonDAOImpl();
				  
		      }else if("SMS".equals(eachJob.getActionToPerform())){
		    	  
		      }
		      boolean status =commonDAO.updateJobCompletionStatus(eachJob);
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
	       		tempScheduleJob.setParameters(parmObject);
	       		jobDetailsToUse.add(tempScheduleJob);
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
		  for(ScheduleJob eachScheduleJob: jobDetailsToUse){
        	taskExecutor.execute(new ProcessJobInner(eachScheduleJob));
		  }

	 }

}
