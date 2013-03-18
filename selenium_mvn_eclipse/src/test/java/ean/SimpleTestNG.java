package ean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SimpleTestNG {
	
  @Test
  public void simpleTest() {
	  WebDriver ffDriver = new FirefoxDriver();
	  
	  ffDriver.navigate().to("");
  }
  
}
