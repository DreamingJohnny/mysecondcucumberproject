Feature: Navigate Tables

  Scenario: User views the book table
    Given the user is on the webpage
    When the user sees the table "book table"
    Then the book table should have a header with "BookName", "Author", "Subject" and "Price"
 
   Scenario: User goes through the paginated table
    Given the user is on the webpage
    When the user sees the table "paginated table"
    Then the first page is selected
    And the user can switch between pages of the table