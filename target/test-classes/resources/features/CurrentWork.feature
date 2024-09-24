Feature: Current Work

Scenario Outline: Selecting date of birth
    Given the user is on the correct page
    And the user sees the container for "frames"
    And the user switches to "frames"
    When the user clicks on the calendar icon the dropdown opens 
    And the user selects "<year>", "<month>" and "<day> from the dropdown"
    Then the "DOBfield" should contain "<expected date>" according to "<expected outcome>"

    Examples:
      | month | day | year | expected date | expected outcome |
      |    10 |  09 | 1981 |    10/09/1981 | pass             |
      |    12 |  22 | 1986 |    12/22/1986 | pass             |
      |    01 |  01 | 2025 |    01/01/2025 | pass             |
      |    13 |  01 | 1990 |    13/01/1990 | fail             |
      |    02 |  29 | 1990 |    02/29/1990 | fail             |