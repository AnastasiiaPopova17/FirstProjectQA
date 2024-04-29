package tests.homeproject.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.homeproject.dto.UserDTO;
import tests.homeproject.utils.DataProviders;

import java.util.Random;

public class CreateAccount extends TestBase {

    @Test
    public void createAccount() {
        Random random = new Random();
        String randomEmail = String.valueOf(random.nextInt(1000));
        String randomPassword = String.valueOf(random.nextInt(10000));
        app.getUserHelper().clickRegisterOnNavBar();
        UserDTO user1 = new UserDTO().setFirstName("A")
                .setLastName("B")
                .setEmail(randomEmail + "proba@gmail.com")
                .setPassword(randomPassword + "Qwer!")
                .setConfirmPassword(randomPassword + "Qwer!");

        app.getUserHelper().addDataForRegistration(user1);

        app.getUserHelper().pause(3000);

        WebElement customerInfo = app.getUserHelper().getAllreadyRegisteredUserEmail();
        String actualRes = app.getUserHelper().getTextBase(customerInfo);

        Assert.assertEquals(actualRes, user1.getEmail());
        app.getUserHelper().clickLogoutBtn();
    }

    @Test(dataProvider = "addNewAccount", dataProviderClass = DataProviders.class)
    public void createDataProviderAccount(String firstName,String lastName,
                                          String email,String password,String confirmPassword)
    {
        app.getUserHelper().clickRegisterOnNavBar();
        UserDTO user1 = new UserDTO().setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword);

        app.getUserHelper().addDataForRegistration(user1);

        app.getUserHelper().pause(3000);

        WebElement customerInfo = app.getUserHelper().getAllreadyRegisteredUserEmail();
        String actualRes = app.getUserHelper().getTextBase(customerInfo);
        app.getUserHelper().clickLogoutBtn();

//        Assert.assertEquals(actualRes, user1.getEmail());
    }

    @Test(dataProvider = "addAccountsCSVFile", dataProviderClass = DataProviders.class)
            public void createDataProviderAccountCSV(UserDTO userDTO)

    {
        app.getUserHelper().clickRegisterOnNavBar();

        app.getUserHelper().addDataForRegistration(userDTO);

        app.getUserHelper().pause(3000);

        WebElement customerInfo = app.getUserHelper().getAllreadyRegisteredUserEmail();
        String actualRes = app.getUserHelper().getTextBase(customerInfo);
        app.getUserHelper().clickLogoutBtn();

//        Assert.assertEquals(actualRes, user1.getEmail());
    }
}