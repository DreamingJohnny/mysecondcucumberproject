Feature: Interact with other WebElements

  Scenario: Use searchbar and navigate to new tab
    Given the user is on the correct page
    And the user sees the container for "tabs container"
    And the user enters "Sweden" into the searchbar
    And the user clicks on the "tabs submit" button
    And the user selects the "4" result in the "tabs search results"
    And the user switches to the tab with index "1"
    Then the url of the new active window is "https://en.wikipedia.org/wiki/Sweden_during_World_War_II"

  Scenario: Click to open new tab
    Given the user is on the correct page
    And the user sees the container for "new browser window container"
    And the user clicks on the "new browser window button" button
    And the user switches to the tab with index "1"
    Then the url of the new active window is "https://demo.opencart.com/"

  Scenario: Close pop-up window
    Given the user is on the correct page
    And the user sees the container for "JS alerts container"
    When the user clicks on the "dismiss alert" button
    And the pop-up window opens
    And the user dismisses the window
    Then the pop-up window has disappeared

  Scenario: Confirm pop-up window
    Given the user is on the correct page
    And the user sees the container for "JS alerts container"
    When the user clicks on the "confirm alert" button
    And the pop-up window opens
    And the user accepts the window
    Then the pop-up window has disappeared

  Scenario: Fill in pop-up window
    Given the user is on the correct page
    And the user sees the container for "JS alerts container"
    When the user clicks on the "prompt alert" button
    And the pop-up window opens
    And the user fills in the field with "John Doe" and confirms
    Then the pop-up window has disappeared
