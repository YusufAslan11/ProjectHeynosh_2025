@guest
Feature: Continue as guest

  @guestReservation
  Scenario Outline: Continue as guest

    Given User clicks Continue as guest
    Then User find a "<restaurant>"
    Then User choice the restaurant
    Then User tries make reservation
    And The user sees that he could not book
    Then User closed the page
    Examples:
      | restaurant |
      | Pizzadam   |

  @guestSearch
  Scenario: Continue as guest

    Given User clicks Continue as guest
    Then User find a "<restaurant>"
    Then User sear
    Then User tries make reservation
    And The user sees that he could not book
    Then User closed the page


