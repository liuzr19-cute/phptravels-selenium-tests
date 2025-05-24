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

        // 拿到 header 里所有 dropdown-toggle 切换器
        List<WebElement> toggles = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("header a.dropdown-toggle")
            )
        );
        WebElement langToggle = toggles.get(0);

        // 悬停
        new Actions(driver)
            .moveToElement(langToggle)
            .pause(Duration.ofMillis(500))
            .perform();

        // 从这个切换器的兄弟节点里找下拉菜单
        WebElement langMenu = langToggle.findElement(
            By.xpath("following-sibling::ul[contains(@class,'dropdown-menu')]")
        );
        // 等待它变可见
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
