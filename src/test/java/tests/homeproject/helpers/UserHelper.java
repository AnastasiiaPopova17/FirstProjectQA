package tests.homeproject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.homeproject.dto.UserDTO;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }
    By btnLogin = By.xpath("//input[@class='button-1 login-button']");
    By customerEmail = By.xpath("//a[@href='/customer/info' and @class='account']");
    By btnLoginNavBar = By.xpath("//a[@class='ico-login']");
    By emailText = By.xpath("//input[@id='Email']");
    By lastNameText = By.xpath("//input[@id='LastName']");
    By firstNameText = By.xpath("//input[@id='FirstName']");
    By passwordText = By.xpath("//input[@id='Password']");
    By confirmPasswordText = By.xpath("//input[@id='ConfirmPassword']");
    By btnRegister = By.xpath("//input[@id='register-button']");
    By btnRegisterNavBar = By.xpath("//a[@class='ico-register']");

    public WebElement getAllreadyRegisteredUserEmail() {
        return driver.findElement(customerEmail);
    }

       public void clickLoginBtn() {
        clickBase(btnLogin);
    }

    public void clickLoginOnNavBar() {
        clickBase(btnLoginNavBar);
    }

    public void login(UserDTO user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        clickLoginBtn();
    }
    public void addDataForRegistration(UserDTO registrationDTO) {
        fillFirstName(registrationDTO.getFirstName());
        fillLastName(registrationDTO.getLastName());
        fillEmail(registrationDTO.getEmail());
        fillPassword(registrationDTO.getPassword());
        confirmPasswordRegistration(registrationDTO.getConfirmPassword());
        clickRegisterBtn();
    }

    public void fillTextInEl(By by, String text) {
        WebElement element = driver.findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);

    }
    public void fillEmail(String email) {
        fillTextInEl(emailText,email);
    }

    public void fillLastName(String lastName) {
        fillTextInEl(lastNameText,lastName);
    }

    public void fillFirstName(String firstName) {
        fillTextInEl(firstNameText, firstName);
    }
    public void fillPassword(String password) {
        fillTextInEl(passwordText, password);
    }

    public void confirmPasswordRegistration(String confirmPassword) {
       fillTextInEl(confirmPasswordText,confirmPassword);

    }

    public void clickRegisterBtn() {
        clickBase(btnRegister);
    }
    public void clickRegisterOnNavBar() {
        clickBase(btnRegisterNavBar);
    }
}




