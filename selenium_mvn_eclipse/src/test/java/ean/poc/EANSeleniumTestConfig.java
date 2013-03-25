package ean.poc;

import java.io.IOException;
import java.util.Properties;

public class EANSeleniumTestConfig {
	private static EANSeleniumTestConfig instance = new EANSeleniumTestConfig();
	
	private Properties properties = new Properties();
	
	private EANSeleniumTestConfig() {
		try {
			properties.load(EANSeleniumTestConfig.class.getResourceAsStream("/ean_poc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Method returns the instance of the EANSeleniumTestConfig class.
	public static EANSeleniumTestConfig getInstance() {
		return instance;
	}
	
	
	/*
	 * Method returns the target website's URL from the "ean_poc.properties" document. 
	 * @ ean.poc.baseUrl - placeholder for the target website URL.  
	*/
	public String getSiteBaseUrl() {
		return properties.getProperty("ean.poc.baseUrl");
	}
	
	
	/*
	 * Method returns the Username used for functional testing from the "ean_poc.properties" document. 
	 * @ ean.poc.username - placeholder for the Username used for functional tests.  
	*/
	public String getUsername() {
		return properties.getProperty("ean.poc.username");
	}
	
	
	/*
	 * Method returns the Password used for functional testing from the "ean_poc.properties" document. 
	 * @ ean.poc.password - placeholder for the Password used for functional tests.  
	*/
	public String getPassword() {
		return properties.getProperty("ean.poc.password");
	}

}
