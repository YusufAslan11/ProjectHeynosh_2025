@Filter
Feature:User assert the filtering
  Background: Login
    Given User clicks on Login button
    Then User enters "e-mail" address for login
    Then User clicks on Continue button
    Then User enters "password" for login
    And User clicks on Continue button

  @Themes
  Scenario:User assert the filtering
    Given User clicks New on HeyNosh filter
    Then User clicks BBQ month
    Then User clicks Free parking
    And User closed the page

  @Cuisines
  Scenario:User assert the filtering
    Given User clicks All you can eat
    Given User clicks Fastfood
    And User closed the page

