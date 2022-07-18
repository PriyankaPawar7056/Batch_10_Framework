package Com.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGeneretor {
	
	//ExtentSparkReporter
	//ExtentReports
     public static ExtentReports extent;
     
	public static ExtentReports getReports() {     //we change return-type (Void) because we want to return ExtentReports REference extent 
		
		String Reportpath="C:\\Users\\rpgsa\\eclipse-workspace\\Batch10_Framework\\Reports\\index.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(Reportpath);
		reporter.config().setDocumentTitle("Batch_10_Reports");
		reporter.config().setReportName("Automation Test Reports");
		reporter.config().setTheme(Theme.DARK);
		
	    extent=new ExtentReports();    //set BrowserName //set we work on Which environmentName
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project Name", "ABC Project");
		extent.setSystemInfo("QA", "xyz");
		return extent;
		
	}
}
