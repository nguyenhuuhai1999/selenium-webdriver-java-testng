package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_16_Tab_Window {
    WebDriver driver;

    @Test
    public void TC_01_Tab_Window_ID() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInseconds(2);
        //driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        String parentWindow = driver.getWindowHandle();
        Set<String> allID = driver.getWindowHandles();
        for(String id : allID){
            if(!id.equals(parentWindow)){
                driver.switchTo().window(id);
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(),"Google");
        sleepInseconds(2);
        driver.close();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        parentWindow = driver.getWindowHandle();
        allID = driver.getWindowHandles();
        for(String id : allID){
            if(!id.equals(parentWindow)){
                driver.switchTo().window(id);
                break;
            }
        }
       // Assert.assertEquals(driver.getTitle(),"Facebook-login or sign up ");
        sleepInseconds(2);
        driver.close();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        parentWindow = driver.getWindowHandle();
        allID = driver.getWindowHandles();
        for(String id : allID){
            if(!id.equals(parentWindow)){
                driver.switchTo().window(id);
                break;
            }
        }
        sleepInseconds(4);
        driver.close();
        driver.switchTo().window(parentWindow);



    }

    @Test
    public void TC_02_Tab_Window_Tittle() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        Set<String> allID = driver.getWindowHandles();
        for(String id : allID){
            driver.switchTo().window(id);
            String actualTittle = driver.getTitle();
            if (actualTittle.equals("TIKI")){
                break;
            }
        }
        sleepInseconds(3);
        driver.close();
        allID = driver.getWindowHandles();
        for(String id : allID){
            driver.switchTo().window(id);
            String actualTittle = driver.getTitle();
            if (actualTittle.equals("Selenium WebDriver")){
                break;
            }
        }
    }

    @Test
    public void TC_03_Tab_Window_Tittle() {
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2[@class='product-name']/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        Assert.assertEquals( driver.findElement(By.xpath("//ul[@class='messages']//span")).getText(),"The product Sony Xperia has been added to comparison list.");
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2[@class='product-name']/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        Assert.assertEquals( driver.findElement(By.xpath("//ul[@class='messages']//span")).getText(),"The product Samsung Galaxy has been added to comparison list.");
        driver.findElement(By.xpath("//div[@class='actions']//button[@title='Compare']")).click();
        driver.getTitle();
        System.out.print(driver.getTitle());
        Set<String> allID = driver.getWindowHandles();
        for(String id : allID){
            driver.switchTo().window(id);
            String actualTittle = driver.getTitle();
            if(actualTittle.equals("Products Comparison List - Magento Commerce")){
                break;

            }
        }
        driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Close Window']")).click();
         allID = driver.getWindowHandles();
        for(String id : allID){
            driver.switchTo().window(id);
            String actualTittle = driver.getTitle();
            if(actualTittle.equals("Mobile")){
                break;

            }
        }
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Huu Hai");
        sleepInseconds(3);


    }

    @Test
    public void TC_04_Tab_Window_Tittle() {
        driver = new FirefoxDriver();
        driver.get("https://dictionary.cambridge.org/vi/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("//div[@amp-access='NOT loggedIn']//span[text()='Đăng nhập' and @class='tb']")).click();
        Set<String> allID = driver.getWindowHandles();
        for(String id : allID){
            driver.switchTo().window(id);
            String actualTittle = driver.getTitle();
            if (actualTittle.equals("Login")){
                break;
            }
        }
        sleepInseconds(3);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();



    }





    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}