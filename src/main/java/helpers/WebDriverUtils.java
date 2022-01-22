package helpers;

import constants.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class WebDriverUtils {
    public static String getWindowHandle(WebDriver driver) {
        // get all the window handles after the popup window appears
        Set<String> afterPopup = driver.getWindowHandles();

        Iterator<String> iterator = afterPopup.iterator();
        while (iterator.hasNext())
            Utility.subWindowHandler = iterator.next();

        return Utility.subWindowHandler;
    }


    public static void switchToWindowHandle() {
        try {
            String popupWidowHandle = getWindowHandle(Utility.getDriver());
            Utility.getDriver().switchTo().window(popupWidowHandle);
            Utility.getDriver().manage().window().maximize();
        } catch (Exception e) {
            //TBD
        }
    }

    public static void waitForControl(WebElement controlName) {
        new WebDriverWait(Utility.getDriver(), Duration.ofSeconds(Constant.WAIT_TIME)).until(ExpectedConditions.visibilityOf(controlName));
    }

    public static void waitForPageLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(Utility.getDriver(), Duration.ofSeconds(Constant.WAIT_TIME));
        try {
            // Wait for HTML load
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    boolean readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    boolean activeJQuery = ((JavascriptExecutor) driver).executeScript("if (typeof jQuery != 'undefined') { return jQuery.active == 0; } else {  return true; }").equals(true);
                    return readyState && activeJQuery;
                }
            });

            // Wait for Angular load
            wait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    Boolean angularIsComplete = (Boolean) (executor.executeScript(
                            "return angular.element(document).injector().get('$http').pendingRequests.length === 0"));
                    return angularIsComplete;
                }
            });
        } catch (Exception e) {
            // TBD
        }
    }
}
