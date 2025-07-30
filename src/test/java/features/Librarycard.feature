@Automation
Feature: Library Card Form Validations

  @Fail
  Scenario: US02-TC02 Verify 10-Digit Phone Number Restriction
    Given the user is on the Library Card page of the main site
    When the user enters "12345" in the phone number field and submits
    Then an error message for an invalid phone number should be shown

  @Pass
  Scenario: US03-TC03 Validate Renewal Option Flow
    Given the user is on the Library Card page of the main site
    When the user selects the 'Renewal' action and submits the form
    Then the result table should show the renewal message

  @Fail
  Scenario: US06-TC06 Validate Numeric-only Age Field
    Given the user is on the Library Card page of the main site
    When the user enters "abc" in the age field and submits
    Then an error message for an invalid age format should be shown

  @Fail
  Scenario: US09-TC09 Submit Valid Library Card Form (Buggy)
    Given the user is on the Library Card page of the main site
    When the user fills the library card form with valid data and submits
    Then the data should be saved and displayed correctly in the result table

  @Pass
  Scenario: US10-TC10 Email Format Validation on Library Card Form
    Given the user is on the Library Card page of the main site
    When the user enters an invalid email "abc.com" and submits
    Then an error message for invalid email format should be displayed
