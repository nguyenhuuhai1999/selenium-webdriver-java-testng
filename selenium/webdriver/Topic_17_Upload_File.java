package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.UploadFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_17_Upload_File {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Firefox_Upload_File() {
        driver = new ChromeDriver();
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String projectPath = System.getProperty("user.dir");

        String hpName = "haiphong.jpg";
        String dnName = "danang.png";
        String hueName = "hue.jpg";

        String hpFile = projectPath + File.separator + "UploadFile" + File.separator + hpName;
        String dnFile = projectPath + File.separator + "UploadFile" + File.separator + dnName;
        String dueFile = projectPath + File.separator + "UploadFile" + File.separator + hueName;

        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(hpFile);
        sleepInseconds(2);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(dnFile);
        sleepInseconds(2);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(dueFile);

        List<WebElement> starButtons = driver.findElements(By.xpath("//td//button[@class='btn btn-primary start']"));
        for(WebElement star : starButtons){
            star.click();
            sleepInseconds(2);
        }
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='name' and text()='danang.png']")).getText(),"danang.png");
//        Assert.assertTrue(driver.findElement(By.xpath("//td//p[text()='haiphong.jpg']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//td//p[text()='danang.png']")).isDisplayed());
        sleepInseconds(3);
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//td//button[@class='btn btn-danger delete']"));
        for(WebElement delete : deleteButtons){
            delete.click();
            sleepInseconds(2);
        }
    }

    @Test
    public void TC_02_Run_On_Firefox_Upload_File() {
        driver = new ChromeDriver();
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // lay duong dan cua project
        String projectPath = System.getProperty("user.dir");
        String dnName = "danang.png";
        String hpName = "haiphong.jpg";
        String hueName = "hue.jpg";
        String dnPath = projectPath + File.separator + "UploadFile" + File.separator + dnName;
        String hpPath = projectPath + File.separator + "UploadFile" + File.separator + hpName;
        String huePath = projectPath + File.separator + "UploadFile" + File.separator + hueName;

        // sendkye file len
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(dnPath);
        sleepInseconds(2);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(hpPath);
        sleepInseconds(2);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(huePath);
        sleepInseconds(2);

        // click vao button start
        List<WebElement> startButtons = driver.findElements(By.cssSelector("td button.start"));
        for(WebElement button : startButtons){
            button.click();
            sleepInseconds(2);
        }

        // kt load thanh cong
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='hue.jpg']")).isDisplayed());

    }





    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}