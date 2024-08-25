Feature: Filling in fields

  Scenario: Reading from homepage
    Given the user is on the form page
    Then the page url should equal the url in config.properties
    Then the page title should equal the title in config.properties

  Scenario: User inputs a name in the "name" field
    Given the user is on the form page
    When the user enters "John Doe" into the "name" field
    Then the "name" field should display "John Doe"

  Scenario: User inputs an email in the "email" field
    Given the user is on the form page
    When the user enters "johndoe@example.com" into the "email" field
    Then the "email" field should display "johndoe@example.com"

  Scenario: User inputs a phone number in the "phone" field
    Given the user is on the form page
    When the user enters "+1234567890" into the "phone" field
    Then the "phone" field should display "+1234567890"
