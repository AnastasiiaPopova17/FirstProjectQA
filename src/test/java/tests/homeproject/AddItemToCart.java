package tests.homeproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {
    @BeforeClass
    public void precondition() {
        clickLoginOnNavBar();
        login(user);

    }


    @Test
    public void addItemInCart()  {
        clickAddItemToCart();
        clickShoppingCart();

        WebElement item = driver.findElement(By.xpath("//a[@class='product-name']"));
        String actualRes = getTextBase(item);
        Assert.assertEquals(actualRes, "14.1-inch Laptop");
    }

}
