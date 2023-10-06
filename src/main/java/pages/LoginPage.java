package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By loginLink = By.xpath("//span//a[@href=\"https://www.evernote.com/Login.action\"]");
    By loginField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("loginButton");
    By wrongEmailErrorMessage = By.id("responseMessage");


    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(loginField).sendKeys(username);
    }

    public void clearUsernameField() {
        driver.findElement(loginField).clear();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getWrongEmailErrorMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(wrongEmailErrorMessage)));
        return driver.findElement(wrongEmailErrorMessage).getText();
    }
}
