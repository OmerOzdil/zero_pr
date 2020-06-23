Feature: Find Transactions in Account Activity

  @wip
  Scenario: Search date Range
    Given The user logged in with "username" "password"
    When The user navigates to "Account Activity"
    Then the user click on "Find Transactions" tab
    And the user enters date range from "1" to "2" and click search

  Scenario: Search description
    Given The user logged in with "username" "password"
    When The user navigates to "Account Activity"
    Then the user click on "Find Transactions" tab
    When the user enters description "ONLINE"
    And the user clicks search
    Then the result table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And the user clicks search
    Then the result table should only show descriptions containing "OFFICE"
    But the result table should not show descriptions containing "ONLINE"

  Scenario: Search description case insensitive
    Given The user logged in with "username" "password"
    When The user navigates to "Account Activity"
    Then the user click on "Find Transactions" tab
    When the user enters description "ONLINE"
    And the user clicks search
    Then the result table should only show descriptions containing "ONLINE"
      


    