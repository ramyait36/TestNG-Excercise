package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import factory.DriverManager;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private static By searchElement = By.name("q");
	
	public void searchMethod() {
		
	    DriverManager.getDriver().get("https://www.google.com");
	//	DriverManager.getDriver().findElement(LoginPage.searchElement).sendKeys("toolsqa");
	    DriverManager.getDriver().findElement(searchElement).sendKeys("toolsqa");
		System.out.println("the title is " + DriverManager.getDriver().getTitle());
		
//		driver.get("https://www.google.com");
//		driver.findElement(searchElement).sendKeys("toolsqa" + Keys.ENTER);
//		System.out.println("the title is " + driver.getTitle());
//
		
		
	}

}
