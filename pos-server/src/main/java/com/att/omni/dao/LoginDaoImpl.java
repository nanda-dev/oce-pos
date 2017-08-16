/*package com.att.omni.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.att.omni.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@Service
public class LoginDaoImpl implements LoginDao {

	public static User getLoginUserData(String userName) {
		User user = new User();
		try {
			System.out.println("Sucessfully connected with database first time!!!!!!!!");
			MongoClient client = new MongoClient("localhost", 27017);
			System.out.println("Sucessfully connected with database first time!!!!!!!!");
			DB db = client.getDB("mydb");
			DBCollection collection = db.getCollection("user");
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("username", userName);
			DBCursor cursor = collection.find(searchQuery);
			List<DBObject> list = new ArrayList<DBObject>();
			System.out.println("got data");
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
				list.add(cursor.next());
			}
			
			System.out.println(list);
			
			for(DBObject dbObject:list){
				user = (User) dbObject;
				System.out.println(user);
			}
			
			 * String userName = (String) dbo.get("username"); String password =
			 * (String) dbo.get("password"); System.out.println("Name:" +
			 * userName + "Password:" + password);
			 * 
			 * user.setUserName(userName); user.setPasswrd(password);
			 
			client.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return user;
	}

}
*/