package utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverManager;

public class screenShotUtil {

	// create a date object, then create a simedateformat object with corresponding pattern required. 
	//with the dateformat object then call the format method and pass date object as parameter
	
	public static String screenShotMethod(String testName) {
	
	Date date = new Date(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
    String timestamp = sdf.format(date);
	
	//screenshot method in selenium
    
    //converting webdriver instance to takescreenshot and call getscreenshot method to create a image file
    
       TakesScreenshot src = ((TakesScreenshot) DriverManager.getDriver());
       File srcshot = src.getScreenshotAs(OutputType.FILE);
       String fileName = timestamp + "-" + testName + ".png";

       // relative path for mapping the screenshot path in the extent report 
    String reportDir = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "reports";
	String absolutePath =  reportDir + File.separator + "screenshots" + File.separator + fileName;
    String relativePath = "screenshots" + File.separator + fileName;
    
    System.out.println(absolutePath);
    System.out.println(relativePath);
    

	File dest = new File(absolutePath);
	dest.getParentFile().mkdirs(); // This creates 'screenshots' folder if missing

	try {
		//FileUtils.copyFile(srcshot, new File(absolutePath));
		FileUtils.copyFile(srcshot, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return relativePath;
	
}
}