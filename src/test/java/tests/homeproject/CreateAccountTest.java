package tests.homeproject;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.homeproject.dto.RegistrationDTO;

public class CreateAccountTest extends TestBase {
    @Test
    public void createAccount() {
        clickRegisterOnNavBar();
        RegistrationDTO registrationDTO = new RegistrationDTO().setFirstName("A")
                .setLastName("B")
                .setEmail("proba18@gmail.com")
                .setPassword("1234Qwer!")
                .setConfirmPassword("1234Qwer!");
        addDataForRegistration(registrationDTO);

        pause(3000);


        WebElement customerInfo = getCustomerInfo();
        String actualRes = getTextBase(customerInfo);


        Assert.assertEquals(actualRes, "proba18@gmail.com");
    }

}