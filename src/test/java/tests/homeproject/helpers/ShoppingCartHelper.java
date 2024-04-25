package tests.homeproject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartHelper extends BaseHelper{
    public ShoppingCartHelper(WebDriver driver) {
        super(driver);
    }
    By shoppingCartFooter = By.xpath("//div[@class='footer']//a[@class='ico-cart']");
    By shoppingCartEl = By.xpath("//a[@class='product-name']");
    public void clickShoppingCart() {
        clickBase(shoppingCartFooter);
    }
    public void clickAddItemToCart() {
       driver.findElements(By.xpath("//input[@value='Add to cart']"))
                .get(1);
    }
    public WebElement getShoppingCartEl() {
        return driver.findElement(shoppingCartEl);
    }
}
