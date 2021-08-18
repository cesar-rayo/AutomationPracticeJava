package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygPage {
    private WebDriver driver;
    private String editorFrameID = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentBtn = By.cssSelector("button[aria-label='Increase indent']");

    public WysiwygPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToEditFrame() {
        driver.switchTo().frame(editorFrameID);
    }

    private void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }

    public void clearTextArea() {
        switchToEditFrame();
        driver.findElement(textArea).clear();
        switchToMainFrame();
    }

    public void typeInTextArea(String input) {
        switchToEditFrame();
        driver.findElement(textArea).sendKeys(input);
        switchToMainFrame();
    }

    public void clickIncreaseIndent() {
        driver.findElement(increaseIndentBtn).click();
    }

    public String getEditorText() {
        switchToEditFrame();
        String text = driver.findElement(textArea).getText();
        switchToMainFrame();
        return text;
    }
}
