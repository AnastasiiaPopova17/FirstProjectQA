package tests.homeproject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartHelper extends BaseHelper{
    public ShoppingCartHelper(WebDriver driver) {
        super(driver);
    }
    public void clickShoppingCart() {
        driver.findElement(By.xpath("//div[@class='footer']//a[@class='ico-cart']")).click();
    }
    public void clickAddItemToCart() {
//        ApplicationManager.getDriver().findElement(By.cssSelector("[onclick*='/addproducttocart/catalog/31/1/1']")).click();
       driver.findElements(By.xpath("//input[@value='Add to cart']"))
                .get(1).click();
    }
    public WebElement getShoppingCartEl() {
        return driver.findElement(By.xpath("//a[@class='product-name']"));

    }
}
