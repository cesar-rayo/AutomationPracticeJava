package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSlider {
    private WebDriver driver;
    private By horizontalSlider = By.cssSelector("div.sliderContainer > input");
    private By rangeLabel = By.id("range");

    public HorizontalSlider(WebDriver driver) {
        this.driver = driver;
    }

    public void increaseScroll() {
        driver.findElement(horizontalSlider).sendKeys(Keys.ARROW_RIGHT);
    }

    public void increaseScroll(int times) {
        for (int i = 0; i < times; i++) {
            increaseScroll();
        }
    }

    public void decreaseScroll() {
        driver.findElement(horizontalSlider).sendKeys(Keys.ARROW_LEFT);
    }

    public void decreaseScroll(int times) {
        for (int i = 0; i < times; i++) {
            decreaseScroll();
        }
    }

    public String getRange() {
        return driver.findElement(rangeLabel).getText();
    }
}
