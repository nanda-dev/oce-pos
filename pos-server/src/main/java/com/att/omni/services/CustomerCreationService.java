package com.att.omni.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.omni.dao.NewActivationDao;
import com.att.omni.dao.SequenceDao;
import com.att.omni.model.AccountOptions;
import com.att.omni.model.Address;
import com.att.omni.model.ContactInformation;
import com.att.omni.model.CreditQuestions;
import com.att.omni.model.CustomerInformation;
import com.att.omni.model.Identification;
import com.att.omni.model.NewActivation;
import com.att.omni.model.OmniChannelModel;
import com.att.omni.model.PersonalInformation;
import com.att.omni.model.ResponseModel;
import com.att.omni.util.NewActivationUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service("customerCreationService")
public class CustomerCreationService implements OmniChannelService {

	@Autowired
	ServletContext context;

	@Autowired
	private NewActivation newActivationObj;

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private NewActivationDao newActivationDao;

	private static final String HOSTING_SEQ_KEY = "seqId";

	@Override
	public ResponseModel getResponse(OmniChannelModel omModel, ServletContext context)
			throws JsonParseException, JsonMappingException, IOException, ParseException {
		System.out.println("Inside NewActivationService");
		ResponseModel rsModel = new ResponseModel();
		System.out.println(omModel.getPayLoad());

		PersonalInformation personalInformation = new PersonalInformation();
		Map<Object, Object> mapPersonalInfo = new HashMap();
		mapPersonalInfo = (Map<Object, Object>) (omModel.getPayLoad().get("PersonalInformation"));
		personalInformation = NewActivationUtil.getPersonalInfo(mapPersonalInfo);
		personalInformation.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		List<PersonalInformation> personalInformations = new ArrayList<PersonalInformation>();
		personalInformations.add(personalInformation);
		newActivationDao.writePersonalInformation(personalInformations);

		CustomerInformation customerInformation = new CustomerInformation();
		Map<Object, Object> mapCustomerInformation = new HashMap();
		mapPersonalInfo = (Map<Object, Object>) (omModel.getPayLoad().get("CustomerInformation"));
		customerInformation = NewActivationUtil.getCustomerInformation(mapCustomerInformation);
		customerInformation.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		List<CustomerInformation> customerInformations = new ArrayList<CustomerInformation>();
		customerInformations.add(customerInformation);
		newActivationDao.writeCustomerInformation(customerInformations);

		Identification identification = new Identification();
		Map<Object, Object> mapIdentification = new HashMap();
		mapIdentification = (Map<Object, Object>) (omModel.getPayLoad().get("Identification"));
		identification = NewActivationUtil.getIdentification(mapIdentification);
		identification.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		List<Identification> identifications = new ArrayList<Identification>();
		identifications.add(identification);
		newActivationDao.writeIdentification(identifications);
		
		ContactInformation contactInformation = new ContactInformation();
		Map<Object, Object> mapContactInformation = new HashMap();
		mapContactInformation = (Map<Object, Object>) (omModel.getPayLoad().get("ContactInformation"));
		contactInformation = NewActivationUtil.getContactInformation(mapContactInformation);
		contactInformation.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		List<ContactInformation> contactInformations = new ArrayList<ContactInformation>();
		contactInformations.add(contactInformation);
		newActivationDao.writeContactInformation(contactInformations);

		Address customerAddress = new Address();
		Map<Object, Object> mapCustomerAddress = new HashMap();
		mapCustomerAddress = (Map<Object, Object>) (omModel.getPayLoad().get("CustomerAddress"));
		customerAddress = NewActivationUtil.getAddress(mapCustomerAddress, false);
		customerAddress.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		List<Address> customerAddresses = new ArrayList<Address>();
		customerAddresses.add(customerAddress);
		newActivationDao.writeAddressInformation(customerAddresses);

		Address billingAddress = new Address();
		Map<Object, Object> mapBillingAddress = new HashMap();
		mapBillingAddress = (Map<Object, Object>) (omModel.getPayLoad().get("BillingAddress"));
		billingAddress = NewActivationUtil.getAddress(mapBillingAddress, true);
		billingAddress.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		List<Address> billingAddresses = new ArrayList<Address>();
		billingAddresses.add(billingAddress);
		newActivationDao.writeAddressInformation(billingAddresses);

		AccountOptions accountOptions = new AccountOptions();
		Map<Object, Object> mapAccountOptions = new HashMap();
		mapAccountOptions = (Map<Object, Object>) (omModel.getPayLoad().get("AccountOptions"));
		accountOptions = NewActivationUtil.getAccountOptions(mapAccountOptions);
		List<AccountOptions> accountOptionsInformations = new ArrayList<AccountOptions>();
		accountOptionsInformations.add(accountOptions);
		newActivationDao.writeAccountOptions(accountOptionsInformations);


		
		return rsModel;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

}