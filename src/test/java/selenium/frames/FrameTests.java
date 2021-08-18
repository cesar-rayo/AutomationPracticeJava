package selenium.frames;

import org.testng.annotations.Test;
import pages.FramesPage;
import pages.NestedFramesPage;
import pages.WysiwygPage;
import selenium.base.BaseTests;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {
    @Test
    public void testSendText() {
        WysiwygPage wysiwygPage = homePage.clickWysiwygEditor();
        wysiwygPage.clearTextArea();
        String inputText1 = "Some text here";
        String inputText2 = "Hello World";

        wysiwygPage.typeInTextArea(inputText1);
        wysiwygPage.clickIncreaseIndent();
        wysiwygPage.typeInTextArea(inputText2);

        assertEquals(wysiwygPage.getEditorText(), inputText1 + inputText2,"Text does not match");
    }

    @Test
    public void testNestedFramesText() {
        FramesPage framesPage = homePage.clickFramesLink();
        NestedFramesPage nestedFramesPage = framesPage.clickNestedFrames();

        String leftText = nestedFramesPage.getLeftFrameText();
        String middleText = nestedFramesPage.getMiddleFrameText();
        String rightText = nestedFramesPage.getRightFrameText();
        String bottomText = nestedFramesPage.getBottomFrameText();

        assertEquals(leftText, "LEFT", "Left Frame Text does not match");
        assertEquals(middleText, "MIDDLE", "Middle Frame Text does not match");
        assertEquals(rightText, "RIGHT", "Right Frame Text does not match");
        assertEquals(bottomText, "BOTTOM", "Bottom Frame Text does not match");
    }
}
