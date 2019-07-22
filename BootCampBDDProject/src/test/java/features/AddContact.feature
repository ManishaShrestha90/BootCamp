Feature: Add Contact
As a user I want to add new contact by filling the form 
	Scenario: User will be able to add contact
	Given a user already logged in 
	When user navigate to CRM -> Add Contact
	Then Add Contact page should display
	When user submits Full Name Company Name Email Phone Address City State/Region Zip/PostalCode Country Tags
	Then New Contact Created Succesfully should display
	
	
#	
#Scenario: User will be able to login
#Given a user with valid creditials
#When user goes to TechFios Login Page
#Then TechFios Login page should display
#When user enter login inforamtion
#Then Submit buttion should be enabled
#When user selects the Submit Button
#Then Dashboard page should display
#And user information should match
	