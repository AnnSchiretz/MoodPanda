package steps;

import io.qameta.allure.Step;
import pages.LogInPage;

public class LogInSteps  {
    private LogInPage logInPage;
    public LogInSteps(){
        logInPage = new LogInPage();
    }
    @Step("Log in user email {email} and password {password}")
    public LogInSteps login(String email,String password){
        logInPage.openPage()
                .logIn(email, password);
        return this;
    }
}
