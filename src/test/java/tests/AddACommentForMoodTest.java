package tests;

import org.testng.annotations.Test;

public class AddACommentForMoodTest extends BaseTest {
    @Test
    public void addAComment(){
        String comment = "xiyybhmacebgikgltswo";
        String message = "8888";
        moodSteps.goToMyUpdates()
                .addAComment(comment, message);
    }
}
