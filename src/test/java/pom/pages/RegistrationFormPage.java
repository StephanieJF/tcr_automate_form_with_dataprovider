package pom.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.dataObjects.PlayerInfo;


public class RegistrationFormPage extends BasePage {

    private final By firstNameFld = By.cssSelector("input[name='wpforms[fields][0][first]']");
    private final By lastNameFld = By.cssSelector("input[name='wpforms[fields][0][last]']");
    private final By dateOfBirthFld = By.cssSelector("input[name='wpforms[fields][17]']");
    private final By playerGradeLevel = By.cssSelector("input[name='wpforms[fields][4]']");
    private final By numberOfSeasonsPlayed = By.cssSelector("input[name='wpforms[fields][5]']");
    private final By parentsFirstNameFld = By.cssSelector("input[name='wpforms[fields][12][first]']");
    private final By parentsLastNameFld = By.cssSelector("input[name='wpforms[fields][12][last]']");
    private final By parentsEmailAddressFld = By.cssSelector("input[name='wpforms[fields][1]']");
    private final By parentsPhoneNumberFld = By.cssSelector("input[name='wpforms[fields][18]']");
    private final By consentCheckBx = By.cssSelector("input[name='wpforms[fields][15][]']");

    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationFormPage enterFirstName(String firstName) {
       driver.findElement(firstNameFld).sendKeys(firstName);
       return this;
    }

    public RegistrationFormPage enterLastName(String lastName){
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public RegistrationFormPage enterDateOfBirth(String dateOfBirth){
        driver.findElement(dateOfBirthFld).sendKeys(dateOfBirth);
        return this;
    }

    public RegistrationFormPage enterPlayerGradeLevel(String gradeLevel){
        driver.findElement(playerGradeLevel).sendKeys(gradeLevel);
        return this;
    }

    public RegistrationFormPage enterNumSeasonsPlayed(String numSeasonsPlayed){
        driver.findElement(numberOfSeasonsPlayed).sendKeys(numSeasonsPlayed);
        return this;
    }

    public RegistrationFormPage selectPositionsPlayed(String positionsPlayed){
        driver.findElement(By.cssSelector("input[name='wpforms[fields][7][]'][value='"+ positionsPlayed + "']")).click();
        return this;
    }

    public RegistrationFormPage selectPositionsTryingOutFor(String positionsTryingOutFor){
        driver.findElement(By.cssSelector("input[name='wpforms[fields][16][]'][value='"+ positionsTryingOutFor + "']")).click();
        return this;
    }

    public RegistrationFormPage enterParentsFirstName(String parentsFirstName){
        driver.findElement(parentsFirstNameFld).sendKeys(parentsFirstName);
        return this;
    }

    public RegistrationFormPage enterParentsLastName(String parentsLastName){
        driver.findElement(parentsLastNameFld).sendKeys(parentsLastName);
        return this;
    }

    public RegistrationFormPage enterParentsEmailAddress(String parentsEmailAddress){
        driver.findElement(parentsEmailAddressFld).sendKeys(parentsEmailAddress);
        return this;
    }

    public RegistrationFormPage enterParentsPhoneNumber(String parentsPhoneNumber){
        driver.findElement(parentsPhoneNumberFld).sendKeys(parentsPhoneNumber);
        return this;
    }

    public void setPlayerInfo(PlayerInfo playerInfo){
        enterFirstName(playerInfo.getFirstName()).enterLastName(playerInfo.getLastName()).enterDateOfBirth(playerInfo.getDateOfBirth()).
                enterPlayerGradeLevel(playerInfo.getPlayerGradeLevel()).enterNumSeasonsPlayed(playerInfo.getNumberOfSeasonsPlayed()).
                selectPositionsPlayed(playerInfo.getPositionsPlayed()).selectPositionsTryingOutFor(playerInfo.getPositionsTryingOutFor()).
                enterParentsFirstName(playerInfo.getParentsFirstName()).enterParentsLastName(playerInfo.getParentsLastName()).
                enterParentsEmailAddress(playerInfo.getParentsEmailAddress()).enterParentsPhoneNumber(playerInfo.getParentsPhoneNumber()).
                clickGiveConsent(playerInfo.getConsentGiven());
    }

    public RegistrationFormPage clickGiveConsent(String giveConsent){
        if(giveConsent == "Yes" ){
            driver.findElement(consentCheckBx).click();
        }
        return this;
    }
}
