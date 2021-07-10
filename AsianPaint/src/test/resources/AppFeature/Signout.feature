#Author: bathula.naga-raju@capgemini.com
Feature: Signout The Application

  Scenario: Signout the Application
    Given customer is on Login  Asianpaint Application
    When customer click on the profile icon
    And customer click on the signout
    Then customer should be  signout the application
