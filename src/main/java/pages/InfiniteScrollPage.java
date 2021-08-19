package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By textParagraph = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToParagraph(int index) {
        // Normal scroll Height
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        while (getNumberOfParagraphs() < index) {
            javascriptExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphs() {
        return driver.findElements(textParagraph).size();
    }
}
