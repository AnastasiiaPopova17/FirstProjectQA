package tests.homeproject.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import tests.homeproject.helpers.ShoppingCartHelper;
import tests.homeproject.helpers.UserHelper;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser;

    ShoppingCartHelper shoppingCartHelper;
    UserHelper userHelper;


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
        if (browser.equals("chrome")) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("firefox")) {
            //driver = new FirefoxDriver();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equals("edge")) {
            // driver = new EdgeDriver();
            EdgeOptions edgeOptionsOptions = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptionsOptions);
        } else if (browser != null && browser != "chrome" && browser != "firefox" && browser != "edge") {
            throw new IllegalArgumentException("browser entered not correct!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://demowebshop.tricentis.com/");

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
