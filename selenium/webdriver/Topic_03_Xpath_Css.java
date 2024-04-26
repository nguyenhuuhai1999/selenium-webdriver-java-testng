package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_03_Xpath_Css {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Firefox() {
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_Register_Empty_Data(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");

    }

    @Test
    public void TC_02_Register_With_Invalid_Email(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Huu Hai");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuuhai@");
        driver.findElement(By.id("txtCEmail")).sendKeys("hainguyenhuu@.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Huuhai1405");
        driver.findElement(By.id("txtCPassword")).sendKeys("Huuhai1405");
        driver.findElement(By.id("txtPhone")).sendKeys("0901773198");

        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

    }

    @Test
    public void TC_03_Register_With_Incorrect_Comfirm_Email(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Huu Hai");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("hainguyenhuu@.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Huuhai1405");
        driver.findElement(By.id("txtCPassword")).sendKeys("Huuhai1405");
        driver.findElement(By.id("txtPhone")).sendKeys("0901773198");

        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

    }

    @Test
    public void TC_04_Register_With_Password(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Huu Hai");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Huuha");
        driver.findElement(By.id("txtCPassword")).sendKeys("Huuha");
        driver.findElement(By.id("txtPhone")).sendKeys("0901773198");

        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

    }

    @Test
    public void TC_05_Register_With_Password(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Huu Hai");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Huuhai1405");
        driver.findElement(By.id("txtCPassword")).sendKeys("Huuha");
        driver.findElement(By.id("txtPhone")).sendKeys("0901773198");

        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

    }

    @Test
    public void TC_06_Register_With_Password(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Huu Hai");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Huuhai1405");
        driver.findElement(By.id("txtCPassword")).sendKeys("Huuha");
        driver.findElement(By.id("txtPhone")).sendKeys("0901773198");

        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

    }

    @Test
    public void TC_07_Invalid_Phone_Number(){
        driver = new FirefoxDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

    // nhap nho hon 10 ky tu
        driver.findElement(By.id("txtFirstname")).sendKeys("Huu Hai");
        driver.findElement(By.id("txtEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("nguyenhuuhai@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Huuhai1405");
        driver.findElement(By.id("txtCPassword")).sendKeys("Huuhai1405");
        driver.findElement(By.id("txtPhone")).sendKeys("090177319");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // nhap lon hon 10 ky tu
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("09017731900000");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // nhap khac dau so nha mang
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("0098327342748");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}