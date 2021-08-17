package selenium.keys;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;
import selenium.base.BaseTests;
import static org.testng.Assert.*;

public class KeysTests extends BaseTests {

    @Test
    public void testBackspace() {
         KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
         keyPressesPage.enterText("A" + Keys.BACK_SPACE);
         assertEquals(keyPressesPage.getResult(), "You entered: BACK_SPACE", "Text does not match");
    }

    @Test
    public void testPi() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterPi();
        assertEquals(keyPressesPage.getResult(), "You entered: 4", "Text does not match");
    }
}
