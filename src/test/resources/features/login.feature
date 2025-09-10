@login
Feature: Login page automation test

  @loginPositive @smoke1
  Scenario: Login page automation test

    Given User clicks on Login button
    Then User enters "email" address for login
    Then User enters "password" for login
    Then User clicks on Log in button
    Then User clicks on account button
    Then User confirms that the username is correct
    Then User closed the page




  @loginNegative @smoke1
  Scenario Outline: Login Page Negative Test
    Given User clicks on Login button
    And User enters "<username_N>" and clicks on Continue button_User
    And User enters "<password_N>" and clicks on Continue button_Pass
    Then User clicks on Log in button
    Then User verifies that the user cannot log in
    Then User closed the page

    Examples:
      | username_N           | password_N |
      | ttyusuf18q@gmail.com | As1456     |
      | denemex@gmail.com    | As1456     |
      | ttyusuf18@gmail.com  | 123456     |