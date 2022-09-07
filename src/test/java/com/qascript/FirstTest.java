package com.qascript;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class FirstTest {


    @Test
    public void OpenBrowser()  {
        
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://server.growatt.com/login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Title of the page is: " + driver.getTitle());
        Assert.assertTrue("Page title is not correct",driver.getTitle().equals("Sign In"));
	    
	WebElement username = driver.findElement(By.id("val_loginAccount"));
        WebElement password = driver.findElement(By.id("val_loginPwd"));
        WebElement login = driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        System.out.println("Step 1 Passed");
        username.sendKeys("mohamad.elcharif");
        password.sendKeys("D@Rock2021");
        login.click();
        WebElement settings = driver.findElement(By.xpath("//div[@class='op-set radiuTop']/span"));
        settings.click();
        WebElement agree = driver.findElement(By.xpath("//*[@id=\"dialog-mzsm\"]/div[2]/label"));
        agree.click();
        WebElement confirm = driver.findElement(By.xpath("//div[@class='dialog-btns']/span[1]"));
        confirm.click();
        WebElement max_ac_charge_current = driver.findElement(By.xpath("//*[@id=\"setDevice\"]/table[3]/tbody/tr[12]/td[2]/input"));
        max_ac_charge_current.clear();
        max_ac_charge_current.click();
        max_ac_charge_current.sendKeys("25");
        WebElement daily_password = driver.findElement(By.xpath("//*[@id=\"val_dialog_setStorage_pwd\"]"));
        daily_password.sendKeys(timeStamp);
        //WebElement save_changes = driver.findElement(By.xpath("//*[@id=\"layui-layer2\"]/div[3]/div[1]/span[1]"));
        //save_changes.click();
        System.out.println("The Maximum AC Charge Current is now changed to 25A");
        driver.quit();
        
    }


}


