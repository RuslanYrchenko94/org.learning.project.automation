package gitHub;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @Test
    void dragAndDrop(){
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        open("/drag_and_drop");
        $("[id=column-a]").dragAndDropTo("[id=column-b]");
        $("[id=column-b]").shouldHave(text("A"));
    }
}
