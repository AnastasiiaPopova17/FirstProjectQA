package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    @Test
    public void createAccount() throws InterruptedException {
        // click on "Register": //a[@class='ico-register']
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        // fill first name: //input[@id='FirstName']
        fillTextInElt(By.xpath("//input[@id='FirstName']"), "A");

        // fill last name: //input[@id='LastName']
        fillTextInElt(By.xpath("//input[@id='LastName']"),"B");

        // fill email: //input[@id='Email']
        fillTextInElt(By.xpath("//input[@id='Email']"),"proba15@gmail.com");

        // enter password: //input[@id='Password']
        fillTextInElt(By.xpath("//input[@id='Password']"),"1234Qwer!");

        // confirm password: //input[@id='ConfirmPassword']
        fillTextInElt(By.xpath("//input[@id='ConfirmPassword']"),"1234Qwer!");

        // click register btn: //input[@id='register-button']
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        Thread.sleep(3000);

        // validation by customer info //a[@href='/customer/info' and @class='account']
        WebElement customerInfo =
                driver.findElement(By.xpath("//a[@href='/customer/info' and @class='account']"));
        String actualRes = customerInfo.getText().trim();

        Assert.assertEquals(actualRes, "proba15@gmail.com");
    }
}