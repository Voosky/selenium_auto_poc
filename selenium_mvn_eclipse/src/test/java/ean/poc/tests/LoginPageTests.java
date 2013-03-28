package ean.poc.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import ean.poc.EANSeleniumTestConfig;
import ean.poc.helpers.CreateAccountPageHelper;
import ean.poc.helpers.IndexPageHelper;
import ean.poc.helpers.LoginPageHelper;
import ean.poc.helpers.TopBarHelper;

public class LoginPageTests {
	
	EANSeleniumTestConfig config = EANSeleniumTestConfig.getInstance();
	LoginPageHelper loginHelper = new LoginPageHelper();
	TopBarHelper topBar = new TopBarHelper();
	IndexPageHelper indexHelper = new IndexPageHelper();
	CreateAccountPageHelper createAccountHelper = new CreateAccountPageHelper();
	
	WebDriver fireFoxDriver;
	
	@BeforeMethod
	public void setUp() {
		//System.setProperty("webdriver.firefox.bin", "C:\\Users\\vlad.chertes\\AppData\\Local\\Mozilla Firefox\\Firefox.exe");
		fireFoxDriver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		fireFoxDriver.quit();
	}

	/*The first test scenario checks that a user can successfully log in and out of the application*/
	@Test
	public void firstTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = config.getUsername();
		String password = config.getPassword();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyLogInInstructionMessage(fireFoxDriver);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		indexHelper.verifyDestinationQuestion(fireFoxDriver);
		Thread.sleep(2000);
		topBar.clickLogOutButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyLogOutInstructionMessage(fireFoxDriver);
	}
	
	
	/*The second test scenario checks that a user can successfully log in and out of the application,
	 * and then log back in successfully*/
	@Test
	public void secondTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = config.getUsername();
		String password = config.getPassword();
				
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyLogInInstructionMessage(fireFoxDriver);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		topBar.clickLogOutButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyLogOutInstructionMessage(fireFoxDriver);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		indexHelper.verifyDestinationQuestion(fireFoxDriver);
	}
	
	
	/*The third test scenario checks that a user cannot log into the application 
	 * if he/she does not enter a user name and a password*/
	@Test
	public void thirdTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyInvalidUserPass(fireFoxDriver);
	}
	
	
	/*The fourth test scenario checks that a user cannot log into the application 
	 * if he/she does not enter a password, but enters a user name*/
	@Test
	public void fourthTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = config.getUsername();

		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyInvalidUserPass(fireFoxDriver);
	}
	
	
	/*The fifth test scenario checks that a user cannot log into the application 
	 * if he/she does not enter a user name, but enters a password*/
	@Test
	public void fifithTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String password = config.getPassword();
		
		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyInvalidUserPass(fireFoxDriver);
	}
	
	
	/*The sixth test scenario checks that a user cannot log into the application 
	 * with an inexistent user name/password*/
	@Test
	public void sixthTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = "userInexistent";
		String password = "parolaInexistenta";

		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyInvalidUserPass(fireFoxDriver);
	}
	
	
	/*The seventh test scenario checks that a user cannot log into the application 
	 * with a valid user name, but with a password containing invalid characters*/
	@Test
	public void seventhTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();
		String username = "youngMan01";
		String password = "Q!W@E#R$T%Y^";

		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.setUsername(username, fireFoxDriver);
		loginHelper.setPassword(password, fireFoxDriver);
		loginHelper.clickLogin(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.verifyInvalidUserPass(fireFoxDriver);
	}
	
	
	/*The eight test scenario checks that a user click the "Create new account..." button, 
	 * and proceed to the Create Account page*/
	@Test
	public void eightTestScenario() throws Exception {
		String baseUrl = config.getSiteBaseUrl();

		fireFoxDriver.navigate().to(baseUrl);
		Thread.sleep(2000);
		topBar.clickLoginButton(fireFoxDriver);
		Thread.sleep(2000);
		loginHelper.clickNewAccount(fireFoxDriver);
		Thread.sleep(2000);
		createAccountHelper.verifyCreateInstructionMessage(fireFoxDriver);
	}
}
