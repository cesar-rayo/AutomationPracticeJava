package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollPage {
    private WebDriver driver;
    private By name = By.id("name");
    private By date = By.id("date");

    public ScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeName(String input) {
        WebElement nameInput = driver.findElement(name);
        scrollTo(nameInput);
        nameInput.sendKeys(input);
    }

    public void typeDate(String input) {
        WebElement dateInput = driver.findElement(date);
        scrollTo(dateInput);
        dateInput.sendKeys(input);
    }

    private void scrollTo(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }
}
