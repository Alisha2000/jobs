@ulta
Feature: search functionality
  Scenario: user launches application
    Given user is on ulta web page
    When user searches for Mascara
    Then verify that Mascara is displayed in search message

