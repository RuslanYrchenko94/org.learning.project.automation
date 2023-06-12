package travelUsaExpress;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTest {

    @Test
    void successfulLoginTest(){

        open("https://dibstest.travelusaexpress.com/#login");
        $(".LoginSection_loginSectionTitle__MD4Df").shouldHave(text("Sign In"));
        $("[name=userName]").setValue("TestRetailStaffAdmin");
        $("[name=password]").setValue("Qwerty1!").pressEnter();
        $(".UserDropdown_userContainer__1ErZr").click();
        $(".ProfilePageUser_username__YjSAE").shouldHave(text("Welcome TestRetailStaffAdmin"));

    }
    @Test
    void unsuccessfulLoginTest(){
        open("https://dibstest.travelusaexpress.com/#login");
        $(".LoginSection_loginSectionTitle__MD4Df").shouldHave(text("Sign In"));
        $("[name=userName]").setValue("testuser");
        $("[name=password]").setValue("Q!").pressEnter();
        $(".LoginSection_errorText__3PU6a").isDisplayed();
        $(".LoginSection_errorText__3PU6a").shouldHave(text("We couldn't sign you in using those credentials."));
    }

}
