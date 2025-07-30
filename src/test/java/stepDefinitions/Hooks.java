package stepDefinitions;

import org.openqa.selenium.WebDriver;
import driver.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverSetup.createWebDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
