package tests.homeproject.dto;

public class UserDTO {
       String email;
       String password;


    public UserDTO() {
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }
}
