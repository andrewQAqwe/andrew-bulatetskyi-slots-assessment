import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class EditorTest extends BaseTest {

    private static final String USERNAME = "andtest.1988@gmail.com";
    private static final String PASSWORD = "P@ssw0rd";


    @Test
    public void editorTest() {

        loginPage.clickLoginLink();
        loginPage.enterUsername(USERNAME);
        loginPage.clickLoginButton();
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();
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