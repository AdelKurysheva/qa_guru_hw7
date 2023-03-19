package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationsResult registrationsResult = new RegistrationsResult();
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            phoneNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            inputFile = $("#uploadPicture"),
    currentAddress =  $("#currentAddress");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }
    public RegistrationPage dateBirthday(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDateBirthday(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies() {
        $(byText("Music")).click();
        return this;
    }

    public RegistrationPage setUploadFile() {
        inputFile.uploadFile(new File("src/test/resources/img/1.png"));
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        $("#state").click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        $("#city").click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setClickSubmit() {
        $("#submit").click();
        return this;
    }
    public RegistrationPage verifyResultsModalAppears(){
        registrationsResult.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResults(String key, String value){
        registrationsResult.verifyResults(key, value);
        return this;
    }
}
