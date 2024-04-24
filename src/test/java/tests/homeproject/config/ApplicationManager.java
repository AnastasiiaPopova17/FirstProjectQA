package tests.homeproject.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tests.homeproject.helpers.RegistrationHelper;
import tests.homeproject.helpers.ShoppingCartHelper;
import tests.homeproject.helpers.UserHelper;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser;
    RegistrationHelper registrationHelper;
    ShoppingCartHelper shoppingCartHelper;
    UserHelper userHelper;

    public RegistrationHelper getRegistrationHelper() {
        return registrationHelper;
    }

    public ShoppingCartHelper getShoppingCartHelper() {
        return shoppingCartHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://demowebshop.tricentis.com/");

        registrationHelper = new RegistrationHelper(driver);
        shoppingCartHelper = new ShoppingCartHelper(driver);
        userHelper = new UserHelper(driver);
    }
    public  void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
