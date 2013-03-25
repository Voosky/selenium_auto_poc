package ean.poc.helpers;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ean.poc.MessageMap;
import ean.poc.UIMap;

public class CreateAccountPageHelper {
	
	//Method used to set the user name in the Username field.
	public void setUsername(String username, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.username"))).sendKeys(username);
	}
	
	
	//Method used to set the E-mail in the E-mail input field.
	public void setEmail(String email, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.email"))).sendKeys(email);
	}
	
	
	//Method used to set the password in the Password field.
	public void setPassword(String password, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.password"))).sendKeys(password);
	}
	
	
	//Method used to send a password in the "Verify Password" field.
	public void checkPassword(String verifyPassword, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.verifyPassword"))).sendKeys(verifyPassword);
	}
	
	
	//Method used to click the "Create" button in the "Create User" form. 
	public void clickCreate(WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.button.create"))).click();	
	}
	
	
	//Method used to verify the User Name field in terms of length(minimum and maximum), 
	//supported characters, and null/blank values. 
	public void verifyUsernameError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidUserName"));
	}
	
	
	//Method used to verify the Password field in terms of length(minimum), and null values. 
	//The method does not cover special character situations for now! (due to limitations in the software)
	public void verifyPasswordError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidPassword"));
	}
	
	
	//Method used to check the Verify Password field in terms of length(lower or higher), 
	//different characters than in the Password field, and null values. 
	public void verifyMatchingPasswordError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.passwordMismatch"));
	}
	
	
	//Method used to verify the Email field in terms of correct format (example@example.com).
	public void verifyEmail(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidEmail"));
	}
	
	
	//Method used to verify that a specific message is returned when the user creates a new account.
	public void verifySuccessfulCreation(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.successMessage.success"));
	}
	
	
}
