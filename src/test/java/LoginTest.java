import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    private static final String USERNAME = "andtest.1988@gmail.com";
    private static final String WRONG_USERNAME = "andtest.1988+vrongEmail@gmail.com";
    private static final String PASSWORD = "P@ssw0rd";


    @Test(priority = 0)
    public void wrongLoginTest() {

        loginPage.clickLoginLink().enterUsername(WRONG_USERNAME).clickLoginButton();

        Assert.assertEquals(loginPage.getWrongEmailErrorMessage(),
                "There is no account for the username or email you entered.",
                "incorrect error message");
    }

    @Test(priority = 1)
    public void loginTest() {

        loginPage.clearUsernameField().enterUsername(USERNAME).clickLoginButton().enterPassword(PASSWORD)
                .clickLoginButton();

        Assert.assertEquals(editorPage.getUserEmailElement(), USERNAME,
                "User's email is incorrect");
    }

    @Test
    public void myTest(){
        var third = "test";
        System.out.println(third);
    }
}
