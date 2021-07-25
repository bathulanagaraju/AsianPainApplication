Feature: Products in Web Orders Application

  Scenario: Counting number of products available
    Given user is on weborders page
    When user clicks on View all Products link
    And user counts number of products available
    Then user displays no of products
