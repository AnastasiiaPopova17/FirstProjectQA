package tests.homeproject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.homeproject.config.ApplicationManager;
import tests.homeproject.dto.RegistrationDTO;

public class RegistrationHelper extends BaseHelper{
    public RegistrationHelper(WebDriver driver) {
        super(driver);
    }
    public void addDataForRegistration(RegistrationDTO registrationDTO) {
        fillFirstName(registrationDTO.getFirstName());
        fillLastName(registrationDTO.getLastName());
        fillEmail(registrationDTO.getEmail());
        fillPasswordOnLogin(registrationDTO.getPassword());
        confirmPasswordRegistration(registrationDTO.getConfirmPassword());
        clickRegisterBtn();
    }

    public void fillTextInElt(By by, String text) {
        WebElement element = ApplicationManager.getDriver().findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);

    }
    public void fillEmail(String email) {
        fillTextInElt(By.xpath("//input[@id='Email']"),email);
    }

    public void fillLastName(String lastName) {
        fillTextInElt(By.xpath("//input[@id='LastName']"),lastName);
    }

    public void fillFirstName(String firstName) {
        fillTextInElt(By.xpath("//input[@id='FirstName']"), firstName);
    }
    public void fillPasswordOnLogin(String password) {
        fillTextInElt(By.xpath("//input[@id='Password']"), "1234Qwer!");
    }
    public void fillEmailOnLogin(String email) {
        fillTextInElt(By.xpath("//input[@id='Email']"), "proba19@gmail.com");
    }
    public void confirmPasswordRegistration(String confirmPassword) {
        fillTextInElt(By.xpath("//input[@id='ConfirmPassword']"),confirmPassword);

    }

    public void clickRegisterBtn() {
        ApplicationManager.getDriver().findElement(By.xpath("//input[@id='register-button']")).click();
    }
    public void clickRegisterOnNavBar() {
        ApplicationManager.getDriver().findElement(By.xpath("//a[@class='ico-register']")).click();
    }
}
