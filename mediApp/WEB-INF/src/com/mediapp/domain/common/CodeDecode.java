package com.mediapp.domain.common;



public class CodeDecode extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 2L;
	
	private String codeCategory;
	
	private String  codeDecode;

	public String getCodeCategory() {
		return codeCategory;
	}

	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}

	public String getCodeDecode() {
		return codeDecode;
	}
	

	public void setCodeDecode(String codeDecode) {
		this.codeDecode = codeDecode;
	}
	
}