package demoqa;

import com.codeborne.selenide.Configuration;
import org.checkerframework.checker.units.qual.Current;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class DemoQATest {
    String userFirstName = "Ruslan";
    String userLastName = "Yurchenko";
    String userEmail = "test@gmail.com";
    String currentAddress = "Test Address";
    String permanentAddress = "13/86";
    String userNumber = "0800601566";
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue(format(userLastName));
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").scrollTo().setValue(permanentAddress);
        $("#submit").scrollTo().click();
        $("#output").scrollTo().shouldBe(visible);
        $("#name ").shouldHave(text(format("%s%s","Name:",userLastName)));
        $("#email ").shouldHave(text(format("%s%s","Email:",userEmail)));
        $("#output #currentAddress").shouldHave(text(format("%s%s","Current Address :", currentAddress)));
        $("#output #permanentAddress").shouldHave(text(format("%s%s","Permananet Address :",permanentAddress)));
    }
    @Test
    void automationPracticeFormPositiveTest(){

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $(".custom-radio:nth-child(1)").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-container").isDisplayed();
        $(".react-datepicker__month-select").selectOptionContainingText("December");
        $(".react-datepicker__year-select").selectOptionContainingText("1994");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $x("//label[text()='Sports']").click();
        $x("//label[text()='Reading']").click();
        $x("//input[@id='uploadPicture']").uploadFile(new File("src/test/resources/Screenshot_1.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();
        $(".modal-content").isDisplayed();
        $(".table-responsive").shouldHave(text(userFirstName),text(userLastName), text(userEmail),
                text("Male"), text(userNumber), text("14 December,1994"), text("Computer Science"),
                        text("Sports"), text("Reading"), text("Screenshot_1.png"), text(currentAddress), text("NCR Noida"));
        $("#closeLargeModal").click();
        $(".practice-form-wrapper").should(visible);
    }
}
