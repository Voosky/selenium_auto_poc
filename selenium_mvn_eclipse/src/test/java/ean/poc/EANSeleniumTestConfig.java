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
	
	public static EANSeleniumTestConfig getInstance() {
		return instance;
	}
	
	public String getSiteBaseUrl() {
		return properties.getProperty("ean.poc.baseUrl");
	}
	
	public String getUsername() {
		return properties.getProperty("ean.poc.username");
	}
	
	public String getPassword() {
		return properties.getProperty("ean.poc.password");
	}

}
