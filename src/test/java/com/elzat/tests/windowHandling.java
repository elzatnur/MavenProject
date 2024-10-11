package com.elzat.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.awt.SystemColor.window;

public class windowHandling {
    WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.com");

        }
        @Test
        public void window_handling_test(){
            ((JavascriptExecutor) driver).executeScript(".open('https://google.com','_blank');)");
            ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');)");
            ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');)");

        }
}
