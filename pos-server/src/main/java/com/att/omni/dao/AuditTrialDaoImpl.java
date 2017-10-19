package com.att.omni.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.att.omni.model.AuditTrial;

@Repository
public class AuditTrialDaoImpl implements AuditTrialDao  {

	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public void writeAuditTrial(List<AuditTrial> auditTrials) {
		System.out.println(auditTrials);
		System.out.println("****"+mongoOperation);
		mongoOperation.insert(auditTrials, AuditTrial.class);
	}

}
