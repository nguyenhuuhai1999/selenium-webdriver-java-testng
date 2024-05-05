package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.UploadFile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_20_ExplicitWait {
    WebDriver driver;
    WebDriverWait explicitWait;

    @Test
    public void TC_01_ExplicitWait_InVisible() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/dynamic-loading/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='start']//button "))).click();
        // wait cho iconloading bien matex
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']//img ")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")).getText(),"Hello World!");


    }

    @Test
    public void TC_02_ExplicitWait_Visible() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/dynamic-loading/");

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='start']//button "))).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")).getText(),"Hello World!");

    }

    @Test
    public void TC_03_ExplicitWait() {
        driver = new FirefoxDriver();
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='calendarContainer']")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='RadAjaxPanel']//span")).getText(),"No Selected Dates to display.");
        driver.findElement(By.xpath("//a[text()='15']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='raDiv']"))));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='RadAjaxPanel']//span[text()='Wednesday, May 15, 2024']")).getText(),"Wednesday, May 15, 2024");

    }

    @Test
    public void TC_04_ExplicitWait() {
        driver = new FirefoxDriver();
        driver.get("https://gofile.io/welcome");
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String dnName = "danang.png";
        String hpName = "haiphong.jpg";

        String dnPath = projectPath + File.separator + "UploadFile" + File.separator + dnName;
        String hpPath = projectPath + File.separator + "UploadFile" + File.separator + hpName;

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']")));
        driver.findElement(By.xpath("//div[@class='col-auto']//button")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']")));
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(dnPath + "\n" + hpPath);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']")));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress"))));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-6 text-center']//a"))).click();
//        driver.findElement(By.xpath("//div[@class='col-6 text-center']//a")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']")));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+ dnName +"']/ancestor::div/following-sibling::div[@class='col-md text-center text-md-end px-0']//span[text()='Download']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+ dnName +"']/ancestor::div/following-sibling::div[@class='col-md text-center text-md-end px-0']//span[text()='Play']")).isDisplayed());




    }




    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}