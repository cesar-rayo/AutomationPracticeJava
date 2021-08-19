package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By link_Example2 = By.cssSelector("a[href='/dynamic_loading/2']");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample2Page clickExample2() {
        driver.findElement(link_Example2).click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample2Page rightClickExample2() {
        // Works for Mac
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(link_Example2))
                .keyDown(Keys.COMMAND)
                .click()
                .keyUp(Keys.COMMAND)
                .build()
                .perform();

        return new DynamicLoadingExample2Page(driver);
    }
}
