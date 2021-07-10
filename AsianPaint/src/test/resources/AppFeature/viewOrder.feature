#Author: bathula.naga-raju@capgemini.com
Feature: Cancle order in Asianpaint Application

  Scenario: Cancle order
    Given customer is on MyProfile page
    When click on My Order
    And click on the vieworder
    Then customer see the order details
    When click on the close to close the order details 
    
