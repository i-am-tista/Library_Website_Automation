package stepDefinitions;

import pages.LibraryCardPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LibraryCardSteps {
    private LibraryCardPage libraryCardPage;

    @Given("the user is on the Library Card page of the main site")
    public void the_user_is_on_the_library_card_page() {
        libraryCardPage = new LibraryCardPage(Hooks.driver);
        Hooks.driver.get("https://webapps.tekstac.com/SeleniumApp2/Library/Library.html");
        libraryCardPage.navigateToPage();
    }

    @When("the user enters {string} in the phone number field and submits")
    public void the_user_enters_in_the_phone_number_field(String phone) {
        libraryCardPage.enterPhoneAndSubmit(phone);
    }

    @Then("an error message for an invalid phone number should be shown")
    public void an_error_message_for_an_invalid_phone_number_should_be_shown() {
        Assert.assertTrue(libraryCardPage.isErrorMessageDisplayedFor("phone"), "TC02-FAIL: Phone error message not shown.");
    }

    @When("the user selects the 'Renewal' action and submits the form")
    public void the_user_selects_the_renewal_action_and_submits() {
        libraryCardPage.selectRenewalAndSubmit();
    }

    @Then("the result table should show the renewal message")
    public void the_result_table_should_show_the_renewal_message() {
        Assert.assertTrue(libraryCardPage.getResultText().contains("Re-form is ready for renewal"), "TC03-PASS: Renewal message not found.");
    }

    @When("the user fills the library card form with valid data and submits")
    public void the_user_fills_the_library_card_form_with_valid_data_and_submits() {
        libraryCardPage.fillFormWithValidData();
        libraryCardPage.submitForm();
    }

    @When("the user enters {string} in the age field and submits")
    public void the_user_enters_in_the_age_field(String age) {
        libraryCardPage.enterAgeAndSubmit(age);
    }

    @Then("an error message for an invalid age format should be shown")
    public void an_error_message_for_an_invalid_age_format_should_be_shown() {
        Assert.assertTrue(libraryCardPage.isErrorMessageDisplayedFor("age"), "TC06-FAIL: Age error message not shown.");
    }

    @Then("the data should be saved and displayed correctly in the result table")
    public void the_data_should_be_saved_and_displayed_correctly() {
        Assert.assertTrue(libraryCardPage.getResultText().contains("John"), "TC09-FAIL: Data not displayed in table after valid submission.");
    }

    @When("the user enters an invalid email {string} and submits")
    public void the_user_enters_an_invalid_email(String email) {
        libraryCardPage.enterInvalidEmailAndSubmit(email);
    }

    @Then("an error message for invalid email format should be displayed")
    public void an_error_message_for_invalid_email_format_should_be_displayed() {
        Assert.assertTrue(libraryCardPage.isErrorMessageDisplayedFor("email"), "TC10-PASS: Email error message not shown.");
    }
}
