Feature: Navigate Tables

  Scenario: User views the book table
    Given the user is on the webpage
    When the user sees the table "bookTable"
    Then the table "bookTable" should have a header with "BookName", "Author", "Subject" and "Price"
    Then the table "bookTable" should display the following books with the correct information:
      | Learn Selenium | Amit   | Selenium |  300 |
      | Learn Java     | Mukesh | Java     |  500 |
      | Master In Java | Amod   | JAVA     | 2000 |

  Scenario: User goes through the paginated table
    Given the user is on the webpage
    When the user sees the table "paginatedTable"
    Then the first page is selected
    Then the user can switch between pages of the table

  Scenario: User selects items on each of the pages
    Given the user is on the webpage
    When the user sees the table "paginatedTable"
    When the user selects items costing less than "<price>" on page "<page>".
    Then the "<expectedAmount>" of items should be selected according to "<expectedOutcome>"
      | price | page | expectedAmount | expectedOutcome |
      |  8.20 |    1 |              2 | pass            |
      | 26.00 |    3 |              4 | pass            |
      |   17. |    4 |              3 | fail            |