package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class LogInPage extends BasePage {
    private static final String URL = "https://moodpanda.com/Login/";
    private static final String LOGIN_BUTTON = "#ContentPlaceHolderContent_ButtonLogin";
    private static final String EMAIL_INPUT = "#ContentPlaceHolderContent_TextBoxEmail";
    private static final String PASSWORD_INPUT = "#ContentPlaceHolderContent_TextBoxPassword";

    @Override
    public LogInPage openPage() {
        open(URL);
        isPageOpen();
        return this;
    }

    @Override
    void isPageOpen() {
        sleep(2000);
        $(LOGIN_BUTTON).shouldBe(Condition.visible);
    }

    public LogInPage logIn(String email, String password){

        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return this;
    }
}
