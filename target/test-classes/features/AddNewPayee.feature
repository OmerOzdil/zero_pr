Feature: Add new Payee under Pay Bills
  
  Scenario: Add a new payee
    Given The user logged in with "username" "password"
    When The user navigates to "Pay Bills"
    Then the user clicks on "Add New Payee" subTab
    And the user creates new payee using the following informations

    |Payee Name   |The Law Offices of Hyde,Price&Scharks|
    |Payee Address|100 Same st,Anytown,USA, 10001       |
    |Account      |Checking                             |
    |Payee details|XYZ Account                          |

    Then message "The new payee The Law Offices of Hyde,Price&Scharks was successfully created." should be displayed

  Scenario: 
    Given The user logged in with "username" "password"
    When The user navigates to "Pay Bills"
    And the user clicks on "Purchase Foreign Currency" subTab
    Then the following currencies should available
    |Australia (dollar)|
    |Canada (dollar) |
    |Switzerland (franc)|
    |China (yuan)|
    |Denmark (krone)|
    |Eurozone (euro)|
    |Great Britain (pound)|
    |Japan (yen)          |
    |Mexico (peso)        |
    |Norway (krone)       |
    |New Zealand (dollar)  |
    |Singapore (dollar)     |

  Scenario: Error message for not entering value
    Given The user logged in with "username" "password"
    When The user navigates to "Pay Bills"
    And the user clicks on "Purchase Foreign Currency" subTab
    And the user clicks on the calculate button without entering any value
    Then the error message "Please, ensure that you have filled all the required fields with valid values." should be displayed

  Scenario: Error message for not entering currency
    Given The user logged in with "username" "password"
    When The user navigates to "Pay Bills"
    And the user clicks on "Purchase Foreign Currency" subTab
    And the user clicks on the calculate button without entering any value
    Then the error message "Please, ensure that you have filled all the required fields with valid values." should be displayed



