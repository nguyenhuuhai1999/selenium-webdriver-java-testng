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

    @Test
    public void TC_02_ID() {

         driver.findElement(By.id("FirstName")).sendKeys("Huu Hai");
    }

    @Test
    public void TC_03_Class() {

        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_04_Css() {
    /// id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));
    /// class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));
    // css vs name
        driver.findElement(By.cssSelector("input[name='FirstName']"));
        //css vs tagname
        driver.findElement(By.cssSelector("input"));
        //css vs link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));
        //css vs partial link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
    }

    @Test
    public void TC_05_Xpath() {
        /// id
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        /// class
        driver.findElement(By.xpath("//div[@class='page-title']"));
        // css vs name
        driver.findElement(By.xpath("//input[@name='FirstName']"));
        //css vs tagname
        driver.findElement(By.xpath("//input"));
        //css vs link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        //css vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
    }

}