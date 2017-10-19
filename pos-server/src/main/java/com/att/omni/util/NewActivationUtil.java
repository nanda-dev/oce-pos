package com.att.omni.util;

import java.io.File;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.att.omni.model.AccountOptions;
import com.att.omni.model.Address;
import com.att.omni.model.ContactInformation;
import com.att.omni.model.CreditQuestions;
import com.att.omni.model.CustomerInformation;
import com.att.omni.model.DocumentsUpload;
import com.att.omni.model.Identification;
import com.att.omni.model.PersonalInformation;

public class NewActivationUtil {

	public static PersonalInformation getPersonalInfo(Map<Object, Object> mapPersonalInfo) throws ParseException {

		PersonalInformation personalInformation = new PersonalInformation();
		personalInformation.setUserId(mapPersonalInfo.get("userId") == null ? "" : mapPersonalInfo.get("userId").toString());
		personalInformation.setFirstName(mapPersonalInfo.get("firstName") == null ? "" : mapPersonalInfo.get("firstName").toString());
		personalInformation.setMiddleName(mapPersonalInfo.get("middleName") == null ? "" : mapPersonalInfo.get("middleName").toString());
		personalInformation.setLastname(mapPersonalInfo.get("lastname") == null ? "" : mapPersonalInfo.get("lastname").toString());

		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateofBirth = (Date) ((DateFormat) formatter).parse(mapPersonalInfo.get("dob") == null ? "" : mapPersonalInfo.get("dob").toString());
		personalInformation.setDob(dateofBirth);

		personalInformation.setGender(mapPersonalInfo.get("gender") == null ? "" : mapPersonalInfo.get("gender").toString());
		personalInformation.setEmployerName(mapPersonalInfo.get("employerName") == null ? "" : mapPersonalInfo.get("employerName").toString());
		personalInformation.setMonthlyIncomeRange(mapPersonalInfo.get("monthlyIncomeRange") == null ? "" : mapPersonalInfo.get("monthlyIncomeRange").toString());

		return personalInformation;

	}

	public static CustomerInformation getCustomerInformation(Map<Object, Object> mapCustomerInformation) {

		CustomerInformation customerInformation = new CustomerInformation();
		customerInformation.setCategory(mapCustomerInformation.get("category") == null ? "" : mapCustomerInformation.get("category").toString());
		customerInformation.setCustomerSubType(mapCustomerInformation.get("customerSubType") == null ? "" : mapCustomerInformation.get("customerSubType").toString());
		customerInformation.setCustomerType(mapCustomerInformation.get("customerType") == null ? "" : mapCustomerInformation.get("customerType").toString());

		return customerInformation;
	}

	public static Identification getIdentification(Map<Object, Object> mapIdentification) {
		
		Identification identification = new Identification();
		identification.setCategoryIdNumber(mapIdentification.get("categoryIdNumber") == null ? "" :mapIdentification.get("categoryIdNumber").toString());
		identification.setCategoryIdType(mapIdentification.get("categoryIdType") == null ? "" :mapIdentification.get("categoryIdType").toString());
		identification.setCurpID(mapIdentification.get("curpID") == null ? "" : mapIdentification.get("curpID").toString());
		identification.setCurpValidation(mapIdentification.get("curpValidation") == null ? "" :mapIdentification.get("curpValidation").toString());
		identification.setIdNumber(mapIdentification.get("curpValidation") == null ? "" :mapIdentification.get("curpValidation").toString());
		identification.setIdProof(mapIdentification.get("idProof") == null ? "" :mapIdentification.get("idProof").toString());
		identification.setMexicoCitizen(mapIdentification.get("mexicoCitizen") == null ? "" :mapIdentification.get("mexicoCitizen").toString());
		identification.setRfc(mapIdentification.get("rfc") == null ? "" :mapIdentification.get("rfc").toString());
		identification.setRfcvalidation(mapIdentification.get("rfcvalidation") == null ? "" :mapIdentification.get("rfcvalidation").toString());
		return identification;
		
	}

