package com.mediapp.domain.common;

import java.util.List;

public class LogonDomain  extends MediAppBaseDomain{
	private static final long serialVersionUID = 4582750755789720718L;
	private String userName;
	private String password;
	private String personType;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
