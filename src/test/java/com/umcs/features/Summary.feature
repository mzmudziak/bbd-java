Feature: Summary feature
  Summary is generated based on given data

  Scenario Outline: Generate summary for months
    Given a list of sale entries
    When I create the summary for month <month>
    Then the summary only contains data for month <month>
    Examples:
      | month    |
      | January  |
      | February |
      | March    |
      | April    |
      | May      |

  Scenario Outline: Summary has correct fields
    Given a list of sale entries
    When I create the summary for month January
    Then the summary has <type> record
    Examples:
      | type    |
      | AVERAGE |
      | HIGH    |
      | LOW     |

  Scenario: Generate a yearly summary
    Given a list of sale entries
    When I create the summary for year
    Then the summary only contains data for year

  Scenario: Monthly summary has top 3 company entries
    Given a list of sale entries
    When I create the summary for month January
    Then the summary top 3 company entries

  Scenario: Monthly summary has top 3 company entries sorted
    Given a list of sale entries
    When I create the summary for month January
    Then the summary top 3 company entries
      And the top list is sorted DESC


