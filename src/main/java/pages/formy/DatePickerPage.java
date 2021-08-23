package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerPage {
    private WebDriver driver;
    private By datePicker = By.id("datepicker");

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDatePicker() {
        driver.findElement(datePicker);
    }

    public void typeDate(String input) {
        WebElement dateField = driver.findElement(datePicker);
        dateField.sendKeys(input);
        dateField.sendKeys(Keys.ENTER);
    }
}
