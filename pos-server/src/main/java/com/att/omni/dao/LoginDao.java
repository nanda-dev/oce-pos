package com.att.omni.dao;

import com.att.omni.model.User;

public class LoginDao {

	public static User getLoginUserData(String userName) {
		User user = new User();
		System.out.println("Sucessfully connected with database first time!!!!!!!!!");
		/*MongoClient client = new MongoClient("localhost", 27017);
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
		}*/
		return user;
	}

}
