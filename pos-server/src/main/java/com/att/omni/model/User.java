package com.att.omni.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "UserAccess")
public class User {

	private String userName;
	private String passwrd;
	private String userId;
	private String priorities;

	@Id
	private long id;

	public User(String userName, String passwrd, String userId, String priorities, long id) {
		super();
		this.userName = userName;
		this.passwrd = passwrd;
		this.userId = userId;
		this.priorities = priorities;
		this.id = id;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPriorities() {
		return priorities;
	}

	public void setPriorities(String priorities) {
		this.priorities = priorities;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", passwrd=" + passwrd + "]";
	}

}
