#Author: bathula.naga-raju@capgemini.com
Feature: Signout The Application

  Scenario: Signout the Application
    Given user is on Login  Asianpaint Application
    When user click on  profile icon
    And user click on the signout
    Then user should be  signout the application
