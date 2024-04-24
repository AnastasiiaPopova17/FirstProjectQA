package tests.homeproject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.homeproject.config.ApplicationManager;

public class ShoppingCartHelper extends BaseHelper{
    public ShoppingCartHelper(WebDriver driver) {
        super(driver);
    }
    public void clickShoppingCart() {
        ApplicationManager.getDriver().findElement(By.xpath("//span[text()='Shopping cart']")).click();
    }
    public void clickAddItemToCart() {
        ApplicationManager.getDriver().findElement(By.cssSelector("[onclick*='/addproducttocart/catalog/31/1/1']")).click();
    }
    public WebElement getShoppingCartElt() {
        return ApplicationManager.getDriver().findElement(By.xpath("//a[@class='product-name']"));

    }
}
