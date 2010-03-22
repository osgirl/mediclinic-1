package com.mediapp.domain.common;

public class DiagnosticTests extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 5L;
	
	private int testID;
	
	private String suggestedTest;
	
	private String testValue;
	
	private String testUnit;

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public String getSuggestedTest() {
		return suggestedTest;
	}

	public void setSuggestedTest(String suggestedTest) {
		this.suggestedTest = suggestedTest;
	}

	public String getTestValue() {
		return testValue;
	}

	public void setTestValue(String testValue) {
		this.testValue = testValue;
	}

	public String getTestUnit() {
		return testUnit;
	}

	public void setTestUnit(String testUnit) {
		this.testUnit = testUnit;
	}
	
	

}
