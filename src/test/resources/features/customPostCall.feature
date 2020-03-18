@customPostCall
Feature: call custom service

Scenario: call custom service with a post method
    Given base URL "https://reqbin.com"
    When I send my custom post method
    Then I receive good response and success message
    
