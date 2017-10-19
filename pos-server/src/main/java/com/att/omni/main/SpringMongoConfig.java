package com.att.omni.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;

/**
 * Spring MongoDB configuration file
 *
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		MongoClient client = new MongoClient("localhost", 27017);
		MongoTemplate mongoTemplate = new MongoTemplate(client, "OmniChannel");
		return mongoTemplate;

	}

	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}
	
	
	@Override
	protected String getDatabaseName() {
		return "OmniChannel";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost", 27017);
	}

}