package stepDefinitions;

import pages.ServicesPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ServicesSteps {
    private ServicesPage servicesPage;

    @Given("the user navigates to the {string} service option")
    public void the_user_navigates_to_the_service_option(String option) {
        servicesPage = new ServicesPage(Hooks.driver);
        servicesPage.navigateToHomePage();
        servicesPage.navigateToOption(option);
    }

    @Then("the 'To' email field should be pre-filled with the librarian's address")
    public void the_to_email_field_should_be_pre_filled() {
        Assert.assertFalse(servicesPage.getToEmailFieldValue().isEmpty(), "TC01-PASS: 'To' email field is not pre-filled.");
    }

    @Then("the librarian's contact number and available hours should be displayed")
    public void the_librarian_s_contact_details_should_be_displayed() {
        Assert.assertTrue(servicesPage.isContactInfoDisplayed(), "TC13-FAIL: Librarian contact info not displayed for 'Call' option.");
    }

    @When("the user fills the email form with from {string} and query {string} and submits")
    public void the_user_fills_the_email_form(String from, String query) {
        servicesPage.fillAndSubmitEmailForm(from, query);
    }

    @Then("a success message for the email query should be displayed")
    public void a_success_message_for_the_email_query_should_be_displayed() {
        Assert.assertTrue(servicesPage.isEmailSuccessMessageVisible(), "TC14-PASS: Email success message not visible.");
    }

    @When("the user fills the chat form with name {string}, phone {string}, and query {string} and submits")
    public void the_user_fills_the_chat_form(String name, String phone, String query) {
        servicesPage.fillAndSubmitChatForm(name, phone, query);
    }

    @Then("a success message for the chat submission should be displayed")
    public void a_success_message_for_the_chat_submission_should_be_displayed() {
        Assert.assertTrue(servicesPage.isChatSuccessMessageVisible(), "TC15-PASS: Chat success message not visible.");
    }
}
