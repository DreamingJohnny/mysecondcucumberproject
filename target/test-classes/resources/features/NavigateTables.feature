Feature: Navigate Tables

  Scenario: User views the book table
    Given the user is on the webpage
    When the user sees the table "book table"
    Then the book table should have a header with "BookName", "Author", "Subject" and "Price"

  Scenario Outline: User reads the book table
    Given the user is on the webpage
    Then the book table should display the following books with the correct information:

    Examples:
      | BookName       | Author | Subject  | Price |
      | Learn Selenium | Amit   | Selenium |   300 |
      | Learn Java     | Mukesh | Java     |   500 |
      | Master In Java | Amod   | JAVA     |  2000 |

  Scenario: User goes through the paginated table
    Given the user is on the webpage
    When the user sees the table "paginated table"
    Then the first page is selected
    And the user can switch between pages of the table

  Scenario Outline: User selects items on each of the pages
    Given the user is on the webpage
    When the user sees the paginated table
    And the user selects items costing less than "<price>" on page "<page>".
    Then the "<expectedAmount>" of items should be selected according to "<expectedOutcome>"

    Examples:
      | price | page | expectedAmount | expectedOutcome |
      |  8.20 |    1 |              2 | pass            |
      | 26.00 |    3 |              4 | pass            |
      | 17.00 |    4 |              3 | fail            |
