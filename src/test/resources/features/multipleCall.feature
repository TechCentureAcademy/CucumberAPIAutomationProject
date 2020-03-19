@multipleCalls
Feature: different calls

  Scenario Outline: my calls
    Given new Base URL
    And add headers
      |X-Auth-Token                     |
      |e1dd3e70277f4d0395066cbf78dd83ab |
    And method name is "get" and "<resourcePath>"
    Then I see 200 ok response

    Examples: 
      |resourcePath          |
      |/v2/competitions/2000 |
      |/v2/matches           |
      |/v2/areas/            |
