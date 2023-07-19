package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.Random;

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

    @Test
    public void verifyCatrgorySearchAndCategoryOnSearchPage() {
        driver.get(Utilities.URL);
        List<WebElement> allCategories = driver.findElements(By.cssSelector("div[class$='_1adcd900']"));
        Random random = new Random();
        WebElement selectedCategory = allCategories.get((random.nextInt(allCategories.size())));
        String searchCategoryText = selectedCategory.getText();
        selectedCategory.click();
        searchCategoryText = searchCategoryText.replace("All in", "");
        searchCategoryText = searchCategoryText.replaceFirst(" ", "");
        String actualCategorySearch = driver.findElement(By.xpath("//span[@class='_7597a67d dd224544'][contains(text(),\"" + searchCategoryText + "\")]")).getText();
        assert searchCategoryText.equals(actualCategorySearch);
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
