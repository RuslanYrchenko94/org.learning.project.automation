package demoqa;

import com.codeborne.selenide.Configuration;
import org.checkerframework.checker.units.qual.Current;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class DemoQATest {
    String userName = "Ruslan Yurchenko";
    String userEmail = "test@gmail.com";
    String currentAddress = "Test Address";
    String permanentAddress = "13/86";
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").scrollTo().setValue(permanentAddress);
        $("#submit").scrollTo().click();
        $("#output").scrollTo().shouldBe(visible);
        $("#name ").shouldHave(text(format("Name:",userName)));
        $("#email ").shouldHave(text(format("Email:",userEmail)));
        $("#output #currentAddress").shouldHave(text(format("Current Address :", currentAddress)));
        $("#output #permanentAddress").shouldHave(text(format("Permananet Address :",permanentAddress)));
    }
}
