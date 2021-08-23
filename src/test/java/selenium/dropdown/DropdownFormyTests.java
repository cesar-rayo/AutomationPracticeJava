package selenium.dropdown;

import org.testng.annotations.Test;
import pages.formy.DropdownPage;
import selenium.base.BaseTestsFormy;

public class DropdownFormyTests extends BaseTestsFormy {
    @Test
    public void testDropdown() {
        DropdownPage dropdownPage = homePage.clickDropdownLink();
        dropdownPage.selectFirstDropdownOption();
        goBack();
        dropdownPage.selectOptionByText("Drag and Drop");
    }
}
