package tests;

import models.Profile;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class RegistrationOfMoodPandaTest extends BaseTest {
    @Test
    public void registration(){
        String userName = "feufhe";
        String surname = "Y";
        String yearOfBirthday = "1990";
        String newEmail = randomEmail() + "@hdu.com";
        String newPassword = "1234567890";
        Profile profile = new Profile(userName, surname,yearOfBirthday,newEmail, newPassword);
        logInSteps.logout();
        registration.userRegistration(profile)
                .updateMoodInTimeRegistration(4)
                .updateMoodInTimeRegistration(8)
                .updateMoodInTimeRegistration(6)
                .validation();
    }

    private String randomEmail() {
        String symbols = "abcdefqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        int count = 20;
        for (int i = 0; i < count; i++) {
            randomString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return randomString.toString();
    }

}
