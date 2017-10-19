package com.att.omni.model;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class DocumentsUpload {

	
	private File ContractFile;
	private File CustomerIDFile;
	private File AddressProofFile;
	private File AuthenticityForm;
	private File CCRecurringChargeConsent;
	private File IncomeProof;
	private File PaymentReceipt;
	private File ChangeofOwnershipForm;
	
	public File getContractFile() {
		return ContractFile;
	}
	public void setContractFile(File contractFile) {
		ContractFile = contractFile;
	}
	public File getCustomerIDFile() {
		return CustomerIDFile;
	}
	public void setCustomerIDFile(File customerIDFile) {
		CustomerIDFile = customerIDFile;
	}
	public File getAddressProofFile() {
		return AddressProofFile;
	}
	public void setAddressProofFile(File addressProofFile) {
		AddressProofFile = addressProofFile;
	}
	public File getAuthenticityForm() {
		return AuthenticityForm;
	}
	public void setAuthenticityForm(File authenticityForm) {
		AuthenticityForm = authenticityForm;
	}
	public File getCCRecurringChargeConsent() {
		return CCRecurringChargeConsent;
	}
	public void setCCRecurringChargeConsent(File cCRecurringChargeConsent) {
		CCRecurringChargeConsent = cCRecurringChargeConsent;
	}
	public File getIncomeProof() {
		return IncomeProof;
	}
	public void setIncomeProof(File incomeProof) {
		IncomeProof = incomeProof;
	}
	public File getPaymentReceipt() {
		return PaymentReceipt;
	}
	public void setPaymentReceipt(File paymentReceipt) {
		PaymentReceipt = paymentReceipt;
	}
	public File getChangeofOwnershipForm() {
		return ChangeofOwnershipForm;
	}
	public void setChangeofOwnershipForm(File changeofOwnershipForm) {
		ChangeofOwnershipForm = changeofOwnershipForm;
	}


}
