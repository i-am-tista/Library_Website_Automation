package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ServicesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By servicesTab = By.linkText("Services");
    private By emailOption = By.id("medium_email");
    private By callOption = By.id("medium_call");
    private By chatOption = By.id("medium_chat");
    private By toEmailField = By.id("toEmail");
    private By callInfoContainer = By.id("call-info-container");
    private By fromEmailInput = By.id("fromEmail");
    private By queryEmailInput = By.id("queryemail");
    private By submitQueryButton = By.id("QuerySubmit");
    private By emailSuccessMessage = By.id("mediummailoutput");
    private By chatNameInput = By.id("chatname");
    private By chatPhoneInput = By.id("yourphone");
    private By chatQueryInput = By.id("querychat");
    private By chatSuccessMessage = By.id("mediumchatoutput");

    public ServicesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToHomePage() {
        driver.get("https://webapps.tekstac.com/SeleniumApp2/Library/Library.html");
    }

    public void navigateToOption(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(servicesTab)).click();

        switch (option.toLowerCase()) {
            case "email":
                driver.findElement(emailOption).click();
                break;
            case "call":
                driver.findElement(callOption).click();
                break;
            case "chat":
                driver.findElement(chatOption).click();
                break;
        }
    }

    public String getToEmailFieldValue() {
        return driver.findElement(toEmailField).getAttribute("value");
    }

    public boolean isContactInfoDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(callInfoContainer));
            String text = driver.findElement(callInfoContainer).getText();
            return text.contains("10 AM – 3 PM");
        } catch (Exception e) {
            return false;
        }
    }

    public void fillAndSubmitEmailForm(String from, String query) {
        driver.findElement(fromEmailInput).sendKeys(from);
        driver.findElement(queryEmailInput).sendKeys(query);
        driver.findElement(submitQueryButton).click();
    }

    public void fillAndSubmitChatForm(String name, String phone, String query) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatNameInput));
        driver.findElement(chatNameInput).sendKeys(name);
        driver.findElement(chatPhoneInput).sendKeys(phone);
        driver.findElement(chatQueryInput).sendKeys(query);
        driver.findElement(submitQueryButton).click();
    }

    public boolean isEmailSuccessMessageVisible() {
        return driver.findElement(emailSuccessMessage).isDisplayed();
    }

    public boolean isChatSuccessMessageVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(chatSuccessMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
