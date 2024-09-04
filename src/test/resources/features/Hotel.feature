Feature: Verify functionalities of stays booking

  Background:
    Given user opens application
    Then verify user is on home screen

  Scenario: Search hotel
    When user enters location "Bangalore"
    And user select checkIn date "14 September 2024" and checkOut date "15 September 2024"
    And select number of rooms "2" and adults "4"
    Then user clicks on search
    And verify user is on hotels displayed page

  Scenario: verify alert is displayed when click on hotel search button without entering destination
      When user clicks on search button
      Then verify alert is displayed


  Scenario: verify hotel is added to wishlist
        When user enters location "Bangalore"
        And user clicks select date
        Then user clicks on search
        When first hotel added to wishlist
        And go to wishlist
        Then verify user is on hotels is added to wishlist

  Scenario: Book hotel
    When user enters location "Bangalore"
    And user clicks select date
    When user clicks on search
    Then verify user is on hotels displayed page
    When user clicks first hotel
    Then verify user is on hotel details page
    When user clicks on see availability button
    Then verify user is on reservation page
    When user select and customise the hotel
    And user clicks on reserve button
    Then verify user is on fill information page
    When fill the information
    And user clicks on next step
    Then Verify user is on booking overview page

  Scenario: verify price sorting
    When user enters location "Bangalore"
    And user clicks select date
    When user clicks on search
    And user clicks on sort
    And user select price low to high sorting
    Then verify price is in ascending order

    Scenario: verify the filter option free cancellation of hotel
      When user enters location "Bangalore"
      And user clicks select date
      When user clicks on search
      And user clicks on filter
      And user select free cancellation
      Then verify the displayed hotels have the option of free cancellation




