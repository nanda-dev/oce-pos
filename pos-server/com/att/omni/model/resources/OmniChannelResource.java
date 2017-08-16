package com.att.omni.model.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.omni.model.OmniChannelModel;
import com.att.omni.model.ResponseModel;
import com.att.omni.model.User;
import com.att.omni.services.OmniChannelService;
import com.att.omni.util.OmniChannelProperties;
import com.att.omni.util.OmniChannelUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("/")
public class OmniChannelResource {

	private OmniChannelService omniChannelService = null;
	private static Logger logger = LoggerFactory.getLogger(OmniChannelResource.class);
	private Map<String, String> servicemap = new HashMap<String, String>(); 
	@Autowired	ServletContext context; 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById() {
		List<OmniChannelModel> omModels = new ArrayList<>();
		OmniChannelModel omModel = new OmniChannelModel();
		omModel.setPayLoad("{\"userName\": \"test\",\"passwrd\": \"test\"}");
		omModels.add(omModel);
		return Response.ok(omModels).build();
	}
	
	@PostConstruct
	public void init(){
		System.out.println("inside init");
		servicemap = OmniChannelUtil.getServicemap();
	}
	
	private void loadOmModel(OmniChannelModel omModel) {
	    ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(context);
	    context.setAttribute("USER1", omModel);
	    System.out.println("******************");
	    OmniChannelModel omModel1 = (OmniChannelModel) context.getAttribute("USER1");
	    System.out.println(omModel1);
	    System.out.println("******************");
	}
	
	@Path("/omniChannel")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getService(OmniChannelModel omModel) {
		ResponseModel rsModel = new ResponseModel();
		String clientLogicClass = servicemap.get(omModel.getService());
		System.out.println(clientLogicClass);
		if(org.springframework.util.StringUtils.isEmpty(clientLogicClass)){
			rsModel.setResponseBoolean(false);
			rsModel.setResponseString("service not present");
			return Response.ok(rsModel).build();			
		}
		loadOmModel(omModel);
		System.out.println(clientLogicClass);
		if (clientLogicClass != null) {
			try {
				omniChannelService = (OmniChannelService) Class.forName(clientLogicClass).newInstance();
				rsModel = omniChannelService.getResponse(omModel,context);
				System.out.println(omniChannelService);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return Response.ok(rsModel).build();
	}

}
