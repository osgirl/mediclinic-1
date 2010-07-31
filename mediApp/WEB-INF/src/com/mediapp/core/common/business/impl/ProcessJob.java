package com.mediapp.core.common.business.impl;

import org.springframework.mail.javamail.JavaMailSender;

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
		  sendEmail.send(eachJob.getParameters().get("EmailTo"), eachJob.getParameters().get("EmailType"));
		  CommonDAO dao = new CommonDAOImpl();
		  boolean status =dao.updateJobCompletionStatus(eachJob);
      }
    }

  }

