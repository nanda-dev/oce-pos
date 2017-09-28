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

@Service("creditQuestionService")
public class CreditQuestionService implements OmniChannelService {

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

		CreditQuestions creditQuestions = new CreditQuestions();
		Map<Object, Object> mapCreditQuestions = new HashMap();
		mapCreditQuestions = (Map<Object, Object>) (omModel.getPayLoad().get("CreditQuestions"));
		creditQuestions = NewActivationUtil.getCreditQuestions(mapCreditQuestions);
		creditQuestions.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		List<CreditQuestions> creditQuestionsList = new ArrayList<CreditQuestions>();
		creditQuestionsList.add(creditQuestions);
		newActivationDao.writeCreditQuestions(creditQuestionsList);
		
		return rsModel;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

}