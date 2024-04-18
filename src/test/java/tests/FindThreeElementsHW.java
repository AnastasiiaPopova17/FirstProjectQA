package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class FindThreeElementsHW {
    @Test
    public void hwTest() {
       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--lang=en");
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver(chromeOptions);

       driver.navigate().to("https://demowebshop.tricentis.com/");

        WebElement elementFooterDisclaimer =
                driver.findElement(By.className("footer-disclaimer"));
        System.out.println(elementFooterDisclaimer.getText());


        WebElement elementClassAccount =
                driver.findElement(By.className("account"));
        System.out.println(elementClassAccount.getText());


        List<WebElement> divElts =
                driver.findElements(By.tagName("div"));
        WebElement divEltHeader = divElts.get(8);
        System.out.println(divEltHeader.getAttribute("class"));

        driver.quit();
    }

}
