Feature: Testing Employee table 

  @employeeDB
  Scenario: Getting employee information based on query
    Given I am connecting to DB
    And getting result based on the query "SELECT last_name, first_name FROM employees WHERE country='USA';"