package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScrollFooterTest extends BaseTest {

    @Test
    void testScrollFooter() throws InterruptedException {
        
        driver.get("https://www.phptravels.net");

       
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

       
        Thread.sleep(1000);

        
        long scrollTop    = (Long) js.executeScript("return window.pageYOffset;");
        long innerHeight  = (Long) js.executeScript("return window.innerHeight;");
        long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight;");

        
        assertTrue(
            scrollTop + innerHeight >= scrollHeight - 2,
            String.format(
              "should reach the bottom, but pageYOffset + innerHeight = %d + %d = %d，小于 scrollHeight %d",
              scrollTop, innerHeight, scrollTop + innerHeight, scrollHeight
            )
        );
    }
}
