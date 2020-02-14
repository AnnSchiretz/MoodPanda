package steps;

import io.qameta.allure.Step;
import pages.MyUpdatesPage;

public class MoodSteps {
    MyUpdatesPage page;
    public MoodSteps(){
        page = new MyUpdatesPage();
    }
    @Step("Update mood to '{moodRate}' with comment '{comment}'")
    public MoodSteps updateMood(int moodRate, String comment){
        page.openPage()
                .clickUpdateMood()
                .updateMood(moodRate, comment);
        return this;
    }
}
