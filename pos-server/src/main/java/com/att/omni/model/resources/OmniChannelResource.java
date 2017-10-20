package com.att.omni.model.resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

import org.apache.commons.io.output.CountingOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.att.omni.model.OmniChannelModel;
import com.att.omni.model.ResponseModel;
import com.att.omni.services.AuditTrialService;
import com.att.omni.services.OmniChannelService;
import com.att.omni.services.UserService;
import com.att.omni.util.OmniChannelUtil;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
public class OmniChannelResource {

	private OmniChannelService omniChannelService = null;
	@Autowired
	private AuditTrialService auditTrialService = null;
	@Autowired
	private UserService userService = null;
	private static Logger logger = LoggerFactory.getLogger(OmniChannelResource.class);
	private Map<String, String> servicemap = new HashMap<String, String>();
	@Autowired
	private ServletContext context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById() {
		List<OmniChannelModel> omModels = new ArrayList<>();
		OmniChannelModel model = new OmniChannelModel();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> payLoad = new HashMap<>();

		/*
		 * NewActivation activation = new NewActivation();
		 * activation.setUserId("testXXXC");
		 * 
		 * CustomerInformation customerInformation = new CustomerInformation();
		 * customerInformation.setCategory("test");
		 * customerInformation.setCustomerSubType("customerSubtype");
		 * customerInformation.setCustomerType("tyoe222");
		 * payLoad.put("CustomerInformation", customerInformation); Map<String,
		 * CustomerInformation> customerInformationMap = new HashMap<>();
		 * customerInformationMap.put("customerInformation",
		 * customerInformation);
		 * 
		 * 
		 * PersonalInformation personalInformation = new PersonalInformation();
		 * personalInformation.setDob(new Date());
		 * personalInformation.setEmployerName("xxx");
		 * personalInformation.setFirstName("John");
		 * personalInformation.setGender("Male");
		 * personalInformation.setLastname("test");
		 * personalInformation.setMiddleName("test");
		 * personalInformation.setMonthlyIncomeRange("middle");
		 * payLoad.put("PersonalInformation", personalInformation); Map<String,
		 * PersonalInformation> personalInformationMap = new HashMap<>();
		 * personalInformationMap.put("personalInformation",
		 * personalInformation);
		 * 
		 * 
		 * Identification identification = new Identification();
		 * payLoad.put("Identification", identification);
		 * 
		 * ContactInformation contactInformation = new ContactInformation();
		 * payLoad.put("ContactInformation", contactInformation);
		 * 
		 * Address addressCustomer = new Address();
		 * payLoad.put("CustomerAddress", addressCustomer);
		 * 
		 * Address billingAddress = new Address(); payLoad.put("BillingAddress",
		 * billingAddress);
		 * 
		 * AccountOptions accountOptions = new AccountOptions();
		 * payLoad.put("AccountOptions", accountOptions);
		 */

		/*FileWriter fw = null;
		DocumentsUpload documentsUpload = new DocumentsUpload();
		File file = new File("d:\\test.pdf");

		documentsUpload.setAddressProofFile(file);
		documentsUpload.setAuthenticityForm(file);
		documentsUpload.setCCRecurringChargeConsent(file);
		documentsUpload.setChangeofOwnershipForm(file);
		payLoad.put("DocumentsUpload", documentsUpload);
		System.out.println("Done");*/
		
		/*CreditQuestions creditQuestions = new CreditQuestions();
		creditQuestions.setCreditQuestionsFirst(Boolean.TRUE);
		creditQuestions.setHaveCarLoan(Boolean.TRUE);
		creditQuestions.setHaveMortage(Boolean.TRUE);
		creditQuestions.setLastDigitOfCard("12345");
		creditQuestions.setOwnsCreditCard(Boolean.TRUE);
		creditQuestions.setProvideSign(Boolean.TRUE);
		creditQuestions.setUserId("12345");
		payLoad.put("CreditQuestions", creditQuestions);*/
		
		
		model.setPayLoad(payLoad);
		model.setService("CreditQuestionService");
		omModels.add(model);
		return Response.ok(omModels).build();

	}

	@PostConstruct
	public void init() {
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
		System.out.println("*******************************");
		ResponseModel rsModel = new ResponseModel();
		// Add data to Audit trial DB
		try {
			auditTrialService.writeAuditTrial(omModel);
			String clientLogicClass = servicemap.get(omModel.getService());
			System.out.println(clientLogicClass);
			if (org.springframework.util.StringUtils.isEmpty(clientLogicClass)) {
				rsModel.setResponseBoolean(false);
				rsModel.setResponseString("service not present");
				return Response.ok(rsModel).build();
			}
			loadOmModel(omModel);
			System.out.println(clientLogicClass);
			if (clientLogicClass != null) {
				ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(context);
				omniChannelService = (OmniChannelService) appContext.getBean(clientLogicClass);
				rsModel = omniChannelService.getResponse(omModel, context);
				System.out.println(rsModel);
			}

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(rsModel).build();
	}

	@RequestMapping(value = "/omniChannel/documentUpload", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public Response upload(@RequestParam("file") MultipartFile[] files) {
		System.out.println("*******************************");
		ResponseModel rsModel = new ResponseModel();
		// Add data to Audit trial DB
		try {
			String clientLogicClass = servicemap.get("documentsUploadService");
			System.out.println(clientLogicClass);
			if (org.springframework.util.StringUtils.isEmpty(clientLogicClass)) {
				rsModel.setResponseBoolean(false);
				rsModel.setResponseString("service not present");
				return Response.ok(rsModel).build();
			}
			System.out.println(clientLogicClass);
			if (clientLogicClass != null) {
				ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(context);
				omniChannelService = (OmniChannelService) appContext.getBean(clientLogicClass);
				rsModel = omniChannelService.getResponse(files, context);
				System.out.println(omniChannelService);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(rsModel).build();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody void uploadFile(@RequestParam MultipartFile file) {

		System.out.println(file.getName());
	}
	
	@POST
	@Path("/upload/photo")
	@Consumes("multipart/form-data")
	public void uploadPhoto(InputStream stream){
	       System.out.println("Inside uploadPhoto");
	}
}
