package webdriver;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_08_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait expliciWait;

    @Test
    public void TC_01() {
        driver = new FirefoxDriver();
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // click vao dropdown
        driver.findElement(By.xpath("//span[@id='number-button']")).click();
        // thoi gian cho de loat ra het item
        expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='number-menu']//div")));
        // lay ra tat ca item
        List<WebElement> allItems = driver.findElements(By.xpath("//ul[@id='number-menu']//div"));
        // duyet qua all item
        for(WebElement item : allItems)
        {
            String text = item.getText();
            if (text.equals("13"))
            {
                item.click();
                break;
            }
        }
    }

    @Test
    public void TC_02() {
        driver = new FirefoxDriver();
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));//(quan trọng)
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        driver.findElement(By.xpath("//span[@id='number-button']")).click();
        List<WebElement> allItems =  expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='number-menu']//div")));
        for(WebElement item : allItems)
        {
            String text = item.getText();
            if(text.equals("10"))
            {
                item.click();
                break;

            }

        }

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(),"10");

    }

    @Test
    public void TC_03() {
        driver = new FirefoxDriver();
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));//(quan trọng)
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        driver.findElement(By.xpath("//span[@id='speed-button']")).click();
        List<WebElement> allItems =  expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='speed-menu']//div")));
        for(WebElement item : allItems)
        {
            String text = item.getText();
            if(text.equals("Slower"))
            {
                item.click();
                break;

            }
        }

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(),"Slower");

    }

    @Test
    public void TC_04() {
        driver = new FirefoxDriver();
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@class='search']")).sendKeys("Bel");
        List<WebElement> allItems =  expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='item']//span")));
        for(WebElement item : allItems)
        {
            String text = item.getText();
            if(text.equals("Belize"))
            {
                item.click();
                break;

            }
        }

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui fluid search selection dropdown']//div[@class='divider text']")).getText(),"Belize");

    }



    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}