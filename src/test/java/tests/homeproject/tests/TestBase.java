package tests.homeproject.tests;

import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import tests.homeproject.config.ApplicationManager;
import tests.homeproject.dto.UserDTO;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    static ApplicationManager app = new ApplicationManager(System
            .getProperty("browser", Browser.CHROME.browserName()));

    final static Logger logger = LoggerFactory.getLogger(TestBase.class);
    UserDTO user = new UserDTO()
            .setEmail("proba@gmail.com")
            .setPassword("1234Qwer!")
            .setFirstName("A")
            .setLastName("B")
            .setConfirmPassword("1234Qwer!");
    @BeforeSuite
    public static void startBrowser() {
        logger.info("run browser settings ");
        app.init();
    }
    @AfterSuite
    public static void tearDown() {
        logger.info("quit browser");
        app.quit();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] o) {
        logger.info("Start test: " + method.getName()
        + " with data " + Arrays.asList(o));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        }else {
            logger.error("FAILED " + result.getMethod().getMethodName());
        }
        logger.info("Stop test");
        logger.info("--------------------------------------");

    }
}

