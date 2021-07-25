Feature: Login feature

  Scenario: Login with valid credentials
    Given the user is on login screen
    When user enters valid username
    And user enters valid password
    And user clicks login button
    Then user should be on weborders page
    When user clicks logout link
    Then user should be logged out
    And user closes browser

  Scenario: Login with valid credentials
    Given the user is on login screen
    When user enters invalid username
    And user enters valid password
    And user clicks login button
    Then user should be on weborders page
    And user closes browser

#Author: bathula.naga-raju@capgemini.com
Feature: Signout The Application

  Scenario: Signout the Application
    Given the customer is on login screen
    When customer enters valid phon number
    And customer enter the OTP
    And customer clicks login button
    Then customer should be on Home page
    When customer click on the profile icon
    And customer click on the signout
    Then customer should be  signout the application