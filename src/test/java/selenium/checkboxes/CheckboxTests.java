package selenium.checkboxes;

import org.testng.annotations.Test;
import pages.formy.CheckBoxesPage;
import selenium.base.BaseTestsFormy;

public class CheckboxTests extends BaseTestsFormy {
    @Test
    public void testCheckboxes() {
        CheckBoxesPage checkBoxesPage = homePage.clickCheckBoxesLink();
        checkBoxesPage.checkAllChecks();
    }
}
