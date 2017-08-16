package com.att.omni.model;

public class OmniChannelModel {
	
	private String service;
	private String status;
	private String errorCode;
	private String errorReason;
	private String payLoad;
	
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
	public String getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}
	
	@Override
	public String toString() {
		return "OmniChannelModel [service=" + service + ", status=" + status + ", errorCode=" + errorCode
				+ ", errorReason=" + errorReason + ", payLoad=" + payLoad + "]";
	}

		

}