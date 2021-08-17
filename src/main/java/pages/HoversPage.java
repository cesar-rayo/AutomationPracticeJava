package pages;

import model.FigureCaption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver driver;
    private By figureBox = By.cssSelector("div[class='figure']");
    private By boxCaption = By.cssSelector("div[class='figcaption']");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = driver.findElements(figureBox).get(index);
        Actions actions = new Actions(driver);
        // Move mouse to WebElement (hover)
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }
}
