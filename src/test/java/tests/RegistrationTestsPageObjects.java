package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationTestsPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testForm() {
        registrationPage.openPage()
                .closeBanner()
                .setFirstName("Inna")
                .setLastName("Ivanova")
                .setUserEmail("i.ivanova@mail.com")
                .setGender("Female")
                .setPhoneNumber("8888888888")
                .dateBirthday("8", "September", "1999")
                .setSubjectsInput("Math")
                .setHobbies("Music")
                .setUploadFile("1.png")
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
