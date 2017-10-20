package com.att.omni.model;

public class ResponseModel {

	private String responseString;
	private boolean responseBoolean;
	
	
	public String getResponseString() {
		return responseString;
	}
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
	public boolean isResponseBoolean() {
		return responseBoolean;
	}
	public void setResponseBoolean(boolean responseBoolean) {
		this.responseBoolean = responseBoolean;
	}
	
	@Override
	public String toString() {
		return "ResponseModel [responseString=" + responseString + ", responseBoolean=" + responseBoolean
				+ ", getResponseString()=" + getResponseString() + ", isResponseBoolean()=" + isResponseBoolean()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
