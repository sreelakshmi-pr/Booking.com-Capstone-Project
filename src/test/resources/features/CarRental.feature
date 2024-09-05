Feature: Verify functionalities of car rental booking

  Background:
    Given user opens application
    Then verify user is on home screen

  Scenario: Search cars with return to same location
    When user clicks on car rental
    And user enters pick up location "Paris"
    And user select pickup date "14 September 2024" and dropOff date "15 September 2024"
    And user select pickup up time "11:00 AM" and drop off time "1:30 PM"
    Then user clicks on search of car rental
    And verify user is on cars displayed page

  Scenario: Search cars with return to different location
    When user clicks on car rental
    And user enters pick up location "Paris"
    And clicks on return to same location
    And user enters drop off location "Lyon"
    And user select pickup date "14 September 2024" and dropOff date "15 September 2024"
    Then user clicks on search of car rental
    And verify user is on cars displayed page


  Scenario: verify alert is displayed when click on car search button without entering pickup location
    When user clicks on car rental
    And user clicks on search button of car page
    Then verify alert is displayed on car Page

    Scenario: verify drop off location is displayed when we off return to same location button
      When user clicks on car rental
      And clicks on return to same location
      Then verify drop off location textbox is displayed


  Scenario: Verify book rental Car without protection
    When user clicks on car rental
    And user enters pick up location "Paris"
    And user select pickup date "14 September 2024" and dropOff date "15 September 2024"
    And user clicks on search of car rental
    Then verify user is on cars displayed page
    When user clicks on first car
    Then verify user is on car details page
    When user click on next step
    Then verify user is on protection option page
    When clicks on book without protection
    Then verify user is on booking summary page
    When user clicks on next step
    Then verify user is on driver details page
    When user fills the driver details
    And user clicks on next step
    Then verify user is on payment page

  Scenario: verify book rental Car with protection
    When user clicks on car rental
    And user enters pick up location "Paris"
    And user select pickup date "14 September 2024" and dropOff date "15 September 2024"
    And user clicks on search of car rental
    Then verify user is on cars displayed page
    When user clicks on first car
    Then verify user is on car details page
    When user click on next step
    Then verify user is on protection option page
    When clicks on book with protection
    Then verify user is on booking summary page
    And verify protection amount is added to total rental price

