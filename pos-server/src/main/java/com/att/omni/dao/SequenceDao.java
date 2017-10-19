package com.att.omni.dao;

import com.att.omni.util.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;

}