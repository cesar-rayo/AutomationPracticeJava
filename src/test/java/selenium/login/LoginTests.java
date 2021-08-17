package selenium.login;

import org.testng.annotations.Test;
import pages.FormAuthenticationPage;
import pages.SecureAreaPage;
import selenium.base.BaseTests;
import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        FormAuthenticationPage authenticationPage = homePage.clickFormAuthentication();
        SecureAreaPage secureAreaPage = authenticationPage.login("tomsmith", "SuperSecretPassword!");
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert Text incorrect");
    }
}
