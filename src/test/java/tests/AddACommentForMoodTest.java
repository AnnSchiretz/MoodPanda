package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AddACommentForMoodTest extends BaseTest {
    @Test
    public void addAComment(){
        String comment = "kqxjmphjmjzqwqisspfx";
        String message = "8888";
        moodSteps.goToMyUpdates()
                .addAComment(comment, message);
    }
}
