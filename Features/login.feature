Feature: Login

@sanity
Scenario: Successful login with valid credentials

	Given User launch chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters email as "admin@yourstore.com" and password as "admin"
	And click on login
	
	When user click on logout link
	
	And close browser
	
	@sanity
Scenario Outline:  Login data driven testing


	Given User launch chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters email as "<email>" and password as "<password>"
	And click on login
	
	When user click on logout link
	
	And close browser
	Examples: 
	|email| |password|
	|admin@yourstore.com| |admin|
	|rajkamal| |mamidala|