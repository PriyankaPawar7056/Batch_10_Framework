package Com.Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static ConfigDataProvider config;     //Access it through the project
	public static ExcelDataProvider excel;
	
	
	@BeforeSuite                //to access configProperties from configDataProvider //Create Object of configDataProvider
	public void inisializationsetup() throws IOException {
		 config=new ConfigDataProvider();
		  excel=new ExcelDataProvider();
	}
	//@Parameters ---->  For cross-browser
	@Parameters({"BrowserName"})
	@BeforeMethod
	public void setUp(String BrowserName) {
		
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	}
	else if(BrowserName.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
	    driver=new EdgeDriver();
	}
	    driver.get(config.getQAENV_1());
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	

}
