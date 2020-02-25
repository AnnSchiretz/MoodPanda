package tests;

import models.Profile;
import org.testng.annotations.Test;

public class RegistrationOfMoodPandaTest extends BaseTest {
    @Test
    public void registration(){
        String userName = "feufhe44";
        String surname = "f";
        String yearOfBirthday = "1990";
        String newEmail = "11111888@mailinator.com";
        String newPassword = "1234567890";
        Profile profile = new Profile(userName, surname,yearOfBirthday,newEmail, newPassword);
        logInSteps.logout();
        registration.userRegistration(profile)
                .updateMoodInTimeRegistration(4)
                .updateMoodInTimeRegistration(8)
                .updateMoodInTimeRegistration(6)
                .validation();
    }

}
