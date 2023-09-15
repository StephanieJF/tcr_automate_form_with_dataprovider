package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public Properties config = new Properties();
    @BeforeSuite
    void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseURL"));
    }

    @AfterMethod
    void cleanUp() {
        driver.quit();
    }

}
