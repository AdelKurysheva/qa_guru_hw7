package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegisrationTestsPageObjects extends TestBase {


    @Test
    void testForm() {
        registrationPage.openPage()
                .setFirstName("Inna")
                .setLastName("Ivanova")
                .setUserEmail("i.ivanova@mail.com")
                .setGender("Female")
                .setPhoneNumber("8888888888")
                .dateBirthday("8", "September", "1999")
                .setSubjectsInput("Math")
                .setHobbies()
                .setUploadFile()
                .setCurrentAddress("34 St-Herald Sq, 5th Avenue, 350, New York")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .setClickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", "Inna Ivanova")
                .verifyResults("Student Email", "i.ivanova@mail.com")
                .verifyResults("Gender", "Female")
                .verifyResults("Mobile", "8888888888")
                .verifyResults("Date of Birth", "8 September,1999")
                .verifyResults("Subjects", "Maths")
                .verifyResults("Hobbies", "Music")
                .verifyResults("Picture", "1.png")
                .verifyResults("Address", "34 St-Herald Sq, 5th Avenue, 350, New York")
                .verifyResults("State and City", "Uttar Pradesh Agra");

    }
}
