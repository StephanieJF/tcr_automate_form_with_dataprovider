package pom.dataObjects;

import pom.utils.JacksonUtils;

import java.io.IOException;

public class PlayerInfo {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String playerGradeLevel;
    private String numberOfSeasonsPlayed;
    private String positionsPlayed;
    private String positionsTryingOutFor;
    private String parentsFirstName;
    private String parentsLastName;
    private String parentsEmailAddress;
    private String parentsPhoneNumber;
    private String consentGiven;

    public PlayerInfo(){}

    public PlayerInfo(String firstName, String lastName, String dateOfBirth,
           String playerGradeLevel, String numberOfSeasonsPlayed, String positionsPlayed, String positionsTryingOutFor,
           String parentsFirstName, String parentsLastName, String parentsEmailAddress, String parentsPhoneNumber, String consentGiven) throws IOException {
        PlayerInfo[] player = JacksonUtils.deserializeJson("PlayerData.json", PlayerInfo[].class);
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.playerGradeLevel=playerGradeLevel;
        this.numberOfSeasonsPlayed=numberOfSeasonsPlayed;
        this.positionsPlayed=positionsPlayed;
        this.positionsTryingOutFor=positionsTryingOutFor;
        this.parentsFirstName=parentsFirstName;
        this.parentsLastName=parentsLastName;
        this.parentsEmailAddress=parentsEmailAddress;
        this.parentsPhoneNumber=parentsPhoneNumber;
        this.consentGiven=consentGiven;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlayerGradeLevel() {
        return playerGradeLevel;
    }

    public void setPlayerGradeLevel(String playerGradeLevel) {
        this.playerGradeLevel = playerGradeLevel;
    }

    public String getNumberOfSeasonsPlayed() {
        return numberOfSeasonsPlayed;
    }

    public void setNumberOfSeasonsPlayed(String numberOfSeasonsPlayed) {
        this.numberOfSeasonsPlayed = numberOfSeasonsPlayed;
    }

    public String getPositionsPlayed() {
        return positionsPlayed;
    }

    public void setPositionsPlayed(String positionsPlayed) {
        this.positionsPlayed = positionsPlayed;
    }

    public String getPositionsTryingOutFor() {
        return positionsTryingOutFor;
    }

    public void setPositionsTryingOutFor(String positionsTryingOutFor) {
        this.positionsTryingOutFor = positionsTryingOutFor;
    }

    public String getParentsFirstName() {
        return parentsFirstName;
    }

    public void setParentsFirstName(String parentsFirstName) {
        this.parentsFirstName = parentsFirstName;
    }

    public String getParentsLastName() {
        return parentsLastName;
    }

    public void setParentsLastName(String parentsLastName) {
        this.parentsLastName = parentsLastName;
    }

    public String getParentsEmailAddress() {
        return parentsEmailAddress;
    }

    public void setParentsEmailAddress(String parentsEmailAddress) {
        this.parentsEmailAddress = parentsEmailAddress;
    }

    public String getParentsPhoneNumber() {
        return parentsPhoneNumber;
    }

    public void setParentsPhoneNumber(String parentsPhoneNumber) {
        this.parentsPhoneNumber = parentsPhoneNumber;
    }

    public String getConsentGiven() {
        return consentGiven;
    }

    public void setConsentGiven(String consentGiven) {
        this.consentGiven = consentGiven;
    }
}
