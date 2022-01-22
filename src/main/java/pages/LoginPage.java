package pages;

import helpers.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage{

    public LoginPage() {
        WebDriverUtils.switchToWindowHandle();
    }

    @FindBy(id = "username")
    private WebElement textbox_Username;

    @FindBy(id = "password")
    private WebElement textbox_Password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement button_Login;

    public void inputTextboxUsername(String username) {
        WebDriverUtils.waitForControl(textbox_Username);
        textbox_Username.clear();
        textbox_Username.sendKeys(username);
    }

    public void inputTextBoxPassword(String password) {
        WebDriverUtils.waitForControl(textbox_Password);
        textbox_Password.clear();
        textbox_Password.sendKeys(password);
    }

    public void loginToRailway(String username, String password) {
        inputTextboxUsername(username);
        inputTextBoxPassword(password);
        WebDriverUtils.waitForControl(button_Login);
        button_Login.click();
        WebDriverUtils.waitForPageLoaded();
    }
}
