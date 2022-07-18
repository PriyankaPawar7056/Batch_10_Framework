package Com.Utility;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Library {
	
	public static ExtentTest test;
	
	//Exception Handling of send-keys and click By Using Try AND Catch Block
	public static void custom_sendkeys(WebElement element,String value,String FieldName) {
	try{
		
		element.sendKeys(value);
		test.log(Status.PASS, FieldName+"=Value Sucessfully Send ="+value);        //It shows on reports what actually we are doing 
		
	}catch(Exception e) {
		
		  test.log(Status.FAIL, e.getMessage());
     
	}
	}
	
	public static void custom_click(WebElement element,String FieldName) {
		try {
			
			element.click();
			test.log(Status.PASS, "Clicked Sucessfully on =" +FieldName);
		}catch(Exception e) {
			test.log(Status.FAIL, e.getMessage());
			
		}
	}
}
