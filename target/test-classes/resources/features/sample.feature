Feature: Sample feature

  Scenario: User logs into the application
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the home page