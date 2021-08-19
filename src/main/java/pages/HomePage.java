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

    public AlertsPage clickJavaScriptAlerts() {
        clickLink("/javascript_alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload() {
        clickLink("/upload");
        return new FileUploadPage(driver);
    }

    public EntryAddPage clickEntryAdd() {
        clickLink("/entry_ad");
        return new EntryAddPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        clickLink("/context_menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygPage clickWysiwygEditor() {
        clickLink("/tinymce");
        return new WysiwygPage(driver);
    }

    public FramesPage clickFramesLink() {
        clickLink("/frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        clickLink("/dynamic_loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeDeepPage clickLargeDeepLink() {
        clickLink("/large");
        return new LargeDeepPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScrollLink() {
        clickLink("/infinite_scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindowsLink() {
        clickLink("/windows");
        return new MultipleWindowsPage(driver);
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
