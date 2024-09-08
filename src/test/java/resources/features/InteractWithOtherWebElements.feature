@skip
Feature: Interact with other WebElements

  Scenario: Use searchbar and navigate to new tab
    Given the user is on the form page
    And the user sees the container for "tabs"
    When the user navigates to the searchbar
    And the user enters "Sweden" into the searchbar
    And the user selects the "3" result
    And the user navigates to the new tab
    Then the url of the new window should be "https://en.wikipedia.org/wiki/Sweden_during_World_War_II"

  Scenario: Close pop-up window
    Given the user sees the container for "JS alerts"
    And the user clicks on the "alert" button
    And the pop-up window opens.
    Then the user clicks on the button in the window to dismiss it

  Scenario: Confirm pop-up window
    Given the user sees the container for "JS alerts"
    And the user clicks on the "confirm box" button
    And the pop-up window opens
    Then the user clicks on the "confirm button" in the window to confirm it.

  Scenario: Fill in pop-up window
    Given the user sees the container for "JS alerts"
    And the user clicks on the "prompt" button.
    And the pop-up window opens.
    Then the user fills in the field with "John Doe" and confirms.

  Scenario: Double click on button to copy field
    Given the user sees the container for "double click"
    And the user inputs "generic greeting" to "field1"
    And the user double clicks on copy text.
    Then "field2" and "field1" should contain the same data

  Scenario: Drag and drop

  Scenario: Move slider

  Scenario: Fill in frame

  Scenario: Select date of birth

  Scenario: Change size of area
