package com.mediapp.core.common.business.impl;

import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.ScheduleJob;

public class JobScheduler  {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private CommonDAO commonDAO;
	
	private ScheduledJob scheduledJob;

	public ScheduledJob getScheduledJob() {
		return scheduledJob;
	}

	public void setScheduledJob(ScheduledJob scheduledJob) {
		this.scheduledJob = scheduledJob;
	}

	public CommonDAO getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	private TaskExecutor taskExecutor;

	 public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}


	public void executeJob(){		
		List <ScheduleJob> jobsToSchedule=commonDAO.getJobsToRun();
		//public Map getJobParms() throws DataAccessException
		
		//ScheduledJob scheduleJob= new ScheduledJob(taskExecutor);
		scheduledJob.processJob(jobsToSchedule);
	  }


	
}
