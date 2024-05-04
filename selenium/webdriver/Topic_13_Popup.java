package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Popup {
    WebDriver driver;

    @Test
    public void TC_01_Fixed_Popup() {
        driver = new FirefoxDriver();
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.xpath("//button[@class='login_ icon-before']")).click();
        sleepInseconds(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]")).isDisplayed());
        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//input[@id='account-input']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//input[@id='password-input']")).sendKeys("automationfc");
        sleepInseconds(3);
        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//button[@class='btn-v1 btn-login-v1 buttonLoading']")).click();
        sleepInseconds(1);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//div[@class='row error-login-panel']")).getText(),"Tài khoản không tồn tại!");
        sleepInseconds(2);
        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//button[@class='close']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]")).isDisplayed());

    }

    @Test
    public void TC_02_Popup_Not_In_Dom() {
        driver = new FirefoxDriver();
        driver.get("https://tiki.vn/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//div[@data-view-id='header_header_account_container']")).click();
        sleepInseconds(3);
       Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']")).isDisplayed());
       driver.findElement(By.xpath("//p[@class='login-with-email']")).click();
       sleepInseconds(1);
       driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
       sleepInseconds(1);
       Assert.assertEquals(driver.findElement(By.xpath("//input[@type='email']/parent::div[@class='input input-error']/following-sibling::span[1]")).getText(),"Email không được để trống");
       Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']/parent::div[@class='input input-error']/following-sibling::span")).getText(),"Mật khẩu không được để trống");
       sleepInseconds(2);
       driver.findElement(By.xpath("//img[@class='close-img']")).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       Assert.assertEquals(driver.findElements(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']")).size(),0);


//        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//input[@id='password-input']")).sendKeys("automationfc");
//        sleepInseconds(3);
//        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//button[@class='btn-v1 btn-login-v1 buttonLoading']")).click();
//        sleepInseconds(1);
//        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//div[@class='row error-login-panel']")).getText(),"Tài khoản không tồn tại!");
//        sleepInseconds(2);
//        driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]//button[@class='close']")).click();
//        Assert.assertFalse(driver.findElement(By.xpath("//div[@id='modal-login-v1' and @style]")).isDisplayed());
    }

    @Test
    public void TC_05_Random_Popup_InDom() {
        driver = new FirefoxDriver();
        driver.get("https://www.javacodegeeks.com/#google_vignette");
        sleepInseconds(30);
        By newLetterPopup = By.cssSelector("div.lepopup-popup-container lepopup-popup-fh-container>div:not([style^='display:none'])");

        if(driver.findElements(newLetterPopup).size()>0 && driver.findElements(newLetterPopup).get(0).isDisplayed()){
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) div.lepopup-element-html-content>a:not([class='lepopup-inherited lepopup-inherited'])")).click();
            sleepInseconds(2);
        }else {
            System.out.println("Popup ko hiển thị");
        }
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Agile Testing Explained");
        driver.findElement(By.xpath("//button[@id='search-submit']")).click();
        sleepInseconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).getText(),"Agile Testing Explained");
    }

    @Test
    public void TC_06_Random_Popup_InDom() {
        driver = new FirefoxDriver();
        driver.get("https://vnk.edu.vn/");
        sleepInseconds(30);
        By newLetterPopup = By.cssSelector("div#tve-p-scroller>article");

        if (driver.findElement(newLetterPopup).isDisplayed()) {
            driver.findElement(By.cssSelector("div.tve_ea_thrive_leads_form_close")).click();
            sleepInseconds(2);
        } else {
            System.out.println("Popup ko hiển thị");
        }
    }

    @Test
    public void TC_07_Random_Popup_Not_InDom() {
        driver = new FirefoxDriver();
        driver.get("https://dehieu.vn/");
        sleepInseconds(10);
        By newLetterPopup = By.cssSelector("div.modal-content");

        if (driver.findElements(newLetterPopup).size()>0 && driver.findElements(newLetterPopup).get(0).isDisplayed()) {
            driver.findElement(By.cssSelector("button.close")).click();
            sleepInseconds(2);
        } else {
            System.out.println("Popup ko hiển thị");
        }
    }



    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}