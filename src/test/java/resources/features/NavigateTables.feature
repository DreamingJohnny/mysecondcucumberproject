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
    When the user sees the paginated table
    Then the first page is selected
    And the user selects all items with a price higher than "4.50"
    Then a "amount" amount of items should be selected.
