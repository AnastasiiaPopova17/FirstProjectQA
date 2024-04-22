package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    @Test
    public void createAccount() {
        // click on "Register": //a[@class='ico-register']
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        // fill first name: //input[@id='FirstName']
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        // fill last name: //input[@id='LastName']
        driver.findElement(By.xpath("//input[@id='LastName']"));
        // fill email: //input[@id='Email']
        driver.findElement(By.xpath("//input[@id='Email']"));
        // enter password: //input[@id='Password']
        driver.findElement(By.xpath("//input[@id='Password']"));
        // confirm password: //input[@id='ConfirmPassword']
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        // click register btn: //input[@id='register-button']
        driver.findElement(By.xpath("//input[@id='register-button']"));

    }

}
