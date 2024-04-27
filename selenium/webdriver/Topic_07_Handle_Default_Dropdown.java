package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Topic_07_Handle_Default_Dropdown {
    WebDriver driver;

    @Test
    public void TC_01_Register() {
        String emailAddress = getEmailAddress();
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/register");

        //dang ky
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        sleepInseconds(3);
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Huu Hai");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nguyen");

        Select day = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))) ;
        //day.selectByVisibleText("1");
        Assert.assertEquals(day.getFirstSelectedOption().getText(),"1");
        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))) ;
        month.selectByVisibleText("May");
        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))) ;
        year.selectByVisibleText("1980");

        // verify so luong item trong dropdown la 32
        List<WebElement> dayOptions = day.getOptions() ;
        Assert.assertEquals(dayOptions.size(),32);

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Huu Hai");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1221426");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("1221426");

        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        sleepInseconds(3);
    }

    @Test
    public void TC_02_Login() {
        String emailAddress = getEmailAddress(), password = "1221426";
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        sleepInseconds(3);

       driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
       driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
       driver.findElement(By.xpath("//button[@class='login-button']")).click();
       sleepInseconds(3);



    }


    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress(){
        Random rand = new Random();
        String emailAddress = "nguyenhuuhai"+rand.nextInt(100000)+"@gmail.com";
        return emailAddress;
    }


}