package selenium.javascript;

import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.InfiniteScrollPage;
import pages.LargeDeepPage;
import selenium.base.BaseTests;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTests extends BaseTests {
    @Test
    public void testScroll() {
        LargeDeepPage largeDeepPage = homePage.clickLargeDeepLink();
        largeDeepPage.scrollToTable();
    }

    @Test
    public void testInfiniteScroll() {
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScrollLink();
        infiniteScrollPage.scrollToParagraph(5);
    }

    @Test
    public void testSelectMultipleOptions() {
        DropdownPage dropdownPage = homePage.clickDropdownLink();
        // Change dropdown attributes
        dropdownPage.addMultipleAttribute();

        List<String> optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectOptionByText);
    }
}
