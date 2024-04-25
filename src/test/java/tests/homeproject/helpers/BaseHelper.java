package tests.homeproject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextBase(WebElement element) {
        return element.getText().trim();

    }
    protected void clickBase(By by) {
        findElementBase(by).click();
    }
    protected WebElement findElementBase(By by) {
        System.out.println("Locator: findElement: " + by.toString());
        return driver.findElement(by);
    }
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
