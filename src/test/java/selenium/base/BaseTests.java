package selenium.base;

//import org.openqa.selenium.Dimension;
import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTests {
    //private WebDriver driver;

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        options.setAcceptInsecureCerts(true);
        return options;
    }

    // Setting custom cookies
    private void setCookie() {
        Cookie cookie = new Cookie.Builder("CookieName", "CookieValue")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    private void deleteCookie(String cookieName) {
        driver.manage().deleteCookieNamed(cookieName);
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/crayo/Documents/work/selenium/drivers/chromedriver");
        //driver = new ChromeDriver();

        // Implementing event listener (logging tools)
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(375, 812));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        setCookie();
        //deleteCookie("optimizelyBuckets");
    }

    @BeforeMethod
    public void goHome() {
        homePage.Load();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    public void takeScreenshot(String fileName) {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filePath = "./evidences/" + fileName;
        try {
            File newFile = new File(filePath);
            Files.move(screenshot, newFile);
            System.out.println("Took Screenshot: " + newFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Take Screenshot if test fails
    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result.getName() + ".png");
        }
    }
}
