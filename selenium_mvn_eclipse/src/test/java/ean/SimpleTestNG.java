package ean;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SimpleTestNG {
	
  @Test
  public void simpleTest() {
	  WebDriver firefoxDriver = new FirefoxDriver();
	  
	  String url = "http://google.com";
	  String expectedTitle = "Google";
	  
	  firefoxDriver.navigate().to(url);
	  
	  Assert.assertEquals(expectedTitle, firefoxDriver.getTitle());
  }
  
}
