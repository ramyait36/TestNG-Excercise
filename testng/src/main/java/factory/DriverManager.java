package factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	// using threadlocal to support parallelization and link driver manger with driver factory
		
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public static WebDriver getDriver() { //get the driverinstance from threadlocalvariable
		return tldriver.get();
	}

	public static void setDriver(WebDriver driver) { //set the driverinstance to threadlocalvariable
		tldriver.set(driver);
	}
	
	public static void qiutDriver() {
		
//		if (tldriver.get() != null)
//		{
//			tldriver.get().quit();
//		}
		//(or)
		
		if (DriverManager.getDriver() != null) {
			
			DriverManager.getDriver().quit();
					}
		tldriver.remove(); // release memory
		
	}

	
	

}
