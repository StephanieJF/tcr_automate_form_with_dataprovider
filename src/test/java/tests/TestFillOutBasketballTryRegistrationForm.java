package tests;

import org.testng.annotations.*;
import base.BaseTest;
import pom.dataObjects.PlayerInfo;
import pom.pages.RegistrationFormPage;
import pom.utils.JacksonUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFillOutBasketballTryRegistrationForm extends BaseTest {

  @Test(dataProvider = "basketball_tryouts_registration")
    public void testFillOutBasketballTryoutsForm(PlayerInfo playerInfo) throws IOException {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
        registrationFormPage.setPlayerInfo(playerInfo);
    }

    @DataProvider(name = "basketball_tryouts_registration")
    public PlayerInfo[] load_test_data() throws IOException {
        // set up the data provider
            return JacksonUtils.deserializeJson("PlayerData.json", PlayerInfo[].class);
    }

    @DataProvider(name = "basketball_tryouts_registration_from_csv_file")
    public Iterator<Object []> provider( ) throws IOException {
        // create a csv file with 5 rows
        // feed csv data into data provider
        List<Object []> testCases = new ArrayList<>();
        String[] data= null;
        String csvFile = "resources/tcr_form_data_provider.csv";
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
