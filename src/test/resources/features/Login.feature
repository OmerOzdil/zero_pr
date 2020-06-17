
Feature: Login in page

  Scenario: Login with credentials
    Given The user is on the login page
    When  The user logged in with "username" "password"
    Then  The user should be able to ne in the "Account Summary" page



  Scenario: Login with wrong username or password
    Given The user is on the login page
    When  The user logged in with "something" "Password"
    Then  The user should see the message "Login and/or password are wrong."







