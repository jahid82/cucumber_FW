package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class steps extends baseClasss{
	
	@Before //this will execute only one time before your test case starts
	public void setup() throws Exception  {
		logger=Logger.getLogger("nopCommerce");//Added logger
		PropertyConfigurator.configure("log4j.properties");//Added logger
		logger.info("Launching browser");
		//reading properties
		configPro=new Properties();
		FileInputStream configpropertyfile=new FileInputStream("C:\\Users\\jahid_5psu063\\Downloads\\CucumberprojectPavanSirCompletePerftectcode-master\\CucumberprojectPavanSirCompletePerftectcode-master\\Pavanbdd\\config.properties");
		configPro.load(configpropertyfile);
		
		
		
		//used for separating configurations
		String br=configPro.getProperty("browser");
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", configPro.getProperty("chromepath"));
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configPro.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
		}
		logger=Logger.getLogger("nopCommerce");//Added logger
		PropertyConfigurator.configure("log4j.properties");//Added logger
		logger.info("Launching browser");
		driver.manage().window().maximize();
		}
	
	
	@Given("^User launch chrome browser$")
		public void user_launch_chrome_browser() {
		
		
		
		lp=new LoginPage(driver);
		
	}
	@When("^user opens URL \"(.*)\"$")
	public void openURl(String url)
	{
		logger.info("opening url");
		driver.get(url);
		
	}
	
	@And("^User enters email as \"(.*)\" and password as \"(.*)\"$")
	public void enteremail(String email,String password)
	{
		logger.info("entering username and password");
		lp.setusername(email);
		lp.setpassword(password);
	}
	
	@And("^click on login$")
	public void loginclick() {
		logger.info("clicking on login button");
		lp.clicklogin();
		
	}
	
	@When ("^user click on logout link$")

	public void logout() throws Exception {
		logger.info("clicking onlogout button");
		lp.logout();
		Thread.sleep(5000);
	}
@And("^close browser$")
public void close_browser() {
	logger.info("closing browser");
	driver.close();
	
}
	//Customer feature step definitions....

	@Then("^User can view dashboard$")
	public void user_can_view_dashboard() {
		logger.info("user is viewing dashboard");
		addCust=new AddCustomerPage(driver);
	Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		
	}
	@When("^User clicks on customer menu$")
	public void user_clcick_customermenu() throws Exception {
		logger.info("clicking on customer menu");
		Thread.sleep(3000  );
		addCust.clickOnCustomerMenu();
	}
	@And("^click on customers menu item$")
	public void click_customer_menuitem() throws Exception {
		logger.info("clicking on custmer menuitem");
		Thread.sleep(3000);
		addCust.clickOnCustomerMenuitem();
	}
	@And("^click on add new button$")
	public void click_add_button() throws Exception {
		logger.info("clicking on add new button");
		Thread.sleep(3000);
		addCust.clickOnAddNewButton();
		Thread.sleep(10000);
	}
	@Then("^User can view new customer page$")
	public void user_view_cutomer_page() {
		logger.info("viewing customer page");
		Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle() );
	}
	@When("^user enter customer info$")
	public void user_enter_customer_info() throws Exception {
		logger.info("entering customer info");
		String email=randomstring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		
		Thread.sleep(7000);	
		
		addCust.setmanagerofVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstname("Pavan");
		addCust.setLastName("Kumar");
		addCust.setDob("09/04/2020");
		addCust.setCompanyName("busyQa");
		addCust.setAdminContent("This is for testing....");
		
	}
	@And("^click on save button$")
	public void click_save_button() throws Exception {
		logger.info("clicking on save button");
		addCust.clickonsave();
		Thread.sleep(5000);
}
	@Then("^user can view confirmation message \"(.*)\"$")
	public void user_view_confirmation_message(String message) {
		logger.info("viewing confirmation message of customer registered");
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
}
	//steps for searching a customer using email
	
	@And("^Enter customer email$")
	public void enter_customer_email() {
		logger.info("entering customer email");
	search=new SearchCustomerPage(driver);
	search.setEmail("victoria_victoria@nopCommerce.com");
}
	@When("^Click on search button$")
	public void click_search_button() throws Exception {
		logger.info("clicking on search button");
		search.clickbtnsearch();
		Thread.sleep(5000);
	}
	@Then("^user should found email in the search table$")
	public void user_availability() {
		logger.info("searchin user availabity in table by email");
		boolean status=search.searchcustomerbyEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	//search customer by firstname and lastname
	@And("^Enter customer firstname$")
	public void customer_firstname() throws InterruptedException {
		logger.info("enter user firstname");
		search=new SearchCustomerPage(driver);
		search.setfirstname("Victoria ");
		Thread.sleep(3000);
	}
	@And("^Enter customer lastname$")
	public void customer_lastname() throws InterruptedException {
		logger.info("entering lastname");
		search.setlastnamem("Terces");
		Thread.sleep(3000);
		
	}
	@Then("^user should found name in the search table$")
	public void customer_name_search() throws InterruptedException {
		logger.info("searching user by customername");
		boolean status=search.searchcustomerbyname("Victoria Terces");
		Assert.assertEquals(true, status);
		
	}
}
	
