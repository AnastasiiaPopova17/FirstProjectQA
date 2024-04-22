package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    @Test
    public void createAccount() throws InterruptedException {
        // click on "Register": //a[@class='ico-register']
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        // fill first name: //input[@id='FirstName']
        WebElement inputFirstName =
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        inputFirstName.click();
        inputFirstName.clear();
        inputFirstName.sendKeys("A");
        // fill last name: //input[@id='LastName']
        WebElement inputLastName =
        driver.findElement(By.xpath("//input[@id='LastName']"));
        inputLastName.click();
        inputLastName.clear();
        inputLastName.sendKeys("B");
        // fill email: //input[@id='Email']
        WebElement inputEmail =
        driver.findElement(By.xpath("//input[@id='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("proba10@gmail.com");
        // enter password: //input[@id='Password']
        WebElement inputPassw =
        driver.findElement(By.xpath("//input[@id='Password']"));
        inputPassw.click();
        inputPassw.clear();
        inputPassw.sendKeys("1234Qwer!");
        // confirm password: //input[@id='ConfirmPassword']
        WebElement inputCnfPassw =
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        inputCnfPassw.click();
        inputCnfPassw.clear();
        inputCnfPassw.sendKeys("1234Qwer!");
        // click register btn: //input[@id='register-button']
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        Thread.sleep(3000);

        WebElement registerElt =
                driver.findElement(By.xpath("//h1"));
        String actualRes = registerElt.getText().trim();
        Assert.assertEquals(actualRes, "Register");
    }

}
