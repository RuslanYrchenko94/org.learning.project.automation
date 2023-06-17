package demoqa.tests;

import demoqa.BaseTest;
import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static globalConstants.Constants.*;


public class DemoQAWithPageObjectTest extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void automationPracticeFormPositiveTest(){

        registrationPage.openPage()
                .setFirstName()
                .setLastName()
                .setUserEmail()
                .setUserGender("Male")
                .setUserNumber()
                .setDateOfBirth("14", "December", "1994")
                .setSubject("Computer Science")
                .setHobbies()
                .setPicture()
                .setCurrentAddress()
                .setState("NCR")
                .setCity("Noida")
                .clickSubmitButton()
                .checkVisibilityModalWindow()
                .checkResponsiveTableContent()
                .closeLargeModal()
                .checkVisibilityMainPage();

    }
}
