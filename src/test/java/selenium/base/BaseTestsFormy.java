package selenium.base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.formy.FormyHomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTestsFormy {
    private WebDriver driver;
    protected FormyHomePage homePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/crayo/Documents/work/selenium/drivers/chromedriver");

        driver = new ChromeDriver();

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
}