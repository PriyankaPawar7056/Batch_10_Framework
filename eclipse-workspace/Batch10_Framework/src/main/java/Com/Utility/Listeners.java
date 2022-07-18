package Com.Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {
	
	//STEPS : 1) Listeners implements ITestListener
	//        2) Right click on class Listeners ------> Source -----> Override \ Implements Methods
	// 3) Now we have tell Listeners class that we have done some implementation in ExtentReportGeneretor class and we Store it in a ExtentReports reference i.e extent
	  // For that ExtentReports extent=ExtentReportGeneretor.reports();
	  
	 ExtentReports extent=ExtentReportGeneretor.getReports();
	 
	// 4)Now We want setup :  Whatever test cases execute that will be store/Attach in only one report
	//NOTE : ExtentTest class which is used for ExtentReports
	 ThreadLocal<ExtentTest> extenttest=new  ThreadLocal<ExtentTest>();
	 
	 public void onTestStart(ITestResult result) {
		Library.test=extent.createTest(result.getTestClass().getName()+"=="+result.getMethod().getMethodName());
		extenttest.set(Library.test);
	}

	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "Test Case Is Pass");
		Library.test.addScreenCaptureFromBase64String(getScreenShot());
		
	}

	public void onTestFailure(ITestResult result) {
		
		extenttest.get().log(Status.FAIL, "Test Case Is Fail");
		Library.test.addScreenCaptureFromBase64String(getScreenShot());
	}

	public void onTestSkipped(ITestResult result) {
		
		extenttest.get().log(Status.SKIP, "Test Case Is Skip");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	public static String getScreenShot() {
		
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 return ts.getScreenshotAs(OutputType.BASE64);   //Base64 because file format wala screenshot mail ke sath nahi jata isliye
	}
   
}
