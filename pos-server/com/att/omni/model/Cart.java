package com.att.omni.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude()
public class Cart {

	
	private String userName;
	private String passwrd;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswrd() {
		return passwrd;
	}
	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passwrd=" + passwrd + "]";
	}
	
	
}
