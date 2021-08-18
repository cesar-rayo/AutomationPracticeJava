package selenium.hover;

import model.FigureCaption;
import org.testng.annotations.Test;
import pages.HoversPage;
import selenium.base.BaseTests;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUser1() {
        HoversPage hoversPage = homePage.clickHovers();
        FigureCaption caption = hoversPage.hoverOverFigure(0);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(),"name: user1", "Title does not match");
        assertEquals(caption.getLinkText(),"View profile", "Caption link does not match");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");
    }
}
