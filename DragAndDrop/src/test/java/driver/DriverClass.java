// DriverClass - Singleton with ThreadLocal to ensure thread-safety for parallel execution
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverClass(){}

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            driver.set(createNewDriver(browser));
        }
        return driver.get();
    }

    private static WebDriver createNewDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "safari":
                return new SafariDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
