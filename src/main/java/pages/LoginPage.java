package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span//a[@href=\"https://www.evernote.com/Login.action\"]")
    private WebElement loginLink;

    @FindBy(id = "username")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "responseMessage")
    private WebElement wrongEmailErrorMessage;


    public LoginPage clickLoginLink() {
        loginLink.click();
        return this;
    }

    public LoginPage enterUsername(String username) {
        loginField.sendKeys(username);
        return this;
    }

    public LoginPage clearUsernameField() {
        loginField.clear();
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public String getWrongEmailErrorMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(wrongEmailErrorMessage));
        return wrongEmailErrorMessage.getText();
    }
}
