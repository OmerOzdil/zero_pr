Feature: Navigating to specific accounts in Account Activity

  Scenario: Saving account redirect
    Given The user logged in with "username" "password"
    Then The user click on savings
    And The page should the title "Zero - Account Activity"
    And Account drop down should have "Savings" selected

  Scenario: Brokerage account redirect
    Given The user logged in with "username" "password"
    When the user clicks on "Brokerage" link on the Account Summary Page
    Then The page should the title "Zero - Account Activity"
    And Account drop down should have "Brokerage" selected


  Scenario: Checking account redirect
    Given The user logged in with "username" "password"
    When the user clicks on "Checking" link on the Account Summary Page
    Then The page should the title "Zero - Account Activity"
    And Account drop down should have "Checking" selected

  Scenario: Credit Card account redirect
    Given The user logged in with "username" "password"
    When the user clicks on "Credit Card" link on the Account Summary Page
    Then The page should the title "Zero - Account Activity"
    And Account drop down should have "Credit Card" selected

  Scenario: Loan Account redirect
    Given The user logged in with "username" "password"
    When the user clicks on "Loan" link on the Account Summary Page
    Then The page should the title "Zero - Account Activity"
    And Account drop down should have "Loan" selected

    
      