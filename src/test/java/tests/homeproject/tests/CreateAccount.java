package tests.homeproject.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.homeproject.dto.UserDTO;

public class CreateAccount extends TestBase {
    @Test
    public void createAccount() {
        app.getUserHelper().clickRegisterOnNavBar();

        UserDTO user1 = new UserDTO().setFirstName("A")
                .setLastName("B")
                .setEmail("proba02@gmail.com")
                .setPassword("1234Qwer!")
                .setConfirmPassword("1234Qwer!");

        app.getUserHelper().addDataForRegistration(user1);

        app.getUserHelper().pause(3000);

        WebElement customerInfo = app.getUserHelper().getAllreadyRegisteredUserEmail();
        String actualRes = app.getUserHelper().getTextBase(customerInfo);


        Assert.assertEquals(actualRes, user1.getEmail());
    }

}