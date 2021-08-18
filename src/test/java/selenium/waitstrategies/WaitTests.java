package selenium.waitstrategies;

import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;
import selenium.base.BaseTests;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {
    @Test
    public void testLoaderExplicitWait() {
        DynamicLoadingExample2Page dynamicLoadingExample2Page = homePage.clickDynamicLoading().clickExample2();
        dynamicLoadingExample2Page.clickStartBtnExplicitWait();
        assertEquals(dynamicLoadingExample2Page.getLoadedText(),"Hello World!","Loaded Message does not match");
    }

    @Test
    public void testLoaderFluentWait() {
        DynamicLoadingExample2Page dynamicLoadingExample2Page = homePage.clickDynamicLoading().clickExample2();
        dynamicLoadingExample2Page.clickStartBtnFluentWait();
        assertEquals(dynamicLoadingExample2Page.getLoadedText(),"Hello World!","Loaded Message does not match");
    }
}
