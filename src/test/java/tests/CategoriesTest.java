package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.Categories;
import config.Utilities;

public class CategoriesTest {
    private WebDriver driver;
    private Categories category;
    private Actions act;

    @BeforeTest
    public void testsInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        category =new Categories(driver);
        act = new Actions(driver);
    }

    @Test
    public void verifyHeroCategoryAndItsDirection() {

        driver.get(Utilities.URL);
        act.moveToElement(category.categoryCarForSale).build().perform();
        act.moveToElement(category.carForSaleSubCategory).click().build().perform();
        String actualSearchText = category.searchText.getText();
        String expectedSearchText = "Cars for Sale";
        assert actualSearchText.equals(expectedSearchText);

    }

//    @Test
//    public void verifyHeroCategoryAndItsDirection() {
//        driver.get("https://www.dubizzle.com.eg/en/");
//        Actions action = new Actions(driver);
//        WebElement categoryCarForSale = driver.findElement(By.xpath("//a[.='Vehicles']"));
//        action.moveToElement(categoryCarForSale).build().perform();
////        WebElement carForSaleSubCategory = driver.findElement(By.xpath("//div[@class='_8f799b34 b5f96152'][.='Cars for Sale']"));
////        action.moveToElement(carForSaleSubCategory).click().build().perform();
////        WebElement actualSearchText = driver.findElement(By.cssSelector("h1[class$='_888f7099']"));
//////                ctg.searchText;
////        String actualText = actualSearchText.getText();
////        String expectedSearchText = "Cars for Sale";
////        assert expectedSearchText.equals(actualText);
//    }

    @AfterTest
    public void distroyBrowser() { driver.quit(); }
}
