package selenium.alerts;

import org.testng.annotations.Test;
import pages.formy.SwitchWindowPage;
import selenium.base.BaseTestsFormy;

public class AlertsFormyTests extends BaseTestsFormy {
    @Test
    public void testAlerts() {
        SwitchWindowPage switchWindowPage = homePage.clickSwitchPageLink();
        switchWindowPage.clickAlertBtn();
    }
}
