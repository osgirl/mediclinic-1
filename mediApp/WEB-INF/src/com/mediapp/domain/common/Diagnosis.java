package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

public class Diagnosis extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 4L;
	
	private int diagnosisID;
	
	private int appointmentID;
	
	private String codeICD;
	
	private String prescription;
	

	private String diagnosisTest;
	
	private String diagnosisTestResultUnit;
	
	private String diagnosisTestResultValue;
	
	private String diagnosis;

	
	private int testID;
	
    private List<String> prescriptionList = LazyList.decorate(
				new ArrayList < String > (),
			FactoryUtils.instantiateFactory(String.class)); 

    private List<String> testList = LazyList.decorate(
			new ArrayList < String > (),
		FactoryUtils.instantiateFactory(String.class)); 


	public List<String> getPrescriptionList() {
		return prescriptionList;
	}

	public void setPrescriptionList(List<String> prescriptionList) {
		this.prescriptionList = prescriptionList;
	}

	public List<String> getTestList() {
		return testList;
	}

	public void setTestList(List<String> testList) {
		this.testList = testList;
	}

	public int getDiagnosisID() {
		return diagnosisID;
	}

	public void setDiagnosisID(int diagnosisID) {
		this.diagnosisID = diagnosisID;
	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getCodeICD() {
		return codeICD;
	}

	public void setCodeICD(String codeICD) {
		this.codeICD = codeICD;
	}



	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getDiagnosisTest() {
		return diagnosisTest;
	}

	public void setDiagnosisTest(String diagnosisTest) {
		this.diagnosisTest = diagnosisTest;
	}

	public String getDiagnosisTestResultUnit() {
		return diagnosisTestResultUnit;
	}

	public void setDiagnosisTestResultUnit(String diagnosisTestResultUnit) {
		this.diagnosisTestResultUnit = diagnosisTestResultUnit;
	}

	public String getDiagnosisTestResultValue() {
		return diagnosisTestResultValue;
	}

	public void setDiagnosisTestResultValue(String diagnosisTestResultValue) {
		this.diagnosisTestResultValue = diagnosisTestResultValue;
	}

}
