package PageEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjects.LoginPageObject;
import Utils.ElementFetch;

public class LoginPage {
	 
	 
	 ElementFetch ele = new ElementFetch();
	 
	 public void verifyifloginpageisloaded() {
		 
		 Assert.assertTrue(ele.getWebElements("XPATH",LoginPageObject.loginbutton).size()>0, "Page Not Loaded Properly");
	 }
	 
	 public void entercredentials() {
		 ele.getWebElement("XPATH", LoginPageObject.email).sendKeys("rahulrai@enercent.co");
		 ele.getWebElement("XPATH", LoginPageObject.password).sendKeys("Enercent$3");
		// jse.executeScript("window.scrollBy(0,250)");
		 ele.getWebElement("XPATH", LoginPageObject.loginbutton).click();
	 }
}
	