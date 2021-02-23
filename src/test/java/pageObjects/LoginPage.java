package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath= "//input[@class='button-1 login-button']")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath= "//a[@href='/logout']")
	@CacheLookup
	WebElement lnklogout;
	
	public void setusername(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
		
		public  void setpassword(String pword) {
			txtPassword.clear();
			txtPassword.sendKeys(pword);
		}
		public void clicklogin() {
			btnlogin.click();
		}
		public void logout() {
			lnklogout.click();
		}
	}


