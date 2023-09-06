package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static WebDriver driver;
    protected static BasePage basePage;
    private static final String baseURL = "https://www.techcoachingwithralph.com/basketball-tryouts-registration-form/";

    @BeforeClass
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @AfterMethod
    public static void cleanUp() {
        driver.quit();
    }

}
