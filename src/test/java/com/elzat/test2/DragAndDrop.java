package test.java.com.elzat.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(com.elzat.tests.configReader.getProp("Url"));
    }
    @AfterMethod
    public void tear_Down(){
        driver.close();
    }
    @Test
    public void value_veriffication(){
        WebElement circleTarget = driver.findElement(By.id("droptarget"));
        circleTarget.getText();
        String expectedresult = "Drag the small circle here.";
        String actualResult = circleTarget.getText();
        Assert.assertEquals(expectedresult, actualResult);
    }
    @Test
    public void dragAndDrop(){
        WebElement bigCircle = driver.findElement(By.id("droptarget"));
        WebElement smallCircle = driver.findElement(By.id("draggable"));
        Actions actions = new Actions(driver);
        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .release().perform();
        String expectedText = "You did great!";
        String actualText = bigCircle.getText();
        Assert.assertTrue(actualText.equals(expectedText));
    }
    @Test
    public void clickAndHoldSmallCircle(){
        WebElement bigCircle = driver.findElement(By.id("droptarget"));
        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement otherElement = driver.findElement(By.className("nav-link"));

        Actions actions = new Actions(driver);
        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(otherElement)
                .pause(1000)
                .perform();
        String expectedText = "Drop here.";
        String actualText = bigCircle.getText();
        Assert.assertTrue(actualText.equals(expectedText));

    }
    @Test
    public void dropOutsideofBigCircle(){
        WebElement bigCircle = driver.findElement(By.id("droptarget"));
        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement otherElement = driver.findElement(By.className("nav-link"));

        Actions actions = new Actions(driver);
        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(otherElement)
                .pause(1000)
                .release()
                .pause(1000)
                .perform();
        String expectedText = "Try again!";
        String actualText = bigCircle.getText();
        Assert.assertTrue(actualText.equals(expectedText));

    }
    @Test
    public void hoverOverBigCircle(){
        WebElement bigCircle = driver.findElement(By.id("droptarget"));
        WebElement smallCircle = driver.findElement(By.id("draggable"));
        //WebElement otherElement = driver.findElement(By.className("nav-link"));

        Actions actions = new Actions(driver);
        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .perform();
        String expectedText = "Now drop...";
        String actualText = bigCircle.getText();
        Assert.assertTrue(actualText.equals(expectedText));

    }

}
