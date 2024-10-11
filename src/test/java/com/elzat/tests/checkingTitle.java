package com.elzat.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class checkingTitle {
    WebDriver driver = new ChromeDriver();
 @BeforeMethod
    public void setUpMethod(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.orangehrm.com/");
    }
 @AfterMethod
    public void tearDown(){
     driver.quit();
    }

    @Test
    public void test1(){
     String actualTitle = driver.getTitle();
     String expectedTitle = "Human Resources Management Software | OrangeHRM";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
