package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase{
    @BeforeClass
            public void precondition() {
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        fillTextInElt(By.xpath("//input[@id='Email']"), "proba@gmail.com");
        fillTextInElt(By.xpath("//input[@id='Password']"), "1234Qwer!");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

    }
    @Test
    public void addItemInCart()  {
//        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")).click();
        driver.findElement(By.cssSelector("[onclick*='/addproducttocart/catalog/31/1/1']")).click();
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

        WebElement item = driver.findElement(By.xpath("//a[@class='product-name']"));
        String actualRes = item.getText().trim();
        Assert.assertEquals(actualRes, "14.1-inch Laptop");
    }
}
