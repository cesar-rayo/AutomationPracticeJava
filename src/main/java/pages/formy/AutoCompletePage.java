package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoCompletePage {
    private WebDriver driver;
    private By address = By.id("autocomplete");
    private By suggestedAddress = By.cssSelector("div[class='pac-item']");

    public AutoCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setAddress(String data) throws InterruptedException {
        WebElement addressText = driver.findElement(address);
        Thread.sleep(1000);
        addressText.sendKeys(data);
        driver.findElement(suggestedAddress).click();
    }
}
