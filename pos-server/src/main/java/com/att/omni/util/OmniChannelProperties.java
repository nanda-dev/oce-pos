package com.att.omni.util;

import java.io.IOException;

/**
 * $Id: CPCProperties.java,v 1.2 2011-06-24 15:07:21 kf3376 Exp $
 */


public class OmniChannelProperties {
    private static org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog(OmniChannelProperties.class);
    private static java.util.Properties generalProperties = null;

    /**
     * getGeneralProperties
     * @param name - property name to return
     */
    public static java.util.Properties getGeneralProperties() {
		return generalProperties;
	}

	/**
     * load
     */
    public static void load() {
    	if ( generalProperties != null ) {
    		return;
    	}
    	
    	generalProperties = new java.util.Properties();
    	
    	try {
    		java.io.InputStream in = OmniChannelProperties.class.getClassLoader().getResourceAsStream("omniChannel.properties");
    		if ( in != null ) {
	    		generalProperties.load( in );
	    		System.out.println( "Internal Generic Omni Channel properties : " + generalProperties );
    		} else {
    			System.out.println("no Internal Generic Omni Channel properties found." );
    		}
    	} catch ( IOException e ) {
        	logger.error(e);
        }
    	
    	
    }
    
    /**
     * getProperty
     * @param name - property name to return
     */
    public static String getProperty(String name) {
    	return generalProperties.getProperty(name);
    }
}
