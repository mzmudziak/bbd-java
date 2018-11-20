Feature: Login Feature
  Verify is program is able to parse CSV file

  Scenario Outline: Load a CSV file
    Given current month is <month>
    When i get the next month
    And is numer 1 five
    Then the current month is <nextMonth>
    Examples:
      | month | nextMonth | number |
      | 12    | 1         | 1      |
      | 1     | 2         | 2      |
      | 2     | 3         | 3      |
      | -1    | 1         | 5      |


