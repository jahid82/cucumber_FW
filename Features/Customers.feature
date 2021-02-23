Feature: Customers

Background: Below are the common steps for each scenario	
	Given User launch chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters email as "admin@yourstore.com" and password as "admin"
	And click on login	
	Then User can view dashboard
	
	@rajkamal
Scenario: Add a new customer
	
	When User clicks on customer menu 
	And click on customers menu item
	And click on add new button
	Then User can view new customer page
	When user enter customer info
	And click on save button
	Then user can view confirmation message "The new customer has been added successfully"
	And close browser

	@mamidala
Scenario: Search Customer By email id
	
	When User clicks on customer menu 
	And click on customers menu item
	And Enter customer email
	When Click on search button
	Then user should found email in the search table
	And close browser
	
	
@regression	
Scenario: Search customer By Name
	
	When User clicks on customer menu 
	And click on customers menu item
	And Enter customer firstname
	And Enter customer lastname
	When Click on search button
	Then user should found name in the search table
	Then close browser
	