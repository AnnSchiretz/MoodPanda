package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyUpdatesPage extends BasePage {
    private static final String URL_MY_UPDATE = "https://moodpanda.com/Feed/?Me=1";
    private static final String TOOLBAR = "#ContentPlaceHolderContent_MyMoodPandaNav1_UserStats";
    private static final String UPDATE_MOOD = "#LinkUpdate";
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
}
