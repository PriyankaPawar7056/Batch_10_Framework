package Com.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.PageObject.LoginPage_POM;
import Com.Utility.BaseClass;
import Com.Utility.Library;

public class VerifyLogin_Test extends BaseClass{
	
	@Test
	public void Verify_TC_01_LoginWithValidCredentials() {
	
		LoginPage_POM login=PageFactory.initElements(driver, LoginPage_POM.class);
		//login.getTxt_emailId().sendKeys("priyankapawar7056");
		//login.getTxt_Pass().sendKeys("priyanka123");
		//login.getBtn_Login().clear();
		
		// We Can Directly Call And Send Values Through Excel-Sheet
		
	   Library.custom_sendkeys(login.getTxt_emailId(),excel.getStringData("Sheet1", 0, 0), "EmailID");
	   Library.custom_sendkeys(login.getTxt_Pass(),excel.getStringData("Sheet1", 0, 1), "Password");
	   Library.custom_click(login.getBtn_Login(), "Login");
	   Assert.assertTrue(false);
     
      }
}