Feature: Login feature

  Scenario: Login with valid credentials
    Given the user is on login screen
    When user enters valid credentials
          |Tester|test|
    And user clicks login button
    Then user should be on weborders page
    When user clicks logout link
    Then user should be logged out
    And user closes browser