package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAuthenticationPage {
    private WebDriver driver;
    private By userNameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button");

    public FormAuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserNameField(String username){
        driver.findElement(userNameField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public SecureAreaPage login(String username, String password){
        setUserNameField(username);
        setPasswordField(password);
        clickLoginButton();
        return new SecureAreaPage(driver);
    }
}
