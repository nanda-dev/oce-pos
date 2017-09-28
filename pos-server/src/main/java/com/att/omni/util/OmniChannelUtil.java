package com.att.omni.util;

import java.util.HashMap;
import java.util.Map;

public class OmniChannelUtil {
	
	public static Map<String, String> getServicemap(){
		
		Map<String,String> serviceMap = new HashMap<String,String>();
		serviceMap.put("Login", "userService");
		serviceMap.put("Logout", "userService");
		serviceMap.put("Cart", "CartService");
		serviceMap.put("CustomerCreationService", "customerCreationService");
		serviceMap.put("CreditQuestionService", "creditQuestionService");
		return serviceMap;
		
		
	}

}
