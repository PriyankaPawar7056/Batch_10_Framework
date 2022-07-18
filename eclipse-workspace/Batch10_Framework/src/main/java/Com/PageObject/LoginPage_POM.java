package Com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage_POM {

	@FindBy(how=How.XPATH,using="//input[@id='ema']")       //here we remove il in email to see/lock the exception
	private WebElement txt_emailId;
	
	@FindBy(how=How.XPATH,using="//input[@id='pass']")
	private WebElement txt_Pass;
	
	@FindBy(how=How.XPATH,using="//button[@id='loginbutton']")
	private WebElement btn_Login;
	
	@FindBy (how=How.XPATH,using="//a[text()='Forgotten account?']")
	private WebElement link_Forgotten;
	
	@FindBy(how=How.XPATH,using="//a[text()='Sign up for Facebook']")
	private WebElement link_signup;

	
	
	
	public WebElement getTxt_emailId() {
		return txt_emailId;
	}

	

	public WebElement getTxt_Pass() {
		return txt_Pass;
	}

	
	public WebElement getBtn_Login() {
		return btn_Login;
	}

	

	public WebElement getLink_Forgotten() {
		return link_Forgotten;
	}

	

	public WebElement getLink_signup() {
		return link_signup;
	}

	
}
