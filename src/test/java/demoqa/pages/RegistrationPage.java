package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import demoqa.BaseTest;
import demoqa.pages.components.CalendarComponent;
import demoqa.tests.DemoQARegistrationPageDataTest;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    Faker faker = new Faker();

    String dataUserFirstName = faker.name().firstName();
    String dataUserLastName = faker.name().lastName();
    String dataUserEmail = faker.bothify("????##@gmail.com");;
    String dataUserNumber = faker.number().digits(10);
    String dataCurrentAddress = faker.address().buildingNumber();
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
        getWebDriver().manage().window().maximize();
        $(".main-header").shouldHave(text("Practice Form"));
        return this;
    }
    public RegistrationPage deleteBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(){
        firstNameSelector.setValue(dataUserFirstName);
        return this;
    }
    public RegistrationPage setLastName(){
        lastNameSelector.setValue(dataUserLastName);
        return this;
    }
    public RegistrationPage setUserEmail(){
        userEmailSelector.setValue(dataUserEmail);
        return this;
    }
    public RegistrationPage setUserGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(){
        userNumberSelector.setValue(dataUserNumber);
        return this;
    }
    public RegistrationPage setSubject(String value){
        subjectsInputSelector.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setCurrentAddress(){
        currentAddressSelector.setValue(dataCurrentAddress);
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
        $("#submit").scrollTo().click();
        return this;
    }
    public RegistrationPage checkVisibilityModalWindow(){
        $(".modal-content").isDisplayed();
        return this;
    }
    public RegistrationPage checkResponsiveTableContent(){
        $(".modal-content").shouldHave(text(dataUserFirstName),text(dataUserLastName), text(dataUserEmail),
                text("Male"), text(dataUserNumber), text("14 December,1994"), text("Computer Science"),
                text("Sports"), text("Reading"), text("Screenshot_1.png"), text(dataCurrentAddress), text("NCR Noida"));
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
