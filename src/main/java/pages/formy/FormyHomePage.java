package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormyHomePage {
    private String url = "https://formy-project.herokuapp.com/";
    private WebDriver driver;

    public FormyHomePage(WebDriver driver) {
        this.driver = driver;
        load();
    }

    public void load() {
        this.driver.get(url);
    }

    private void clickOnLink(String linkName) {
        By locator = By.cssSelector(String.format("a[href='%s'][class='btn btn-lg']", linkName));
        driver.findElement(locator).click();
    }

    public AutoCompletePage clickAutocompleteLink() {
        clickOnLink("/autocomplete");
        return new AutoCompletePage(driver);
    }

    public ScrollPage clickPageScrollLink() {
        clickOnLink("/scroll");
        return new ScrollPage(driver);
    }

    public SwitchWindowPage clickSwitchPageLink() {
        clickOnLink("/switch-window");
        return new SwitchWindowPage(driver);
    }

    public ModalPage clickModalLink() {
        clickOnLink("/modal");
        return new ModalPage(driver);
    }

    public DragDropPage clickDragDropLink() {
        clickOnLink("/dragdrop");
        return new DragDropPage(driver);
    }

}
