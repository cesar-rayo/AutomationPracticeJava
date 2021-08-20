package selenium.scrolling;

import org.testng.annotations.Test;
import pages.formy.ScrollPage;
import selenium.base.BaseTestsFormy;

public class ScrollTests extends BaseTestsFormy {
    @Test
    public void testScroll() {
        ScrollPage scrollPage = homePage.clickPageScrollLink();
        scrollPage.typeName("Some Name Here");
        scrollPage.typeDate("01/01/2020");
    }
}
