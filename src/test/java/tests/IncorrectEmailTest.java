package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class IncorrectEmailTest extends BaseTest {
    @Test
    public void sendIncorrectEmail(){
        logInSteps.logout()
                .loginWithIncorrectEmail("dhuwqhduq@hyd.com", "1234565777");
    }
}
