package com.att.omni.dao;

import org.bson.Document;

import com.att.omni.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class LoginDao {

	public static User getLoginUserData(String userName) {
		User user = new User();
		System.out.println("Sucessfully connected with database first time!!!!!!!!");
		MongoClient client = new MongoClient("localhost", 27017);
		System.out.println("Sucessfully connected with database first time!!!!!!!!");
		try {

			DB db = client.getDB("mydb");
			DBCollection collection = db.getCollection("user");
			BasicDBObject allQuery = new BasicDBObject();
			allQuery.put("username", userName);
			DBCursor cursor = collection.find(allQuery);
			System.out.println("hurey");

			while (cursor.hasNext()) {
				DBObject obj = cursor.next();
				System.out.println(obj.get("username") + "\t" + obj.get("password"));
				user.setUserName(obj.get("username").toString());
				user.setPasswrd(obj.get("password").toString());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}
		return user;
	}

}
