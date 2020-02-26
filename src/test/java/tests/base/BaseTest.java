package tests.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    public LogInSteps logInSteps;
    public MoodSteps moodSteps;
    public EditProfileSteps editProfile;
    public AvatarSteps avatar;
    public RegistrationSteps registration;
    @BeforeClass
    public void setupDriver(){
        Configuration.headless = true;
        Configuration.timeout = 15000;
        Configuration.clickViaJs = true;
        //Configuration.screenshots = true;
        logInSteps = new LogInSteps();
        moodSteps = new MoodSteps();
        editProfile = new EditProfileSteps();
        avatar = new AvatarSteps();
        registration = new RegistrationSteps();
    }
    @BeforeMethod
    public void login(){
        logInSteps.login("schirets@mailinator.com", "12345678");
    }
    @AfterMethod
    public void afterTest(){
        closeWebDriver();
    }
}
