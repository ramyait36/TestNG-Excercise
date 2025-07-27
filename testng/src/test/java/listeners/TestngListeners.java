package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import factory.DriverManager;
import utils.screenShotUtil;

public class TestngListeners implements ITestListener{
 
//	ITestResult result;
	//String testName = result.getName();
	private static ExtentReports report = ExtentManager.createInstance();

	
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
	//creating atest entry in extent report
		//reates a new test block in the ExtentReport using the method name as the test title.
		//result.getMethod().getMethodName() is equivalkent to result.getName() - both return string method name
		
		//result.getTestClass().getName() gives package.class name : 	"tests.LoginTest"
		//result.getTestClass().getRealClass().getSimpleName() - return the classname as logintest 
		
		//		String testName = result.getName();
		String testName = result.getMethod().getMethodName();

		ExtentTest test = report.createTest(testName);
		System.out.println("the testname is:" + testName);
		ExtentManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		//test.log or test.pass or test.fail or test.skip
		//thTest.get() - reteriving the test variable from threadlocal
		
	//System.out.println("the test name is:" + testName);
		
		String testName = result.getMethod().getMethodName();

		String logText = "<b>"+"TEST CASE:- "+ testName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		
		//passing the relative path from the screenshot util method
		String path = screenShotUtil.screenShotMethod(testName);

		
		ExtentManager.getTest().log(Status.PASS, m, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		
	//	//or
		//thTest.get().pass("passed");
		
			}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testName = result.getMethod().getMethodName();


		String logText = "<b>" +" TEST CASE:- "+ testName.toUpperCase() + " FAILED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentManager.getTest().log(Status.FAIL, m);
		  String path = screenShotUtil.screenShotMethod(testName);

		  ExtentManager.getTest().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	
		
		
		
		
		//manual creation of html report attaching images in reportng report
//		System.out.println("capturing screen shotfor the failed test");
//		
//		System.setProperty("org.uncommons.reportng.escape-output","false");
//		Reporter.log("<a href=\"F:\\screenshot\\error.jpg\" target=\"_blank\">Screenshot link</a>");
//		Reporter.log("<br>");
//		Reporter.log("<a href=\"F:\\screenshot\\error.jpg\" target=\"_blank\"><img height=200 width=200 src=\"F:\\screenshot\\error.jpg\"></a>");
//
//		System.out.println(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		//result.getThrowable() - returns throwable object
		
		String testName = result.getMethod().getMethodName();
		String logText = "<b>" +" TEST CASE:-" + testName.toUpperCase()+" SKIPPED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.LIME);
		ExtentManager.getTest().log(Status.SKIP, result.getThrowable());
		
	//	or thTest.get().skip("skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		if (report != null) {
		report.flush();}
	}

}
