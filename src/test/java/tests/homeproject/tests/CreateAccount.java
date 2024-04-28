package tests.homeproject.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.homeproject.dto.UserDTO;
import tests.homeproject.utils.DataProviders;

public class CreateAccount extends TestBase {

    @Test
    public void createAccount() {
//        Random random = new Random();
//        String email = String.valueOf(random.nextInt(1000)) + "proba@gmail.com";
//        String password = String.valueOf(random.nextInt(10000)) + "Qwer!";
        app.getUserHelper().clickRegisterOnNavBar();
        UserDTO user1 = new UserDTO().setFirstName("A")
                .setLastName("B")
                .setEmail("proba034@gmail.com")
                .setPassword("1234Qwer!")
                .setConfirmPassword("1234Qwer!");

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