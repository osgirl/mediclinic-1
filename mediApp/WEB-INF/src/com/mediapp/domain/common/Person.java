package com.mediapp.domain.common;

import java.util.List;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;


public class Person extends MediAppBaseDomain{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

    private String password;
    
    private String emailID;

    private boolean authenticated;
    
    private CodeDecode personType;
    
        
    public CodeDecode getPersonType() {
		return personType;
	}
	
	public void setPersonType(CodeDecode personType) {
		this.personType = personType;
	}


	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	/**
	 * @return the authenticated
	 */
	public boolean isAuthenticated() {
		return authenticated;
	}

	/**
	 * @param authenticated the authenticated to set
	 */
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
    
}