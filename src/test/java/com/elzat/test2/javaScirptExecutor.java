package test.java.com.elzat.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class javaScirptExecutor {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(com.elzat.tests.configReader.getProp("Url"));
    }
    @Test
    public void infiniteScroll() throws InterruptedException {
        WebElement downlink = driver.findElement(By.linkText("CYDEO"));
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true)", downlink, homeLink);
        Thread.sleep(2000);
        js.executeScript("arguments[1].scrollIntoView(true)", downlink, homeLink);
    }

}
