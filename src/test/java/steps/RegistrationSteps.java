package steps;

import io.qameta.allure.Step;
import models.Profile;
import pages.RegistrationPage;

public class RegistrationSteps {
    private RegistrationPage registration;

    public RegistrationSteps(){
        registration = new RegistrationPage();
    }

    @Step("registration user in Mood Panda")
    public RegistrationSteps userRegistration(Profile profile){
        registration.openPage()
                .addPersonalInfo(profile)
                .addEmailAndPassword(profile)
                .confirmRegistration();
        return this;
    }

    @Step("update mood after registration")
    public RegistrationSteps updateMoodInTimeRegistration(int moodRate){
        registration.updateWelcomeMood(moodRate);
        return this;
    }

    @Step("validation mood after registration ")
    public RegistrationSteps validation(){
        registration.validationMoodAfterRegistration();
        return this;
    }

}
