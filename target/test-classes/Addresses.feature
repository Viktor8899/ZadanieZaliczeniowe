Feature: tests that checking addresses section

  Scenario Outline: add new addresses for logged user
    Given an open browser with 'https://mystore-testlab.coderslab.pl'
    And user logged into account with EliaszWalczak@armyspy.com and 12345
    And user clicked a button called ADDRESSES
    When user added new address: <alias>, <address>, <city>, <zipCode>, <phone>
    Then message about successful add address
    And close the browser

    Examples:
      | alias  | address   | city    | zipCode | phone     |
      | User01 | Address01 | Glasgow | 000123A | 510511512 |
      | User02 | Testowa01 | Warsaw  | 1312321 | 510000000 |