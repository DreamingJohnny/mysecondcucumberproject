Feature: Interact with other WebElements

  Scenario: Use searchbar and navigate to new tab
    Given the user is on the form page
    And the user sees the container for "tabs container"
    When the user navigates to the searchbar
    And the user enters "Sweden" into the searchbar
    And the user clicks on the "tabs submit" button
    And the user selects the "3" result
    And the user navigates to the new tab
    Then the url of the new window is "https://en.wikipedia.org/wiki/Sweden_during_World_War_II"

  Scenario: Close pop-up window
    Given the user sees the container for "JS alerts"
    When the user clicks on the "alert" button
    And the pop-up window opens
    Then the user clicks on the button in the window to dismiss it

  Scenario: Confirm pop-up window
    Given the user sees the container for "JS alerts"
    When the user clicks on the "confirm box" button
    And the pop-up window opens
    And the user clicks on the "confirm button" in the pop-up window
    Then the pop-up window has disappeared

  Scenario: Fill in pop-up window
    Given the user sees the container for "JS alerts"
    When the user clicks on the "prompt" button
    And the pop-up window opens
    And the pop-up window has a input field
    Then the user fills in the field with "John Doe" and confirms

  Scenario: Double click on button to copy field
    Given the user sees the container for "double click"
    When the user inputs "generic greeting" to "field1"
    And the user double clicks on the "copy text" button.
    Then "field2" and "field1" should contain the same data

  Scenario: Drag and drop
    Given the user sees the container for "drag and drop"
    Then the user moves the draggable object into the target object

  Scenario: Move slider
    Given the user sees the "slider"
    When the user uses the cursor to move the slider to a new position
    Then the slider is in the new position

  Scenario: Fill in frame
    Given the user sees the container for "frames"
    And the user switches to "frames"
    And the user enters "John Doe" into the "frames name" field
    Then the "frames name" field should contain "John Doe"

  Scenario: Select from dropdown
    Given the user sees the container for "frames"
    And the user switches to "frames"
    And the user selects "QA Engineer" from the "job drop down"
    Then the "job drop down" contains "QA Engineer"

  Scenario Outline: Inputting date of birth
    Given the user sees the container for "frames"
    And the user switches to "frames"
    And the user inputs "<date of birth>"
    Then the "DOBfield" should contain "<expected date>" according to "<expected outcome>"

    Examples:
      | date of birth   | expected date | expected outcome |
      |      09/10/1981 |    10/09/1981 | pass             |
      |      12/22/1986 |    12/22/1986 | pass             |
      |        10092026 |    10/09/1981 | pass             |
      | johndoe         | johndoe       | fail             |
      |     02/29/19900 |    02/29/1990 | pass             |
      | p0a2r2s9i1n9g90 |    02/29/1990 | pass             |

  Scenario Outline: Selecting date of birth
    Given the user sees the container for "frames"
    And the user switches to "frames"
    And the user clicks on the calendar icon
    And the user selects "<year>", "<month>" and "<day>"
    Then the "DOBfield" should contain "<expected date>" according to "<expected outcome>"

    Examples:
      | month | day | year | expected date | expected outcome |
      |    10 |  09 | 1981 |    10/09/1981 | pass             |
      |    12 |  22 | 1986 |    12/22/1986 | pass             |
      |    01 |  01 | 2025 |    01/01/2025 | pass             |
      |    13 |  01 | 1990 |    13/01/1990 | fail             |
      |    02 |  29 | 1990 |    02/29/1990 | fail             |

  Scenario: Change size of area
    Given the user sees the container for "changing size"
    Then the user uses the cursor to change the size of the object
