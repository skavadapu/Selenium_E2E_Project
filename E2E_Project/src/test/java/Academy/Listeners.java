package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.baseClass;

public class Listeners extends baseClass implements ITestListener{

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	// The below Threadlocal allows to run parellel tests on seperate thread and no conflict of one test case listener with other test case listener
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// Calling Extent Reports onTestStart
		
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// 
		extentTest.get().log(Status.PASS, "Test Passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//send the failure log details to report
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		//Capture failed screenshots
		String testMethodName = result.getMethod().getMethodName();  //which gives the testcase name/method
		
		try {
			// the below will pull the driver field of relevant testcase
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
		
		//Calling the TakeScreenShot method and add the screen to defect in the report with logs
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, driver), result.getMethod().getMethodName());
		
			
		} catch (Exception e2) {
		
			e2.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// Print the reports after all tests execution completes
		
		extent.flush();
	}
}
