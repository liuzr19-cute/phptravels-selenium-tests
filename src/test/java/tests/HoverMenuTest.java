package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverMenuTest extends BaseTest {

    @Test
    void testLanguageDropdownDisplaysOnHover() {
        driver.get("https://www.phptravels.net");

        
        List<WebElement> toggles = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("header a.dropdown-toggle")
            )
        );
        WebElement langToggle = toggles.get(0);

      
        new Actions(driver)
            .moveToElement(langToggle)
            .pause(Duration.ofMillis(500))
            .perform();

    
        WebElement langMenu = langToggle.findElement(
            By.xpath("following-sibling::ul[contains(@class,'dropdown-menu')]")
        );
      
        wait.until(ExpectedConditions.visibilityOf(langMenu));

        assertTrue(langMenu.isDisplayed(), "Language dropdown should appear on hover");
    }

    @Test
    void testCurrencyDropdownDisplaysOnHover() {
        driver.get("https://www.phptravels.net");

        List<WebElement> toggles = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("header a.dropdown-toggle")
            )
        );
        WebElement currToggle = toggles.get(1);

        new Actions(driver)
            .moveToElement(currToggle)
            .pause(Duration.ofMillis(500))
            .perform();

        WebElement currMenu = currToggle.findElement(
            By.xpath("following-sibling::ul[contains(@class,'dropdown-menu')]")
        );
        wait.until(ExpectedConditions.visibilityOf(currMenu));

        assertTrue(currMenu.isDisplayed(), "Currency dropdown should appear on hover");
    }
}
