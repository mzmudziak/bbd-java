Feature: Login Feature
  Verify is program is able to parse CSV file

  Scenario: Load a CSV file
    Given a file with CSV values
    When we parse the file
    Then an array with values is returned
