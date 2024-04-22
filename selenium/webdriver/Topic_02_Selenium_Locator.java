package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Firefox() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/register");
        //driver.quit();
    }

    public void TC_02_ID() {

         driver.findElement(By.id("FirstName")).sendKeys("Huu Hai");
    }

}