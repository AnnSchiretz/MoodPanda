package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AddHugForMoodTest extends BaseTest {
    @Test
    public void addHug(){
        String comment = "lipmfocxfmyzwybueaji";
        moodSteps.goToMyUpdates()
                .addHug(comment);
    }
}