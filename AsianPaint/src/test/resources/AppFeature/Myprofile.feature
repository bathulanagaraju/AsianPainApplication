#Author: bathula.naga-raju@capgemini.com
Feature: MyProfile in Asianpaint Application

  Scenario: see the personal information
    Given customer should be on Home page
    When customer click on the profile icon
    And click on My profile
    Then customer  should be on My Profile page
