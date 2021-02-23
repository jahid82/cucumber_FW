package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By lnkCustomers_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][text()='Customers']");
	
	By btnAddnew=By.xpath("//a[@class='btn bg-blue']");
	
	
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	
//	By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
//	
//	By lstitemAdministrators=By.xpath("//li[text()='Administrators']");
//	By lstitemForumModerators=By.xpath("//li[text()='Forum Moderators']");
//	By lstitemGuests=By.xpath("//li[text()='Guests']");
//	By lstitemRegistered =By.xpath("//li[text()='Registered']");
//	By lstitemVendors=By.xpath("//li[text()='Vendors']");
	
	By drpmgOfVendor=By.xpath("//select[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@name='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
	
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@class='btn bg-blue'][@name='save']");
	
	
	//Actions Methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void  clickOnCustomerMenu() {
	ldriver.findElement(lnkCustomers_menu).click();
	}
	public void clickOnCustomerMenuitem() {
		ldriver.findElement(lnkCustomers_menuitem).click();;
	}
	public void clickOnAddNewButton() {
		ldriver.findElement(btnAddnew).click();;
	}
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
//	public void setCustomerRoles(String role) throws Exception {
//		if(!role.equals("vendors")) {
//			ldriver.findElement(By.xpath("//span[@class='k-icon k-loading k-loading-hidden']"));
//		
//		}
//		ldriver.findElement(txtcustomerRoles).click();
//		WebElement listitem;
//		Thread.sleep(3000);
//		if(role.equals("Administrators")) {
//			listitem=ldriver.findElement(lstitemAdministrators);
//			}
//		else if(role.equals("Guests")) {
//			listitem=ldriver.findElement(lstitemGuests);
//		}
//		else if(role.equals("Registered")) {
//			listitem=ldriver.findElement(lstitemRegistered);
//		}
//		else if(role.equals("Vendors")) {
//			listitem=ldriver.findElement(lstitemVendors);
//		
//		}
//		else {
//			listitem=ldriver.findElement(lstitemGuests);
//		}
//		listitem.click();
//}
	public void setmanagerofVendor(String text) {
		Select select=new Select(ldriver.findElement(drpmgOfVendor));
		select.selectByVisibleText(text);;
	}
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female")) {
			ldriver.findElement(rdFemaleGender).click();
		}
		else {
			ldriver.findElement(rdMaleGender).click();
		}
	}
	public void setFirstname(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String cname) {
		ldriver.findElement(txtCompanyName).sendKeys(cname);
	}
	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	public void clickonsave() {
		ldriver.findElement(btnSave).click();
	}
}
