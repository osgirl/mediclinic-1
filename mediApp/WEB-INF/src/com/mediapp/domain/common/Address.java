package com.mediapp.domain.common;

public class Address extends MediAppBaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idAddress;

	private String address1;

	private String address2;

	private String locality;

	private String city;

	private String state;

	private String country;

	private Long idPerson;

	public Long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}


}
