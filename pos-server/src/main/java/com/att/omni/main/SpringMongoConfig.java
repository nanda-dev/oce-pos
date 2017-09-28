package com.att.omni.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.MongoClient;

/**
 * Spring MongoDB configuration file
 *
 */
@Configuration
public class SpringMongoConfig {

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		MongoClient client = new MongoClient("localhost", 27017);
		MongoTemplate mongoTemplate = new MongoTemplate(client, "OmniChannel");
		return mongoTemplate;

	}

}