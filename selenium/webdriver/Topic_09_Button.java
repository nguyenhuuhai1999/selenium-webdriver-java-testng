package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_09_Button {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Firefox() {
        driver = new FirefoxDriver();
        driver.get("https://www.fahasa.com/customer/account/create");
        sleepInseconds(3);
        driver.findElement(By.xpath("//li[@class='popup-login-tab-item popup-login-tab-login']")).click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='fhs-btn-login']"));
        // verify button disable
        Assert.assertFalse(loginButton.isEnabled());
        String loginButtonBackgroundColor = driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).getCssValue("background-color");
        Color loginButtonColor = Color.fromString(loginButtonBackgroundColor);
        String loginButtonHexa = loginButtonColor.asHex().toLowerCase() ;
        System.out.println(loginButtonHexa);
        Assert.assertEquals(loginButtonHexa,"#000000");

        // nhap thong tin vào email va mat khau roi kt button
        driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("hainguyendiv@gmail.com");
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Hai@1999");
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).isEnabled());
        String loginButtonColorBg = driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).getCssValue("background-color")  ;
        Color LgButtonColor = Color.fromString(loginButtonColorBg) ;
        String LgButtonColorHexa = LgButtonColor.asHex().toLowerCase() ;
        System.out.println(LgButtonColorHexa);
        Assert.assertEquals(LgButtonColorHexa,"#c92127");
    }




    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}