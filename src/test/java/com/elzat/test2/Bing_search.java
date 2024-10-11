package com.elzat.test2;

import com.elzat.tests.configReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Bing_search {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(configReader.getProp("bingUrl"));
    }
    @Test
    public void search_Test(){
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchBox.sendKeys("apple");
        searchBox.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bing";
        Assert.assertEquals(actualTitle, expectedTitle);


    }
}
