package tests;

import models.Profile;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class EditProfileTest extends BaseTest {
    @Test
    public void editProfile(){
        String userName = "feufhe";
        String surname = "F";
        String yearOfBirthday = "1990";
        String gender = "Bigender";
        String newEmail = "1111111@mailinator.com";
        String newPassword = "1234567890";
        String timezone = "3";
        String country = "Germany";

        Profile profile = new Profile(userName, surname, yearOfBirthday, gender,timezone, country,newEmail, newPassword);
        editProfile.editPersonalInfo(profile)
                .validationPersonalInfo(profile);
    }
}
