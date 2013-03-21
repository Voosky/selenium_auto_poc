package ean.poc.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ean.poc.UIMap;

public class LoginPageHelper {

	public void setUsername(String username, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.login.inputField.username"))).sendKeys(username);
	}
	
	public void setPassword(String password, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.login.inputField.password"))).sendKeys(password);
	}
	
	public void clickLogin(WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.login.button.loginUser"))).click();
	}
}
