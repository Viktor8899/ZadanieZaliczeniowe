Feature: tests that checking purchase section

  Scenario: add new address
    Given an open browser with 'https://mystore-testlab.coderslab.pl'
    And user logged into account with EliaszWalczak@armyspy.com and 12345
    And user has returned to the home page
    And choose hummingbird printed sweater from popular products section
    And user chose size M of the sweater
    And user chose quantity of sweater equal to 5
    And user added sweater to cart
    And user clicked button proceed to checkout on popup
    And user clicked second button proceed to checkout on shopping cart page
    And user clicked continue button on addresses page
    And user chose 'pick up in store' option
    And user clicked 'continue' button on shipping method
    And user picked payment option 'Pay by Check'
    And user clicked checkbox with 'terms of service'
    When user clicked 'place order' button
    Then order is confirmed
    And screenshot has been taken
    And close the browser