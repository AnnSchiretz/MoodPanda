package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
@Log4j2
public class RateHappinessPage extends BasePage {
    private static final String COMMENT = "#TextBoxUpdateMoodTag";
    private static final String SLIDER = "#slider-range-min";
    private static final String SLIDER_MOVE = ".ui-slider a";
    private static final String COMMENT_TO_UPDATE_MOOD = "#TextBoxUpdateMoodTag";
    private static final String CLICK_CALENDAR = ".ResetOlder";
    private static final String CLICK_UPDATE = ".ButtonUpdate";
    private static final String DELETE_MOOD = ".rounded-top-corner .media-body .glyphicon-trash";
    private static final String BUTTON_HUG = ".ButtonHug";
    private static final String ADD_COMMENT = ".addcomment";
    private static final String INPUT_FOR_COMMENT = ".median-newcomment textarea";
    private static final String BUTTON_REPLY = "//a[contains(text(), 'Reply')]";
    private static final String COMMENT_FOR_MOOD = ".media-comment p";
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
    public RateHappinessPage updateMood(int moodRate, String  comment, String date){
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
        $(COMMENT_TO_UPDATE_MOOD).sendKeys(comment);
        $(CLICK_CALENDAR).click();
        $(By.xpath("//table[@class='ui-datepicker-calendar']//td/a[contains(text(),"+date+")]")).click();
        $(CLICK_UPDATE).click();
        refresh();
        return this;
    }

    public RateHappinessPage deleteMood(String comment){
        List<SelenideElement> moods = $$(By.xpath("//div[contains(@class,'rounded-top-corner')]//div[contains(@class,'MoodPostItem')]"));
        for (int i = 0; i < moods.size(); i++) {
            if(moods.get(i).getText().equals(comment)){
                List<SelenideElement> delete = $$(DELETE_MOOD);
                delete.get(i).click();
                refresh();
                $$(By.xpath("//div[@class ='MoodPostItem media-content']")).find(Condition.text(comment)).shouldNotBe(Condition.visible);
                log.error("не удалился муд");
            }
        }
        return this;
    }
    public RateHappinessPage addACommentToMyMood(String comment, String message){
        List<SelenideElement> moods = $$(By.xpath("//div[contains(@class,'rounded-top-corner')]//div[contains(@class,'MoodPostItem')]"));
        for (int i = 0; i < moods.size(); i++) {
            if (moods.get(i).getText().equals(comment)) {
                List<SelenideElement> delete = $$(ADD_COMMENT);
                delete.get(i).click();
                List<SelenideElement> input = $$(INPUT_FOR_COMMENT);
                input.get(i).sendKeys(message);
                List<SelenideElement> button = $$(By.xpath(BUTTON_REPLY));
                button.get(i).click();
                List<SelenideElement> commentArea = $$(COMMENT_FOR_MOOD);
                assertEquals(commentArea.get(i + 1).getText(), message, "");
                log.error("не совпал текст в сообщениях.");
            }
        }
        return this;
    }
    public RateHappinessPage addHug(String comment){
        List<SelenideElement> moods = $$(By.xpath("//div[contains(@class,'rounded-top-corner')]//div[contains(@class,'MoodPostItem')]"));
        for (int i = 0; i < moods.size(); i++) {
            if (moods.get(i).getText().equals(comment)) {
                List<SelenideElement> hug = $$(BUTTON_HUG);
                hug.get(i).click();
                refresh();
                String count = hug.get(i).getText();
                System.out.println(count);
                assertEquals(count.trim(), "Hug ( 1 )", "");
                log.error("не совпало число обнимашек");
            }
        }
        return this;
    }

}
