package ean.poc.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ean.poc.EANSeleniumTestConfig;
import ean.poc.helpers.CreateAccountPageHelper;
import ean.poc.helpers.IndexPageHelper;
import ean.poc.helpers.LoginPageHelper;
import ean.poc.helpers.TopBarHelper;

public class CreateAccountPageTests {

	EANSeleniumTestConfig config = EANSeleniumTestConfig.getInstance();
	IndexPageHelper indexHelper = new IndexPageHelper();
	TopBarHelper topBar = new TopBarHelper();
	LoginPageHelper loginHelper = new LoginPageHelper();
	CreateAccountPageHelper createAccountHelper = new CreateAccountPageHelper();

	/*The first test scenario checks that a user can reach the log-in page and click the "Create new account..."
	 *  button, proceed to the Create Account page, create an account (all fields), and log in with that account*/
	@Test(enabled = false)
	public void firstTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = "testAccount_2";
		String email = "email@mail.com";
		String password = "qazwsx123";
		String verifyPassword = "qazwsx123";
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");

		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
		createAccountHelper.setUsername(username, fireFoxDriver);
		createAccountHelper.setEmail(email, fireFoxDriver);
		createAccountHelper.setPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.setVerificationPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.clickCreate(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifySuccessfulCreation(fireFoxDriver);
		Thread.sleep(1000);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		indexHelper.verifyDestinationQuestion(fireFoxDriver);
		
		fireFoxDriver.quit();
	}
	
	
	/*The second test scenario checks that a user can reach the log-in page and click the "Create new account..."
	 *  button, proceed to the Create Account page, create an account (only mandatory fields), and log in with 
	 *  that account, then log out, and log back in again*/
	@Test(enabled = false)
	public void secondTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = "testAccount_3";
		String password = "qazwsx123";
		String verifyPassword = "qazwsx123";
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
		createAccountHelper.setUsername(username, fireFoxDriver);
		createAccountHelper.setPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.setVerificationPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.clickCreate(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifySuccessfulCreation(fireFoxDriver);
		Thread.sleep(1000);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		indexHelper.verifyDestinationQuestion(fireFoxDriver);
		Thread.sleep(1000);
		topBar.clickLogOutButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyLogOutInstructionMessage(fireFoxDriver);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		indexHelper.verifyDestinationQuestion(fireFoxDriver);
		
		fireFoxDriver.quit();
	}
	
	
	/*The third test scenario checks that a user cannot create an account with an invalid user name
	 * (3 characters, invalid characters), and valid passwords.*/
	@Test(enabled = false)
	public void thirdTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = "!@#";
		String password = "qazwsx123";
		String verifyPassword = "qazwsx123";
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
		createAccountHelper.setUsername(username, fireFoxDriver);
		createAccountHelper.setPassword(password, fireFoxDriver);
		createAccountHelper.setVerificationPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.clickCreate(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyUsernameError(fireFoxDriver);
		
		fireFoxDriver.quit();
	}
	
	
	/*The fourth test scenario checks that a user cannot create an account with an invalid email format.*/
	@Test(enabled = false)
	public void fourthTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = "emailTests";
		String email = "invalidEmail";
		String password = "qazwsx123";
		String verifyPassword = "qazwsx123";
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
		createAccountHelper.setUsername(username, fireFoxDriver);
		createAccountHelper.setEmail(email, fireFoxDriver);
		createAccountHelper.setPassword(password, fireFoxDriver);
		createAccountHelper.setVerificationPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.clickCreate(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyEmail(fireFoxDriver);
		
		fireFoxDriver.quit();
	}
	
	
	/*The fifth test scenario checks that a user cannot create an account with an invalid password (4 characters), 
	 * and valid user name.*/
	@Test(enabled = false)
	public void fifthTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = "validUser";
		String password = "1234";
		String verifyPassword = "1234";
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
		createAccountHelper.setUsername(username, fireFoxDriver);
		createAccountHelper.setPassword(password, fireFoxDriver);
		createAccountHelper.setVerificationPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.clickCreate(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyPasswordError(fireFoxDriver);
		
		fireFoxDriver.quit();
	}
	
	
	/*The sixth test scenario checks that a user cannot create an account with a mismatching password*/
	@Test(enabled = false)
	public void sixthTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = "validUser";
		String password = "012345";
		String verifyPassword = "012346";
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
		createAccountHelper.setUsername(username, fireFoxDriver);
		createAccountHelper.setPassword(password, fireFoxDriver);
		createAccountHelper.setVerificationPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.clickCreate(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyMatchingPasswordError(fireFoxDriver);
		
		fireFoxDriver.quit();
	}
	
	
	/*The seventh test scenario checks that a user cannot create an account while leaving all fields blank.*/
	@Test(enabled = false)
	public void seventhTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
		createAccountHelper.clickCreate(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyEmptyValueError(fireFoxDriver);
		
		fireFoxDriver.quit();
	}
	
	
	/*The eight test scenario checks that a user cannot create a user that already exists.*/
	@Test(enabled = false)
	public void eightTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = config.getUsername();
		String password = config.getPassword();
		String verifyPassword = config.getPassword();
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		
		WebDriver fireFoxDriver = new FirefoxDriver();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
		createAccountHelper.setUsername(username, fireFoxDriver);
		createAccountHelper.setPassword(password, fireFoxDriver);
		createAccountHelper.setVerificationPassword(verifyPassword, fireFoxDriver);
		createAccountHelper.clickCreate(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyUserAlreadyExists(fireFoxDriver);
		
		fireFoxDriver.quit();
	}
}