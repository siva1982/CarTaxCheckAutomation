Feature: Selenium Cucumber Java Example

  Scenario: Validate Car Tax details
    Given I have vehicle registration numbers
    When I check each registration number on cartaxcheck.com
    Then I can verify tax details with expected values