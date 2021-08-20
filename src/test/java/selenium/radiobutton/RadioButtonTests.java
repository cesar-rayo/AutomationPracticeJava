package selenium.radiobutton;

import org.testng.annotations.Test;
import pages.formy.RadioButtonPage;
import selenium.base.BaseTestsFormy;

public class RadioButtonTests extends BaseTestsFormy {
    @Test
    public void testRadioButton() {
        RadioButtonPage radioButtonPage = homePage.clickRadioButtonLink();
        radioButtonPage.clickRadioButtonByIndex(1);
    }
}
