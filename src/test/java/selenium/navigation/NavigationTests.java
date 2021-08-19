package selenium.navigation;

import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;
import pages.MultipleWindowsPage;
import selenium.base.BaseTests;

import static org.testng.Assert.assertEquals;

public class NavigationTests extends BaseTests {
    @Test
    public void testNavigation() {
        homePage.clickDynamicLoading().clickExample2();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testMultipleWindows() {
        MultipleWindowsPage multipleWindowsPage = homePage.clickMultipleWindowsLink();
        multipleWindowsPage.clickHereLink();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testSimulateRightClick() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        DynamicLoadingExample2Page dynamicLoadingExample2Page = dynamicLoadingPage.rightClickExample2();

        getWindowManager().switchToTabByUrl("dynamic_loading/2");
        dynamicLoadingExample2Page.clickStartBtnExplicitWait();
        String actualText = dynamicLoadingExample2Page.getLoadedText();

        getWindowManager().switchToTabByUrl("dynamic_loading");
        assertEquals(actualText,"Hello World!","Loaded Message does not match");
    }
}
