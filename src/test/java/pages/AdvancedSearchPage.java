package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchPage {
    WebDriver driver;

    By authorName = By.id("authorName");
    By subject = By.id("subject");
    By edition = By.id("edition");
    By bookFormat = By.id("format");
    By teenRadio = By.id("ageGroup_teen");
    By adultRadio = By.id("ageGroup_adult");
    By submitBtn = By.id("searchSubmit");

    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setAuthorName(String name) {
        driver.findElement(authorName).clear();
        driver.findElement(authorName).sendKeys(name);
    }

    public void setSubject(String sub) {
        driver.findElement(subject).clear();
        driver.findElement(subject).sendKeys(sub);
    }

    public void selectEdition(String ed) {
        new Select(driver.findElement(edition)).selectByVisibleText(ed);
    }

    public void selectBookFormat(String format) {
        new Select(driver.findElement(bookFormat)).selectByVisibleText(format);
    }

    public void selectAgeGroup(String group) {
        if (group.equalsIgnoreCase("Teen")) {
            driver.findElement(teenRadio).click();
        } else if (group.equalsIgnoreCase("Adult")) {
            driver.findElement(adultRadio).click();
        }
    }

    public void submit() {
        driver.findElement(submitBtn).click();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}
