package com.mediapp.domain.common;

public class Help extends MediAppBaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1233434L;
	
	private String pageName;
	
	private String componentName;
	
	private String helpText;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}
}
