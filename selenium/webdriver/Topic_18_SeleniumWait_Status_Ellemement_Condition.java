package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_SeleniumWait_Status_Ellemement_Condition {
    WebDriver driver;
    WebDriverWait expliciWait;
    @Test
    public void TC_01_Visibility() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        expliciWait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.findElement(By.xpath("//div[@class='_6ltg']//a")).click();
        sleepInseconds(3);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("hainguyendiv@gmail.com");
        sleepInseconds(3);
        By confirmEmail = By.xpath("//input[@name='reg_email_confirmation__']");
        expliciWait.until(ExpectedConditions.visibilityOfElementLocated(confirmEmail));
        Assert.assertTrue(driver.findElement(confirmEmail).isDisplayed());


    }

    @Test
    public void TC_02_InVisibility() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        expliciWait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.findElement(By.xpath("//div[@class='_6ltg']//a")).click();
        sleepInseconds(3);
        By confirmEmail = By.xpath("//input[@name='reg_email_confirmation__']");
        expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(confirmEmail));
        Assert.assertFalse(driver.findElement(confirmEmail).isDisplayed());


    }

    @Test
    public void TC_03_Presence() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        expliciWait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.findElement(By.xpath("//div[@class='_6ltg']//a")).click();
        sleepInseconds(3);
//        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("hainguyendiv@gmail.com");
//        sleepInseconds(3);
        By confirmEmail = By.xpath("//input[@name='reg_email_confirmation__']");
        expliciWait.until(ExpectedConditions.presenceOfElementLocated(confirmEmail));
        Assert.assertFalse(driver.findElement(confirmEmail).isDisplayed());


    }

    @Test
    public void TC_04_Staless() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        expliciWait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.findElement(By.xpath("//div[@class='_6ltg']//a")).click();
        sleepInseconds(3);

        By confirmEmail = By.xpath("//input[@name='reg_email_confirmation__']");
        WebElement preConfirmEmail = driver.findElement(confirmEmail);
        sleepInseconds(2);
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        sleepInseconds(2);

        expliciWait.until(ExpectedConditions.stalenessOf(preConfirmEmail));




    }




    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}