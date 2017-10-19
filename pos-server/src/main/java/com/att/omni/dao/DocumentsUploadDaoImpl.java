package com.att.omni.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.att.omni.main.SpringMongoConfig;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Repository("documentsUploadDaoImpl")
public class DocumentsUploadDaoImpl implements DocumentsUploadDao {

	@Autowired
	private GridFsOperations gridOperations;

	@PostConstruct
	public void init() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		gridOperations = (GridFsOperations) ctx.getBean("gridFsTemplate");
	}


	@Override
	public void writeFile(File inputFile, String fileName, String fileType) {
		DBObject metaData = new BasicDBObject();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(inputFile);
			gridOperations.store(inputStream, fileName, fileName, metaData);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
