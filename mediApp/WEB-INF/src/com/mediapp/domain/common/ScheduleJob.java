package com.mediapp.domain.common;

import java.util.HashMap;

public class ScheduleJob extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 411L;

	private int jobId;
	
	private String actionToPerform;
	
	private String comments;
	
	private HashMap <String, String> parameters;
	
	private String parameterName;
	
	private String parameterValue;
	
	private String jobStatus;
	
	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getActionToPerform() {
		return actionToPerform;
	}

	public void setActionToPerform(String actionToPerform) {
		this.actionToPerform = actionToPerform;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public HashMap<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}


}
