package com.att.omni.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "AccountOptions")
public class AccountOptions {

	@Id
	private long id;
	private String userId;
	private String accountPasscode;
	private boolean shareInfo;
	private boolean receivePromotions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountPasscode() {
		return accountPasscode;
	}

	public void setAccountPasscode(String accountPasscode) {
		this.accountPasscode = accountPasscode;
	}

	public boolean isShareInfo() {
		return shareInfo;
	}

	public void setShareInfo(boolean shareInfo) {
		this.shareInfo = shareInfo;
	}

	public boolean isReceivePromotions() {
		return receivePromotions;
	}

	public void setReceivePromotions(boolean receivePromotions) {
		this.receivePromotions = receivePromotions;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
