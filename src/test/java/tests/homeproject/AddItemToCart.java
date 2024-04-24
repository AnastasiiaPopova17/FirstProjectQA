package tests.homeproject;

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
    @Test
    public void addItemInCart()  {
        app.getShoppingCartHelper().getShoppingCartElt();
        app.getShoppingCartHelper().clickShoppingCart();

        WebElement item = app.getShoppingCartHelper().getShoppingCartElt();
        String actualRes = app.getShoppingCartHelper().getTextBase(item);
        Assert.assertEquals(actualRes, "14.1-inch Laptop");
    }


}
