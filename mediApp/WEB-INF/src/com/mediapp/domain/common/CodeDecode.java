package com.mediapp.domain.common;

import java.util.ArrayList;


public class CodeDecode extends MediAppBaseDomain{
	
	private static final long serialVersionUID = 2L;
	
	private String codeCategory;
	
	private ArrayList<String>  codeDecode[][];

	public String getCodeCategory() {
		return codeCategory;
	}

	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}

	public ArrayList<String>[][] getCodeDecode() {
		return codeDecode;
	}

	public void setCodeDecode(ArrayList<String>[][] codeDecode) {
		this.codeDecode = codeDecode;
	}
	
}