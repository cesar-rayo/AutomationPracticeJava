package selenium.forms;

import org.testng.annotations.Test;
import pages.formy.FormPage;
import pages.formy.ThanksPage;
import selenium.base.BaseTestsFormy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class FormTests extends BaseTestsFormy {
    @Test
    public void testCompleteForm() {
        FormPage formPage = homePage.clickFormLink();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String dateFormatted = dtf.format(now.plusMonths(1));

        formPage.typeFirstName("First Name");
        formPage.typeLastName("Last Name");
        formPage.typeJobTitle("Job Title");
        formPage.selectEducationLevel("College");
        formPage.selectSex("Prefer not to say");
        formPage.selectYearsByVisibleText("5-9");
        formPage.typeDate(dateFormatted);

        ThanksPage thanksPage = formPage.clickSubmit();
        assertEquals(thanksPage.getConfirmationMsg(),"The form was successfully submitted!","Message does not match!");
    }

    @Test
    public void testIncompleteForm() {
        FormPage formPage = homePage.clickFormLink();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String dateFormatted = dtf.format(now.plusMonths(1));

        formPage.typeFirstName("First Name");
        formPage.typeLastName("Last Name");
        formPage.typeJobTitle("Job Title");
        formPage.selectYearsByVisibleText("10+");
        formPage.typeDate(dateFormatted);

        ThanksPage thanksPage = formPage.clickSubmit();
        assertEquals(thanksPage.getConfirmationMsg(),"The form was successfully submitted!","Message does not match!");
    }
}
