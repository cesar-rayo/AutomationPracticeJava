package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage {
    private WebDriver driver;
    private By topFrame = By.cssSelector("frame[src='/frame_top']");
    private By leftFrame = By.cssSelector("frame[src='/frame_left']");
    private By middleFrame = By.cssSelector("frame[src='/frame_middle']");
    private By rightFrame = By.cssSelector("frame[src='/frame_right']");
    private By bottomFrame = By.cssSelector("frame[src='/frame_bottom']");
    private By frameBody = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
    }

    private void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    private String getFrameBodyText(By locator) {
        switchToFrame(driver.findElement(locator));
        String bodyText = driver.findElement(frameBody).getText();
        switchToParentFrame();
        return bodyText;
    }

    private String getTopFrameText(By locator) {
        switchToFrame(driver.findElement(topFrame));
        String frameText = getFrameBodyText(locator);
        switchToParentFrame();
        return frameText;
    }

    public String getLeftFrameText(){
        return getTopFrameText(leftFrame);
    }

    public String getMiddleFrameText(){
        return getTopFrameText(middleFrame);
    }

    public String getRightFrameText(){
        return getTopFrameText(rightFrame);
    }

    public String getBottomFrameText(){
        return getFrameBodyText(bottomFrame);
    }

}
