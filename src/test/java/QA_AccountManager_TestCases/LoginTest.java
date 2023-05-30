package QA_AccountManager_TestCases;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.LoginPage;
import PageObjects.LoginPageObject;
import Utils.ElementFetch;

public class LoginTest extends BaseTest  {

	ElementFetch ele = new ElementFetch();
	LoginPage login = new LoginPage();
	
	@Test
	
	public void loginpage() {
		
		login.verifyifloginpageisloaded();
		login.entercredentials();
	}
	
}
