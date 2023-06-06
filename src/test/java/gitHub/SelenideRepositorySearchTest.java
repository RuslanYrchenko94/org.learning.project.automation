package gitHub;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {
    @Test
    void findSelenideRepositoryAtTheTop(){
        open("https://github.com/");
        $("[name=q]").setValue("Selenide").pressEnter();
        $("ul.repo-list li:nth-child(1) div.f4").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
