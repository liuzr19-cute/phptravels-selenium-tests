package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavLinksTest extends BaseTest {

    @ParameterizedTest(name = "Click “{1}” nav should lead to /{0}")
    @CsvSource({
        "flights,Flights",
        "hotels,Hotels"
    })
    void testNavLinks(String pathSegment, String linkText) {
    
        driver.get("https://www.phptravels.net");

      
        WebElement navLink = wait.until(
            ExpectedConditions.elementToBeClickable(By.linkText(linkText))
        );
        navLink.click();

        
        wait.until(ExpectedConditions.urlContains(pathSegment));
        String url = driver.getCurrentUrl();
        assertTrue(url.contains(pathSegment),
            "URL should contain “" + pathSegment + "” but was: " + url);

       
        wait.until(ExpectedConditions.titleContains(linkText));
        String title = driver.getTitle();
        assertTrue(title.contains(linkText),
            "Title should contain “" + linkText + "” but was: " + title);
    }
}
