package com.att.omni.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "CreditQuestions")
public class CreditQuestions {

	@Id
	private long id;
	private boolean creditQuestionsFirst;
	private String userId;
	private String lastDigitOfCard;
	private boolean provideSign;
	private boolean ownsCreditCard;
	private boolean haveMortage;
	private boolean haveCarLoan;

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

	public boolean isCreditQuestionsFirst() {
		return creditQuestionsFirst;
	}

	public void setCreditQuestionsFirst(boolean creditQuestionsFirst) {
		this.creditQuestionsFirst = creditQuestionsFirst;
	}

	public String getLastDigitOfCard() {
		return lastDigitOfCard;
	}

	public void setLastDigitOfCard(String lastDigitOfCard) {
		this.lastDigitOfCard = lastDigitOfCard;
	}

	public boolean isProvideSign() {
		return provideSign;
	}

	public void setProvideSign(boolean provideSign) {
		this.provideSign = provideSign;
	}

	public boolean isOwnsCreditCard() {
		return ownsCreditCard;
	}

	public void setOwnsCreditCard(boolean ownsCreditCard) {
		this.ownsCreditCard = ownsCreditCard;
	}

	public boolean isHaveMortage() {
		return haveMortage;
	}

	public void setHaveMortage(boolean haveMortage) {
		this.haveMortage = haveMortage;
	}

	public boolean isHaveCarLoan() {
		return haveCarLoan;
	}

	public void setHaveCarLoan(boolean haveCarLoan) {
		this.haveCarLoan = haveCarLoan;
	}

}
