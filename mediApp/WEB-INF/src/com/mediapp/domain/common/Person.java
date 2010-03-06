package com.mediapp.domain.common;

import java.util.Date;
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
    
    private String personTypeString;
    
    private String accountType;
    
    private final String key = "goodLord";
    
    private int idPerson;
    
    private String firstName;
    
    private String middleInitial;
    
    private String lastName;
    
    private Date dateOfBirth;
    
    private String gender;
    
    private Integer landlinePhoneNumber;
    
    private Integer cellPhoneNumber;
    
    private String accountStatus;
    
    public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getLandlinePhoneNumber() {
		return landlinePhoneNumber;
	}

	public void setLandlinePhoneNumber(Integer landlinePhoneNumber) {
		this.landlinePhoneNumber = landlinePhoneNumber;
	}

	public Integer getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(Integer cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getKey() {
		return key;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPersonTypeString() {
		return personTypeString;
	}

	public void setPersonTypeString(String personTypeString) {
		this.personTypeString = personTypeString;
	}

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