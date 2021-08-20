package selenium.formy.autocomplete;

import org.testng.annotations.Test;
import pages.formy.AutoCompletePage;
import selenium.base.BaseTestsFormy;

public class AutocompleteTests extends BaseTestsFormy {
    @Test
    public void testAutocomplete() {
        AutoCompletePage autoCompletePage = homePage.clickAutocompleteLink();
        try {
            autoCompletePage.setAddress("1555 Park Blvd, Palo Alto, CA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
