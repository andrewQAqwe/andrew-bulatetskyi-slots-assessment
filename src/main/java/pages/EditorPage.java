package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditorPage {

    private final WebDriver driver;

    public EditorPage(WebDriver driver) {
        this.driver = driver;
    }

    By userEmail = By.xpath("//div[@class='mjp8WyYQODySClV2byHt']");
    By createNewNoteButton = By.id("qa-HOME_NOTE_WIDGET_CREATE_NOTE");
    By iframeLocator = By.id("qa-COMMON_EDITOR_IFRAME");
    By textField = By.xpath("//en-note[@id='en-note']");
    By signOut = By.xpath("//span[@class='ATm3C3aUTlB1vovtP09c fqGPff50YEEMz7JBRAUX HUWoDG8e8KhEOGqVocpC']");
    By logOutConfirmButton = By.id("qa-LOGOUT_CONFIRM_DIALOG_CANCEL");
    By notesMenu = By.id("qa-NAV_ALL_NOTES");
    By notesCreationTimeText = By.xpath("//div[@class='RkC_qBZYf_0e1WJqaS3o PSyIGieTOzqjqmm98ZqQ']");
    By moreActionsDropdown = By.id("qa-NOTE_ACTIONS");
    By deleteButton = By.id("qa-ACTION_DELETE");


    public String getUserEmailElement() {
        return driver.findElement(userEmail).getText();
    }

    public void clickCreateNewNote() {
        driver.findElement(createNewNoteButton).click();
    }

    public void switchToIframe() {
        WebElement iframe = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframe);
    }

    public void writeInTextField(String text) {
        driver.findElement(textField).sendKeys(text);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void clickSignOut() {
        driver.findElement(userEmail).click();
        driver.findElement(signOut).click();
    }

    public void logOutConfirm() {
        driver.findElement(logOutConfirmButton).click();
    }

    public void openNotesMenu() {
        driver.findElement(notesMenu).click();
    }

    public String getNotesCreationTime(){
        return driver.findElement(notesCreationTimeText).getText();
    }

    public void openMoreActionsMenu (){
        driver.findElement(moreActionsDropdown).click();
    }

    public void clickDeleteButton(){
        driver.findElement(deleteButton).click();
    }
}
