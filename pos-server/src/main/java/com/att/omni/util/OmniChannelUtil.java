package com.att.omni.util;

import java.util.HashMap;
import java.util.Map;

public class OmniChannelUtil {
	
	public static Map<String, String> getServicemap(){
		
		Map<String,String> serviceMap = new HashMap<String,String>();
		serviceMap.put("Login", "com.att.omni.services.UserService");
		serviceMap.put("Logout", "com.att.omni.services.UserService");
		serviceMap.put("Cart", "com.att.omni.services.CartService");
		serviceMap.put("CustomerCreation", "com.att.omni.services.UserService");
		return serviceMap;
		
		
	}

}
