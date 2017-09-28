package com.att.omni.model;

import java.util.Map;

public class OmniChannelModel {

	private String service;
	private String status;
	private String errorCode;
	private String errorReason;
	private Map<String, Object> payLoad;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

	@Override
	public String toString() {
		return "OmniChannelModel [service=" + service + ", status=" + status + ", errorCode=" + errorCode
				+ ", errorReason=" + errorReason + ", payLoad=" + payLoad + "]";
	}

	public Map<String, Object> getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(Map<String, Object> payLoad) {
		this.payLoad = payLoad;
	}

}
