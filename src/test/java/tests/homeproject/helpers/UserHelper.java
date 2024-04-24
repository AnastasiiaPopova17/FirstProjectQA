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
        return ApplicationManager.getDriver().findElement(By.xpath("//a[@href='/customer/info' and @class='account']"));

    }

    public void clickLoginBtn() {
        ApplicationManager.getDriver().findElement(By.xpath("//input[@class='button-1 login-button']")).click();
    }

    public void clickLoginOnNavBar() {
        ApplicationManager.getDriver().findElement(By.xpath("//a[@class='ico-login']")).click();
    }

    public void login(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        fillPasswordOnLogin(user.getPassword());
        clickLoginBtn();
    }

    public void fillPasswordOnLogin(String password) {
    }

    public void fillEmailOnLogin(String email) {
    }


}




