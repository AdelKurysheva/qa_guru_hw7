package pages;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public static void setDateBirthday(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--00" + day + "").click();
    }
}
