package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private By startBtn = By.cssSelector("#start > button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStartBtnExplicitWait() {
        driver.findElement(startBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public void clickStartBtnFluentWait() {
        driver.findElement(startBtn).click();
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loadedText)));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}
