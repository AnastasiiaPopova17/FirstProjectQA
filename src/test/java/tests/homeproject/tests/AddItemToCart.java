package tests.homeproject.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {
    @BeforeClass
    public void precondition() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().login(user);

    }

//    boolean flag = false;
//
//    @AfterMethod
//    public void methodPostCondition() {
//        if (flag) {
//            app.getUserHelper().clickLogoutBtn();
//            flag = false;
//        } else {
//            app.getUserHelper().clickOkAlert();
//        }
//        app.getUserHelper().navigateToHomePage();
//    }


    @Test
    public void addItemInCart()  {

        app.getShoppingCartHelper().clickAddItemToCart();
        app.getShoppingCartHelper().clickShoppingCart();

        WebElement item = app.getShoppingCartHelper().getShoppingCartEl();
        String actualRes = app.getShoppingCartHelper().getTextBase(item);
        Assert.assertEquals(actualRes, "14.1-inch Laptop");
        app.getUserHelper().clickLogoutBtn();
    }


}
