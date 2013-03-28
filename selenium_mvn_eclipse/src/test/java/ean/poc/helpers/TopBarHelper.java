package ean.poc.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ean.poc.UIMap;

public class TopBarHelper {

	/*This method is used to click the "Home" button in the application's Top Bar.*/	
	public void clickHomeButton (WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.topBar.button.homePage"))).click();
	}
	
	
	/*This method is used to click the "Log-In" button in the application's Top Bar.*/	
	public void clickLoginButton (WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.topBar.button.loginPage"))).click();
	}

	
	/*This method is used to click the "Account" button in the application's Top Bar.*/	
	public void clickAccountButton (WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.topBar.button.accountPage"))).click();
	}
	
	
	/*This method is used to click the "Manage your bookings" button in the application's Top Bar.*/	
	public void clickManageBookingsButton (WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.topBar.button.itineraryPage"))).click();
	}
	
	
	/*This method is used to click the "Log Out" button in the application's Top Bar.*/	
	public void clickLogOutButton (WebDriver driver) throws Exception {
		WebElement accountMenu = driver.findElement(By.xpath(UIMap.find("ean.poc.topBar.button.accountPage")));
		WebElement logOutButton = driver.findElement(By.xpath(UIMap.find("ean.poc.topBar.button.logOut")));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(accountMenu).click(logOutButton);
		builder.perform();
	}
	
	
	/*This method is used to click the "Contact" button in the application's Top Bar.*/	
	public void clickContactButton(WebDriver driver) throws Exception {
		driver.findElement(By.xpath(UIMap.find("ean.poc.topBar.button.contactPage")));
	}
}
