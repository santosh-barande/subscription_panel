package com.subscription.models;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String subscriptionLevel;
	private String expiryDate;
	private CompanyPrivateDetails companyPrivateDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubscriptionLevel() {
		return subscriptionLevel;
	}

	public void setSubscriptionLevel(String subscriptionLevel) {
		this.subscriptionLevel = subscriptionLevel;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public CompanyPrivateDetails getCompanyPrivateDetails() {
		return companyPrivateDetails;
	}

	public void setCompanyPrivateDetails(CompanyPrivateDetails companyPrivateDetails) {
		this.companyPrivateDetails = companyPrivateDetails;
	}

}
