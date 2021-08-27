package selenium.base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.formy.FormyHomePage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestsFormy {
    private WebDriver driver;
    protected FormyHomePage homePage;


    @BeforeClass
    public void setUp() {
        boolean remote = Boolean.parseBoolean(System.getProperty("USE_GRID","false"));
        String driverFlavor = System.getProperty("BROWSER","chrome");

        String gridUrl = "http://localhost:4444/wd/hub";
        System.out.println(String.format("Remote: %s, Driver: %s",remote, driverFlavor));

        //Remote driver
        if (remote) {
            try {
                switch (driverFlavor) {
                    case "firefox":
                        driver = new RemoteWebDriver(new URL(gridUrl), new FirefoxOptions());
                        break;
                    case "edge":
                        driver = new RemoteWebDriver(new URL(gridUrl), new EdgeOptions());
                        break;
                    case "opera":
                        driver = new RemoteWebDriver(new URL(gridUrl), new OperaOptions());
                        break;
                    default:
                        driver = new RemoteWebDriver(new URL(gridUrl), new ChromeOptions());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            // Use bonigarcia webdrivermanager for setting up local environment
            switch (driverFlavor.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1775, 954));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new FormyHomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        homePage.load();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
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

    public void goBack() {
        driver.navigate().back();
    }
}