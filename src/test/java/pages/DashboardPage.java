package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By titleBy = By.cssSelector("p.page_title");
    private By userToggleBy = By.id("dropdownUser1");
    private By logoutBy = By.linkText("Logout");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleBy));
    }

    public String getHeader() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleBy));
        return title.getText();
    }

    public void logout() {
        driver.findElement(userToggleBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutBy)).click();
    }
}
