package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static globalConstants.Constants.*;

public class RegistrationPage  {
    CalendarComponent calendarComponent = new CalendarComponent();
    private SelenideElement firstNameSelector = $("#firstName"),
            lastNameSelector = $("#lastName"),
            userEmailSelector = $("#userEmail"),
            userNumberSelector = $("#userNumber"),
            subjectsInputSelector = $("#subjectsInput"),
            currentAddressSelector = $("#currentAddress"),
            stateSelector = $("#react-select-3-input"),
            citySelector = $("#react-select-4-input");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameSelector.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameSelector.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value){
        userEmailSelector.setValue(value);
        return this;
    }
    public RegistrationPage setUserGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberSelector.setValue(value);
        return this;
    }
    public RegistrationPage setSubject(String value){
        subjectsInputSelector.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        currentAddressSelector.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value){
        stateSelector.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setCity(String value){
        citySelector.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-container").isDisplayed();
        calendarComponent.setDate(day, month,year);
        return this;
    }
    public RegistrationPage setHobbies(){
        $x("//label[text()='Sports']").click();
        $x("//label[text()='Reading']").click();
        return this;
    }
    public RegistrationPage setPicture(){
        $x("//input[@id='uploadPicture']").uploadFile(new File("src/test/resources/Screenshot_1.png"));
        return this;
    }
    public RegistrationPage clickSubmitButton(){
        $("#submit").click();
        return this;
    }
    public RegistrationPage checkVisibilityModalWindow(){
        $(".modal-content").isDisplayed();
        return this;
    }
    public RegistrationPage checkResponsiveTableContent(){
        $(".table-responsive").shouldHave(text(userFirstName),text(userLastName), text(userEmail),
                text("Male"), text(userNumber), text("14 December,1994"), text("Computer Science"),
                text("Sports"), text("Reading"), text("Screenshot_1.png"), text(currentAddress), text("NCR Noida"));
        return this;
    }
    public RegistrationPage closeLargeModal(){
        $("#closeLargeModal").click();
        return this;
    }
    public void checkVisibilityMainPage(){
        $(".practice-form-wrapper").should(visible);
    }

}
