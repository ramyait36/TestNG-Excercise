
package testclasses;


import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverManager;
import listeners.ExtentManager;
import pageclasses.LoginPage;

public class LoginTest extends BaseTest{
	
// 	LoginPage loginpage = new LoginPage(driver); normal but we used threadlocal variable set to driver so retrieving driver by DriverManager.getDriver()

		LoginPage loginpage = new LoginPage(DriverManager.getDriver());
	@Test
	public void verifyUrl()
	{
		ExtentManager.getTest().info("launch the browser and search the text");
		loginpage.searchMethod();
	ExtentManager.getTest().pass("url verified successfully");
	
		
	}
	
	

}
