package selenium.alerts;

import org.testng.annotations.Test;
import pages.AlertsPage;
import selenium.base.BaseTests;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerJsAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Result text does not match");
    }

    @Test
    public void testGetTextFromAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirmAlert();
        String actualText = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(actualText, "I am a JS Confirm", "Alert Text does not match");
    }

    @Test
    public void testSetInputInAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerJsPromptAlert();
        String inputText = "Custom Text";
        alertsPage.alert_setInput(inputText);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + inputText, "Result text does not match");
    }
}
