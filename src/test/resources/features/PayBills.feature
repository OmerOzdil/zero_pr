Feature: Pay Bills module

  Scenario: the page title
    Given The user is on the login page
    When The user logged in with "username" "password"
    And The user navigates to "Pay Bills"
    Then The page should the title "Zero - Pay Bills"


    Scenario: the completed payment message shown
    Given The user is on the login page
    When The user logged in with "username" "password"
    And The user navigates to "Pay Bills"
    And The user enter amount, put a date,press the pay button and "The payment was successfully submitted."

  Scenario: the fill out message appeared
    Given The user is on the login page
    When The user logged in with "username" "password"
    And The user navigates to "Pay Bills"
    Then The message "Please fill in this field" pop up