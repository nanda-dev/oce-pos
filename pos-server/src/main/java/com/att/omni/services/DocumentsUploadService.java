package com.att.omni.services;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.att.omni.dao.DocumentsUploadDao;
import com.att.omni.dao.SequenceDao;
import com.att.omni.model.OmniChannelModel;
import com.att.omni.model.ResponseModel;
import com.att.omni.model.User;
import com.att.omni.util.DocumentUploadUtil;
import com.att.omni.util.NewActivationUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service("documentsUploadService")
public class DocumentsUploadService implements OmniChannelService {

	@Autowired
	ServletContext context;

	@Autowired
	private DocumentsUploadDao documentsUploadDao;

	@Autowired
	private SequenceDao sequenceDao;

	private static final String HOSTING_SEQ_KEY = "seqId";

	@Override
	public ResponseModel getResponse(OmniChannelModel omModel, ServletContext context)
			throws JsonParseException, JsonMappingException, IOException, ParseException {
		System.out.println("Inside DocumentsUploadService");
		ResponseModel rsModel = new ResponseModel();
		return rsModel;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Override
	public ResponseModel getResponse(MultipartFile[] files, ServletContext context) throws IllegalStateException, IOException {
		ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(context);
		OmniChannelModel omModel = (OmniChannelModel) context.getAttribute("USER1");
		String userNameUserID = omModel.getPayLoad().get("userName").toString() + omModel.getPayLoad().get("userId").toString() ;
		System.out.println("Inside DocumentsUploadService");
		ResponseModel rsModel = new ResponseModel();
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[0]), "Contract"+userNameUserID,files[0].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[1]), "CustomerID"+userNameUserID,files[1].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[2]), "AddressProof"+userNameUserID,files[2].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[3]), "AuthenticityForm"+userNameUserID,files[3].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[4]), "CCRecurringChargeConsent"+userNameUserID,files[4].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[5]), "IncomeProof"+userNameUserID,files[5].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[6]), "PaymentReceipt"+userNameUserID,files[6].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[7]), "ChangeofOwnershipForm"+userNameUserID,files[7].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[8]), "BureauConsent"+userNameUserID,files[8].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[9]), " PortabilityFormat&CancellationProof(2docs)"+userNameUserID,files[9].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[10]), " SubidentificationProof"+userNameUserID,files[10].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[11]), "RFC"+userNameUserID,files[11].getContentType());
		documentsUploadDao.writeFile(DocumentUploadUtil.convertMultipartFiletoFile(files[12]), "CURP"+userNameUserID,files[12].getContentType());
		System.out.println("done");
		return rsModel;
	}

}