package ean.poc.helpers;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ean.poc.MessageMap;
import ean.poc.UIMap;

public class IndexPageHelper {

	
	//Method used to check if the destination question is present on the index page's search form.
	public void verifyDestinationQuestion(WebDriver driver) throws Exception {
		String destinationQuestion = driver.findElement(By.xpath(UIMap.find("ean.poc.index.label.destinationSearchQuestion"))).getText();
		
		Assert.assertEquals(destinationQuestion, MessageMap.find("ean.poc.index.searchForm.searchQuestion"));
	}
}
