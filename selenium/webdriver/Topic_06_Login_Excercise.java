package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_06_Login_Excercise {
    WebDriver driver;

    @Test
    public void TC_01_Login_With_Empty_Email_Password() {
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account' and text()='My Account'] ")).click();
        sleepInseconds(3);
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email'] ")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass'] ")).getText(),"This is a required field.");
    }

    @Test
    public void TC_02_Login_With_Invalid_Email() {
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account' and text()='My Account'] ")).click();
        sleepInseconds(3);
        // nhap sai dinh dang email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123456@124");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1234513115");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInseconds(3);
       Assert.assertEquals( driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void TC_03_Login_With_Password_5_Characters() {
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account' and text()='My Account'] ")).click();
        sleepInseconds(3);
        // nhap sai dinh dang email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hainguyendiv@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInseconds(3);
        Assert.assertEquals( driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_04_Login_With_Incorrect_Email_Password() {
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account' and text()='My Account'] ")).click();
        sleepInseconds(3);
        // nhap sai dinh dang email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hainguyendiv@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1231212426457568");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInseconds(3);
        Assert.assertEquals( driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),"Invalid login or password.");
    }

    @Test
    public void TC_05_Login_Success() {
        driver = new FirefoxDriver();
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account' and text()='My Account'] ")).click();
        sleepInseconds(3);
        driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();
        sleepInseconds(3);

        // dk 1 tk truoc
        String firstName="Huu Hai", lastName="Nguyen", emailAddress = getEmailAddress(), password="12345678";
        String fullName = lastName + " " + firstName;
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
        driver.findElement(By.xpath("//div[@class='buttons-set']//button[@class='button']")).click();
        sleepInseconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong ")).getText(),"Hello," + fullName+"!");
        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));
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