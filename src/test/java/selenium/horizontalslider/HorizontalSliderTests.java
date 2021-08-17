package selenium.horizontalslider;

import org.testng.annotations.Test;
import pages.HorizontalSlider;
import selenium.base.BaseTests;
import static org.testng.Assert.*;

public class HorizontalSliderTests extends BaseTests {
    @Test
    public void testIncreaseTo2() {
        HorizontalSlider horizontalSlider = homePage.clickHorizontalSlider();
        horizontalSlider.increaseScroll(4);
        assertEquals(horizontalSlider.getRange(), "2", "Range does not match");
    }

    @Test
    public void testDecreaseTo3() {
        HorizontalSlider horizontalSlider = homePage.clickHorizontalSlider();
        horizontalSlider.increaseScroll(8);
        horizontalSlider.decreaseScroll(2);
        assertEquals(horizontalSlider.getRange(), "3", "Range does not match");
    }
}
