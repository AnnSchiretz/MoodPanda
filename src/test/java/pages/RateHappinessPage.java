package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateHappinessPage extends BasePage {
    private static final String COMMENT = "#TextBoxUpdateMoodTag";
    private static final String SLIDER = "#slider-range-min";
    private static final String SLIDER_MOVE = ".ui-slider a";

    @Override
    @Deprecated
    public RateHappinessPage openPage() {
        isPageOpen();
        return this;
    }

    @Override
    void isPageOpen() {
        $(COMMENT).shouldBe(Condition.visible);
    }
    public RateHappinessPage updateMood(int moodRate, String  comment){
        $(SLIDER).click();
        int difference = moodRate - 5;
        Keys key;
        if(difference < 0){
            key = Keys.ARROW_LEFT;
        } else {
            key = Keys.ARROW_RIGHT;
        }
        for(int i = 0; i < Math.abs(difference); i++){
            $(SLIDER_MOVE).sendKeys(key);
        }
        return this;
    }
}
