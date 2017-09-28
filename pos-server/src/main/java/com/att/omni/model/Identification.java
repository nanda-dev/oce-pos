package com.att.omni.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Identification")
public class Identification {

	@Id
	private long id;
	private String userId;
	private String mexicoCitizen;
	private String idProof;
	private String idNumber;
	private String rfc;
	private String rfcvalidation;
	private String curpID;
	private String curpValidation;
	private String categoryIdType;
	private String categoryIdNumber;

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

	public String getMexicoCitizen() {
		return mexicoCitizen;
	}

	public void setMexicoCitizen(String mexicoCitizen) {
		this.mexicoCitizen = mexicoCitizen;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRfcvalidation() {
		return rfcvalidation;
	}

	public void setRfcvalidation(String rfcvalidation) {
		this.rfcvalidation = rfcvalidation;
	}

	public String getCurpID() {
		return curpID;
	}

	public void setCurpID(String curpID) {
		this.curpID = curpID;
	}

	public String getCurpValidation() {
		return curpValidation;
	}

	public void setCurpValidation(String curpValidation) {
		this.curpValidation = curpValidation;
	}

	public String getCategoryIdType() {
		return categoryIdType;
	}

	public void setCategoryIdType(String categoryIdType) {
		this.categoryIdType = categoryIdType;
	}

	public String getCategoryIdNumber() {
		return categoryIdNumber;
	}

	public void setCategoryIdNumber(String categoryIdNumber) {
		this.categoryIdNumber = categoryIdNumber;
	}

}
