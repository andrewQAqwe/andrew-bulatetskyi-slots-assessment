import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.EditorPage;
import pages.LoginPage;


public class FifthTaskTest extends BaseTest {

    private static final String USERNAME = "andtest.1988@gmail.com";
    private static final String WRONG_USERNAME = "andtest.1988+vrongEmail@gmail.com";
    private static final String PASSWORD = "P@ssw0rd";


    LoginPage loginPage = new LoginPage(driver);
    EditorPage editorPage = new EditorPage(driver);


    @Test(priority = 0)
    public void wrongLoginTest() {

        loginPage.clickLoginLink();
        loginPage.enterUsername(WRONG_USERNAME);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getWrongEmailErrorMessage(),
                "There is no account for the username or email you entered.",
                "incorrect error message");
    }

    @Test(priority = 1)
    public void loginTest() {

        loginPage.clearUsernameField();
        loginPage.enterUsername(USERNAME);
        loginPage.clickLoginButton();
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();

        Assert.assertEquals(editorPage.getUserEmailElement(), USERNAME,
                "User's email is incorrect");
    }

    @Test(priority = 2)
    public void writeNoteTest() {

        editorPage.clickCreateNewNote();
        editorPage.switchToIframe();
        editorPage.writeInTextField("Hello bro!");
        editorPage.switchToDefaultContent();
        editorPage.clickSignOut();
        editorPage.logOutConfirm();
        loginPage.enterUsername(USERNAME);
        loginPage.clickLoginButton();
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();
        editorPage.openNotesMenu();

        Assert.assertEquals(editorPage.getNotesCreationTime(), "Just now",
                "This is not the last note created");
    }

    @AfterClass
    private void deleteNote() {

        editorPage.openMoreActionsMenu();
        editorPage.clickDeleteButton();
    }
}
