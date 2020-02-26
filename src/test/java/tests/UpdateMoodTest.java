package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class UpdateMoodTest extends BaseTest {
    @Test
    public void updateMood(){
        int date = (int) (Math.random()* 9);
        String comment = randomMessage();
        moodSteps.updateMood(4,comment, String.valueOf(date));
    }
    private String randomMessage(){
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        int count = 20;
        for (int i = 0; i < count; i++) {
            randomString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return randomString.toString();
    }
}
