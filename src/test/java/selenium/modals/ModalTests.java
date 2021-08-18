package selenium.modals;

import org.testng.annotations.Test;
import pages.EntryAddPage;
import selenium.base.BaseTests;

import static org.testng.Assert.assertTrue;

public class ModalTests extends BaseTests {
    @Test
    public void testCloseModal() {
        EntryAddPage entryAddPage = homePage.clickEntryAdd();
        String actualText = entryAddPage.getModalText();
        entryAddPage.closeModal();
        assertTrue(actualText.contains("It's commonly used to encourage"), "Text does not contain the expected phrase");
    }
}
