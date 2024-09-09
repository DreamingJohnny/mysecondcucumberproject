@skip
Feature: Filling in fields

  Scenario: Reading from homepage
    Given the user is on the form page
    Then the page url should equal the url in config.properties
    And the page title should equal the title in config.properties

  Scenario: User inputs a name in the name field
    Given the user is on the form page
    When the user enters "John Doe" into the "name" field
    Then the "name" field should display "John Doe"

  Scenario: User inputs an email in the email field
    Given the user is on the form page
    When the user enters "johndoe@example.com" into the "email" field
    Then the "email" field should display "johndoe@example.com"

  Scenario: User inputs a phone number in the phone field
    Given the user is on the form page
    When the user enters "+1234567890" into the "phone" field
    Then the "phone" field should display "+1234567890"

  Scenario: User sees gender option
    Given the user is on the form page
    Then neither "male" nor "female" option should be selected

  Scenario: User selects male gender option
    Given the user is on the form page
    When the user selects the "male" option
    Then the "male" option should be selected
    And the "female" option should not be selected

  Scenario: User selects female gender option
    Given the user is on the form page
    When the user selects the "female" option
    Then the "female" option should be selected
    And the "male" option should not be selected

  Scenario: User sees the weekday options
    Given the user is on the form page
    Then none of the weekdays should be selected

  Scenario: User selects one weekday option
    Given the user is on the form page
    When the user selects the following weekdays:
      | monday |
    Then none of the weekdays except for the following should be selected
      | monday |

  Scenario: User selects several weekday options
    Given the user is on the form page
    When the user also selects the following weekdays:
      | monday  |
      | tuesday |
      | sunday  |
    Then none of the weekdays except for the following should be selected
      | monday  |
      | tuesday |
      | sunday  |

  Scenario: The user selects and deselects weekday options
    Given the user is on the form page
    When the user also selects the following weekdays:
      | monday  |
      | tuesday |
      | sunday  |
    And the user deselects the following weekdays:
      | monday  |
      | tuesday |
      | sunday  |
    Then none of the weekdays should be selected
