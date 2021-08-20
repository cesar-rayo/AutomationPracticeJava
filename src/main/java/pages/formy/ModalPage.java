package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalPage {
    private WebDriver driver;
    private By openModalBtn = By.id("modal-button");
    private By modalCloseBtn = By.id("close-button");

    public ModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickModalBtn() {
        driver.findElement(openModalBtn).click();
    }

    public void modal_clickCloseBtn() {
        WebElement closeBtn = driver.findElement(modalCloseBtn);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;

        String script = "arguments[0].click()";
        javascriptExecutor.executeScript(script, closeBtn);
    }
}
