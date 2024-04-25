package tests.homeproject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.homeproject.config.ApplicationManager;
import tests.homeproject.dto.UserDTO;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public WebElement getCustomerInfo() {
        return driver.findElement(By.xpath("//a[@href='/customer/info' and @class='account']"));

    }

    public void clickLoginBtn() {
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
    }

    public void clickLoginOnNavBar() {
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
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
        WebElement element = ApplicationManager.getDriver().findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);

    }
    public void fillEmail(String email) {
        fillTextInEl(By.xpath("//input[@id='Email']"),email);
    }

    public void fillLastName(String lastName) {
        fillTextInEl(By.xpath("//input[@id='LastName']"),lastName);
    }

    public void fillFirstName(String firstName) {
        fillTextInEl(By.xpath("//input[@id='FirstName']"), firstName);
    }
    public void fillPassword(String password) {
        fillTextInEl(By.xpath("//input[@id='Password']"), password);
    }

    public void confirmPasswordRegistration(String confirmPassword) {
        fillTextInEl(By.xpath("//input[@id='ConfirmPassword']"),confirmPassword);

    }

    public void clickRegisterBtn() {
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
    }
    public void clickRegisterOnNavBar() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    }
}




