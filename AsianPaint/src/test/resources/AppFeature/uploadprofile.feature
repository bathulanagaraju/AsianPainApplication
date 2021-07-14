#Author: bathula.naga-raju@capgemini.com
Feature: Upload the Profile Picter in Asianpaint Application

  Scenario: Upload the Profile Picter
    Given customer should be on MyProfile page
    When custome click on the Upload and send the image
    Then customer is  able to upload the profile picter
