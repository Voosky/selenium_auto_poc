package ean.poc.helpers;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ean.poc.MessageMap;
import ean.poc.UIMap;

public class LoginPageHelper {

	/*Method used to type the Username into the Username input field (Log-In page).  
	* @username - the value of the username string which will be used.
	* @ean.poc.login.inputField.username - the XPath location of the username input field.
	*/
	public void setUsername(String username, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.login.inputField.username"))).sendKeys(username);
	}
	
	
	/*Method used to type the Password into the Password input field (Log-In page).  
	* @password - the value of the password string which will be used.
	* @ean.poc.login.inputField.password - the XPath location of the password input field.
	*/
	public void setPassword(String password, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.login.inputField.password"))).sendKeys(password);
	}
	
	
	/*Method used to click the "Login" button on the Log-In page.  
	* @ean.poc.login.button.loginUser - the XPath location of the Login button.
	*/
	public void clickLogin(WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.login.button.loginUser"))).click();
	}
	
	
	/*Method used to click the "Create new account" button in order to reach the "Create account" page.
	* @ean.poc.login.button.createAccount - the XPath location of the Create Account button.
	*/	
	public void clickNewAccount(WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.login.button.createAccount"))).click();
	}
	
	
	/*Method used to verify that a success message is displayed in the log-in page after creating a new account.
	* @ean.poc.login.form.creationSuccessField - the XPath location of the error field on the Create Account page.
	* @ean.poc.login.successMessage.accountCreated - retrieves the value of the "Successful Account Creation" message Key. 
	*/ 
	public void verifySuccessfulCreation(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.login.form.creationSuccessField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.login.successMessage.accountCreated"));
	}
	
	
	/*Method used to verify the error messages displayed in the log-in page.   
	* Cases covered: default/blank values (for username, password, or both),
	* invalid username/password (inexistent, incorrect credentials, lower/higher number of characters). 
	* @ean.poc.login.form.errorField - the XPath location of the error field on the Log-In page.
	* @ean.poc.login.errorMessage.invalidUserPass - retrieves the value of the "Invalid Username or Password" error message Key. 
	*/
	public void verifyInvalidUserPass (WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.login.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.login.errorMessage.invalidUserPass"));
	}
}
