package com.elzat.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class checkingTables {
    WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void setUpMethod(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_verify_name(){

        WebElement bobcell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println(bobcell.getText());
        WebElement BobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));
        String expectedDate = "12/31/2021";
        String actualDate = BobsOrderDate.getText();
        Assert.assertEquals(expectedDate, actualDate);


    }



}
