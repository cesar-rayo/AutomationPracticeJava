package selenium.datepicker;

import org.testng.annotations.Test;
import pages.formy.DatePickerPage;
import selenium.base.BaseTestsFormy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePickerTests extends BaseTestsFormy {
    @Test
    public void testDatePickerSendKeys() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String dateFormatted = dtf.format(now.plusMonths(1));

        DatePickerPage datePickerPage = homePage.clickDatePickerlink();
        datePickerPage.typeDate(dateFormatted);
    }
}
