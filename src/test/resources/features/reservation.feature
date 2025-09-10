@reservation
Feature: Reservation page automation test

  @reservation_Make @smoke
  Scenario Outline: Reservation page automation test

    Given User clicks on Login button
    Then User enters "email" address for login
    Then User enters "password" for login
    Then User clicks on Log in button
    And User searches for "<restaurant>"
    And User clicks on the restaurant
    Then User sees the booking information
    Then User confirms the booking information
    Then User confirms the booking
    And User closed the page
    Examples:
      | restaurant |
      | Sollomon   |

  @reservation_Update
  Scenario:User should be able to update the reservation
    Given User clicks on Login button
    Then User enters "e-mail" address for login
    Then User enters "password" for login
    Then User clicks on Log in button
    Given User clicks on the Reservation button
    And User clicks on the booking information for Update
    And User click on the Update reservation
    And User selects time for reservation for update
    And User verifies the update
    And User closed the page

  @reservation_Cancel @smoke
  Scenario:User should be able to cancel the reservation
    Given User clicks on Login button
    Then User enters "e-mail" address for login
    Then User enters "password" for login
    And User clicks on Continue button
    Given User clicks on the Reservation button
    And User clicks on the booking information
    Then User clicks on the Cancel reservation
    Then User verifies the canceled reservation
    And User closed the page



