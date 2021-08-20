package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPage {
    private WebDriver driver;
    private By checkBox = By.cssSelector("input[type='checkbox']");

    public CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkAllChecks() {
        List<WebElement> checkboxList = driver.findElements(checkBox);
        for (WebElement checkBox: checkboxList) {
            checkBox.click();
        }
    }
}
