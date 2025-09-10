@favorite
Feature:User adds to favorites
  Background: Login
    Given User clicks on Login button
    Then User enters "e-mail" address for login
    Then User enters "password" for login
    Then User clicks on Log in button

  @favorites_add
  Scenario: User adds to favorites
    Given User searches for the "restaurant"
    Then User enters to restaurant
    Then User clicks on favorites icon
    Then User confirms to add to favorites
    And User closed the page

  @favorites
  Scenario Outline: User should be able to search a restaurant
    Given User clicks on Login button
    Then User enters "e-mail" address for login
    Then User enters "password" for login
    Then User clicks on Log in button
    Given User find a "<restaurant>"
    Then User select the restaurant
    Then User clicks on favorites icon
    Then User confirms to add to favorites
    And User closed the page


    Examples:
      | restaurant        |
      | Bariloche         |
