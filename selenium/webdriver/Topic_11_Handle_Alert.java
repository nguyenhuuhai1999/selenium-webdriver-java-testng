package webdriver;

import org.openqa.selenium.Alert;
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

public class Topic_11_Handle_Alert {
    WebDriver driver;
    WebDriverWait expliciWait;

    @Test
    public void TC_01_Accept_Alert(){
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        expliciWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        expliciWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(result.getText(),"You clicked an alert successfully");
    }

    @Test
    public void TC_02_Confirm_Alert(){
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        expliciWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        expliciWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(result.getText(),"You clicked: Cancel");
    }

    @Test
    public void TC_03_Prompt_Alert(){
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        expliciWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        expliciWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        alert.sendKeys("Huu Hai");
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(result.getText(),"You entered: Huu Hai");
    }






    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}