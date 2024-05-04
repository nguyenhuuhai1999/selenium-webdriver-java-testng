package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_14_Showdow_Dom {
    WebDriver driver;

    @Test
    public void TC_01_Shadow_Dom() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/shadow-dom/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext someTextShadowRoot = shadowHost.getShadowRoot();
        String someText = someTextShadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.print(someText);


        WebElement nestedTextShadow = someTextShadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedTextShadowRoot = nestedTextShadow.getShadowRoot();
        String nestedText = nestedTextShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        System.out.print(nestedText);

    }






    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}