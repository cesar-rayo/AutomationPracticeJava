package selenium.navigation;

import org.testng.annotations.Test;
import pages.formy.SwitchWindowPage;
import selenium.base.BaseTestsFormy;

public class TabTests extends BaseTestsFormy {
    @Test
    public void testSwitchTabs() {
        SwitchWindowPage switchWindowPage = homePage.clickSwitchPageLink();
        switchWindowPage.clickNewTabBtn();
    }
}
