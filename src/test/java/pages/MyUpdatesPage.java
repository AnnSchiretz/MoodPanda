package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MyUpdatesPage extends BasePage {
    private static final String URL_MY_UPDATE = "https://moodpanda.com/Feed/?Me=1";
    private static final String TOOLBAR = "#ContentPlaceHolderContent_MyMoodPandaNav1_UserStats";
    private static final String UPDATE_MOOD = "#LinkUpdate";
    private static final String ACCOUNT = "//li[@id='Settings']/a";
    private static final String EDIT_PROFILE = "//a[contains(text(), 'Edit profile')]";
    private static final String CLICK_MYUPDATES = "//li[@id='LIMe']/a";
    private static final String USER_STATISTIC = "#ContentPlaceHolderContent_MyMoodPandaNav1_UserStats";
    @Override
   public MyUpdatesPage openPage() {
        open(URL_MY_UPDATE);
        isPageOpen();
        return this;
    }

    @Override
    void isPageOpen() {
        $(TOOLBAR).shouldBe(Condition.visible);
    }
    public RateHappinessPage clickUpdateMood(){
        $(UPDATE_MOOD).click();
        RateHappinessPage modal = new RateHappinessPage();
        modal.isPageOpen();
        return modal;
    }
    public EditProfilePage clickEditProfile(){
        $(ACCOUNT).click();
        $(By.linkText("Edit profile")).click();
        EditProfilePage editProfile = new EditProfilePage();
        editProfile.isPageOpen();
        return editProfile;
    }
    public RateHappinessPage goToMyMoods(){
        $(USER_STATISTIC).shouldBe(Condition.visible);
        RateHappinessPage modal = new RateHappinessPage();
        return modal;
    }
    public RateHappinessPage goToMyUpdates(){
        $(By.xpath(CLICK_MYUPDATES)).click();
        $(By.linkText("My updates")).click();
        RateHappinessPage modal = new RateHappinessPage();
        return modal;
    }
    public RateHappinessPage addAComment(String comment, String message){
        goToMyUpdates();
        RateHappinessPage modal = new RateHappinessPage();
        modal.addACommentToMyMood(comment, message);
        return modal;
    }
    public RateHappinessPage addHug(String comment){
        goToMyUpdates();
        RateHappinessPage modal = new RateHappinessPage();
        modal.addHug(comment);
        return modal;
    }
    public LogInPage logout(){
        $(By.xpath(ACCOUNT)).click();
        $(By.linkText("Logout")).click();
        LogInPage login = new LogInPage();
        login.openPage();
        return login;
    }
}
