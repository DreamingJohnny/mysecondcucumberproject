Feature: Current Work

  Scenario: Fill in frame
    Given the user is on the correct page
    And the user sees the container for "practice form"
    When the user switches to "practice form"
    And the user enters "John Doe" into the "frames name" field in the iframe
    Then the "frames name" field in the iframe should contain "John Doe"

  Scenario: Select from dropdown
    Given the user is on the correct page
    And the user sees the container for "practice form"
    When the user switches to "practice form"
    And the user selects "QA Engineer" from the "frame work dropdown"
    Then the "frame work dropdown" contains "QA Engineer"
