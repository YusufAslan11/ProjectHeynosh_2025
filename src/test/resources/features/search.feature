@search
Feature: User should be able to search  the restaurants and foods

  @searchRestaurant
  Scenario Outline: User should be able to search a restaurant
    Given User clicks on Login button
    Then User enters "email" address for login
    Then User enters "password" for login
    Then User clicks on Log in button
    Given User find a "<restaurant>"
    Then User confirms that they found the "<restaurant>"
    And User closed the page
    Examples:
      | restaurant        |
      | Bariloche         |
      | Casa Italiana     |
      | Annapurna Kitchen |
      | Sohbet            |
      | Mewsim            |

  @searchFood
  Scenario Outline: User should be able to search a restaurant
    Given User clicks on Login button
    Then User enters "email" address for login
    Then User enters "password" for login
    Then User clicks on Log in button
    Given User find a food "<food>"
    Then User confirms that they found the  food"<food>"
    And User closed the page
    Examples:
      | food      |
      | Breakfast |
      | Dinner    |
      | Pizza     |
      | Soup      |
