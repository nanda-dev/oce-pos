package com.att.omni.services;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import com.att.omni.model.OmniChannelModel;
import com.att.omni.model.ResponseModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public interface OmniChannelService {

	ResponseModel getResponse(OmniChannelModel omModel, ServletContext context) throws JsonParseException, JsonMappingException, IOException, ParseException;

	ResponseModel getResponse(MultipartFile[] files, ServletContext context) throws IllegalStateException, IOException;

}
