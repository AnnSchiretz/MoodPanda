package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import steps.LogInSteps;
import steps.MoodSteps;

public class BaseTest {
    LogInSteps logInSteps;
    MoodSteps moodSteps;
    @BeforeClass
    public void setupDriver(){
        //Configuration.headless = true;
        Configuration.timeout = 20000;
        //Configuration.clickViaJs = true;
        //Configuration.screenshots = true;
        logInSteps = new LogInSteps();
        moodSteps = new MoodSteps();
    }
}
