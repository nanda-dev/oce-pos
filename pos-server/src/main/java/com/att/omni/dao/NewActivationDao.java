package com.att.omni.dao;

import java.util.List;

import com.att.omni.model.AccountOptions;
import com.att.omni.model.Address;
import com.att.omni.model.ContactInformation;
import com.att.omni.model.CreditQuestions;
import com.att.omni.model.CustomerInformation;
import com.att.omni.model.Identification;
import com.att.omni.model.PersonalInformation;

public interface NewActivationDao {

	void writeNewActivationData(List<PersonalInformation> newActivations);

	void writePersonalInformation(List<PersonalInformation> personalInformations);

	void writeCustomerInformation(List<CustomerInformation> customerInformations);

	void writeIdentification(List<Identification> identifications);

	void writeContactInformation(List<ContactInformation> contactInformations);

	void writeAddressInformation(List<Address> customerAddresses);

	void writeAccountOptions(List<AccountOptions> accountOptionsInformations);

	void writeCreditQuestions(List<CreditQuestions> creditQuestionsList);
}
