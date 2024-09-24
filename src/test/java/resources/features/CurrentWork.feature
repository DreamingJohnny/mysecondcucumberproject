Feature: Current Work

  Scenario Outline: Inputting date of birth
    Given the user is on the correct page
    And the user sees the container for "practice form"
    And the user switches to "practice form"
    And the user inputs "<date of birth>" into the "DOB field"
    Then the "DOB field" should contain "<expected date>" according to "<expected outcome>"

    Examples:
      | date of birth | expected date | expected outcome |
      |    10/09/1981 |    10/09/1981 | pass             |
      |    12/22/1986 |    12/22/1986 | pass             |
      |    1000902026 |    10/09/2026 | fail             |
      | johndoe       | johndoe       | fail             |
      |   02/29/19900 |    02/29/1990 | pass             |
      | p1a2r1i9n9g1  |      1/2/1991 | pass             |
