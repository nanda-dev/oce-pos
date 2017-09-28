package com.att.omni.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.att.omni.main.SpringMongoConfig;
import com.att.omni.model.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private  MongoOperations mongoOperation;

	@PostConstruct
	public void init() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}

	@Override
	public User getLoginUserData(String userName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		User user = mongoOperation.findOne(query, User.class);
		return user;
	}
	
	
}
