package demoqa;

import org.junit.jupiter.api.Test;

import static globalConstants.Constants.*;


public class DemoQAWithPageObjectTest extends BaseTest {

    @Test
    void automationPracticeFormPositiveTest(){

        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setUserEmail(userEmail)
                .setUserGender("Male")
                .setUserNumber(userNumber)
                .setDateOfBirth("14", "December", "1994")
                .setSubject("Computer Science")
                .setHobbies()
                .setPicture()
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Noida")
                .clickSubmitButton()
                .checkVisibilityModalWindow()
                .checkResponsiveTableContent()
                .closeLargeModal()
                .checkVisibilityMainPage();

    }
}
