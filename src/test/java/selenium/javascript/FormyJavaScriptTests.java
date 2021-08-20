package selenium.javascript;

import org.testng.annotations.Test;
import pages.formy.ModalPage;
import selenium.base.BaseTestsFormy;

public class FormyJavaScriptTests extends BaseTestsFormy {
    @Test
    public void testCloseModal() {
        ModalPage modalPage = homePage.clickModalLink();
        modalPage.clickModalBtn();
        modalPage.modal_clickCloseBtn();
    }
}
