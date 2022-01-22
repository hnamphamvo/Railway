package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {
    public static WebDriver driver;

    public static String subWindowHandler = null;

    public enum DriverType {CHROME, FIREFOX}

    public static WebDriver getDriver() {
        return driver;
    }

    public static void startBrowser(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    public static void navigateToURL(String url) {
        getDriver().get(url);
    }

    public static void quitBrowser() {
        if (driver != null) {
            getDriver().quit();
            driver = null;
        }
    }
}
