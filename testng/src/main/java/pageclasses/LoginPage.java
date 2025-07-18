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
	
	private By searchElement = By.name("q");
	
	public void searchMethod() {
		
		DriverManager.getDriver().findElement(searchElement).sendKeys("toolsqa" + Keys.ENTER);
		System.out.println("the title is " + DriverManager.getDriver().getTitle());
		
		
	}

}
