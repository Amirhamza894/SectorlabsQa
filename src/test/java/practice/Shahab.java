package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.Categories;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //DropDown (Select Tag)
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[id='dropdown-class-example']")));
        dropdown.selectByIndex(1);
        dropdown.selectByValue("option2");
        dropdown.selectByVisibleText("Option3");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Checkboxes
        List<WebElement> checkboxs = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Random random = new Random();
        WebElement checkbox = checkboxs.get(random.nextInt(checkboxs.size()));
        checkbox.click();
        assert checkbox.isSelected();

    }
}
