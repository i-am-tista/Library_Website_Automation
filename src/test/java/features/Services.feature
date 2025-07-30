@Automation
Feature: Services - Ask a Librarian

  @Pass
  Scenario: US01-TC01 Verify Pre-filled 'To' Field in Email
    Given the user navigates to the "Email" service option
    Then the 'To' email field should be pre-filled with the librarian's address

  @Fail
  Scenario: US13-TC13 Display of Librarian Contact Details for Call Option
    Given the user navigates to the "Call" service option
    Then the librarian's contact number and available hours should be displayed

  @Pass
  Scenario: US14-TC14 Submit Query via Email Form
    Given the user navigates to the "Email" service option
    When the user fills the email form with from "test@example.com" and query "Book status" and submits
    Then a success message for the email query should be displayed

  @Pass
  Scenario: US15-TC15 Submit Chat Form Successfully
    Given the user navigates to the "Chat" service option
    When the user fills the chat form with name "John", phone "1234567890", and query "Help" and submits
    Then a success message for the chat submission should be displayed
