package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSExecutorTest extends BaseTest {

    @Test
    void testGetTitleWithJS() {
      
        driver.get("https://www.phptravels.net");

      
        JavascriptExecutor js = (JavascriptExecutor) driver;

       
        String jsTitle = (String) js.executeScript("return document.title;");

        
        assertEquals(
            driver.getTitle(),
            jsTitle,
            "The page title should match the title returned by the JS"
        );
    }
}
