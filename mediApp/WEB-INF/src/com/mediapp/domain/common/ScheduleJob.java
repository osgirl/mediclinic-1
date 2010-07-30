package com.mediapp.domain.common;

public class ScheduleJob extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 411L;

	private int jobId;
	
	private String actionToPerform;
	
	private String comments;
	
	private String parameterName;
	
	private String parameterValue;

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
