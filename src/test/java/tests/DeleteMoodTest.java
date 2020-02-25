package tests;

import org.testng.annotations.Test;

public class DeleteMoodTest extends BaseTest {
    @Test
    public void deleteSomeMoods(){
        String comment = "rbdgkfgejjtjhnduygsw";
        String secondComment = "vuaxjszmlcgmvfckgbrr";
        moodSteps.goToMyUpdates();
        moodSteps.deleteMood(comment);
        moodSteps.deleteMood(secondComment);
    }
}
