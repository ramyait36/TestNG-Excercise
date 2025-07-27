package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverFactory {

	/*
	 * for mapping the browser driver to correct browser//
	 */	

	public static void initDriver(String browserName)

	{
		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//DriverManager.setDriver(driver); //merging of driver factory & driver manager


		} else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//DriverManager.setDriver(driver); //merging of driver factory & driver manager
		}

		else {
			throw new IllegalArgumentException("exception thrown pls chk the browser name ," + browserName);


		}
		
		//merging of driver factory & driver manager
		
//		DriverManager.getDriver().manage().window().maximize();
//		DriverManager.getDriver().manage().deleteAllCookies();
//		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      //  return the driver in normal case by giving the return type as WebDriver in method definition
      
      //return driver;
		
  	 // set the driver returned to threadlocal variable - finally setting the value of driver to threadlocal variable
  		
  		 DriverManager.setDriver(driver);
		

		//	another type or using switch case in driver factory


		//		switch(browserName.toLowerCase())
		//		{
		//		case "chrome":{
		//			WebDriverManager.chromedriver().setup();
		//			driver = new ChromeDriver();
		//	break; 	              }
	//			
	//		case "firefox":{
	//			WebDriverManager.firefoxdriver().setup();
	//			driver = new 

	//	          break;}	
	//	
	//		default: { throw new IllegalArgumentException ("Unsupported browser: " + browserName);}
	//			
	//		}

		
		



}

}
