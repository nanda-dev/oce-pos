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

@Repository("newActivationDaoImpl")
public class NewActivationDaoImpl implements NewActivationDao {

	@Autowired
	private MongoOperations mongoOperation;

	@PostConstruct
	public void init() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}

	@Override
	public void writeNewActivationData(List<PersonalInformation> newActivations) {
		System.out.println(newActivations);
		System.out.println("****" + mongoOperation);
		mongoOperation.insert(newActivations, PersonalInformation.class);
	}

	@Override
	public void writePersonalInformation(List<PersonalInformation> personalInformations) {
		mongoOperation.insert(personalInformations, PersonalInformation.class);
	}

	@Override
	public void writeCustomerInformation(List<CustomerInformation> customerInformations) {
		mongoOperation.insert(customerInformations, CustomerInformation.class);

	}

	@Override
	public void writeIdentification(List<Identification> identifications) {
		mongoOperation.insert(identifications, Identification.class);

	}

	@Override
	public void writeAddressInformation(List<Address> customerAddresses) {
		mongoOperation.insert(customerAddresses, Address.class);
	}

	@Override
	public void writeAccountOptions(List<AccountOptions> accountOptionsInformations) {
		mongoOperation.insert(accountOptionsInformations, AccountOptions.class);

	}

	@Override
	public void writeContactInformation(List<ContactInformation> contactInformations) {
		mongoOperation.insert(contactInformations, ContactInformation.class);

	}

	@Override
	public void writeCreditQuestions(List<CreditQuestions> creditQuestionsList) {
		mongoOperation.insert(creditQuestionsList, CreditQuestions.class);
	}

}
