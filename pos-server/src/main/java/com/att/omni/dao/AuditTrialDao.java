package com.att.omni.dao;

import java.util.List;

import com.att.omni.model.AuditTrial;

public interface AuditTrialDao {	
	
	void writeAuditTrial(List<AuditTrial> auditTrials) ;
}
