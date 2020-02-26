package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import models.Profile;
import org.openqa.selenium.By;
import steps.EditProfileSteps;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class EditProfilePage extends BasePage {
    private static final String URL_EDIT_MODAL = "https://moodpanda.com/Account/";
    private static final String EDIT_MODAL = ".graph";
    private static final String EDIT_FIRST_NAME = "#ContentPlaceHolderContent_TextBoxFirstname";
    private static final String EDIT_SURNAME = "#ContentPlaceHolderContent_TextBoxSurname";
    private static final String EDIT_YEAR_OF_BIRTHDAY = "#ContentPlaceHolderContent_DropDownListYearOfBirth";
    private static final String EDIT_GENDER = "#ContentPlaceHolderContent_DropDownListGender";
    private static final String EDIT_EMAIL = "#ContentPlaceHolderContent_TextBoxEmail";
    private static final String NEW_PASSWORD = "#ContentPlaceHolderContent_TextBoxNewPassword";
    private static final String CONFIRM_NEW_PASSWORD = "#ContentPlaceHolderContent_TextBoxNewPasswordConfirm";
    private static final String SET_TIMEZONE = "#ContentPlaceHolderContent_DropDownListTimeZone";
    private static final String SELECT_COUNTRY = "#ContentPlaceHolderContent_DropDownListCountry";
    private static final String UPDATE_DETAILS = "#ContentPlaceHolderContent_ButtonSave";
    private static final String UPDATE_SUCCESS = "#ContentPlaceHolderContent_MessageSuccess";

    @Override
    public EditProfilePage openPage() {
        open(URL_EDIT_MODAL);
        isPageOpen();
        return this;
    }

    @Override
    void isPageOpen() {
        $(EDIT_MODAL).shouldBe(Condition.visible);
        screenshot("editPage");
        log.error("не видно элемента");
    }
    public EditProfilePage editFirstName(Profile profile){
        $(EDIT_FIRST_NAME).clear();
        $(EDIT_FIRST_NAME).sendKeys(profile.getUserName());
        screenshot("editFirstName");
        return this;
    }
    public EditProfilePage editSurname (Profile profile){
        $(EDIT_SURNAME).clear();
        $(EDIT_SURNAME).sendKeys(profile.getSurname());
        screenshot("editSurname");
        return this;
    }
    public EditProfilePage editYearOfBirthday(Profile profile){
        $(EDIT_YEAR_OF_BIRTHDAY).click();
        log.error("не был совершен клик по элементу");
        $(EDIT_YEAR_OF_BIRTHDAY).selectOptionContainingText(profile.getYearOfBirthday());
        screenshot("editBirthday");
        return this;
    }
    public EditProfilePage editGender(Profile profile){
        $(EDIT_GENDER).click();
        log.error("не был совершен клик по элементу");
        $(EDIT_GENDER).selectOptionContainingText(profile.getGender());
        screenshot("editGender");
        return this;
    }
    public EditProfilePage editEmailAddress(Profile profile){
        $(EDIT_EMAIL).clear();
        $(EDIT_EMAIL).sendKeys(profile.getEmail());
        screenshot("editEmail");
        return this;
    }
    public EditProfilePage setNewPassword(Profile profile){
        $(NEW_PASSWORD).sendKeys(profile.getNewPassword());
        $(CONFIRM_NEW_PASSWORD).sendKeys(profile.getNewPassword());
        screenshot("editPassword");
        return this;
    }
    public EditProfilePage setTimeZone(Profile profile){
        $(SET_TIMEZONE).click();
        log.error("не был совершен клик по элементу");
        $(SET_TIMEZONE).selectOption(profile.getTimezone());
        screenshot("editTimezone");
        return this;
    }
    public EditProfilePage selectCountry (Profile profile){
        $(SELECT_COUNTRY).click();
        log.error("не был совершен клик по элементу");
        $(SELECT_COUNTRY).selectOptionContainingText(profile.getCountry());
        screenshot("editCountry");
        return this;
    }
    public EditProfilePage updateDetails(){
        $(UPDATE_DETAILS).click();
        log.error("не был совершен клик по элементу");
        $(UPDATE_SUCCESS).shouldBe(Condition.visible);
        screenshot("updateMessageInProfile");
        log.error("не видно элемента");
        return this;
    }
    public EditProfilePage validationPersonalInfoAfterUpdate(Profile profile){
        assertEquals($(EDIT_FIRST_NAME).getValue(), profile.getUserName());
        log.error("Не сошлись данные имени пользователя, что после обновления и того, что вводил юзер");
        screenshot("validationFirstNameInProfilePage");
        assertEquals($(EDIT_SURNAME).getValue(), profile.getSurname().toLowerCase());
        screenshot("validationSurnameInProfilePage");
        log.error("Не сошлись фамилии пользователя, что после обновления и того, что вводил юзер");
        assertEquals($(EDIT_YEAR_OF_BIRTHDAY).getValue(), profile.getYearOfBirthday());
        screenshot("validationYearBirthdayInProfilePage");
        log.error("Не сошлись даты рождения, что после обновления и того, что вводил юзер");
        assertEquals($(EDIT_GENDER).getText(), profile.getGender());
        screenshot("validationGenderInProfilePage");
        log.error("Не сошлись гендеры, что после обновления и того, что вводил юзер");
        return this;
    }
    public EditProfilePage validationForEmail(Profile profile){
        assertEquals($(EDIT_EMAIL).getValue(), profile.getEmail());
        screenshot("validationEmailInProfilePage");
        log.error("не сошелся почтовый ящик после изменения");
        return this;
    }
    public EditProfilePage validationTimezone(Profile profile){
        assertEquals($(SELECT_COUNTRY).getText(), profile.getCountry());
        screenshot("validationCountryInProfilePage");
        log.error("не произошло изменение страны");
        assertEquals($(SET_TIMEZONE).getText(),profile.getTimezone());
        screenshot("validationTimezoneInProfilePage");
        log.error("не произошла смена таймзоны");
        return this;
    }

}
