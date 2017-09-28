package com.att.omni.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.omni.dao.AuditTrialDao;
import com.att.omni.dao.SequenceDao;
import com.att.omni.model.AuditTrial;
import com.att.omni.model.OmniChannelModel;

@Service
public class AuditTrialService {

	private static final String HOSTING_SEQ_KEY = "seqId";
	
	@Autowired
	private SequenceDao sequenceDao;
	
	@Autowired
	private AuditTrialDao auditTrialDao;

	public void writeAuditTrial(OmniChannelModel omModel) {

		AuditTrial auditTrial = new AuditTrial();
		System.out.println(omModel);
		auditTrial.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		auditTrial.setRequest(omModel.getPayLoad().toString());
		auditTrial.setServiceName(omModel.getService());
		auditTrial.setResponse("test");
		List<AuditTrial> auditTrials = new ArrayList<AuditTrial>();
		auditTrials.add(auditTrial);
		auditTrialDao.writeAuditTrial(auditTrials);
	}

	public void setSequenceDao(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}

	public void setAuditTrialDao(AuditTrialDao auditTrialDao) {
		this.auditTrialDao = auditTrialDao;
	}

}