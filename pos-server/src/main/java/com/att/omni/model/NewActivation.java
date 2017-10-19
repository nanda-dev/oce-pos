package com.att.omni.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "NewActivation")
public class NewActivation {

	@Id
	private long id;
	private String userId;
	private Map<String, CustomerInformation> customerInformation;
	private Map<String, PersonalInformation> personalInformation;
	private Map<String, Identification> identification;
	private Map<String, ContactInformation> contactInformation;
	private Map<String, Address> customerAddress;
	private Map<String, Address> billingAddress;
	private Map<String, AccountOptions> accountOptions;
	private Map<String, CreditQuestions> creditQuestions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, CustomerInformation> getCustomerInformation() {
		return customerInformation;
	}

	public void setCustomerInformation(Map<String, CustomerInformation> customerInformation) {
		this.customerInformation = customerInformation;
	}

	public Map<String, PersonalInformation> getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(Map<String, PersonalInformation> personalInformation) {
		this.personalInformation = personalInformation;
	}

	public Map<String, Identification> getIdentification() {
		return identification;
	}

	public void setIdentification(Map<String, Identification> identification) {
		this.identification = identification;
	}

	public Map<String, ContactInformation> getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(Map<String, ContactInformation> contactInformation) {
		this.contactInformation = contactInformation;
	}

	public Map<String, Address> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Map<String, Address> customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Map<String, Address> getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Map<String, Address> billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Map<String, AccountOptions> getAccountOptions() {
		return accountOptions;
	}

	public void setAccountOptions(Map<String, AccountOptions> accountOptions) {
		this.accountOptions = accountOptions;
	}

	public Map<String, CreditQuestions> getCreditQuestions() {
		return creditQuestions;
	}

	public void setCreditQuestions(Map<String, CreditQuestions> creditQuestions) {
		this.creditQuestions = creditQuestions;
	}

}
