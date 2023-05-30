package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseTest;

public class ElementFetch {

	public WebElement getWebElement(String indentifierType, String identifiervalue) {
		
		switch(indentifierType) {
		
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifiervalue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifiervalue));
		case "ID":
			return BaseTest.driver.findElement(By.id(identifiervalue));
		case "NAME":
			return BaseTest.driver.findElement(By.name(identifiervalue));
		case "CLASSNAME":
			return BaseTest.driver.findElement(By.className(identifiervalue));
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(identifiervalue));
		
		default:
			return null;
			
		}
	}
	
   public List<WebElement> getWebElements(String indentifierType, String identifiervalue) {
		
		switch(indentifierType) {
		
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifiervalue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifiervalue));
		case "ID":
			return BaseTest.driver.findElements(By.id(identifiervalue));
		case "NAME":
			return BaseTest.driver.findElements(By.name(identifiervalue));
		case "CLASSNAME":
			return BaseTest.driver.findElements(By.className(identifiervalue));
		case "TAGNAME":
			return BaseTest.driver.findElements(By.tagName(identifiervalue));
		
		default:
			return null;
			
		}}
}
