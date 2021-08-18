package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerJsAlertBtn = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerJsConfirmAlertBtn = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerJsPromptAlertBtn = By.xpath(".//button[text()='Click for JS Prompt']");
    private By resultLabel = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerJsAlert() {
        driver.findElement(triggerJsAlertBtn).click();
    }

    public void triggerConfirmAlert() {
        driver.findElement(triggerJsConfirmAlertBtn).click();
    }

    public void triggerJsPromptAlert() {
        driver.findElement(triggerJsPromptAlertBtn).click();
    }

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void alert_setInput(String input) {
        driver.switchTo().alert().sendKeys(input);
    }

    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }

    public String getResult() {
        return driver.findElement(resultLabel).getText();
    }
}
