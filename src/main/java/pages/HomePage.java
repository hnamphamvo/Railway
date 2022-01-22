package pages;

import helpers.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    public HomePage() {
        WebDriverUtils.switchToWindowHandle();
    }

    @FindBy(xpath = "//h1[text()='Welcome to Safe Railway']")
    private WebElement text_HomePageTitle;

    public boolean doesHomePageDisplay() {
        return text_HomePageTitle.isDisplayed();
    }
}
