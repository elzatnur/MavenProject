package com.elzat.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class checkingDropDowns {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setupMethod(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practice.cydeo.com/dropdown");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        yearDropdown.selectByVisibleText("1933");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);
        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertTrue(expectedYear.equals(actualYear));
        Assert.assertEquals(expectedMonth, actualMonth);
        Assert.assertEquals(expectedDay, actualDay);
    }

    @Test
    public void test2(){
        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropDown.selectByValue("VA");
        stateDropDown.selectByIndex(5);
        stateDropDown.selectByVisibleText("Idaho");
        //verify if final selected option is Idaho
        String expectedSt = "Idaho";
        String actualSt = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedSt, actualSt);
    }

    @Test
    public void test3 (){
        WebElement websiteDropDown = driver.findElement(By.linkText("Dropdown link"));
        websiteDropDown.click();
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
