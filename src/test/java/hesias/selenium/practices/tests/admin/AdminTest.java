package hesias.selenium.practices.tests.admin;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import hesias.selenium.practices.tests.BaseTest;

import java.time.Duration;

public class AdminTest extends BaseTest{
    @Test
    public void testNavigateToAdmin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));

        WebElement usernameTextField = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement pwdTextField = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
        usernameTextField.sendKeys("Admin");
        pwdTextField.sendKeys("admin123");
        button.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-main-menu-item")));

        WebElement menuAdminOption = driver.findElement(By.cssSelector("a[class='oxd-main-menu-item']"));
        menuAdminOption.click();

        WebElement addButton = driver.findElement(By.cssSelector("button[type='button']"));
        addButton.click();
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
