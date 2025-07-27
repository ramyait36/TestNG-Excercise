
package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import factory.DriverFactory;
import factory.DriverManager;
import listeners.TestngListeners;

@Listeners(TestngListeners.class)
public class BaseTest {
  
 //   protected WebDriver driver = DriverManager.getDriver();

    


	//
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser)
		
	{
		DriverFactory.initDriver(browser);

	}
		
	
	
	
	@AfterMethod
	public void tearDown() {
		
		DriverManager.quitDriver();

}
}