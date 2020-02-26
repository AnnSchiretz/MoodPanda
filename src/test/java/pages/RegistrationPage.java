package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.Profile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class RegistrationPage extends BasePage {
    private static final String URL = "https://moodpanda.com/Register/";
    private static final String REGISTRATION_FORM = "#UpdateMoodWelcome";
    private static final String ADD_FIRST_NAME = "#ContentPlaceHolderContent_TextBoxFirstName";
    private static final String ADD_SURNAME_INITIAL = "#ContentPlaceHolderContent_TextBoxSurname";
    private static final String ADD_GENDER = "#ContentPlaceHolderContent_DropDownListGender";
    private static final String ADD_YEAR_OF_BIRTHDAY = "#ContentPlaceHolderContent_DropDownListYearOfBirth";
    private static final String ADD_EMAIL = "#ContentPlaceHolderContent_TextBoxEmail";
    private static final String ADD_PASSWORD = "#ContentPlaceHolderContent_TextBoxPassword";
    private static final String CONFIRM_PASSWORD = "#ContentPlaceHolderContent_TextBoxPasswordConfirm";
    private static final String LOGIN = "#ContentPlaceHolderContent_ButtonLogin";
    private static final String WELCOME_MOOD_UPDATE = "#UpdateMoodWelcome";
    private static final String SLIDER = "#slider-range-minWelcome";
    private static final String SLIDER_MOVE = "#slider-range-minWelcome a";
    private static final String UPDATE_MOOD = ".ButtonUpdateWelcome";
    private static final String MOOD_AFTER_UPDATE = "//div[contains(@class,'rounded-top-corner')]//div[contains(@class,'MoodPostItem')]";

    @Override
    public RegistrationPage openPage() {
        open(URL);
        isPageOpen();
        return this;
    }

    @Override
    void isPageOpen() {
        $(REGISTRATION_FORM).shouldBe(Condition.visible);
        screenshot("registrationForm");
    }
    public RegistrationPage addPersonalInfo(Profile profile){
        $(ADD_FIRST_NAME).sendKeys(profile.getUserName());
        $(ADD_SURNAME_INITIAL).sendKeys(profile.getSurname());
        $(ADD_YEAR_OF_BIRTHDAY).click();
        $(ADD_YEAR_OF_BIRTHDAY).selectOptionContainingText(profile.getYearOfBirthday());
        screenshot("addRegistrationInfo");
        return this;
    }
    public RegistrationPage addEmailAndPassword(Profile profile){
        $(ADD_EMAIL).sendKeys(profile.getEmail());
        $(ADD_PASSWORD).sendKeys(profile.getNewPassword());
        $(CONFIRM_PASSWORD).sendKeys(profile.getNewPassword());
        screenshot("addRegistrationEmailAndPassword");
        return this;
    }
    public RegistrationPage confirmRegistration(){
        $(LOGIN).click();
        $(WELCOME_MOOD_UPDATE).shouldBe(Condition.visible);
        screenshot("welcomeMood");
        return this;
    }
    public RegistrationPage updateWelcomeMood(int moodRate){
        $(SLIDER).shouldBe(Condition.visible).click();
        screenshot("welcomeMood");
        int difference = moodRate - 5;
        Keys key;
        if(difference < 0){
            key = Keys.ARROW_LEFT;
        } else {
            key = Keys.ARROW_RIGHT;
        }
        for(int i = 0; i < Math.abs(difference); i++){
            $(SLIDER_MOVE).sendKeys(key);
            $(UPDATE_MOOD).click();
            screenshot("updateWelcomeMood");
            break;
        }
        return this;
    }
    public MyUpdatesPage validationMoodAfterRegistration (){
        MyUpdatesPage page = new MyUpdatesPage();
        page.isPageOpen();
        List<SelenideElement> moods = $$(By.xpath(MOOD_AFTER_UPDATE));
        assertEquals(String.valueOf(moods.size()), "3");
        screenshot("moodsAfterRegistration");
        return page;
    }
}
