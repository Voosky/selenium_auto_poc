package ean.poc.helpers;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ean.poc.MessageMap;
import ean.poc.UIMap;

public class CreateAccountPageHelper {

	public void setUsername(String username, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.username"))).sendKeys(username);
	}
	
	public void setEmail(String email, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.email"))).sendKeys(email);
	}
	
	public void setPassword(String password, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.password"))).sendKeys(password);
	}
		
	public void checkPassword(String verifyPassword, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.verifyPassword"))).sendKeys(verifyPassword);
	}
	
	public void clickCreate(WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.button.create"))).click();	
	}
	
	
	//This method can be used to verify the User Name field in terms of length(minimum and maximum), 
	//supported characters, and null/blank values. 
	public void verifyUsernameError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.id("ean.poc.createAccount.form.errorField")).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidUserName"));
	}
	
	
	//This method can be used to verify the Password field in terms of length(minimum), and null values. 
	//The method does not cover special character situations.
	public void verifyPasswordError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.id("ean.poc.createAccount.form.errorField")).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidPassword"));
	}
	
	
	//This method can be used to verify the Verify Password field in terms of length(lower or higher), 
	//different characters than in the Password field, and null values. 
	public void verifyMatchingPasswordError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.id("ean.poc.createAccount.form.errorField")).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.passwordMismatch"));
	}
	
	
	//This method can be used to verify the Email field in terms of correct format (example@example.com).
	public void verifyEmail(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.id("ean.poc.createAccount.form.errorField")).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidEmail"));
	}
	
	
	//This method can be used to verify that a specific message is returned when the user creates a new account.
	public void verifySuccessfulCreation(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.id("ean.poc.createAccount.form.errorField")).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.successMessage.success"));
	}
	
	
}
