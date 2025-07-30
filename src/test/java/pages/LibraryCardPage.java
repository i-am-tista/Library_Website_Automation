package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LibraryCardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By libraryCardTab = By.id("library-card-tab");
    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By ageInput = By.id("age");
    private By emailInput = By.id("email");
    private By phoneInput = By.id("phone");
    private By schoolNameInput = By.id("schoolname");
    private By actionApplyRadio = By.id("action_apply");
    private By actionRenewalRadio = By.id("action_renewal");
    private By submitButton = By.id("submit");
    private By resultTable = By.id("result");
    private By firstNameLabel = By.xpath("//label[@for='firstname']");

    public LibraryCardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToPage() {
        wait.until(ExpectedConditions.elementToBeClickable(libraryCardTab)).click();
    }

    public void enterPhoneAndSubmit(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(submitButton).click();
    }

    public void selectRenewalAndSubmit() {
        driver.findElement(actionRenewalRadio).click();
        driver.findElement(submitButton).click();
    }

    public void enterAgeAndSubmit(String age) {
        driver.findElement(ageInput).sendKeys(age);
        driver.findElement(submitButton).click();
    }

    public void enterInvalidEmailAndSubmit(String email) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(submitButton).click();
    }

    public void fillFormWithValidData() {
        driver.findElement(firstNameInput).sendKeys("John");
        driver.findElement(lastNameInput).sendKeys("Doe");
        driver.findElement(ageInput).sendKeys("25");
        driver.findElement(emailInput).sendKeys("john.doe@example.com");
        driver.findElement(phoneInput).sendKeys("1234567890");
        driver.findElement(schoolNameInput).sendKeys("Test University");
        driver.findElement(actionApplyRadio).click();
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean isErrorMessageDisplayedFor(String fieldId) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId + "Error")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getResultText() {
        return driver.findElement(resultTable).getText();
    }

    public boolean isMandatoryIndicatorVisible() {
        return driver.findElement(firstNameLabel).getText().contains("*");
    }
}
