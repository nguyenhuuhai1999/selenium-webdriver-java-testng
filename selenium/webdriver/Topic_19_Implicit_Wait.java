package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_19_Implicit_Wait {
    WebDriver driver;


    @Test
    public void TC_01_Run_On_Firefox() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        driver.findElement(By.xpath("//div[@id='start']/button")).click();
//        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(),"Hello World!");

    }




    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}