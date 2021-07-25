Feature: Login with data tables

  Scenario: using data tables approach 2
    Given the user navigates to login screen
    When user enters credentials
      | Tester | test   |
      | admin | 12345   |
      | Tester12 | test123   |
      And user hits login button
    Then user sees his account