	public static ContactInformation getContactInformation(Map<Object, Object> mapContactInformation) {

		ContactInformation contactInformation = new ContactInformation();
		contactInformation.setContactNumber( mapContactInformation.get("contactNumber") == null ? "" : mapContactInformation.get("contactNumber").toString());
		contactInformation.setEmail( mapContactInformation.get("email") == null ? "" : mapContactInformation.get("email").toString());
		contactInformation.setPreferredContact( mapContactInformation.get("preferredContact") == null ? "" : mapContactInformation.get("preferredContact").toString());
		return contactInformation;
	}

	public static Address getAddress(Map<Object, Object> mapAddress, boolean isBillingAddress) {

		Address address = new Address();
		address.setAddressLine2(mapAddress.get("addressLine2") == null ? "" : mapAddress.get("addressLine2").toString());
		address.setBillingAddress(isBillingAddress);
		address.setCity(mapAddress.get("city") == null ? "" : mapAddress.get("city").toString());
		address.setCountry(mapAddress.get("country") == null ? "" : mapAddress.get("country").toString());
		address.setExternal(mapAddress.get("external") == null ? "" : mapAddress.get("external").toString());
		address.setMunicipality(mapAddress.get("municipality") == null ? "" : mapAddress.get("municipality").toString());
		address.setNeighborhood(mapAddress.get("neighborhood") == null ? "" : mapAddress.get("neighborhood").toString());
		address.setPostalCode(mapAddress.get("postalCode") == null ? "" : mapAddress.get("postalCode").toString());
		address.setProofOfAddress(mapAddress.get("proofOfAddress") == null ? "" : mapAddress.get("proofOfAddress").toString());
		address.setState(mapAddress.get("state") == null ? "" : mapAddress.get("state").toString());
		address.setStreet(mapAddress.get("street") == null ? "" : mapAddress.get("street").toString());
		return address;
	}

	public static AccountOptions getAccountOptions(Map<Object, Object> mapAccountOptions) {
		AccountOptions accountOptions = new AccountOptions();
		accountOptions.setAccountPasscode(mapAccountOptions.get("accountPasscode") == null ? "" : mapAccountOptions.get("accountPasscode").toString());
		accountOptions.setReceivePromotions(mapAccountOptions.get("receivePromotions") == null ? false : Boolean.valueOf(mapAccountOptions.get("receivePromotions").toString()));
		accountOptions.setShareInfo(mapAccountOptions.get("shareInfo") == null ? false : Boolean.valueOf(mapAccountOptions.get("shareInfo").toString()));
		return accountOptions;
	}

	public static CreditQuestions getCreditQuestions(Map<Object, Object> mapCreditQuestions) {
		CreditQuestions creditQuestions = new CreditQuestions();
		creditQuestions.setCreditQuestionsFirst(mapCreditQuestions.get("creditQuestionsFirst") == null ? false : Boolean.valueOf(mapCreditQuestions.get("creditQuestionsFirst").toString()));
		creditQuestions.setHaveCarLoan(mapCreditQuestions.get("haveCarLoan") == null ? false : Boolean.valueOf(mapCreditQuestions.get("haveCarLoan").toString()));
		creditQuestions.setHaveMortage(mapCreditQuestions.get("haveMortage") == null ? false : Boolean.valueOf(mapCreditQuestions.get("haveMortage").toString()));
		creditQuestions.setLastDigitOfCard(mapCreditQuestions.get("lastDigitOfCard") == null ? "" : mapCreditQuestions.get("lastDigitOfCard").toString());
		creditQuestions.setOwnsCreditCard(mapCreditQuestions.get("ownsCreditCard") == null ? false : Boolean.valueOf(mapCreditQuestions.get("ownsCreditCard").toString()));
		creditQuestions.setProvideSign(mapCreditQuestions.get("provideSign") == null ? false : Boolean.valueOf(mapCreditQuestions.get("provideSign").toString()));
		return creditQuestions;
		
	}
	
	
	public static DocumentsUpload getDocumentsUploads(Map<Object, Object> mapDocumentsUploads) {
		DocumentsUpload documentsUpload = new DocumentsUpload();
		documentsUpload.setAddressProofFile((File) mapDocumentsUploads.get("addressProofFile"));
		return documentsUpload;
		
	}

}
