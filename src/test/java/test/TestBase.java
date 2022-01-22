package test;

import constants.Constant;
import helpers.Utility;
import helpers.LogHelper;

import helpers.WebDriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser) {
        LogHelper.info("Pre-condition");
        Utility.startBrowser(Utility.DriverType.valueOf(browser.toUpperCase()));
        Utility.navigateToURL(Constant.RAILWAY_URL);
        WebDriverUtils.waitForPageLoaded();
    }

    @AfterMethod
    public void afterMethod() {
        Utility.quitBrowser();
    }
}
