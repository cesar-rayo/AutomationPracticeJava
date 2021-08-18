package selenium.files;

import org.testng.annotations.Test;
import pages.FileUploadPage;
import selenium.base.BaseTests;

import static org.testng.Assert.assertEquals;

public class UploadFileTests extends BaseTests {

    @Test
    public void testUploadFile() {
        FileUploadPage fileUploadPage = homePage.clickFileUpload();
        String filePath = "/Users/crayo/Documents/work/personal/java_projects/AutomationPracticeJava/files/test.txt";
        fileUploadPage.uploadFile(filePath);
        assertEquals(fileUploadPage.getUploadedFiles(), "test.txt", "Uploaded file name does not match");
    }
}
