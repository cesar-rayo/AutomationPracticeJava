package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EntryAddPage {
    private WebDriver driver;
    private By modal = By.cssSelector("div[class='modal']");
    private By modalText = By.cssSelector("div[class='modal-body']");
    private By modalCloseLbl = By.cssSelector("div[class='modal-footer'] > p");

    public EntryAddPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToModal() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modal)));
        driver.switchTo().activeElement();
    }

    public void closeModal() {
        switchToModal();
        driver.findElement(modalCloseLbl).click();
    }

    public String getModalText() {
        switchToModal();
        return driver.findElement(modalText).getText();
    }
}
