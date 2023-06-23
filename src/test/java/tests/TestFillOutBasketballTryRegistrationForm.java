package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFillOutBasketballTryRegistrationForm {
    // set up the driver including the webdriver manager
    WebDriver driver;
    String BASKETBALL_TRYOUTS_REGISTRATION_FORM = "https://www.techcoachingwithralph.com/basketball-tryouts-registration-form/";

    @BeforeClass
    static public void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    void cleanUp() {
        driver.quit();
    }

    @Test(dataProvider = "basketball_tryouts_registration_from_csv_file")
    void testFillOutBasketballTryoutsForm(
            String firstName,
            String lastName,
            String dateOfBirth,
            String playerGradeLevel,
            String numberOfSeasonsPlayed,
            String positionsPlayed,
            String positionsTryingOutFor,
            String parentsFirstName,
            String parentsLastName,
            String parentsEmailAddress,
            String parentsPhoneNumber,
            String giveConsent
    ) {
        // go to the form in the browser
        driver.get(BASKETBALL_TRYOUTS_REGISTRATION_FORM);

        // automate the form
        // first name
        System.out.println("First Name: " + firstName);
        driver.findElement(By.cssSelector("input[name='wpforms[fields][0][first]']")).sendKeys(firstName);
        // last name
        System.out.println("Last Name: " + lastName);
        driver.findElement(By.cssSelector("input[name='wpforms[fields][0][last]']")).sendKeys(lastName);
        // date of birth
        driver.findElement(By.cssSelector("input[name='wpforms[fields][17]']")).sendKeys(dateOfBirth);
        // grade level
        driver.findElement(By.cssSelector("input[name='wpforms[fields][4]']")).sendKeys(playerGradeLevel);
        // number of seasons played
        driver.findElement(By.cssSelector("input[name='wpforms[fields][5]']")).sendKeys(numberOfSeasonsPlayed);
        // positions played (checkboxes)
        driver.findElement(By.cssSelector("input[name='wpforms[fields][7][]'][value='"+ positionsPlayed + "']")).click();
        // positions trying out form (checkboxes)
        driver.findElement(By.cssSelector("input[name='wpforms[fields][16][]'][value='"+ positionsTryingOutFor + "']")).click();
        // parent first name
        driver.findElement(By.cssSelector("input[name='wpforms[fields][12][first]']")).sendKeys(parentsFirstName);
        // parent last name
        driver.findElement(By.cssSelector("input[name='wpforms[fields][12][last]']")).sendKeys(parentsLastName);
        // parent email address
        driver.findElement(By.cssSelector("input[name='wpforms[fields][1]']")).sendKeys(parentsEmailAddress);
        // parent phone number
        driver.findElement(By.cssSelector("input[name='wpforms[fields][18]']")).sendKeys(parentsPhoneNumber);
        // permission checkbox
        if (giveConsent == "Yes") {
            driver.findElement(By.cssSelector("input[name='wpforms[fields][15][]']")).click();
        }


        // run the test
    }



    // first set it up with one test to see it run with the data provider

    @DataProvider(name = "basketball_tryouts_registration")
    public Object[][] load_test_data() {
        // set up the data provider
        return new Object[][] {
                { "Cedric", "The Entertainer", "01/01/2009", "8th", "3", "Point Guard", "Small Forward", "Sue-Ellen", "Smith", "sue-ellen.smith@gmail.com", "305-777-6859", "Yes"},
                { "Steve", "Harvey", "03/11/2013", "5th", "3", "Point Guard", "Small Forward", "Sue-Ellen", "Smith", "sue-ellen.smith@gmail.com", "305-777-6859", "Yes"},
        };
    }

    @DataProvider(name = "basketball_tryouts_registration_from_csv_file")
    public Iterator<Object []> provider( ) throws IOException {
        // create a csv file with 5 rows
        // feed csv data into data provider
        List<Object []> testCases = new ArrayList<>();
        String[] data= null;
        String csvFile = "testdata/tcr_form_data_provider.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        //this loop is pseudocode
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data = line.split(cvsSplitBy);
            testCases.add(data);
        }

        return testCases.iterator();
    }




}
