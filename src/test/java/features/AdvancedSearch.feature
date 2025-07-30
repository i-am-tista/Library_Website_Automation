@Automation
Feature: Advanced Search Functionality

  @Fail
  Scenario: Submit form without selecting age group
    Given the user is on the Advanced Search page
    When the user enters author name as "Philip Roth" and subject as "fiction"
    And selects edition as "Edition 2"
    And selects book format as "NewsPaper"
    And the user does not select any age group
    Then an error message for age group should be displayed

  @Fail
  Scenario: Submit form without selecting book format
    Given the user is on the Advanced Search page
    When the user enters author name as "Philip Roth" and subject as "fiction"
    And selects edition as "Edition 2"
    And selects age group as "Adult"
    Then an error message for book format should be displayed

  @Pass
  Scenario: Validate author name with valid input
    Given the user is on the Advanced Search page
    When the user enters author name as "Philip Roth" and subject as "fiction"
    And selects edition as "Edition 3"
    And selects book format as "E_Books"
    And selects age group as "Adult"
    Then books related to author should be listed

  @Pass
  Scenario: Submit form without entering author name
    Given the user is on the Advanced Search page
    When the user leaves author name blank
    And enters subject as "fiction"
    And selects edition as "Edition 2"
    And selects book format as "NewsPaper"
    And selects age group as "Teen"
    Then an error message for author name should be displayed

  @Pass
  Scenario: Submit form without entering subject
    Given the user is on the Advanced Search page
    When the user enters author name as "Philip Roth" and leaves subject blank
    And selects edition as "Edition 2"
    And selects book format as "NewsPaper"
    And selects age group as "Adult"
    Then an error message for subject should be displayed

  @Pass
  Scenario: Submit form with space in author name
    Given the user is on the Advanced Search page
    When the user enters author name as " " and subject as "fiction"
    And selects edition as "Edition 1"
    And selects book format as "E_Books"
    And selects age group as "Adult"
    Then an error message for author name should be displayed

  @Pass
  Scenario: Submit form with space in subject
    Given the user is on the Advanced Search page
    When the user enters author name as "Philip Roth" and subject as " "
    And selects edition as "Edition 2"
    And selects book format as "NewsPaper"
    And selects age group as "Teen"
    Then an error message for subject should be displayed
