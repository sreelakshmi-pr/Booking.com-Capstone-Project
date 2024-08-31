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

