package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import resources.properties.DriverManager;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    @BeforeSuite
    public void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new DriverManager().initializeDriver();
        driver.get("https://www.techcoachingwithralph.com/basketball-tryouts-registration-form/");
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

}
