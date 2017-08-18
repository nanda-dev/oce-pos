package com.att.omni.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.omni.dao.LoginDao;
import com.att.omni.model.OmniChannelModel;
import com.att.omni.model.ResponseModel;
import com.att.omni.model.Tutorial;
import com.att.omni.model.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class UserService implements OmniChannelService {
	
	@Autowired	ServletContext context; 
	
	@Override
	public ResponseModel getResponse(OmniChannelModel omModel,ServletContext context) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Inside UserService");
		boolean loginFlag = Boolean.FALSE;
		ResponseModel rsModel = new ResponseModel();
		System.out.println(omModel.getPayLoad());
	
		User OrgUser = new User();
		OrgUser.setUserName(omModel.getPayLoad().get("userName"));
		OrgUser.setPasswrd(omModel.getPayLoad().get("userName"));
		System.out.println(OrgUser);
		User daoUser = new User();
		daoUser = LoginDao.getLoginUserData(OrgUser.getUserName());
		System.out.println(daoUser);
		if(OrgUser.getUserName().equals(daoUser.getUserName()) && OrgUser.getPasswrd().equals(daoUser.getPasswrd())){
			loginFlag = true;
		}
		rsModel.setResponseBoolean(loginFlag);
		
		ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(context);
	    System.out.println("****************** %%%% *************");
	    OmniChannelModel omModel1 = (OmniChannelModel) context.getAttribute("USER1");
	    System.out.println(omModel1);
	    System.out.println("******************");
	    
		return rsModel;
	}


	
}