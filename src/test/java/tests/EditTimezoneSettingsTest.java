package tests;

import models.Profile;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class EditTimezoneSettingsTest extends BaseTest {
    @Test
    public void editTimezoneSettings(){
        String userName = "feufhe";
        String surname = "F";
        String yearOfBirthday = "1990";
        String gender = "Bigender";
        String timezone = "(GMT) Western Europe Time, London, Lisbon, Casablanca";
        String newEmail = "1111111@mailinator.com";
        String newPassword = "1234567890";
        String country = "Poland";
        Profile profile = new Profile(userName, surname, yearOfBirthday, gender,timezone, country,newEmail, newPassword);

        editProfile.editTimezoneSettings(profile)
                .validationTimezoneAndCountry(profile);
    }
}
