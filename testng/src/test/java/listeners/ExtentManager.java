package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	
	private static ExtentReports extent;
	
	private static ThreadLocal<ExtentTest> thTest = new ThreadLocal<>();
	
	public static ExtentReports createInstance() {
    String path = System.getProperty("user.dir")+ "/test-output/reports/extentreport.html";
    ExtentSparkReporter reporter = new ExtentSparkReporter(path);
  	reporter.config().setReportName("test automation execution report");
	reporter.config().setDocumentTitle("automation extent report");
	reporter.config().setTheme(Theme.STANDARD);

	// attach the extent report 
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	// add config for extent report
	
	extent.setSystemInfo("tester", "ramya");
	extent.setSystemInfo("env", "qa");
	
	
		return extent;
}
		// use this method in test classes for logging the status 
	
	public static ExtentTest getTest() {
		return thTest.get();
	}

	public static void setTest(ExtentTest test) {
		thTest.set(test);
	}
	
	

}