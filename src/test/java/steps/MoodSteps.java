package steps;

import io.qameta.allure.Step;
import pages.MyUpdatesPage;

public class MoodSteps {
    MyUpdatesPage page;
    public MoodSteps(){
        page = new MyUpdatesPage();
    }
    @Step("Update mood to '{moodRate}' with comment '{comment}'")
    public MoodSteps updateMood(int moodRate, String comment, String date){
        page.openPage()
                .clickUpdateMood()
                .updateMood(moodRate, comment, date);
        return this;
    }
    @Step("")
    public MoodSteps deleteMood(String comment){
        page.goToMyMoods()
            .deleteMood(comment);
        return this;
    }
    @Step("go to My updates")
    public MoodSteps goToMyUpdates(){
        page.goToMyUpdates();
        return this;
    }
    @Step()
    public MoodSteps addAComment(String comment, String message){
        page.addAComment(comment, message);
        return this;
    }
    @Step()
    public MoodSteps addHug(String comment){
        page.addHug(comment);
        return this;
    }
}
