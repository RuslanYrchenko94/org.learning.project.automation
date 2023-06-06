package gitHub;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenideTest {
    @Test
    void solntsevShouldBeTheTopContributor(){
        open("https://github.com/selenide/selenide");
        $(".BorderGrid li:nth-child(1) .avatar").scrollTo().hover();
        $(".Popover").shouldHave(text("Andrei Solntsev"));
    }

    @Test
    void searchSoftAssertionsPage(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("[id=wiki-pages-box] ul .Box-row:nth-last-child(1)").scrollTo();
        $("[id=wiki-pages-box] ul .Box-row:nth-last-child(1) button").click();
        $("[id=wiki-pages-box]").shouldHave(text("SoftAssertions"));
        $("[id=wiki-pages-box] ul .Box-row:nth-last-child(2) a").click();
        $("#wiki-body").shouldHave(text("JUnit5"));
    }
    @Test
    void searchEnterprisePage(){
        open("https://github.com");
        $(".HeaderMenu-item", 1).hover();
        $(byText("Enterprise")).click();
        $(".application-main").shouldHave(text("Build like the best"));
    }
}
