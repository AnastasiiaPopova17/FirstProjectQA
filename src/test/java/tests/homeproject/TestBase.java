package tests.homeproject;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.homeproject.config.ApplicationManager;
import tests.homeproject.dto.UserDTO;

public class TestBase {
    static ApplicationManager app = new ApplicationManager(System
            .getProperty("browser", Browser.CHROME.browserName()));
    UserDTO user = new UserDTO().setEmail("proba21@gmail.com").setPassword("1234Qwer!");
    @BeforeSuite
    public static void startBrowser() {
        app.init();
    }
    @AfterSuite
    public void tearDown() {
        app.quit();
    }
}

