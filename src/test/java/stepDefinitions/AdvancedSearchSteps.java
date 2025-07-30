package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.AdvancedSearchPage;

public class AdvancedSearchSteps {
    WebDriver driver = Hooks.driver;
    AdvancedSearchPage searchPage;

    @Given("the user is on the Advanced Search page")
    public void user_on_advanced_search_page() {
        driver.get("https://webapps.tekstac.com/SeleniumApp2/Library/advancedSearch.html");
        searchPage = new AdvancedSearchPage(driver);
    }

    @When("the user enters author name as {string} and subject as {string}")
    public void user_enters_author_and_subject(String author, String subject) {
        searchPage.setAuthorName(author);
        searchPage.setSubject(subject);
    }

    @When("selects edition as {string}")
    public void user_selects_edition(String edition) {
        searchPage.selectEdition(edition);
    }

    @When("selects book format as {string}")
    public void user_selects_book_format(String format) {
        searchPage.selectBookFormat(format);
    }

    @When("selects age group as {string}")
    public void user_selects_age_group(String group) {
        searchPage.selectAgeGroup(group);
    }

    @Then("books related to author should be listed")
    public void books_related_to_author_should_be_listed() {
        searchPage.submit();
        Assert.assertTrue(searchPage.getPageSource().contains("List of Books"), "Book list table not found.");
    }

    @When("the user leaves author name blank")
    public void user_leaves_author_name_blank() {
        searchPage.setAuthorName("");
    }

    @When("enters subject as {string}")
    public void enters_subject(String subject) {
        searchPage.setSubject(subject);
    }

    @When("the user enters author name as {string} and leaves subject blank")
    public void user_enters_author_and_leaves_subject_blank(String author) {
        searchPage.setAuthorName(author);
        searchPage.setSubject("");
    }

    @When("the user does not select any age group")
    public void user_does_not_select_age_group() {
        searchPage.submit();
    }

    @When("the user does not select any book format")
    public void user_does_not_select_book_format() {
        searchPage.submit();
    }

    @Then("an error message for author name should be displayed")
    public void error_for_author() {
        searchPage.submit();
        Assert.assertTrue(searchPage.getPageSource().contains("Please Enter the Author Name"));
    }

    @Then("an error message for subject should be displayed")
    public void error_for_subject() {
        searchPage.submit();
        Assert.assertTrue(searchPage.getPageSource().contains("Please Enter the Subject"));
    }

    @Then("an error message for book format should be displayed")
    public void error_for_book_format() {
        searchPage.submit();
        Assert.assertTrue(searchPage.getPageSource().contains("Please Select Format"));
    }

    @Then("an error message for age group should be displayed")
    public void error_for_age_group() {
        Assert.assertTrue(searchPage.getPageSource().contains("Please Select AgeGroup"));
    }
}
