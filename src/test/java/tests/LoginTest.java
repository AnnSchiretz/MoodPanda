package tests;

import org.testng.annotations.Test;
import pages.MyUpdatesPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginUsingCorrectCredentials(){
        logInSteps.login("schirets@mailinator.com", "12345678");
        moodSteps.updateMood(9, "");
    }
}
