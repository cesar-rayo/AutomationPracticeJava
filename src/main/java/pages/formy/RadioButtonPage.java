package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {
    private WebDriver driver;
    private By radioBtn = By.cssSelector("input[type='radio']");

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRadioButtonByIndex(int index) {
        driver.findElements(radioBtn).get(index).click();
    }
}
