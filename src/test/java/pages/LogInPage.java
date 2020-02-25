package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class LogInPage extends BasePage {
    private static final String URL = "https://moodpanda.com/Login/";
    private static final String LOGIN_BUTTON = "#ContentPlaceHolderContent_ButtonLogin";
    private static final String EMAIL_INPUT = "#ContentPlaceHolderContent_TextBoxEmail";
    private static final String PASSWORD_INPUT = "#ContentPlaceHolderContent_TextBoxPassword";
    private static final String LOGIN_MODAL = "#ContentPlaceHolderContent_AppStore";
    private static final String MESSAGE_ERROR ="#ContentPlaceHolderContent_MessageError";

    @Override
    public LogInPage openPage() {
        open(URL);
        isPageOpen();
        return this;
    }

    @Override
    void isPageOpen() {
        sleep(500);
        $(LOGIN_MODAL).shouldBe(Condition.visible);
    }

    public LogInPage logIn(String email, String password){
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return this;
    }
    public LogInPage sendIncorrectEmail(String email, String password){
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
        $(MESSAGE_ERROR).shouldBe(Condition.visible);
        return this;
    }

}
