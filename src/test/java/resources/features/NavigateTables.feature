Feature: Navigate Tables

  Scenario: User views the book table
    Given the user is on the webpage
    When the user sees the table of books
    Then the table should have a header with "Title", "Author", and "Price"
    Then the table should display the following books with the correct information:
      | Title          | Author | Subject  | Price |
      | Learn Selenium | Amit   | Selenium |   300 |
      | Learn Java     | Mukesh | Java     |   500 |
      | Master In Java | Amod   | JAVA     |  2000 |

  Scenario: User goes through the paginated table
    Given the user is on the webpage
    When the user sees the paginated table
    And the user selects all items with a price higher than "price"
    Then a "amount" amount of items should be selected.
