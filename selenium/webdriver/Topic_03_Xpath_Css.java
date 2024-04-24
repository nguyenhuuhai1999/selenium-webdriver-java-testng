package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Css {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Firefox() {
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.quit();
    }

    @Test
    public void TC_Register_01_Empty_Daata(){

        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
    }

}