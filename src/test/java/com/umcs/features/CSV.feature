Feature: CSV File Reader
  CSV File Reader is able to parse different kinds of files

  Scenario Outline: Parse company sales data from CSV file
    Given a CSV file named <filename> with <numRecords> records
    When I parse the file contents
    Then total of <numRecords> records have been loaded
    Examples:
      | filename                | numRecords |
      | companyTestData.txt     | 0          |
      | companyTestData.txt     | 5          |
      | companyTestData.txt     | 100        |
      | fileThatDoesntExist.txt | 0          |


  Scenario Outline: Parse company sales data from files with different delimiters
    Given a CSV file named <filename> with 5 records
    When the data is separated by <c>
    And I parse the file contents
    Then data is being loaded from file
    Examples:
      | filename  | c  |
      | data.csv  | ,  |
      | data.tsv  | \t |
      | data.scsv | ;  |
      | data.dsv  | .  |

  Scenario: Parses when data is doubled
    Given a CSV file named fileWithDoubledData.txt with 6 records
    When I parse the file contents
    Then only the first appearing price is taken into account

  Scenario: Parses when data is out of order
    Given a CSV file named fileWithDataOutOfOrder.txt with 6 records
    When I parse the file contents
    Then only the first appearing price is taken into account

  Scenario: Parses when prices are written in comma notation
    Given a CSV file named fileWithPricesSeparatedByComma.txt with 6 records
    When I parse the file contents
    Then data is being loaded from file

  Scenario: Parses when prices are written in dot notation
    Given a CSV file named fileWithPricesSeparatedByDot.txt with 6 records
    When I parse the file contents
    Then data is being loaded from file

  Scenario: Parses when prices are separeted by spaces
    Given a CSV file named fileWithPricesSeparatedBySpacesOnThousands.txt with 6 records
    When I parse the file contents
    Then data is being loaded from file

  Scenario: Parses when some prices are missing only one time
    Given a CSV file named fileWithMissingPricesOnce.txt with 100 records
    When I parse the file contents
    Then data is being loaded from file
      And prices are calculated using average price from previous and next day

  Scenario: Parses when prices are missing multiple times
    Given a CSV file named fileWithPricesMissingALot.txt with 100 records
    When I parse the file contents
    Then data is being loaded from file
      And prices are calculated using last known price

  Scenario: Company stopped being noted on exchange
    Given a CSV file named fileWithPricesMissingALot.txt with 100 records
    When I parse the file contents
      And data is being loaded from file
      And I create the summary for year
    Then report says that company was not noted on exchange after some time

