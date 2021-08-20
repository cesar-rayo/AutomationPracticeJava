package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
    private WebDriver driver;
    private By image = By.id("image");
    private By targetBox = By.id("box");

    public DragDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveImageToBox() {
        driver.navigate().refresh();
        WebElement sourceImage = driver.findElement(image);
        WebElement box = driver.findElement(targetBox);
        moveElementTo(sourceImage, box);
    }

    public String getBoxMessage() {
        return driver.findElement(targetBox).getText();
    }

    private void moveElementTo(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }
}
