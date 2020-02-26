package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Profile;
import pages.EditProfilePage;
import pages.MyUpdatesPage;

@Log4j2
public class EditProfileSteps {
    private EditProfilePage editProfile;
    private MyUpdatesPage page;

    public EditProfileSteps(){
        editProfile = new EditProfilePage();
        page = new MyUpdatesPage();
    }
    @Step("User edit personal info")
    public EditProfileSteps editPersonalInfo(Profile profile){
        editProfile.openPage()
                .editFirstName(profile)
                .editSurname(profile)
                .editYearOfBirthday(profile)
                .editGender(profile)
                .updateDetails();
        return this;
    }
    @Step("User edit login details")
    public EditProfileSteps editLoginDetails(Profile profile){
        editProfile.openPage()
                .editEmailAddress(profile)
                .setNewPassword(profile)
                .updateDetails();
        return this;
    }
    @Step("User edit timezone settings")
    public EditProfileSteps editTimezoneSettings(Profile profile){
        editProfile.openPage()
                .setTimeZone(profile)
                .selectCountry(profile)
                .updateDetails();
        return this;
    }
    @Step("Validate after update personal info")
    public EditProfileSteps validationPersonalInfo(Profile profile){
        editProfile.openPage()
                .validationPersonalInfoAfterUpdate(profile);
        return this;
    }

    @Step("validation email after update")
    public EditProfileSteps validationEmail(Profile profile){
        editProfile.openPage()
                .validationForEmail(profile);
        return this;
    }

    @Step("validation timezone and country in settings")
    public EditProfileSteps validationTimezoneAndCountry(Profile profile){
        editProfile.openPage()
                .validationTimezone(profile);
        return this;
    }



}
