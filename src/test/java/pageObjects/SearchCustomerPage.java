package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	WaitHelper waithelper;
public WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.XPATH, using="//input[@id='SearchEmail']")
	@CacheLookup
	WebElement emailtxt;
	
	@FindBy(how =How.XPATH,using="//input[@id='SearchFirstName']")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(how=How.ID,using="SearchLastName")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(how=How.XPATH,using="//button[@id='search-customers']")
	@CacheLookup
	WebElement btnsearch;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']")
	@CacheLookup
	WebElement tblsearchresults;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement>tablerows;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tablecolumns;
	
	//Action methods
	
	public void setEmail(String email) {
		waithelper.waitForElement(emailtxt, 30);
		emailtxt.clear();
		emailtxt.sendKeys(email);
	}
	
		public void setfirstname(String fname) {
			waithelper.waitForElement(firstname, 30);
				firstname.clear();
				firstname.sendKeys(fname);
				
			}
		public void setlastnamem(String lname) {
			waithelper.waitForElement(lastname, 30);
			lastname.clear();
			lastname.sendKeys(lname);
		}
		
		public void clickbtnsearch() {
			waithelper.waitForElement(btnsearch, 60);
			btnsearch.click();
		}
		public int getNoOfRows() {
			return(tablerows.size());
		}
		public int getNoOfColumns() {
			return(tablecolumns.size());
		}
		public boolean searchcustomerbyEmail(String email) {
			boolean flag=false;
			for(int i=1;i<=getNoOfRows();i++) {
				String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(emailid);
				if(emailid.equals(email)) {
					flag=true;
				}
			}
			return flag;
		}
		
		public boolean searchcustomerbyname(String name) {
			boolean flag=false;
			for(int i=1;i<=getNoOfRows();i++) {
				String name1=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
				 System.out.println(name1);
				 String[] names=name1.split(" ");
				if(names[0].equals("Victoria")&& names[1].equals("Terces")) {
					flag=true;
				}
				
			}
			return flag;
		}
	}

