Feature: Filling in fields

Scenario: Filling in the name field
  Given I am on the form page
  When I enter "John Doe" in the "Name" field
  Then the "Name" field should contain "John Doe"

Scenario: Filling in the email field
  Given I am on the form page
  When I enter "john.doe@example.com" in the "Email" field
  Then the "Email" field should contain "john.doe@example.com"

Scenario: Selecting a gender option
  Given I am on the form page
  When I select "Male" from the "Gender" options
  Then the "Gender" field should have "Male" selected
