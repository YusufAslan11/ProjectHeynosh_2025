@register
Feature: Register page automation test

  @registerP @smoke
  Scenario: Register page automation test

    Given User clicks on signUp for free button
    Then User enters full name
    Then User enters e-mail address
    Then User enters password
    Then User clicks on Continue button
    Then User clicks Agree and Continue button
    Then User clicks skip button
    Then User allows to the location
    Then User clicks While Using the app button
    Then User clicks on account button
    Then User clicks on Show Profile
    Then User closed the page


  @registerNegative @smoke
  Scenario Outline: Register page automation test negative scenario
    Given User clicks on signUp for free button
    Then User enters "<fullName>" as full name
    Then User enters "<email>" as email address
    Then User enters "<password>" as password
    Then User clicks on Continue button
    Then User should not be able to register with incorrect data
    Then User closed the page
    Examples:
      | fullName    | email            | password |
      |             | as1456@gmail.com | 123456   |
      | Yusuf Aslan | as1456@gmail     | 123456   |
      | Yusuf Aslan | as1456gmail.com  | 123456   |
      | Yusuf Aslan | as1456@gmailcom  | 123456   |
      | Yusuf Aslan |                  | 123456   |
      | Yusuf Aslan | as1456@gmail.com |          |
      | Yusuf Aslan | as1456@gmail.com | 12345    |
















