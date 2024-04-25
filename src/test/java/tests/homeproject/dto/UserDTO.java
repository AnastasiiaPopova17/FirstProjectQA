package tests.homeproject.dto;

public class UserDTO {
    String firstName;
    String lastName;
       String email;
       String password;
    String confirmPassword;


    public UserDTO() {
    }
    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
    public UserDTO setConfirmPassword(String confirmPassword) {
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
