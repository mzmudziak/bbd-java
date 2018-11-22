Feature: Exchange downlaoder
  Exchange records are being downlaoded from internet

  Scenario: Records are downloaded once per day
    Given a timeframe of 5 days
    When downloader is running every day
    Then downlaoder has been invoked 5 times
