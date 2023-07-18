package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.Categories;

import java.time.Duration;

public class Shahab {

    private WebDriver driver;

//    private Actions act;
    @Test
    public void seleniumAction() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).build().perform();
        act.moveToElement(driver.findElement(By.xpath("//a[.='Top']"))).click().build().perform();
        String url = driver.getCurrentUrl();
        assert url.contains("#top");








//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        category =new Categories(driver);
//        act = new Actions(driver);
    }
}
