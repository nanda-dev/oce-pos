package com.att.omni.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import com.att.omni.dao.LoginDao;
import com.att.omni.model.OmniChannelModel;
import com.att.omni.model.ResponseModel;
import com.att.omni.model.Tutorial;
import com.att.omni.model.User;

public class CartService implements OmniChannelService{
	
	private final List<Tutorial> tutorials = new ArrayList<Tutorial>();
	@Inject
	private LoginDao logindao;

	public boolean getLoginUserData(String userName,String password) {
		System.out.println("inside service"+userName +" password "+password);
		boolean loginFlag = Boolean.FALSE;
		User user = new User();
		user = logindao.getLoginUserData(userName);
		System.out.println(user);
		if(userName.equals(user.getUserName()) && password.equals(user.getPasswrd())){
			loginFlag = true;
		}
		return loginFlag;
		
	}

	
	@Override
	public ResponseModel getResponse(OmniChannelModel omModel,ServletContext context) {
		return null;
		// TODO Auto-generated method stub
		
	}


}
