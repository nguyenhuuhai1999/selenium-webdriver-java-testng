package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_00_Template {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Firefox() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }


    @Test
    public void TC_02_Run_On_Chrome() {
        driver = new ChromeDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.quit();
    }

    @Test
    public void TC_03_Run_On_Edge() {
        driver = new EdgeDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.quit();
    }
}