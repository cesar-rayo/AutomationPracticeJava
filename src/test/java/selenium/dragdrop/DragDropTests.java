package selenium.dragdrop;

import org.testng.annotations.Test;
import pages.formy.DragDropPage;
import selenium.base.BaseTestsFormy;

import static org.testng.Assert.assertEquals;

public class DragDropTests extends BaseTestsFormy {
    @Test
    public void testDragDrop() {
        DragDropPage dragDropPage = homePage.clickDragDropLink();
        dragDropPage.moveImageToBox();
        assertEquals(dragDropPage.getBoxMessage(),"Dropped!","Element was not dropped");
    }
}
