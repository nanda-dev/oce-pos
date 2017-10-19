package com.att.omni.dao;

import java.util.List;

import com.att.omni.model.AccountOptions;
import com.att.omni.model.Address;
import com.att.omni.model.ContactInformation;
import com.att.omni.model.CreditQuestions;
import com.att.omni.model.CustomerInformation;
import com.att.omni.model.Identification;
import com.att.omni.model.PersonalInformation;

public interface CreditQuestionsDao {

	void writeCreditQuestions(List<CreditQuestions> creditQuestionsList);
}
