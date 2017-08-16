package com.att.cpc.generic.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.att.cpc.generic.exception.CPCGeneralException;

/**
 * This class is used as the generic controller
 * 
 * $Id: Controller.java,v 1.2 2012-03-14 23:42:32 sg0019 Exp $
 * 
 * @author Kerry Fidler
 * 
 */

public class Controller {
	private static org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory
			.getLog(Controller.class);

	/**
	 * CPCRequest
	 * 
	 * @param cPCRequest
	 * @return com.att.cpc.service.generic.CPCResponse
	 * @throws CPCGeneralException 
	 * @throws SQLException 
	 */
	public static com.att.cpc.generic.om.CPCResponse cPCRequest(com.att.cpc.generic.om.CPCRequest cPCRequest) throws CPCGeneralException, SQLException
		{

		if (cPCRequest == null) {
			throw new com.att.cpc.generic.exception.CPCGeneralException("null request", "217");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Request recieved: " + cPCRequest);
		}
		com.att.cpc.generic.logic.LogicInterface logic = null;

		String clientLogicClass = com.att.cpc.generic.properties.CPCProperties.getProperty(cPCRequest.getClientId()
				+ "_logic");
		if (clientLogicClass == null) {
			clientLogicClass = com.att.cpc.generic.properties.CPCProperties.getProperty(cPCRequest.getClientId()
					.replace(" ", "_") + "_logic");
		}

		String catalogLogicClass = com.att.cpc.generic.properties.CPCProperties.getProperty(cPCRequest
				.getChannelCatalog().replace(" ", "_") + "_logic");

		try {
			if (clientLogicClass != null) {
				logic = (com.att.cpc.generic.logic.LogicInterface) Class.forName(clientLogicClass).newInstance();
			} else if (catalogLogicClass != null) {
				logic = (com.att.cpc.generic.logic.LogicInterface) Class.forName(catalogLogicClass).newInstance();
			} else {
				logic = new com.att.cpc.generic.logic.GenericLogic();
			}
		} catch (InstantiationException e) {
			logger.error(e,e);
		} catch (IllegalAccessException e) {
			logger.error(e,e);
		} catch (ClassNotFoundException e) {
			logger.error(e,e);
		}
		
		com.att.cpc.generic.om.CPCResponse cpcResponse = logic.processRequest(cPCRequest);

		if (cpcResponse.getItems() == null || cpcResponse.getItems().isEmpty()) {
			throw new com.att.cpc.generic.exception.CPCGeneralException("No items found", "216");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Response sent: " + cpcResponse);
			try {
				logger.debug("Response size: " + cpcResponse.size());
			} catch (IOException e) {
				logger.debug(e);
			}
		}

		return cpcResponse;
	}
}
