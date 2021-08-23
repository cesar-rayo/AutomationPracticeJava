package pages.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdownMenu = By.id("dropdownMenuButton");
    private By autocompleteOption = By.id("autocomplete");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectOptionByText(String option) {
        driver.findElement(dropdownMenu).click();
        driver.findElement(By.linkText(option)).click();
    }

    public void selectFirstDropdownOption() {
        driver.findElement(dropdownMenu).click();
        driver.findElement(autocompleteOption).click();
    }
}
