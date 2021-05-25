Feature: Login into account
        Existing user should be able to login to account using correct credentials
		
Scenario: Login into account with correct credentials
	Given User navigates to stackoverflow website 
	And User clicks on SignIn button
	And User enters a valid username "tggupta22@gmail.com"
	And User enters a valid password 
	When User clicks on Login button 
	Then User should be taken to Login Page successfully
	And User should LogOut portal