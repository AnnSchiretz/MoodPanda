package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class AvatarPage extends BasePage {
    private static final String URL_AVATAR = "https://moodpanda.com/Account/Avatar/";
    private static final String TOOLBAR = "#ContentPlaceHolderContent_MyMoodPandaNav1_UserStats";
    private static final String CURRENT_IMG = "defaulticon.png";
    private static final String AVATAR_IMG = ".col-lg-12 input";
    private static final String MESSAGE_SUCCESS = "#ContentPlaceHolderContent_MessageSuccess";

    @Override
    public AvatarPage openPage() {
        open(URL_AVATAR);
        isPageOpen();
        screenshot("avatarOpenPage");
        return this;
    }

    @Override
    void isPageOpen() {
        $(TOOLBAR).shouldBe(Condition.visible);
        screenshot("avatarOpenPage");
        log.error("не видно элемента");
    }

    public AvatarPage changeImg(int numberImg) {
        $(AVATAR_IMG).shouldBe(Condition.visible);
        screenshot("avatarImages");
        List<SelenideElement> countImg = $$(AVATAR_IMG);
        for (int i = 0; i < countImg.size();) {
            countImg.get(numberImg).click();
            break;
        }
        $(MESSAGE_SUCCESS).shouldBe(Condition.visible);
        screenshot("successfulMessageAfterUpdate");
        return this;
    }
}
