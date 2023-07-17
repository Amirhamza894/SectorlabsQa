package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login;
import config.Utilities;
import java.time.Duration;

public class LoginTest {

    private WebDriver driver;
    private Login login;
    //private String URL = "https://www.bayut.com/en";

    @BeforeTest
    public void intialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login =new Login(driver);
    }

    @Test
    public void loginWithValidCredentials() {
        driver.get("https://www.bayut.com/en");
        //1. Click login button
        login.loginBtn.click();
        //2. Enter Email
        login.enterCredentials(Utilities.username, Utilities.password);
        //4. Click login button
        login.sumitBtn.click();
        //driver.findElement(By.cssSelector("button[type='submit']")).click();
        //5. verify if logged in
        String expectedUsername = "Haris";
        String actualUsername = login.usernameLabel.getText();
        Assert.assertEquals(actualUsername,expectedUsername);

    }

    @Test
    public void loginWithInValidCredentials() {
        driver.get("https://www.bayut.com/en");
        //1. Click login button
        driver.findElement(By.cssSelector("[aria-label='Login']")).click();
        //2. Enter Email
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("muhammad.haris@dubizzlelabs.com");
        //3. Enter password
        driver.findElement(By.id("password")).sendKeys("1234567b");
        //4. Click login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //5. verify if logged in
        assert driver.findElement(By.className("_3ea7cdfa")).isDisplayed();

    }

    @Test
    public void test() {
        System.out.println("Hello Automation Engineers");
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}

