package test;

import helpers.Utility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void TC01() {
        LoginPage loginPage = PageFactory.initElements(Utility.getDriver(), LoginPage.class);
        loginPage.loginToRailway("hnamphamvo@gmail.com","Nam12345678");

        HomePage homePage = PageFactory.initElements(Utility.getDriver(), HomePage.class);
        Assert.assertTrue(homePage.doesHomePageDisplay());
    }
}
