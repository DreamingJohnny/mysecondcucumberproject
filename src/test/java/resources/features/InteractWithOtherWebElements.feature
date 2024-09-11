Feature: Interact with other WebElements

  Scenario: Use searchbar and navigate to new tab
    Given the user is on the correct page
    And the user sees the container for "tabs container"
    And the user enters "Sweden" into the searchbar
    And the user clicks on the "tabs submit" button
    And the user selects the "4" result in the "tabs search results"
    And the user navigates to the new tab
    Then the url of the new window is "https://en.wikipedia.org/wiki/Sweden_during_World_War_II"

  Scenario: Close pop-up window
    Given the user sees the container for "JS alerts"
    When the user clicks on the "alert" button
    And the pop-up window opens
    Then the user clicks on the button in the window to dismiss it
