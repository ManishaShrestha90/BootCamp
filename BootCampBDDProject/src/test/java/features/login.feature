Feature: Login Action
As a user I want a login page so that only authentic users can login.

Scenario: User will be able to login
Given a user with valid creditials
When user goes to TechFios Login Page
Then TechFios Login page should display
When user enter login inforamtion
Then Submit buttion should be enabled
When user selects the Submit Button
Then Dashboard page should display
And user information should match
