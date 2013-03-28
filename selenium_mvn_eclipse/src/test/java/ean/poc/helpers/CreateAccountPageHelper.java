package ean.poc.helpers;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ean.poc.MessageMap;
import ean.poc.UIMap;

public class CreateAccountPageHelper {
	
	/*Method used to type the desired Username into the Username input field (Create Account page).  
	* @username - the value of the desired username string used.
	* @ean.poc.createAccount.inputField.username - the XPath location of the username input field.
	*/
	public void setUsername(String username, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.username"))).sendKeys(username);
	}
	
	
	/*Method used to type the desired E-mail into the E-mail input field (Create Account page).  
	* @email - the value of the desired e-mail string used.
	* @ean.poc.createAccount.inputField.email - the XPath location of the e-mail input field.
	*/
	public void setEmail(String email, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.email"))).sendKeys(email);
	}
	
	
	/*Method used to type the desired Password into the Password input field (Create Account page).  
	* @password - the value of the desired Password string used.
	* @ean.poc.createAccount.inputField.password - the XPath location of the Password input field.
	*/
	public void setPassword(String password, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.password"))).sendKeys(password);
	}
	
	
	/*Method used to type the verification password into the Verify Password input field (Create Account page).  
	* @verifyPassword - the value of the desired verification password string used.
	* @ean.poc.createAccount.inputField.verifyPassword - the XPath location of the Verify Password input field.
	*/
	public void setVerificationPassword(String verifyPassword, WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.inputField.verifyPassword"))).sendKeys(verifyPassword);
	}
	
	
	//Method used to click the "Create" button on the "Create Account" page. 
	public void clickCreate(WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.button.create"))).click();	
	}
	
	
	//Method used to 
	public void verifyCreateInstructionMessage(WebDriver driver) throws Exception {
		String instructionMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.instructionMessage"))).getText();
		
		Assert.assertEquals(instructionMessage, MessageMap.find("ean.poc.createAccount.staticMessage.instructionMessage"));
	}
	
	
	/*Method used to verify the cannot create an account by leaving blank values in the fields.
	* @ean.poc.createAccount.form.errorField - the XPath location of the error field on the Create Account page.
	* @ean.poc.createAccount.errorMessage.emptyValueError - retrieves the value of the empty value error message Key. 
	*/
	public void verifyEmptyValueError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.emptyValueError"));
	}
	
	
	
	/*Method used to verify the error message received if a user creates an account that already exists. 
	* @ean.poc.createAccount.form.errorField - the XPath location of the error field on the Create Account page.
	* @ean.poc.createAccount.errorMessage.userAlreadyExists - retrieves the value of the "Account already Exists" error message Key. 
	*/
	public void verifyUserAlreadyExists(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.userAlreadyExists"));
	}
	
	
	/*Method used to verify the User Name field in terms of length(minimum and maximum), 
	* supported characters, and null/blank values. 
	* @ean.poc.createAccount.form.errorField - the XPath location of the error field on the Create Account page.
	* @ean.poc.createAccount.errorMessage.invalidUserName - retrieves the value of the "Invalid Username" error message Key. 
	*/
	public void verifyUsernameError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidUserName"));
	}
	
	
	/*Method used to verify the Password field in terms of length(minimum), and null values. 
	* The method does not cover special character situations for now! (due to limitations in the software)
	* @ean.poc.createAccount.form.errorField - the XPath location of the error field on the Create Account page.
	* @ean.poc.createAccount.errorMessage.invalidPassword - retrieves the value of the "Invalid Password" error message Key. 
	*/
	public void verifyPasswordError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidPassword"));
	}
	
	
	/*Method used to check the Verify Password field in terms of length(lower or higher), 
	* different characters than in the Password field, and null values (mismatch). 
	* @ean.poc.createAccount.form.errorField - the XPath location of the error field on the Create Account page.
	* @ean.poc.createAccount.errorMessage.passwordMismatch - retrieves the value of the "Password Mismatch" error message Key. 
	*/ 
	public void verifyMatchingPasswordError(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.passwordMismatch"));
	}
	
	
	/*Method used to verify the Email field in terms of correct format (example@example.com).
	* @ean.poc.createAccount.form.errorField - the XPath location of the error field on the Create Account page.
	* @ean.poc.createAccount.errorMessage.invalidEmail - retrieves the value of the "Invalid Email" error message Key. 
	*/ 
	public void verifyEmail(WebDriver driver) throws Exception {
		String errorMessage = driver.findElement(By.xpath(UIMap.find("ean.poc.createAccount.form.errorField"))).getText();
		
		Assert.assertEquals(errorMessage, MessageMap.find("ean.poc.createAccount.errorMessage.invalidEmail"));
	}
		
}
