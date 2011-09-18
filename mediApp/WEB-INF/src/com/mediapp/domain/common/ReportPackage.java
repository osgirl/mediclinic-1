package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

public class ReportPackage  extends MediAppBaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 123434L;


	private String reportName;
	
	private List<String> packageName;
	
	private String searchCriteria;

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}


	public List<String> getPackageName() {
		return packageName;
	}

	public void setPackageName(List<String> packageName) {
		this.packageName = packageName;
	}

	public String getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

}
