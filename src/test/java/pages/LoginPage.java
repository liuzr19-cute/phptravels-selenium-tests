package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailBy    = By.id("email");
    private By passwordBy = By.id("password");
    private By submitBy   = By.id("submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.phptravels.net/admin");
        // 等待输入框可见
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBy));
    }

    public void login(String email, String password) {
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(submitBy).click();
    }
}
