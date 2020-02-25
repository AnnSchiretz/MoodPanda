package tests;

import org.testng.annotations.Test;

public class IncorrectEmailTest extends BaseTest {
    @Test
    public void sendIncorrectEmail(){
        logInSteps.logout()
                .loginWithIncorrectEmail("dhuwqhduq@hyd.com", "1234565777");
    }
}
