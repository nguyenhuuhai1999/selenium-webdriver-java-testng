package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_10_Default_Checkbox_Radio {
    WebDriver driver;

    @Test
    public void TC_01_Default_Checkbox_Radio() {
        driver = new FirefoxDriver();
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        sleepInseconds(4);
        WebElement checkBox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input"));
        Assert.assertFalse(checkBox.isSelected());
        if (!checkBox.isSelected()){
            checkBox.click();
        }
        Assert.assertTrue(checkBox.isSelected());

        if (checkBox.isSelected()){
            checkBox.click();
        }
        Assert.assertTrue(!checkBox.isSelected());

    }

    @Test
    public void TC_02_Default_Checkbox_Radio() {
        driver = new FirefoxDriver();
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        sleepInseconds(4);
        WebElement radioCheck = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input"));
        Assert.assertFalse(radioCheck.isSelected());
        if (!radioCheck.isSelected()) {
            radioCheck.click();
        }
        Assert.assertTrue(radioCheck.isSelected());
        sleepInseconds(3);
        if (radioCheck.isSelected()) {
            WebElement radioCheck1 = driver.findElement(By.xpath("//label[text()='1.6 Diesel, 77kW']/preceding-sibling::span/input"));
            radioCheck1.click();
            Assert.assertTrue(radioCheck1.isSelected());
        }
        Assert.assertFalse(radioCheck.isSelected());

    }

    @Test
    public void TC_03_Default_Checkbox_Radio() {
        driver = new FirefoxDriver();
        driver.get("https://material.angular.io/components/radio/examples");
       // sleepInseconds(4);
        WebElement radioCheck = driver.findElement(By.xpath("//label[text()='Summer']/preceding-sibling::div//input"));
        Assert.assertFalse(radioCheck.isSelected());
       if (!radioCheck.isSelected()) {
           ((JavascriptExecutor)driver).executeScript("argument[2].click();",
                   driver.findElement(By.xpath("//label[text()='Summer']/preceding-sibling::div//input")));
       }
       Assert.assertTrue(radioCheck.isSelected());

    }

    @Test
    public void TC_04_Default_All_Checkbox() {
//        driver = new FirefoxDriver();
//        driver.get("https://automationfc.github.io/multiple-fields/");
//        List<WebElement> allCheckBoxs = driver.findElements(By.xpath("//div[@class='form-single-column']//span[@class='form-checkbox-item']"));
//       for(WebElement checkBox :allCheckBoxs){
//           if(!checkBox.isSelected()){
//               checkBox.click();
//               //sleepInseconds(1);
//           }
//
//       }

//       driver.manage().deleteAllCookies();
//       driver.navigate().refresh();
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement>  allCheckBoxs = driver.findElements(By.xpath("//div[@class='form-single-column']//span[@class='form-checkbox-item']"));
        for(WebElement checkBox :allCheckBoxs){
         //   checkBox = driver.findElement(By.xpath("//div[@class='form-single-column']//span[@class='form-checkbox-item']//label[text()='Use a C-PAP machine']"));
            if(!checkBox.isSelected() && checkBox.getAttribute("value").equals("Use a C-PAP machine")){
                checkBox.click();
                sleepInseconds(1);
            }
        }
    }

    @Test
    public void TC_05_Custom_Checkbox_Radio() {
        driver = new FirefoxDriver();
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
//        WebElement radioCustom = driver.findElement(By.xpath("//div[@aria-label='Cần Thơ']"));
//        Assert.assertEquals(radioCustom.getAttribute("aria-checked"),"false");
//       // Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' && aria-checked='False']")).isDisplayed());
//        radioCustom.click();
//        sleepInseconds(2);
//        Assert.assertEquals(radioCustom.getAttribute("aria-checked"),"true");
       // Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' && aria-checked='true']")).isDisplayed());

        //div[@aria-label='Quảng Ngãi']
        WebElement radioCustom1 = driver.findElement(By.xpath("//div[@aria-label='Quảng Ngãi']"));
        Assert.assertEquals(radioCustom1.getAttribute("aria-checked"),"false");
        // Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' && aria-checked='False']")).isDisplayed());
        radioCustom1.click();
        sleepInseconds(2);
        Assert.assertEquals(radioCustom1.getAttribute("aria-checked"),"true");
        sleepInseconds(3);
        radioCustom1.click();
        Assert.assertEquals(radioCustom1.getAttribute("aria-checked"),"false");
    }

    @Test
    public void TC_06_Default_Checkbox_Radio() {
        driver = new FirefoxDriver();
        driver.get("https://login.ubuntu.com/");
        sleepInseconds(4);

        //System.out.println(radioCheck);
        ((JavascriptExecutor)driver).executeScript("argument[0].click();",
                driver.findElement(By.xpath("//div[@class='hide-nojs user-intention']//input[@id='id_new_user']")));



    }





    public void sleepInseconds(long timeInSecond){
        try{
            Thread.sleep(timeInSecond*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}