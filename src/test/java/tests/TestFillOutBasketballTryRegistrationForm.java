package tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import pom.BaseTest;
import pom.pages.RegistrationFormPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFillOutBasketballTryRegistrationForm extends BaseTest {

    @Test(dataProvider = "basketball_tryouts_registration")
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

        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);

        registrationFormPage.goTo();

        // automate the form
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        registrationFormPage.enterFirstName(firstName).
                enterLastName(lastName).
                enterDateOfBirth(dateOfBirth).
                enterPlayerGradeLevel(playerGradeLevel).
                enterNumSeasonsPlayed(numberOfSeasonsPlayed).
                selectPositionsPlayed(positionsPlayed).
                selectPositionsTryingOutFor(positionsTryingOutFor).
                enterParentsFirstName(parentsFirstName).
                enterParentsLastName(parentsLastName).
                enterParentsEmailAddress(parentsEmailAddress).
                enterParentsPhoneNumber(parentsPhoneNumber).
                clickGiveConsent(giveConsent);
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
