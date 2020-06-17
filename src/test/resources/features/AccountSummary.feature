Feature: Account Summary Page

  Scenario: the title check
    Given The user is on the login page
    When The user logged in with "username" "password"
    Then The page should the title "Zero - Account Summary"

  Scenario: the account summary page
    Given The user is on the login page
    When The user logged in with "username" "password"
    Then the page should contains the followings

    |Cash Accounts      |
    |Investment Accounts|
    |Credit Accounts    |
    |Loan Accounts      |

    Scenario: Credit Account Table
      Given The user is on the login page
      When The user logged in with "username" "password"
      Then The user must see the following coloums

      |Account    |
      |Credit Card|
      |Balance    |

    Scenario: Account Activity Page
      Given The user is on the login page
      When The user logged in with "username" "password"
      And The user navigates to "Account Activity"
      Then The page should the title "Zero - Account Activity"
  
    Scenario: The default Dropdown
      Given The user is on the login page
      When The user logged in with "username" "password"
      And The user navigates to "Account Activity"
      Then The user should the default option as "Savings"

    Scenario: Options of the dropdown
      Given The user is on the login page
      When The user logged in with "username" "password"
      And The user navigates to "Account Activity"
      Then the dropdown has to contains following options
      |Savings    |
      |Checking   |
      |Loan       |
      |Credit Card|
      |Brokerage  |
    Scenario: Account Activity coloums` name
      Given The user is on the login page
      When The user logged in with "username" "password"
      And The user navigates to "Account Activity"
      Then The transaction table coloums mus have the followings

      |Date       |
      |Description|
      |Deposit    |
      |Withdrawal |