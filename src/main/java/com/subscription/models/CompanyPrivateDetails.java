package com.subscription.models;

import java.io.Serializable;

public class CompanyPrivateDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tanNumber;
	private String registrationNumber;

	public String getTanNumber() {
		return tanNumber;
	}

	public void setTanNumber(String tanNumber) {
		this.tanNumber = tanNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}
