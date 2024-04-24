package tests.homeproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.homeproject.dto.RegistrationDTO;
import tests.homeproject.dto.UserDTO;

import java.time.Duration;

public class TestBase {
    static WebDriver driver;
    UserDTO user = new UserDTO().setEmail("proba17@gmail.com").setPassword("1234Qwer!");
    @BeforeSuite
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        // imlicit waiting's
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }
    @AfterSuite
    public void tearDown() {

        driver.quit();
    }
    public void fillTextInElt(By by, String text) {
        WebElement element = driver.findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    public String getTextBase(WebElement element) {
        return element.getText().trim();

    }

    public WebElement getCustomerInfo() {
        return driver.findElement(By.xpath("//a[@href='/customer/info' and @class='account']"));

    }

    public void clickLoginBtn() {
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
    }

    public void clickLoginOnNavBar() {
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
    }

    public void fillPasswordOnLogin(String password) {
        fillTextInElt(By.xpath("//input[@id='Password']"), "1234Qwer!");
    }

    public void fillEmailOnLogin(String email) {
        fillTextInElt(By.xpath("//input[@id='Email']"), "proba18@gmail.com");
    }

    public void login(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        fillPasswordOnLogin(user.getPassword());
        clickLoginBtn();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDataForRegistration(RegistrationDTO registrationDTO) {
        fillFirstName(registrationDTO.getFirstName());
        fillLastName(registrationDTO.getLastName());
        fillEmail(registrationDTO.getEmail());
        fillPasswordOnLogin(registrationDTO.getPassword());
        confirmPasswordRegistration(registrationDTO.getConfirmPassword());
        clickRegisterBtn();
    }

    public void confirmPasswordRegistration(String confirmPassword) {
        fillTextInElt(By.xpath("//input[@id='ConfirmPassword']"),confirmPassword);
    }

    public void fillEmail(String email) {
        fillTextInElt(By.xpath("//input[@id='Email']"),email);
    }

    public void fillLastName(String lastName) {
        fillTextInElt(By.xpath("//input[@id='LastName']"),lastName);
    }

    public void fillFirstName(String firstName) {
        fillTextInElt(By.xpath("//input[@id='FirstName']"), firstName);
    }

    public void clickRegisterBtn() {
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
    }

    public void clickRegisterOnNavBar() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    }

    public void clickShoppingCart() {
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
    }

    public void clickAddItemToCart() {
        driver.findElement(By.cssSelector("[onclick*='/addproducttocart/catalog/31/1/1']")).click();
    }
}
