package com.att.omni.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.att.omni.main.SpringMongoConfig;
import com.att.omni.model.AccountOptions;
import com.att.omni.model.Address;
import com.att.omni.model.ContactInformation;
import com.att.omni.model.CreditQuestions;
import com.att.omni.model.CustomerInformation;
import com.att.omni.model.Identification;
import com.att.omni.model.PersonalInformation;

@Repository("creditQuestionsDaoImpl")
public class CreditQuestionsDaoImpl implements CreditQuestionsDao {

	@Autowired
	private MongoOperations mongoOperation;

	@PostConstruct
	public void init() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}

	@Override
	public void writeCreditQuestions(List<CreditQuestions> creditQuestionsList) {
		mongoOperation.insert(creditQuestionsList, CreditQuestions.class);
	}

}
