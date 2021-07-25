Feature: web

  Scenario Outline: Login with valid credintials
    Given the user is on login screen
    When user enters valid usernam
    And user enters valid passwor
    And user clicks login button
    Then user should be on weborders page
    When user clicks on Order link
    And user select the product type
    And user enter the quantity as "<quantity>"
    And user enter the price as  "<price>"
    And user enter the discount as "<discount>"
    And user  calculate total amount
    And user enter castomer name "<name>"
    And user enter street name
    And user enter city name "<city>"
    And user enter zip code "<zip>"
    And user select card type
    And user enter card no "<cardno>"
    And user enter expiry date "<expiry>"
    And user click on process
    When user click on view all order
    Then user can see his data
    When user clicks logout link
    Then user should be logged out
    And user closes browser

    Examples: 
      | quantity | price | discount | name  |  city    | zip    | cardno     | expiry |
      |        5 |   200 |       10 | Argha |  kolkata | 700056 | 4578995112 | 02/24  |
