package tests.homeproject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.homeproject.dto.RegistrationDTO;

public class CreateAccountTest extends TestBase {
    @Test
    public void createAccount() {
        app.getRegistrationHelper().clickRegisterOnNavBar();
        RegistrationDTO registrationDTO = new RegistrationDTO().setFirstName("A")
                .setLastName("B")
                .setEmail("proba21@gmail.com")
                .setPassword("1234Qwer!")
                .setConfirmPassword("1234Qwer!");
        app.getRegistrationHelper().addDataForRegistration(registrationDTO);

        app.getRegistrationHelper().pause(3000);

        WebElement customerInfo = app.getUserHelper().getCustomerInfo();
        String actualRes = app.getUserHelper().getTextBase(customerInfo);


        Assert.assertEquals(actualRes, "proba21@gmail.com");
    }

}