package pages.formy;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchWindowPage {
    private WebDriver driver;
    private By newTabBtn = By.id("new-tab-button");
    private By newAlertBtn = By.id("alert-button");

    public SwitchWindowPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewTabBtn() {
        driver.findElement(newTabBtn).click();
        String originalHandle = driver.getWindowHandle();

        for (String handle: driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        // Closes second tab
        driver.close();
        driver.switchTo().window(originalHandle);
    }

    public void clickAlertBtn() {
        driver.findElement(newAlertBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
