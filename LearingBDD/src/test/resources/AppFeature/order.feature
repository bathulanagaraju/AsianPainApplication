Feature: oreder

  Scenario: Login with valid credintials
    Given the user is on login screen
    When user enters valid usernam
    And user enters valid passwor
    And user clicks login button
    Then user should be on weborders page
    When user clicks on Order link
    And user select the product type
    And user enters the quantity ,priceas and discount 
    |quantity|price|discount|
    |2       |200  |  10    |
    |7|400|5|
    And user  calculate total amount
    
    
     