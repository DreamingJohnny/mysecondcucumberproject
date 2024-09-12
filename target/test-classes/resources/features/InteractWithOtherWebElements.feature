Feature: Interact with other WebElements

  Scenario: Use searchbar and navigate to new tab
    Given the user is on the correct page
    And the user sees the container for "tabs container"
    And the user enters "Sweden" into the searchbar
    And the user clicks on the "tabs submit" button
    And the user selects the "4" result in the "tabs search results"
    And the user switches to the tab with index "1"
    Then the url of the new active window is "https://en.wikipedia.org/wiki/Sweden_during_World_War_II"
