package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.LogInPage;
import pages.MyUpdatesPage;

@Log4j2
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

    @Step("log out user")
    public LogInSteps logout(){
        MyUpdatesPage page = new MyUpdatesPage();
        page.logout();
        logInPage.openPage();
        return this;
    }

    @Step("log in user with incorrect email and password")
    public LogInSteps loginWithIncorrectEmail(String email,String password){
        logInPage.openPage()
                .sendIncorrectEmail(email,password);
        return this;
    }
}
