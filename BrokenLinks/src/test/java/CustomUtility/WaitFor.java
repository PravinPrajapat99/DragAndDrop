package CustomUtility;

import driver.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFor {
    private static WebDriver driver= DriverClass.getDriver("chrome");
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public static WebElement visibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void clickable(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
}
