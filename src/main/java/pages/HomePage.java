package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private String URL = "https://the-internet.herokuapp.com/";
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        Load();
    }

    public void Load() {
        driver.get(URL);
    }

    private void clickLink(String href) {
        driver.findElement(By.cssSelector("a[href='" + href + "'")).click();
    }

    public FormAuthenticationPage clickFormAuthentication(){
        clickLink("/login");
        return new FormAuthenticationPage(driver);
    }

    public HoversPage clickHovers() {
        clickLink("/hovers");
        return new HoversPage(driver);
    }

    public DropdownPage clickDropdownLink() {
        clickLink("/dropdown");
        return new DropdownPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink("/key_presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSlider clickHorizontalSlider() {
        clickLink("/horizontal_slider");
        return new HorizontalSlider(driver);
    }

    /**
     * List<WebElement> links = driver.findElements(By.tagName("a"));
     * System.out.println(links.size());
     *
     * driver.findElement(By.cssSelector("[href='/shifting_content']")).click();
     * driver.findElement(By.cssSelector("[href='/shifting_content/menu']")).click();
     *
     * WebElement mainDiv = driver.findElement(By.cssSelector("div[class='example']"));
     * List<WebElement> menuLinks = mainDiv.findElements(By.tagName("li"));
     * System.out.println("Items in Shifting menu: " + menuLinks.size());
     */

}
