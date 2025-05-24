package tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver    = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testJsGetTitle() {
        String title = (String)((org.openqa.selenium.JavascriptExecutor)driver)
            .executeScript("return document.title");
        assertTrue(title.toLowerCase().contains("login"));
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login("admin@phptravels.com", "demoadmin");
        // Wait URL， Should jump to /admin/dashboard
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
            .until(d -> d.getCurrentUrl().contains("/admin/dashboard"));
        assertTrue(driver.getCurrentUrl().contains("/admin/dashboard"), 
                   "Should jump to /admin/dashboard");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
