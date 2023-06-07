package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        $(format("%s%s",".react-datepicker__day--0",day)).click();
    }
}
