package ean.poc.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ean.poc.EANSeleniumTestConfig;
import ean.poc.UIMap;
import ean.poc.helpers.LoginPageHelper;

public class LoginPageTests {
	
	EANSeleniumTestConfig config = EANSeleniumTestConfig.getInstance();
	LoginPageHelper loginHelper = new LoginPageHelper();

	@Test
	public void firstTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = config.getUsername();
		String password = config.getPassword();
		
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		fireFoxDriver.findElement(By.xpath(UIMap.find("ean.poc.topBar.button.loginPage"))).click();
		Thread.sleep(2000);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		
		fireFoxDriver.quit();
	}
}
