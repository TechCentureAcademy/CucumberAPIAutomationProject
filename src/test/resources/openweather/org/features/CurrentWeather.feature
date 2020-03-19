Feature: Current Weather functionality (API)

  @Positive
  Scenario: Get request for Current Weather API - positive
    When User is sending "GET" request to the "/data/2.5/weather" end-point
      | city | London |
    Then User is verifying that status code is 200
    And User is verifying following data
      | name        | London                  |
      | description | light intensity drizzle |
      | latitude    |                   51.51 |
      | longtitude  |                   -0.13 |
