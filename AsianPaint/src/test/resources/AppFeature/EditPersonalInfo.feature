#Author: bathula.naga-raju@capgemini.com
Feature: Edit the Personal information in Asianpaint Application

  Scenario Outline: Edit the personal information with valid credentials
    Given customer is on MyProfile page
    When custome click on the Edit
    And Remove the existing firstname and Enter the valid firstname  as "<FirstName>"
    And Remove the existing lastname and Enter the valid lastname as "<LastName>"
    And Select the valid DatOfBirth
    And Remove the existing Mobile number and Enter the valid MobileNumber as "<MobileNumber>"
    And click on the Update
    Then close the browser

    Examples: 
      | FirstName | LastName | MobileNumber |
      | Naga1     | Raju2    |   9063771132 |

  Scenario Outline: Edit the Mobile Number  with invalid credentials
    Given customer is on MyProfile page
    When custome click on the Edit
    And Remove the existing Mobile Number and Enter the invalid MobileNumber as "<MobileNumber>"
    Then See the Error message

    Examples: 
      | MobileNumber |
      | asncdfergg   |
      |       993788 |
