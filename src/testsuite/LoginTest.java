package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        // Enter the valid username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter the valid password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the text 'Secure Area'
        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Secure Area",expectedText);
        Thread.sleep(5000);
    }
    @Test
    public void verifyTheUsernameErrorMessage() throws InterruptedException {
        // Enter the valid username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter the valid password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the text 'Secure Area'
        String expectedText = "Your username is invalid!";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Your username is invalid!",expectedText);
        Thread.sleep(5000);
    }
    @Test
    public void verifyThePasswordErrorMessage() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter the valid password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the text 'Secure Area'
        String expectedText = "Your password is invalid!";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Your password is invalid!",expectedText);
        Thread.sleep(5000);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
