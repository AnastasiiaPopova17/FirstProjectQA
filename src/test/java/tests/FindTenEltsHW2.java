package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindTenEltsHW2 {
    WebDriver driver;
    @BeforeClass
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    @Test
    public void testCss() {
        WebElement byId1 = driver.findElement
                (By.cssSelector("#small-searchterms"));

        WebElement byClass2 = driver.findElement
                (By.cssSelector(".header-selectors-wrapper"));

        WebElement byAttrNameAndValue3 = driver.findElement
                (By.cssSelector("[action='/search']"));

        WebElement byAttrName4 = driver.findElement
                (By.cssSelector("[action]"));

        WebElement byAttrNameAndPartlyValue5 = driver.findElement
                (By.cssSelector("[action*='earc']"));

        WebElement byAttrNameAndStartsWithInValue6 = driver.findElement
                (By.cssSelector("[action^='/se']"));

        WebElement byAttrNameAndOverWithValue7 = driver.findElement
                (By.cssSelector("[action$='rch']"));

        WebElement byTagAndClassValue8 = driver.findElement
                (By.cssSelector("div.master-wrapper-content"));

        WebElement byTagIdValueAndClassValue9 = driver.findElement
                (By.cssSelector("div#bar-notification.bar-notification"));

        WebElement byTagIdAndAttr10 = driver.findElement
                (By.cssSelector("input#newsletter-email[type='text']"));

        WebElement twoAttrSearc1 = driver.findElement
                (By.xpath("//div[@id='newsletter-subscribe-block' and @class='newsletter-subscribe-block']"));

        WebElement twoAttrSearch2 = driver.findElement
                (By.xpath("//div[@id='bar-notification' and @class='bar-notification']"));

        WebElement byPartialText3 = driver.findElement
                (By.xpath("//div[contains(text(),'items in your')]"));

        WebElement byTagAndAttr4 = driver.findElement
                (By.xpath("//div[@class='count']"));

        WebElement byTagAndAttr5 = driver.findElement
                (By.xpath("//*[@class='mini-shopping-cart']"));

        WebElement byTextContains6 = driver.findElement
                (By.xpath("//div[contains(text(),'You have no')]"));

        WebElement byTextStartsWith7 = driver.findElement
                (By.xpath("//a[starts-with(.,'Digital')]"));

        WebElement byTagAndAttr8 = driver.findElement
                (By.xpath("//div[@class='master-wrapper-page']"));

        WebElement byText9 = driver.findElement
                (By.xpath("//p[text()='Welcome to the new Tricentis store!']"));

        WebElement byStartsWithText10 = driver.findElement
                (By.xpath("//p[starts-with(.,'Feel free to')]"));

        WebElement byPartialText11 = driver.findElement
                (By.xpath("//div[contains(.,'Tricentis')]"));

        WebElement byPartialText12 = driver.findElement
                (By.xpath("//div[contains(.,'shop around and explore')]"));

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
