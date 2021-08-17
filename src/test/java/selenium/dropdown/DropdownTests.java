package selenium.dropdown;

import com.beust.jcommander.Strings;
import org.testng.annotations.Test;
import pages.DropdownPage;
import selenium.base.BaseTests;
import static org.testng.Assert.*;

import java.util.List;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        DropdownPage dropdownPage = homePage.clickDropdownLink();

        String optionText = "Option 2";
        dropdownPage.selectOptionByText(optionText);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),1, "More than 1 option is selected");
        assertTrue(selectedOptions.contains(optionText), "Wrong option is selected");
    }
}
