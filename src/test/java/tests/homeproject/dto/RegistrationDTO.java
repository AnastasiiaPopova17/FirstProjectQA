package tests.homeproject.dto;

public class RegistrationDTO {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  String confirmPassword;

    public RegistrationDTO() {
    }

    public RegistrationDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public RegistrationDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }

    public String getConfirmPassword() {

        return confirmPassword;
    }
}
