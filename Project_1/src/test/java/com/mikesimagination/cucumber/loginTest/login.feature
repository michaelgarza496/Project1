Feature: A user can login sucessfully or fail

Background: User navigates to Initek's website

	Given I am on initek's website
	
Scenario: User gives credentials

	When I enter username as "peter.livingston@initech.com" and I enter password as "peter"
	Then Login should pass