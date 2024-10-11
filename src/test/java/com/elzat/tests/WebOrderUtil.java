package com.elzat.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class WebOrderUtil {

    public static String returnOrderDate(WebElement driver, String customerName){
        String locator = "//td[.='"+customerName+"']/../td[3]";
        WebElement customerDateCell = driver.findElement(By.xpath(locator));
        return customerDateCell.getText();

    }

}

