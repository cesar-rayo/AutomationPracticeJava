package selenium.contextmenu;

import org.testng.annotations.Test;
import pages.ContextMenuPage;
import selenium.base.BaseTests;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {
    @Test
    public void testContextMenu() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickHotSpot();
        String actualText = contextMenuPage.getAlertText();
        contextMenuPage.acceptAlert();
        assertEquals(actualText,"You selected a context menu","Alert Text does not match");
    }
}
