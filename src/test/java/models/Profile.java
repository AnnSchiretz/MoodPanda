package models;

public class Profile {

    private String userName;
    private String surname;
    private String yearOfBirthday;
    private String gender;
    private String email;
    private String newPassword;
    private String timezone;
    private String country;

    public Profile(String userName, String surname, String yearOfBirthday, String gender,
                   String timezone, String country,String email, String newPassword){
        this.userName = userName;
        this.surname = surname;
        this.yearOfBirthday = yearOfBirthday;
        this.gender = gender;
        this.timezone = timezone;
        this.country = country;
        this.email = email;
        this.newPassword = newPassword;
    }
    public Profile(String userName, String surname, String yearOfBirthday,String email, String newPassword){
        this.userName = userName;
        this.surname = surname;
        this.yearOfBirthday = yearOfBirthday;
        this.email = email;
        this.newPassword = newPassword;
    }

    public Profile(String email, String newPassword){
        this.email = email;
        this.newPassword = newPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getYearOfBirthday() {
        return yearOfBirthday;
    }

    public void setYearOfBirthday(String yearOfBirthday) {
        this.yearOfBirthday = yearOfBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
