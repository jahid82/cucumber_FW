package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class baseClasss {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage search;
	public static Logger logger;
	public Properties configPro;
	//created for generating random string for  unique email id
	public static String randomstring() {
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
	

}
