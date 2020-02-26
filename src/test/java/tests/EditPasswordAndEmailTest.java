package tests;

import models.Profile;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class EditPasswordAndEmailTest extends BaseTest {
    @Test
    public void editEmailAndPassword(){
        String newEmail = "1111111@mailinator.com";
        String newPassword = "1234567890";
        String newEmail1 = "schirets@mailinator.com";
        String newPassword1 = "12345678";
        Profile profile = new Profile(newEmail, newPassword);
        Profile profile1 = new Profile(newEmail1, newPassword1);
        editProfile.editLoginDetails(profile)
                .validationEmail(profile);
        logInSteps.logout()
                .login(newEmail, newPassword);
        editProfile.editLoginDetails(profile1);
    }
}
