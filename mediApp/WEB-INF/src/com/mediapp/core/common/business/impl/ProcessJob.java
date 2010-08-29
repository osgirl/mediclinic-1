package com.mediapp.core.common.business.impl;

import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.core.common.dao.impl.CommonDAOImpl;
import com.mediapp.domain.common.ScheduleJob;

public class ProcessJob implements Runnable {
	
	private ScheduleJob eachJob;
	
	public ProcessJob(ScheduleJob eachJob){
		this.eachJob = eachJob;
	}
	
    public void run() {
      if ("Email".equals(eachJob.getActionToPerform()) ){
		  ScheduleEMail sendEmail = new ScheduleEMail( );
    	  if(CommonCoreConstants.REG_EMAIL_TYPE.equals(eachJob.getParameters().get("EmailType"))){
    		 // sendEmail.sendEmailForRegistration(eachJob.getParameters().get("EmailTo"));
    	  }
		  CommonDAO dao = new CommonDAOImpl();
		  boolean status =dao.updateJobCompletionStatus(eachJob);
      }else if ("SMS".equals(eachJob.getActionToPerform()) ){
		  SendSMS sendSMS = new SendSMS( );
    	  if(CommonCoreConstants.REG_EMAIL_TYPE.equals(eachJob.getParameters().get("SMSType"))){
    		  try{
    			  sendSMS.sendSMSForRegistration(eachJob.getParameters().get("PhoneNumber")) ;  
    		  }catch (Exception se){
    			  System.out.println("Error has occured.....");
    		  }
    	  }
      }
    }

  }

